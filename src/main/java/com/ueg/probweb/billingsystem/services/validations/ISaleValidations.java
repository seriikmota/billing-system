package com.ueg.probweb.billingsystem.services.validations;

import com.ueg.probweb.billingsystem.entities.Sale;

public interface ISaleValidations {
    void validate(Sale s, ValidationAction action);
}
