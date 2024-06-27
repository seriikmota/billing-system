package com.ueg.probweb.billingsystem.services.impl;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.HighestClientDTO;
import com.ueg.probweb.billingsystem.entities.dtos.TotalSalePerDateDTO;
import com.ueg.probweb.billingsystem.entities.dtos.HighestProductDTO;
import com.ueg.probweb.billingsystem.entities.dtos.HighestSellerDTO;
import com.ueg.probweb.billingsystem.exceptions.BusinessLogicException;
import com.ueg.probweb.billingsystem.exceptions.ErrorEnum;
import com.ueg.probweb.billingsystem.repositorys.SaleRepository;
import com.ueg.probweb.billingsystem.services.ISaleService;
import com.ueg.probweb.billingsystem.services.validations.ISaleValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class SaleServiceImpl extends GenericService<Sale, Long, SaleRepository, ISaleValidations> implements ISaleService {

    @Autowired
    private SaleRepository repository;

    @Override
    public List<Sale> getSalesPerDates(LocalDate initialDate, LocalDate finalDate) {
        validateDates(initialDate, finalDate);
        var saleList = repository.getByCreatedDateBetween(initialDate, finalDate);
        Collections.sort(saleList);
        return saleList;
    }

    @Override
    public Double getTotalSalesPrice() {
        return repository.sumAllSalesPrice();
    }

    @Override
    public List<TotalSalePerDateDTO> getTotalSalesPrice(LocalDate initialDate, LocalDate finalDate) {
        validateDates(initialDate, finalDate);
        return repository.sumSalesPriceByCreatedDate(initialDate, finalDate);
    }

    @Override
    public HighestProductDTO getHighestProduct(){
        return repository.findProductWithHighestSales();
    }

    @Override
    public HighestSellerDTO getHighestSeller(){
        return repository.findSellerWithHighestSales();
    }

    @Override
    public HighestClientDTO getHighestClient(){
        return repository.findCustomerWithHighestSales();
    }

    @Override
    protected void prepareToCreate(Sale data) {
        data.setCreatedDate(LocalDate.now());
    }

    private void validateDates(LocalDate initialDate, LocalDate finalDate) {
        if (initialDate.isAfter(finalDate)){
            throw new BusinessLogicException(ErrorEnum.DATE_START_AFTER_DATE_FINAL);
        }
    }
}
