package com.ueg.probweb.billingsystem.services.validations.Impl;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.exceptions.BusinessRuleException;
import com.ueg.probweb.billingsystem.services.validations.ISaleValidations;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class ValidateFields implements ISaleValidations {
    @Override
    public void validate(Sale s, ValidationAction action) {
        if (action == ValidationAction.CREATE){
            if (s.getSeller() == null || s.getSeller().isBlank()) {
                throw new BusinessRuleException("O vendedor é obrigatório!");
            }
            if (s.getClient() == null || s.getClient().isBlank()) {
                throw new BusinessRuleException("O cliente é obrigatório!");
            }
        }
        if (s.getProduct() == null || s.getProduct().isBlank()) {
            throw new BusinessRuleException("O produto é obrigatório!");
        }
        if (s.getProductPrice() == null) {
            throw new BusinessRuleException("O valor do produto é obrigatório!");
        }
        if (s.getSalePrice() == null) {
            throw new BusinessRuleException("O valor total da nota é obrigatório!");
        }
        if (s.getSituation() == null) {
            throw new BusinessRuleException("A situação é obrigatória!");
        }
    }
}
