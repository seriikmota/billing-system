package com.ueg.probweb.billingsystem.exceptions;

import lombok.Getter;

@Getter
public enum ErrorEnum {
    GENERAL(0L, "Erro desconhecido!"),
    NOT_FOUND(404L, "Registro não encontrado!"),
    MANDATORY_FIELD_NOT_FOUND(1L, "Campo Obrigatório não preenchido"),
    DATE_START_AFTER_DATE_FINAL(2L, "A data inicial é maior que a final!");

    private final Long id;
    private final String message;

    ErrorEnum(Long id, String message){
        this.id = id;
        this.message = message;
    }
}
