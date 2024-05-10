package com.ueg.probweb.billingsystem.entities.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDateRangeDTO {
    private LocalDate initialDate;
    private LocalDate finalDate;
}
