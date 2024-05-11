package com.ueg.probweb.billingsystem.services.validations;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.exceptions.BusinessRuleException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class ValidatePrices implements ISaleValidations {
    @Override
    public void validate(Sale s, ValidationAction action) {
        if (s.getProductPrice() > s.getSalePrice()){
            throw new BusinessRuleException("O valor da venda não pode ser menor que o valor do produto!");
        }
    }
}
