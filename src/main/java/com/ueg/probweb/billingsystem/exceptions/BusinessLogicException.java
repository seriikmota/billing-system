package com.ueg.probweb.billingsystem.exceptions;

import lombok.Getter;

@Getter
public class BusinessLogicException extends RuntimeException {
    private final ErrorEnum error;

    public BusinessLogicException(String message){
        super(message);
        this.error = ErrorEnum.GENERAL;
    }

    public BusinessLogicException(String message, Throwable e){
        super(message, e);
        this.error = ErrorEnum.GENERAL;
    }

    public BusinessLogicException(ErrorEnum err){
        super(err.getMessage());
        this.error = err;
    }

    public BusinessLogicException(String message, Throwable e, ErrorEnum err){
        super(message, e);
        this.error = err;
    }
}
