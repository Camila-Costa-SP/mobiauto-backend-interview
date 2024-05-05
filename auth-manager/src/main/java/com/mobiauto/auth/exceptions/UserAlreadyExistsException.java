package com.mobiauto.auth.exceptions;

import static com.mobiauto.auth.enums.ErrorType.USER_ALREADY_EXISTS;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super(USER_ALREADY_EXISTS.getMessage());
    }
}