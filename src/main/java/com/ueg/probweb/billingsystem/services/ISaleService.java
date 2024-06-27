package com.ueg.probweb.billingsystem.services;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.HighestClientDTO;
import com.ueg.probweb.billingsystem.entities.dtos.TotalSalePerDateDTO;
import com.ueg.probweb.billingsystem.entities.dtos.HighestProductDTO;
import com.ueg.probweb.billingsystem.entities.dtos.HighestSellerDTO;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService extends IGenericService<Sale, Long> {
    List<Sale> getSalesPerDates(LocalDate initialDate, LocalDate finalDate);
    Double getTotalSalesPrice();
    List<TotalSalePerDateDTO> getTotalSalesPrice(LocalDate initialDate, LocalDate finalDate);
    HighestClientDTO getHighestClient();
    HighestProductDTO getHighestProduct();
    HighestSellerDTO getHighestSeller();

}
