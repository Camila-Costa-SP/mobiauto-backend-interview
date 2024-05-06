package com.mobiauto.auth.dto;

import com.mobiauto.auth.enums.Roles;

public record UserDto(Long id, String username, String email, Roles role) {}