package com.ueg.probweb.billingsystem.services;

import com.ueg.probweb.billingsystem.entities.Sale;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    Sale create(Sale sale);
    Sale update(Long id, Sale sale);
    void delete(Long id);
    List<Sale> listAll();
    Sale getById(Long id);
    List<Sale> getSalesPerDates(LocalDate initialDate, LocalDate finalDate);
    Double getTotalSalesPrice();
    Double getTotalSalesPrice(LocalDate initialDate, LocalDate finalDate);
}
