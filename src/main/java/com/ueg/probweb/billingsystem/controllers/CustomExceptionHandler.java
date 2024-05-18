package com.ueg.probweb.billingsystem.controllers;

import com.ueg.probweb.billingsystem.exceptions.BusinessLogicException;
import com.ueg.probweb.billingsystem.exceptions.DataException;
import com.ueg.probweb.billingsystem.exceptions.BusinessRuleException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(DataException.class)
    public ResponseEntity<String> handleDataException(DataException ex){
        ex.printStackTrace();
        return ResponseEntity.status(ex.getError().getId()).body(ex.getMessage());
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<String> handleBusinessRuleException(BusinessRuleException ex) {
        return ResponseEntity.status(ex.getError().getId()).body(ex.getMessage());
    }

    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<String> handleBusinessLogicException(BusinessLogicException ex) {
        ex.printStackTrace();
        return ResponseEntity.status(ex.getError().getId()).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.badRequest().body("Ocorreu um erro ao realizar a requisição!");
    }
}
