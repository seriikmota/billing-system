package com.ueg.probweb.billingsystem.exceptions;

import lombok.Getter;

@Getter
public class BusinessRuleException extends RuntimeException {
    private final ErrorEnum error;
    public BusinessRuleException(String message) {
        super(message);
        this.error = ErrorEnum.BUSINESS_RULE;
    }
}
