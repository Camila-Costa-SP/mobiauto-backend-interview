package com.mobiauto.auth.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType {
    USER_ALREADY_EXISTS("User with provided email already exists."),
    USER_NOT_FOUND("User not found with the provided id."),
    JWT_TOKEN_EXPIRED("Expired or invalid JWT token"),
    INVALID_EMAIL("Invalid email supplied."),
    INVALID_PASSWORD("Invalid password supplied"),
    ERROR_MESSAGE ( "No role with text %s found"),
    NOT_AUTHORIZED_MESSAGE ( "No role with text %s found"),
    ACCESS_DENIED_MESSAGE ("You are not allowed to associate user to these resales");


    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    @JsonValue
    public String getMessage() {
        return this.message;
    }
}