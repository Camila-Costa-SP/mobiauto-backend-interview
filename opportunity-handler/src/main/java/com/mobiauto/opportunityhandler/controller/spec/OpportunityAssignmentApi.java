package com.mobiauto.opportunityhandler.controller.spec;

import com.mobiauto.opportunityhandler.dto.OpportunityAssignmentDTO;
import com.mobiauto.opportunityhandler.dto.OpportunityAssignmentRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/opportunity-assignments")
public interface OpportunityAssignmentApi {

    @GetMapping("/{id}")
    @PreAuthorize(" hasAnyRole('ADMIN') or @securityService.canAccessAssignment(principal, #id)")
    @Operation(summary = "Get an opportunity assignment", description = "Retrieves an opportunity assignment by its ID.")
    @ApiResponse(responseCode = "200", description = "Opportunity assignment retrieved successfully",
            content = @Content(schema = @Schema(implementation = OpportunityAssignmentDTO.class)))
    ResponseEntity<OpportunityAssignmentDTO> getAssignment(@PathVariable Long id);

    @PutMapping("/{id}")
    @PreAuthorize(" hasAnyRole('ADMIN') or @securityService.canAccessAssignment(principal, #id)")
    @Operation(summary = "Update an opportunity assignment", description = "Updates an existing opportunity assignment.")
    @ApiResponse(responseCode = "200", description = "Opportunity assignment updated successfully",
            content = @Content(schema = @Schema(implementation = OpportunityAssignmentDTO.class)))
    ResponseEntity<OpportunityAssignmentDTO> updateAssignment(@PathVariable Long id, @RequestBody OpportunityAssignmentRequestDTO requestDTO);

    @GetMapping
    @Operation(summary = "List all opportunity assignments", description = "Lists all available opportunity assignments.")
    @ApiResponse(responseCode = "200", description = "Opportunity assignments listed successfully",
            content = @Content(schema = @Schema(implementation = OpportunityAssignmentDTO[].class)))
    ResponseEntity<List<OpportunityAssignmentDTO>> listAllAssignments();
}