package com.mobiauto.opportunities.service;

import com.mobiauto.opportunities.dto.OpportunityDTO;
import com.mobiauto.opportunities.dto.OpportunityRequestDTO;

import java.util.List;

public interface OpportunityService {
    OpportunityDTO createOpportunity(OpportunityRequestDTO opportunity);

    OpportunityDTO getOpportunity(Long id);

    OpportunityDTO updateOpportunity(Long id, OpportunityRequestDTO opportunity);

    List<OpportunityDTO> getAllOpportunities();

    OpportunityDTO updateOpportunityStatus(Long id, String status);
}