package com.example.beerclient.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Beer(
        @Null
        UUID id,
        @NotBlank
        String beerName,
        @NotNull
        BeerStyle beerStyle,
        String upc,
        Integer quantityOnHand,
        BigDecimal price,
        Integer version,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate
) {
}
