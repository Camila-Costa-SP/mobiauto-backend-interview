package com.mobiauto.auth.exceptions;

import static com.mobiauto.auth.enums.ErrorType.JWT_TOKEN_EXPIRED;

public class JwtAuthenticationException extends RuntimeException {
    public JwtAuthenticationException() {
        super(JWT_TOKEN_EXPIRED.getMessage());
    }
}
