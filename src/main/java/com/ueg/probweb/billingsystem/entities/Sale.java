package com.ueg.probweb.billingsystem.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "VENDA")
public class Sale implements Comparable<Sale>, GenericModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate createdDate;
    private String seller;
    private String client;
    private String product;
    private Double productPrice;
    private Double salePrice;
    private SituationSale situation;

    @Override
    public int compareTo(Sale o) {
        return this.createdDate.compareTo(o.getCreatedDate());
    }
}
