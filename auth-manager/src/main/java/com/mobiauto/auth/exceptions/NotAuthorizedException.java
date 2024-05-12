package com.mobiauto.auth.exceptions;

import static com.mobiauto.auth.enums.ErrorType.NOT_AUTHORIZED_MESSAGE;

public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException() {
        super(NOT_AUTHORIZED_MESSAGE.getMessage());
    }
}
