package com.mobiauto.auth.controller.spec;
import com.mobiauto.auth.dto.UserDto;
import com.mobiauto.auth.dto.UserRequestDto;
import com.mobiauto.auth.enums.Roles;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/users")
public interface UserApi {

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN') or (hasAnyRole('OWNER', 'MANAGER') " +
            "and @securityService.canCreateUser(principal, #userRequestDto.resaleIds))")
    @Operation(summary = "Create a new user")
    @ApiResponse(responseCode = "200", description = "User created successfully",
            content = @Content(schema = @Schema(implementation = UserDto.class)))
    ResponseEntity<UserDto> createUser(@RequestBody @Valid  UserRequestDto userRequestDto);

    @PutMapping("/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER', 'MANAGER') and @securityService.canUpdateUser(principal, #userId)")
    @Operation(summary = "Update a user")
    ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody UserRequestDto userRequest);

    @GetMapping("/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER', 'MANAGER', 'ASSISTANT')")
    @Operation(summary = "Get a user")
    ResponseEntity<UserDto> getUser(@PathVariable Long userId);

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER', 'MANAGER', 'ASSISTANT')")
    @Operation(summary = "Get a user by email")
    ResponseEntity<UserDto> getUserByEmail(@RequestParam("email") String email);

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete a user")
    ResponseEntity<Void> deleteUser(@PathVariable Long userId);

    @GetMapping("/by-role-and-resale")
    @PreAuthorize("hasRole('ADMIN') or (hasRole('OWNER' MANAGER) " +
            "and @securityService.canAccessResaleData(principal, #resaleId))")
    @Operation(summary = "Get users by role and resale ID")
    ResponseEntity<List<UserDto>> getUsersByRoleAndResale(@RequestParam Roles role, @RequestParam Long resaleId);
}