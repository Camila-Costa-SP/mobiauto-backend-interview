package com.mobiauto.auth.dto;

import com.mobiauto.auth.enums.Roles;

import java.util.Set;

public record UserDto(Long id, String username, String email, Roles role, Set<Long> resaleIds) {}