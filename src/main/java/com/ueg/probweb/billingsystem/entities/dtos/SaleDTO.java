package com.ueg.probweb.billingsystem.entities.dtos;

import com.ueg.probweb.billingsystem.entities.SituationSale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {
    private Long id;
    private LocalDate createdDate;
    private String seller;
    private String client;
    private String product;
    private Double productPrice;
    private Double salePrice;
    private SituationSale situation;
}
