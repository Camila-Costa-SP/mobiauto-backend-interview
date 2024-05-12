package com.mobiauto.opportunityhandler.service.impl;

import com.mobiauto.opportunityhandler.dto.OpportunityAssignmentDTO;
import com.mobiauto.opportunityhandler.dto.OpportunityAssignmentRequestDTO;
import com.mobiauto.opportunityhandler.entity.OpportunityAssignment;
import com.mobiauto.opportunityhandler.exception.AssignmentNotFoundException;
import com.mobiauto.opportunityhandler.mapper.OpportunityAssignmentMapper;
import com.mobiauto.opportunityhandler.repository.OpportunityAssignmentRepository;
import com.mobiauto.opportunityhandler.service.OpportunityAssignmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpportunityAssignmentServiceImpl implements OpportunityAssignmentService {
    @Autowired
    private OpportunityAssignmentRepository repository;

    @Autowired
    private OpportunityAssignmentMapper mapper;

    public OpportunityAssignmentDTO getAssignment(Long id) {
        OpportunityAssignment assignment = getOpportunityAssignment(id);
        return mapper.toDto(assignment);
    }

    @Transactional
    public OpportunityAssignmentDTO updateAssignment(Long id, OpportunityAssignmentRequestDTO requestDTO) {
        OpportunityAssignment assignment = getOpportunityAssignment(id);
        mapper.updateEntity(requestDTO, assignment);
        assignment.setCompletionDate(LocalDateTime.now());
        repository.save(assignment);
        return mapper.toDto(assignment);
    }

    public List<OpportunityAssignmentDTO> listAllAssignments() {
        List<OpportunityAssignment> assignments = repository.findAll();
        return assignments.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    private OpportunityAssignment getOpportunityAssignment(Long id) {
        return repository.findById(id)
                .orElseThrow(AssignmentNotFoundException::new);
    }
}