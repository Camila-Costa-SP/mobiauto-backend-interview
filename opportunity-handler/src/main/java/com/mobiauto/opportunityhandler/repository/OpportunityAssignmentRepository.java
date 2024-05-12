package com.mobiauto.opportunityhandler.repository;

import com.mobiauto.opportunityhandler.entity.OpportunityAssignment;
import com.mobiauto.opportunityhandler.enums.OpportunityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpportunityAssignmentRepository extends JpaRepository<OpportunityAssignment, Long> {

    Optional<OpportunityAssignment> findOneByIdAndAssignedToUserId(Long assignmentId, Long userId);

    @Query("SELECT COUNT(a) FROM OpportunityAssignment a WHERE a.assignedToUserId = :assignedToUserId AND a.status = :status")
    int countByUserIdAndStatus(@Param("assignedToUserId") Long assignedToUserId, @Param("status") OpportunityStatus status);

    @Query("SELECT a FROM OpportunityAssignment a WHERE a.assignedToUserId = :assignedToUserId ORDER BY a.assignedDate DESC LIMIT 1")
    Optional<OpportunityAssignment> findLastAssignmentByUserId(@Param("assignedToUserId") Long assignedToUserId);



}