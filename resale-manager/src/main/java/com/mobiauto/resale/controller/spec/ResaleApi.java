package com.mobiauto.resale.controller.spec;

import com.mobiauto.resale.dto.ResaleDto;
import com.mobiauto.resale.dto.ResaleRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/resales")
public interface ResaleApi {

    @PostMapping("/")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER', 'MANAGER')")
    @Operation(summary = "Create a new resale", description = "Creates a new resale and returns the created object.")
    @ApiResponse(responseCode = "201", description = "Resale created successfully",
            content = @Content(schema = @Schema(implementation = ResaleDto.class)))
    ResponseEntity<ResaleDto> createResale(@Valid @RequestBody ResaleRequestDto resaleRequestDto);

    @GetMapping("/{id}")
    @Operation(summary = "Get a resale by ID", description = "Retrieves a resale by its ID.")
    @ApiResponse(responseCode = "200", description = "Resale retrieved successfully",
            content = @Content(schema = @Schema(implementation = ResaleDto.class)))
    ResponseEntity<ResaleDto> getResaleById(@PathVariable Long id);

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER', 'MANAGER')")
    @Operation(summary = "Update a resale", description = "Updates an existing resale.")
    @ApiResponse(responseCode = "200", description = "Resale updated successfully",
            content = @Content(schema = @Schema(implementation = ResaleDto.class)))
    ResponseEntity<ResaleDto> updateResale(@PathVariable Long id, @Valid @RequestBody ResaleRequestDto resaleRequestDto);

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete a resale", description = "Deletes a resale.")
    @ApiResponse(responseCode = "204", description = "Resale deleted successfully",
            content = @Content(schema = @Schema(implementation = Void.class)))
    ResponseEntity<Void> deleteResale(@PathVariable Long id);
}
