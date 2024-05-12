package com.mobiauto.opportunities.dto;


import java.time.LocalDateTime;

public record OpportunityDTO(
        Long id,
        ClientDTO client,
        ProductInterestDTO productInterest,
        String status,
        LocalDateTime creationDate,
        LocalDateTime updateDate,
        Long resaleId
) {}