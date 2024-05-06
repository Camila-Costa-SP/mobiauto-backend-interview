package com.mobiauto.auth.dto;

import com.mobiauto.auth.enums.Roles;

public record AuthResponseDto(String token, String username, Roles role) {}