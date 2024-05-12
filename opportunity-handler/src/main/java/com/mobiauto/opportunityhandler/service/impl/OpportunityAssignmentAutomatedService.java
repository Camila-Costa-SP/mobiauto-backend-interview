package com.mobiauto.opportunityhandler.service.impl;

import com.mobiauto.opportunityhandler.client.UserManagerClient;
import com.mobiauto.opportunityhandler.dto.OpportunityMessageDTO;
import com.mobiauto.opportunityhandler.dto.UserDTO;
import com.mobiauto.opportunityhandler.entity.OpportunityAssignment;
import com.mobiauto.opportunityhandler.enums.Roles;
import com.mobiauto.opportunityhandler.repository.OpportunityAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import static com.mobiauto.opportunityhandler.enums.OpportunityStatus.ASSIGNED;
import static com.mobiauto.opportunityhandler.enums.OpportunityStatus.IN_PROGRESS;
@Service
public class OpportunityAssignmentAutomatedService {

    @Autowired
    private OpportunityAssignmentRepository assignmentRepository;

    @Autowired
    private UserManagerClient userManagerClient;

    public void assignOpportunity(OpportunityMessageDTO opportunity) {

        List<UserDTO> assistants = userManagerClient.findByRoleAndResaleId(Roles.ASSISTANT, opportunity.resaleId());

        UserDTO selectedAssistant = assistants.stream()
                .min(Comparator.comparingInt(this::countActiveOpportunities)
                        .thenComparing(this::getLastOpportunityTime))
                .orElseThrow(() -> new IllegalStateException("No eligible assistants found"));

        createOpportunityAssignment(opportunity, selectedAssistant);
    }

    private void createOpportunityAssignment(OpportunityMessageDTO opportunity, UserDTO selectedAssistant) {

        OpportunityAssignment newAssignment = new OpportunityAssignment();
        newAssignment.setOpportunityId(opportunity.opportunityId());
        newAssignment.setAssignedToUserId(selectedAssistant.getId());
        newAssignment.setStatus(ASSIGNED);
        newAssignment.setAssignedDate(LocalDateTime.now());
        assignmentRepository.save(newAssignment);
    }

    private int countActiveOpportunities(UserDTO user) {
        return assignmentRepository.countByUserIdAndStatus(user.getId(), IN_PROGRESS);
    }

    private LocalDateTime getLastOpportunityTime(UserDTO user) {
        return assignmentRepository.findLastAssignmentByUserId(user.getId())
                .map(OpportunityAssignment::getAssignedDate)
                .orElse(LocalDateTime.MIN);
    }
}
