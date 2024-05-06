package com.mobiauto.opportunities.exception;

import static com.mobiauto.opportunities.enums.ErrorType.PRODUCT_INTEREST_NOT_FOUND;

public class ProductInterestNotFoundException extends RuntimeException {
    public ProductInterestNotFoundException() {
        super(PRODUCT_INTEREST_NOT_FOUND.getMessage());
    }
}
