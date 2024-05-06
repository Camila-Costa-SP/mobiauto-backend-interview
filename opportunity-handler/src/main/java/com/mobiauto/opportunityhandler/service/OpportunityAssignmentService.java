package com.mobiauto.opportunityhandler.service;

import com.mobiauto.opportunityhandler.dto.OpportunityAssignmentDTO;
import com.mobiauto.opportunityhandler.dto.OpportunityAssignmentRequestDTO;

import java.util.List;

public interface OpportunityAssignmentService {

    OpportunityAssignmentDTO createAssignment(OpportunityAssignmentRequestDTO requestDTO);

    OpportunityAssignmentDTO getAssignment(Long id);

    OpportunityAssignmentDTO updateAssignment(Long id, OpportunityAssignmentRequestDTO requestDTO);

    void deleteAssignment(Long id);

    List<OpportunityAssignmentDTO> listAllAssignments();
}
