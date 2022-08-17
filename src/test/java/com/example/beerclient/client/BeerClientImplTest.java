package com.example.beerclient.client;

import com.example.beerclient.config.WebClientProperties;
import com.example.beerclient.model.BeerPagedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

class BeerClientImplTest {

    String baseUrl = "http://api.springframework.guru";
    String beerV1Path = "/api/v1/beer";
    WebClientProperties properties = new WebClientProperties();

    BeerClientImpl beerClient;

    @BeforeEach
    void setUp() {
        properties.setBaseUrl(baseUrl);
        properties.setBeerV1Path(beerV1Path);
        beerClient = new BeerClientImpl(WebClient.builder().baseUrl(baseUrl).build(), properties);
    }

    @Test
    void getBeers() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.getBeers(
                null, null, null, null, false
        );

        var result = beerPagedListMono.block();
        assertThat(result).isNotNull();
        assertThat(result.getContent().size()).isGreaterThan(0);
    }

    @Test
    void getBeersPageSize10() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.getBeers(
                1, 10, null, null, false
        );

        var result = beerPagedListMono.block();
        assertThat(result).isNotNull();
        assertThat(result.getContent().size()).isEqualTo(10);
    }

    @Test
    void getBeersNoRecords() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.getBeers(
                10, 20, null, null, false
        );

        var result = beerPagedListMono.block();
        assertThat(result).isNotNull();
        assertThat(result.getContent().size()).isEqualTo(0);
    }

    @Test
    void createBeer() {
    }

    @Test
    void updateBeer() {
    }

    @Test
    void getBeerById() {
    }

    @Test
    void deleteBeer() {
    }

    @Test
    void getBeerByUPC() {
    }
}