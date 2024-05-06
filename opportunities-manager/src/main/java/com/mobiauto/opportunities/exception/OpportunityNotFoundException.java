package com.mobiauto.opportunities.exception;

import static com.mobiauto.opportunities.enums.ErrorType.OPPORTUNITY_NOT_FOUND;

public class OpportunityNotFoundException extends RuntimeException {
    public OpportunityNotFoundException() {
        super(OPPORTUNITY_NOT_FOUND.getMessage());
    }
}