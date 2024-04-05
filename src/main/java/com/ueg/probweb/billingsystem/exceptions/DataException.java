package com.ueg.probweb.billingsystem.exceptions;

import lombok.Getter;

@Getter
public class DataException extends RuntimeException {
    private final ErrorEnum error;

    public DataException(String message){
        super(message);
        this.error = ErrorEnum.GENERAL;
    }
    public DataException(String message, Throwable e){
        super(message, e);
        this.error = ErrorEnum.GENERAL;
    }
    public DataException(ErrorEnum err){
        super(err.getMessage());
        this.error = err;
    }
    public DataException(String message, ErrorEnum err, Throwable e){
        super(message, e);
        this.error = err;
    }
}
