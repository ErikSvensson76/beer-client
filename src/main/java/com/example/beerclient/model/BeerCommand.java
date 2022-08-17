package com.example.beerclient.model;

public record BeerCommand(
        String beerName,
        BeerStyle beerStyle,
        String upc,
        Integer quantityOnHand,
        Double price
) {
}
