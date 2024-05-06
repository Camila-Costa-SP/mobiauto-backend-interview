package com.mobiauto.opportunities.exception;

import static com.mobiauto.opportunities.enums.ErrorType.CLIENT_NOT_FOUND;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException() {
        super(CLIENT_NOT_FOUND.getMessage());
    }
}