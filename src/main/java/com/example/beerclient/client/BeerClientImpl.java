package com.example.beerclient.client;

import com.example.beerclient.config.WebClientProperties;
import com.example.beerclient.model.Beer;
import com.example.beerclient.model.BeerCommand;
import com.example.beerclient.model.BeerPagedList;
import com.example.beerclient.model.BeerStyle;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.reflect.Type;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerClientImpl implements BeerClient {

    private final WebClient webClient;
    private final WebClientProperties properties;

    @Override
    public Mono<BeerPagedList> getBeers(Integer pageNumber, Integer pageSize, String beerName, BeerStyle beerStyle, boolean showInventoryOnHand) {
        return webClient.get()
                .uri(properties.getBeerV1Path())
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
    public Mono<Beer> getBeerById(UUID beerId, boolean showInventoryOnHand) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<?>> deleteBeer(UUID beerId) {
        return null;
    }

    @Override
    public Mono<Beer> getBeerByUPC(String upc) {
        return null;
    }
}
