package com.mobiauto.auth.controller.spec;

import com.mobiauto.auth.dto.AuthResponseDto;
import com.mobiauto.auth.dto.LoginDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthApi {

    @PostMapping("/sign-in")
    @Operation(summary = "Sign in a user", description = "Authenticates a user and returns a JWT token.")
    @ApiResponse(responseCode = "200", description = "Successful authentication",
            content = @Content(schema = @Schema(implementation = AuthResponseDto.class)))
    ResponseEntity<AuthResponseDto> signIn(@RequestBody LoginDto loginDto);
}