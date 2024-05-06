package com.mobiauto.opportunities.mappers;

import com.mobiauto.opportunities.dto.OpportunityDTO;
import com.mobiauto.opportunities.dto.OpportunityRequestDTO;
import com.mobiauto.opportunities.entity.Opportunity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OpportunityMapper {

    OpportunityDTO toOpportunityDTO(Opportunity opportunity);

    Opportunity fromOpportunityRequestDTO(OpportunityRequestDTO requestDTO);

    @Mapping(target = "client", ignore = true)
    @Mapping(target = "productInterest", ignore = true)
    void updateOpportunityFromRequestDTO(OpportunityRequestDTO requestDTO, @MappingTarget Opportunity opportunity);
}