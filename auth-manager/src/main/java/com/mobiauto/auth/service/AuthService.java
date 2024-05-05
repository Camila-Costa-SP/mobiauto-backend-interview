package com.mobiauto.auth.service;

import com.mobiauto.auth.dto.LoginDto;
import com.mobiauto.auth.dto.AuthResponseDto;

public interface AuthService {
    AuthResponseDto authenticateUser(final LoginDto loginDto);
}