package com.mobiauto.opportunityhandler.dto;

import lombok.Data;

@Data
public class OpportunityAssignmentRequestDTO {
    private Long opportunityId;
    private Long assignedToUserId;
    private String status;

}
