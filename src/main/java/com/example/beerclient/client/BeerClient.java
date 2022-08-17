package com.example.beerclient.client;

import com.example.beerclient.model.Beer;
import com.example.beerclient.model.BeerCommand;
import com.example.beerclient.model.BeerStyle;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface BeerClient {

    Mono<List<Beer>> getBeers(
            Integer pageNumber,
            Integer pageSize,
            String beerName,
            BeerStyle beerStyle,
            boolean showInventoryOnHand
    );

    Mono<ResponseEntity<?>> createBeer(BeerCommand beerCommand);

    Mono<ResponseEntity<?>> updateBeer(BeerCommand beerCommand);

    Mono<Beer> getBeerById(UUID beerId, boolean showInventoryOnHand);

    Mono<ResponseEntity<?>> deleteBeer(UUID beerId);

    Mono<Beer> getBeerByUPC(String upc);
}
