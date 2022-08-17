package com.example.beerclient.client;

import com.example.beerclient.model.Beer;
import com.example.beerclient.model.BeerCommand;
import com.example.beerclient.model.BeerPagedList;
import com.example.beerclient.model.BeerStyle;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BeerClient {

    Mono<BeerPagedList> getBeers(Integer pageNumber, Integer pageSize, String beerName, BeerStyle beerStyle, Boolean showInventoryOnHand);

    Mono<ResponseEntity<?>> createBeer(BeerCommand beerCommand);

    Mono<ResponseEntity<?>> updateBeer(BeerCommand beerCommand);

    Mono<Beer> getBeerById(UUID beerId, boolean showInventoryOnHand);

    Mono<ResponseEntity<?>> deleteBeer(UUID beerId);

    Mono<Beer> getBeerByUPC(String upc);
}
