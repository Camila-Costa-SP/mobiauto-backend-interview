package com.mobiauto.opportunityhandler.mapper;

import com.mobiauto.opportunityhandler.dto.OpportunityAssignmentDTO;
import com.mobiauto.opportunityhandler.dto.OpportunityAssignmentRequestDTO;
import com.mobiauto.opportunityhandler.entity.OpportunityAssignment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OpportunityAssignmentMapper {
    OpportunityAssignmentDTO toDto(OpportunityAssignment entity);
    OpportunityAssignment toEntity(OpportunityAssignmentRequestDTO dto);

    void updateEntity(OpportunityAssignmentRequestDTO requestDTO, @MappingTarget OpportunityAssignment assignment);

}
