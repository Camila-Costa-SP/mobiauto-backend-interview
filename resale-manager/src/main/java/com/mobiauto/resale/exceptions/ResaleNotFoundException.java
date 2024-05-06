package com.mobiauto.resale.exceptions;

import static com.mobiauto.resale.enums.ErrorType.RESALE_NOT_FOUND;

public class ResaleNotFoundException extends RuntimeException {
    public ResaleNotFoundException() {
        super(RESALE_NOT_FOUND.getMessage());
    }
}