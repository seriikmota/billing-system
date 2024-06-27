package com.ueg.probweb.billingsystem.entities.dtos;

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
public class TotalSalePerDateDTO {
    private LocalDate createdDate;
    private Double totalSales;
}
