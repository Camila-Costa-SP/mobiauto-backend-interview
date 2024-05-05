package com.mobiauto.auth.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<CustomErrorResponse> handleInvalidEmailException(HttpServletRequest request, InvalidEmailException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<CustomErrorResponse> handleInvalidPasswordException(HttpServletRequest request, InvalidPasswordException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<CustomErrorResponse> handleUserAlreadyExistsException(HttpServletRequest request, UserAlreadyExistsException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleUserNotFoundException(HttpServletRequest request, UserNotFoundException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(JwtAuthenticationException.class)
    public ResponseEntity<CustomErrorResponse> handleJwtAuthenticationException(HttpServletRequest request, JwtAuthenticationException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.UNAUTHORIZED, request);
    }

    private ResponseEntity<CustomErrorResponse> buildErrorResponse(String message, HttpStatus status, HttpServletRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                status.value(),
                message,
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, status);
    }
}