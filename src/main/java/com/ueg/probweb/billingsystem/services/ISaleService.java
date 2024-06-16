package com.ueg.probweb.billingsystem.services;

import com.ueg.probweb.billingsystem.entities.Sale;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService extends IGenericService<Sale, Long> {
    List<Sale> getSalesPerDates(LocalDate initialDate, LocalDate finalDate);
    Double getTotalSalesPrice();
    List<Object[]> getTotalSalesPrice(LocalDate initialDate, LocalDate finalDate);
    List<Object[]> getClientTotal();
    List<Object[]> getProductTotal();
    List<Object[]> getSellerTotal();

}
