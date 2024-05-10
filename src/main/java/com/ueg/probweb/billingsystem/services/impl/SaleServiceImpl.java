package com.ueg.probweb.billingsystem.services.impl;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.exceptions.BusinessLogicException;
import com.ueg.probweb.billingsystem.exceptions.DataException;
import com.ueg.probweb.billingsystem.exceptions.ErrorEnum;
import com.ueg.probweb.billingsystem.repositorys.SaleRepository;
import com.ueg.probweb.billingsystem.services.ISaleService;
import com.ueg.probweb.billingsystem.services.validations.ISaleValidations;
import com.ueg.probweb.billingsystem.services.validations.ValidationAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl extends GenericService<Sale, Long, SaleRepository> implements ISaleService {

    @Autowired
    private SaleRepository repository;
    @Autowired
    private List<ISaleValidations> validations;

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
    public Double getTotalSalesPrice(LocalDate initialDate, LocalDate finalDate) {
        validateDates(initialDate, finalDate);
        return repository.sumSalesPriceByCreatedDate(initialDate, finalDate);
    }

    @Override
    protected void prepareToCreate(Sale data) {
        data.setCreatedDate(LocalDate.now());
    }

    @Override
    protected void validateForCreate(Sale data) {
        validations.forEach(v -> v.validate(data, ValidationAction.CREATE));
    }

    @Override
    protected void validateForUpdate(Sale data) {
        validations.forEach(v -> v.validate(data, ValidationAction.UPDATE));
    }

    private void validateDates(LocalDate initialDate, LocalDate finalDate) {
        if (initialDate.isAfter(finalDate)){
            throw new BusinessLogicException(ErrorEnum.DATE_START_AFTER_DATE_FINAL);
        }
    }
}
