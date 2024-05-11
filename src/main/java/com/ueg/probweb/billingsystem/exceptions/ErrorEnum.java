package com.ueg.probweb.billingsystem.exceptions;

import lombok.Getter;

@Getter
public enum ErrorEnum {
    GENERAL(400, "Erro!"),
    NOT_FOUND(404, "Registro não encontrado!"),
    MANDATORY_FIELD_NOT_FOUND(400, "Campo Obrigatório não preenchido!"),
    DATE_START_AFTER_DATE_FINAL(400, "A data inicial é maior que a final!"),
    PARAMETER_REQUIRED(400, "Parâmetro(s) obrigatório(s) não inserido(s): "),
    BUSINESS_RULE(428, "");

    private final Integer id;
    private final String message;

    ErrorEnum(Integer id, String message){
        this.id = id;
        this.message = message;
    }
}
