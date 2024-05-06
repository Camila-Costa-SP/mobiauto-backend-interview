package com.mobiauto.auth.dto;

import com.mobiauto.auth.enums.Roles;

public record UserRequestDto(String username, String email, String password, Roles role) {}