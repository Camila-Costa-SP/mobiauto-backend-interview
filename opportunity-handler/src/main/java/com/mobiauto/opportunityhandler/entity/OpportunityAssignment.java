package com.mobiauto.opportunityhandler.entity;

import com.mobiauto.opportunityhandler.enums.OpportunityStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "opportunity_assignments", schema =  "opportunities-handler")
@Data
public class OpportunityAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long opportunityId;

    @Column(nullable = false)
    private Long assignedToUserId;

    @Column(nullable = false)
    private LocalDateTime assignedDate;

    @Enumerated(EnumType.STRING)
    private OpportunityStatus status;

    private LocalDateTime completionDate;

}
