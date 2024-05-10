package com.ueg.probweb.billingsystem.entities.dtos;

import com.ueg.probweb.billingsystem.entities.SituationSale;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SaleCreateDTO {
    private String seller;
    private String client;
    private String product;
    private Double productPrice;
    private Double salePrice;
    private SituationSale situation;
}
