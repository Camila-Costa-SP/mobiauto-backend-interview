package com.mobiauto.auth.dto;

import com.mobiauto.auth.annotation.ValidResaleRequirement;
import com.mobiauto.auth.enums.Roles;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
@ValidResaleRequirement
public record UserRequestDto(
        @NotNull
        String username,

        @NotNull
        String email,

        @NotNull
        String password,

        @NotNull
        Roles role,

        Set<Long> resaleIds) {}