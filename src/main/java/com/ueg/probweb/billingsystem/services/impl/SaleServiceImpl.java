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

    @Override
    protected void prepareToCreate(Sale dado) {

    }
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
    protected void validateMandatoryFields(Sale dado) {

    }

    @Override
    protected void validateBusinessLogic(Sale dado) {

    }

    @Override
    protected void validateBusinessLogicForInsert(Sale dado) {

    }

    @Override
    protected void validateBusinessLogicForUpdate(Sale dado) {

    }

    private void validateDates(LocalDate initialDate, LocalDate finalDate) {
        if (initialDate.isAfter(finalDate)){
            throw new BusinessLogicException(ErrorEnum.DATE_START_AFTER_DATE_FINAL);
        }
    }
}
