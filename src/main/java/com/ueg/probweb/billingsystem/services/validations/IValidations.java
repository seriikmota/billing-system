package com.ueg.probweb.billingsystem.services.validations;

import com.ueg.probweb.billingsystem.services.validations.Impl.ValidationAction;

public interface IValidations<MODEL> {
    void validate(MODEL data, ValidationAction action);
}
