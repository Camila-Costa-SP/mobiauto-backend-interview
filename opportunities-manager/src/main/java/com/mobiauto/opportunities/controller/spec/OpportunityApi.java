package com.mobiauto.opportunities.controller.spec;

import com.mobiauto.opportunities.dto.OpportunityDTO;
import com.mobiauto.opportunities.dto.OpportunityRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/opportunities")
public interface OpportunityApi {

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('OWNER') or hasRole('MANAGER')")
    @Operation(summary = "Create a new opportunity", description = "Creates a new opportunity and returns the created object.")
    @ApiResponse(responseCode = "200", description = "Opportunity created successfully",
            content = @Content(schema = @Schema(implementation = OpportunityDTO.class)))
    ResponseEntity<OpportunityDTO> createOpportunity(@RequestBody OpportunityRequestDTO opportunity);

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SALES') or hasRole('OWNER') or hasRole('MANAGER')")
    @Operation(summary = "Get an opportunity", description = "Retrieves an opportunity by its ID.")
    @ApiResponse(responseCode = "200", description = "Opportunity retrieved successfully",
            content = @Content(schema = @Schema(implementation = OpportunityDTO.class)))
    ResponseEntity<OpportunityDTO> getOpportunity(@PathVariable Long id);

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SALES') or hasRole('OWNER') or hasRole('MANAGER')")
    @Operation(summary = "Update an opportunity", description = "Updates an existing opportunity.")
    @ApiResponse(responseCode = "200", description = "Opportunity updated successfully",
            content = @Content(schema = @Schema(implementation = OpportunityDTO.class)))
    ResponseEntity<OpportunityDTO> updateOpportunity(@PathVariable Long id, @RequestBody OpportunityRequestDTO opportunity);

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SALES') or hasRole('OWNER') or hasRole('MANAGER')")
    @Operation(summary = "List all opportunities", description = "Lists all available opportunities.")
    @ApiResponse(responseCode = "200", description = "Opportunities listed successfully",
            content = @Content(schema = @Schema(implementation = OpportunityDTO[].class)))
    ResponseEntity<List<OpportunityDTO>> getAllOpportunities();

    @PatchMapping("/{id}/status/{status}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @Operation(summary = "Update opportunity status", description = "Updates the status of an existing opportunity.")
    @ApiResponse(responseCode = "200", description = "Opportunity status updated successfully",
            content = @Content(schema = @Schema(implementation = OpportunityDTO.class)))
    ResponseEntity<OpportunityDTO> updateOpportunityStatus(@PathVariable Long id, @PathVariable String status);
}