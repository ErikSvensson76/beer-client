package com.example.beerclient.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer implements Serializable {
        @Null
        UUID id;
        @NotBlank
        String beerName;
        @NotNull
        BeerStyle beerStyle;
        String upc;
        Integer quantityOnHand;
        BigDecimal price;
        Integer version;
        LocalDateTime createdDate;
        LocalDateTime lastModifiedDate;

}
