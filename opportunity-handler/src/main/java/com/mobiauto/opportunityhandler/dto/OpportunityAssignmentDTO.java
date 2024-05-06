package com.mobiauto.opportunityhandler.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OpportunityAssignmentDTO {
    private Long id;
    private Long opportunityId;
    private Long assignedToUserId;
    private String status;
    private LocalDateTime assignedDate;
    private LocalDateTime completionDate;

}
