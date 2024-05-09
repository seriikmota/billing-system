package com.ueg.probweb.billingsystem.entities.dtos;

import com.ueg.probweb.billingsystem.entities.SituationSale;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleUpdateDTO {
    private String product;
    private Double productPrice;
    private Double salePrice;
    private SituationSale situation;
}
