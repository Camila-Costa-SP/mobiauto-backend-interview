package com.mobiauto.auth.exceptions;

import static com.mobiauto.auth.enums.ErrorType.USER_NOT_FOUND;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super(USER_NOT_FOUND.getMessage());
    }
}
