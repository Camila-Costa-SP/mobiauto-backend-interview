package com.mobiauto.opportunities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType {

    CLIENT_NOT_FOUND("Client not found"),
    OPPORTUNITY_NOT_FOUND("Opportunity not found"),

   PRODUCT_INTEREST_NOT_FOUND ("Product interest not found");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    @JsonValue
    public String getMessage() {
        return this.message;
    }
}