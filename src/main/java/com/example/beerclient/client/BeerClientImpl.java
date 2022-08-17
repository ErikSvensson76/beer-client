package com.example.beerclient.client;

import com.example.beerclient.config.WebClientProperties;
import com.example.beerclient.model.Beer;
import com.example.beerclient.model.BeerCommand;
import com.example.beerclient.model.BeerPagedList;
import com.example.beerclient.model.BeerStyle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerClientImpl implements BeerClient {

    private final WebClient webClient;
    private final WebClientProperties properties;

    @Override
    public Mono<BeerPagedList> getBeers(Integer pageNumber, Integer pageSize, String beerName, BeerStyle beerStyle, Boolean showInventoryOnHand) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(properties.getBeerV1Path())
                        .queryParamIfPresent("pageNumber", Optional.ofNullable(pageNumber))
                        .queryParamIfPresent("pageSize", Optional.ofNullable(pageSize))
                        .queryParamIfPresent("beerName", Optional.ofNullable(beerName))
                        .queryParamIfPresent("beerStyle", Optional.ofNullable(beerStyle))
                        .queryParamIfPresent("showInventoryOnHand", Optional.ofNullable(showInventoryOnHand))
                        .build()
                )
                .retrieve()
                .bodyToMono(BeerPagedList.class);
    }

    @Override
    public Mono<ResponseEntity<?>> createBeer(BeerCommand beerCommand) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<?>> updateBeer(BeerCommand beerCommand) {
        return null;
    }

    @Override
    public Mono<Beer> getBeerById(UUID beerId, Boolean showInventoryOnHand) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(properties.getBeerById())
                        .queryParamIfPresent("showInventoryOnHand", Optional.ofNullable(showInventoryOnHand))
                        .build(beerId))
                .retrieve()
                .bodyToMono(Beer.class);

    }

    @Override
    public Mono<ResponseEntity<?>> deleteBeer(UUID beerId) {
        return null;
    }

    @Override
    public Mono<Beer> getBeerByUPC(String upc) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(properties.getBeerByUpc())
                        .build(upc))
                .retrieve()
                .bodyToMono(Beer.class);
    }
}
