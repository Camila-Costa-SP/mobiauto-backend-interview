package com.mobiauto.opportunityhandler.enums;

import java.util.Arrays;

public enum OpportunityStatus {
    ASSIGNED;

    public static OpportunityStatus fromString(String status) {
        return Arrays.stream(OpportunityStatus.values())
                .filter(s -> s.name().equalsIgnoreCase(status))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown status: " + status));
    }
}
