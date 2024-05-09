package com.ueg.probweb.billingsystem.entities.dtos;

import com.ueg.probweb.billingsystem.entities.SituationSale;

import java.time.LocalDate;

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
