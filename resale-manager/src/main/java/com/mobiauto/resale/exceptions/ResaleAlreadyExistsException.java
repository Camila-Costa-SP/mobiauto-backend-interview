package com.mobiauto.resale.exceptions;

import static com.mobiauto.resale.enums.ErrorType.RESALE_ALREADY_EXISTS;

public class ResaleAlreadyExistsException extends RuntimeException {
    public ResaleAlreadyExistsException() {
        super(RESALE_ALREADY_EXISTS.getMessage());
    }
}