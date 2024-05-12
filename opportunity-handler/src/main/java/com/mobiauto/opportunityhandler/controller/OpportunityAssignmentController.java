package com.mobiauto.opportunityhandler.controller;

import com.mobiauto.opportunityhandler.controller.spec.OpportunityAssignmentApi;
import com.mobiauto.opportunityhandler.dto.OpportunityAssignmentDTO;
import com.mobiauto.opportunityhandler.dto.OpportunityAssignmentRequestDTO;
import com.mobiauto.opportunityhandler.service.OpportunityAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OpportunityAssignmentController implements OpportunityAssignmentApi {

    @Autowired
    private OpportunityAssignmentService service;

    public ResponseEntity<OpportunityAssignmentDTO> getAssignment(final Long id) {
        return ResponseEntity.ok(service.getAssignment(id));
    }

    public ResponseEntity<OpportunityAssignmentDTO> updateAssignment(final Long id,
                                                                     final OpportunityAssignmentRequestDTO requestDTO) {
        return ResponseEntity.ok( service.updateAssignment(id, requestDTO));
    }

    public ResponseEntity<List<OpportunityAssignmentDTO>> listAllAssignments() {
        return ResponseEntity.ok(service.listAllAssignments());
    }
}