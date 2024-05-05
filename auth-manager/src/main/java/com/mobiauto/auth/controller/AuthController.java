package com.mobiauto.auth.controller;

import com.mobiauto.auth.controller.spec.AuthApi;
import com.mobiauto.auth.dto.LoginDto;
import com.mobiauto.auth.dto.AuthResponseDto;
import com.mobiauto.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {

    @Autowired
    private AuthService authService;

    public ResponseEntity<AuthResponseDto> signIn(final LoginDto loginDto) {
        AuthResponseDto response = authService.authenticateUser(loginDto);
        return ResponseEntity.ok(response);
    }
}