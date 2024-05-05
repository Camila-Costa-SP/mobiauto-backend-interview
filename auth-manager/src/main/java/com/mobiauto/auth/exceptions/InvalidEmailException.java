package com.mobiauto.auth.exceptions;

import static com.mobiauto.auth.enums.ErrorType.INVALID_EMAIL;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super(INVALID_EMAIL.getMessage());
    }
}