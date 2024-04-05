package com.ueg.probweb.billingsystem.services.impl;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.exceptions.BusinessLogicException;
import com.ueg.probweb.billingsystem.exceptions.DataException;
import com.ueg.probweb.billingsystem.exceptions.ErrorEnum;
import com.ueg.probweb.billingsystem.repositorys.SaleRepository;
import com.ueg.probweb.billingsystem.services.ISaleService;
import com.ueg.probweb.billingsystem.services.validations.ISaleValidations;
import com.ueg.probweb.billingsystem.services.validations.ValidationAction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService implements ISaleService {
    private final SaleRepository repository;
    private final List<ISaleValidations> validations;

    public SaleService(SaleRepository repository, List<ISaleValidations> validations){
        this.repository = repository;
        this.validations = validations;
    }

    @Override
    public Sale create(Sale sale) {
        prepareToCreate(sale);
        validations.forEach(v -> v.validate(sale, ValidationAction.CREATE));
        return repository.save(sale);
    }

    @Override
    public Sale update(Long id, Sale saleUpdate) {
        var saleDb = validateIdSaleExists(id);
        updateData(saleDb, saleUpdate);
        validations.forEach(v -> v.validate(saleUpdate, ValidationAction.UPDATE));
        return repository.save(saleDb);
    }

    @Override
    public void delete(Long id) {
        var sale = validateIdSaleExists(id);
        repository.delete(sale);
    }

    @Override
    public List<Sale> listAll() {
        var saleList = repository.findAll();
        Collections.sort(saleList);
        return saleList;
    }

    @Override
    public Sale getById(Long id) {
        return validateIdSaleExists(id);
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

    private void prepareToCreate(Sale s){
        s.setId(null);
        s.setCreatedDate(LocalDate.now());
    }

    private Sale validateIdSaleExists(Long id){
        Optional<Sale> byId = repository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        } else {
            throw new DataException(ErrorEnum.NOT_FOUND);
        }
    }

    private void updateData(Sale saleDb, Sale saleUpdate){
        saleDb.setProduct(saleUpdate.getProduct());
        saleDb.setProductPrice(saleUpdate.getProductPrice());
        saleDb.setSalePrice(saleUpdate.getSalePrice());
        saleDb.setSituation(saleUpdate.getSituation());
    }

    private void validateDates(LocalDate initialDate, LocalDate finalDate) {
        if (initialDate.isAfter(finalDate)){
            throw new BusinessLogicException(ErrorEnum.DATE_START_AFTER_DATE_FINAL);
        }
    }
}
