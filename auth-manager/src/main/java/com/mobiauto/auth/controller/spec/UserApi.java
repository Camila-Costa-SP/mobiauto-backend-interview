package com.mobiauto.auth.controller.spec;

import com.mobiauto.auth.dto.UserDto;
import com.mobiauto.auth.dto.UserRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping("/users")
public interface UserApi {

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create a new user")
    @ApiResponse(responseCode = "200", description = "User created successfully",
            content = @Content(schema = @Schema(implementation = UserDto.class)))
    ResponseEntity<UserDto> createUser(@RequestBody UserRequestDto userRequestDto);

    @PutMapping("/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    @Operation(summary = "Update a user")
    ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody UserRequestDto userRequest);

    @GetMapping("/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER', 'MANAGER', 'ASSISTANT')")
    @Operation(summary = "Get a user")
    ResponseEntity<UserDto> getUser(@PathVariable Long userId);


    @GetMapping("/users/by-username/{username}")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER', 'MANAGER')")
    @Operation(summary = "Get a user by username")
    ResponseEntity<UserDto> getUserByUsername(@PathVariable("username") String username);

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete a user")
    ResponseEntity<Void> deleteUser(@PathVariable Long userId);
}
