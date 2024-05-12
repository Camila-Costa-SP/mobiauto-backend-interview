package com.mobiauto.opportunityhandler.dto;

public record OpportunityMessageDTO(
        Long opportunityId,
        Long clientId,
        Long productInterestId,
        String status,
        Long resaleId) {}

