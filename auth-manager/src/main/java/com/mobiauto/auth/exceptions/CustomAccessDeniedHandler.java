package com.mobiauto.auth.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.io.PrintWriter;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private static final String ACCESS_DENIED_JSON = "{\"error\": \"Access Denied: %s\"}";

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        String jsonResponse = String.format(ACCESS_DENIED_JSON, accessDeniedException.getMessage());

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        try (PrintWriter writer = response.getWriter()) {
            writer.write(jsonResponse);
        }
    }
}