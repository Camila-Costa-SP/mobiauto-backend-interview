package com.mobiauto.opportunities.dto;

public record OpportunityMessageDTO(
        Long opportunityId,
        Long clientId,
        Long productInterestId,
        String status,
        Long resaleId) {}
