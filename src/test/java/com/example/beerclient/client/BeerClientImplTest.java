package com.example.beerclient.client;

import com.example.beerclient.config.WebClientProperties;
import com.example.beerclient.model.Beer;
import com.example.beerclient.model.BeerPagedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class BeerClientImplTest {

    String baseUrl    = "http://api.springframework.guru";
    String beerV1Path = "/api/v1/beer";
    String beerById =   "/api/v1/beer/{beerId}";

    String beerByUpc  = "/api/v1/beerUpc/{upc}";
    WebClientProperties properties = new WebClientProperties();

    BeerClientImpl beerClient;

    public Beer getBeer(){
        return Objects.requireNonNull(beerClient.getBeers(1, 1, null, null, null)
                        .block())
                .getContent().stream()
                .findFirst()
                .orElseThrow();
    }

    @BeforeEach
    void setUp() {
        properties.setBaseUrl(baseUrl);
        properties.setBeerV1Path(beerV1Path);
        properties.setBeerById(beerById);
        properties.setBeerByUpc(beerByUpc);
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
        UUID beerId = getBeer().getId();
        Mono<Beer> resultMono = beerClient.getBeerById(beerId, null);

        var result = resultMono.block();

        assertThat(result).isNotNull();
        System.err.println(result);
    }

    @Test
    void deleteBeer() {
    }

    @Test
    void getBeerByUPC() {
        String upc = getBeer().getUpc();
        Mono<Beer> resultMono = beerClient.getBeerByUPC(upc);

        var result = resultMono.block();

        assertThat(result).isNotNull();
        assertThat(result.getUpc()).isEqualTo(upc);

    }
}