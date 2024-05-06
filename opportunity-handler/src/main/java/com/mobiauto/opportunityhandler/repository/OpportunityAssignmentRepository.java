package com.mobiauto.opportunityhandler.repository;

import com.mobiauto.opportunityhandler.entity.OpportunityAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OpportunityAssignmentRepository extends JpaRepository<OpportunityAssignment, Long> {

    Optional<OpportunityAssignment> findOneByIdAndAssignedToUserId(Long assignmentId, Long userId);
}