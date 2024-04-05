package com.ueg.probweb.billingsystem.entities.dtos;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleDateRangeDTO {
    private LocalDate initialDate;
    private LocalDate finalDate;
}
