package com.ueg.probweb.billingsystem.services;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.HighestDTO;
import com.ueg.probweb.billingsystem.entities.dtos.TotalSalePerDateDTO;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService extends IGenericService<Sale, Long> {
    List<Sale> getSalesPerDates(LocalDate initialDate, LocalDate finalDate);
    Double getTotalSalesPrice();
    List<TotalSalePerDateDTO> getTotalSalesPrice(LocalDate initialDate, LocalDate finalDate);
    HighestDTO getHighestClient();
    HighestDTO getHighestProduct();
    HighestDTO getHighestSeller();

}
