package com.mobiauto.auth.dto;

public record UserRequestDto(String username, String email, String password, String role) {}