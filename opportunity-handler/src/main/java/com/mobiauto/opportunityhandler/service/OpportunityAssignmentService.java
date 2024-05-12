package com.mobiauto.opportunityhandler.service;

import com.mobiauto.opportunityhandler.dto.OpportunityAssignmentDTO;
import com.mobiauto.opportunityhandler.dto.OpportunityAssignmentRequestDTO;

import java.util.List;

public interface OpportunityAssignmentService {

    OpportunityAssignmentDTO getAssignment(Long id);

    OpportunityAssignmentDTO updateAssignment(Long id, OpportunityAssignmentRequestDTO requestDTO);

    List<OpportunityAssignmentDTO> listAllAssignments();
}
