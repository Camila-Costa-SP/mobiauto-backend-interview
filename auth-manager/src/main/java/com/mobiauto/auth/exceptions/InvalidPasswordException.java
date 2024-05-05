package com.mobiauto.auth.exceptions;

import static com.mobiauto.auth.enums.ErrorType.INVALID_PASSWORD;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super(INVALID_PASSWORD.getMessage());
    }
}