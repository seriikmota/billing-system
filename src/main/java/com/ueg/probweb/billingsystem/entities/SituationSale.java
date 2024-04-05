package com.ueg.probweb.billingsystem.entities;

public enum SituationSale {
    OPEN(0L, "Aberta"),
    CLOSED(1L, "Fechada");

    private final Long id;
    private final String message;

    SituationSale(Long id, String message){
        this.id = id;
        this.message = message;
    }
}
