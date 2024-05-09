package com.ueg.probweb.billingsystem.exceptions;

import lombok.Getter;

@Getter
public class ParameterRequiredException extends RuntimeException {
    private final ErrorEnum error;
    public ParameterRequiredException(String message){
        super(ErrorEnum.PARAMETER_REQUIRED.getMessage() + message);
        this.error = ErrorEnum.PARAMETER_REQUIRED;
    }
}
