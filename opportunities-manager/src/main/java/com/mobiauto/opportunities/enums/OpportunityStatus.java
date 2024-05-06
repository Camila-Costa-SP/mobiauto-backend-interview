package com.mobiauto.opportunities.enums;

public enum OpportunityStatus {
    NEW("Novo"),
    IN_PROGRESS("Em atendimento"),
    COMPLETED("Concluído");

    private final String description;

    OpportunityStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
