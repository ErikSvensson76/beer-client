package com.example.beerclient.client;

import com.example.beerclient.model.Beer;
import com.example.beerclient.model.BeerCommand;
import com.example.beerclient.model.BeerStyle;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerClientImpl implements BeerClient {
    @Override
    public Mono<Page<Beer>> getBeers(Integer pageNumber, Integer pageSize, String beerName, BeerStyle beerStyle, boolean showInventoryOnHand) {
        return null;
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
