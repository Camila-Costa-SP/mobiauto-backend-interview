package com.mobiauto.resale.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType {
    RESALE_NOT_FOUND("Resale not found"),
    RESALE_ALREADY_EXISTS("CNPJ already exists.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    @JsonValue
    public String getMessage() {
        return this.message;
    }
}