package com.mobiauto.opportunities.controller;

import com.mobiauto.opportunities.controller.spec.OpportunityApi;
import com.mobiauto.opportunities.dto.OpportunityDTO;
import com.mobiauto.opportunities.dto.OpportunityRequestDTO;
import com.mobiauto.opportunities.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OpportunityController implements OpportunityApi {

    @Autowired
    private OpportunityService opportunityService;

    public ResponseEntity<OpportunityDTO> createOpportunity(final OpportunityRequestDTO opportunity) {
        return ResponseEntity.ok(opportunityService.createOpportunity(opportunity));
    }

    public ResponseEntity<OpportunityDTO> getOpportunity(final Long id) {
        return ResponseEntity.ok(opportunityService.getOpportunity(id));
    }

    public ResponseEntity<OpportunityDTO> updateOpportunity(final Long id,
                                                            final OpportunityRequestDTO opportunity) {
        return ResponseEntity.ok(opportunityService.updateOpportunity(id, opportunity));
    }

    public ResponseEntity<OpportunityDTO> updateOpportunityStatus(final Long id, final String status) {
        return ResponseEntity.ok(opportunityService.updateOpportunityStatus(id, status));
    }
}