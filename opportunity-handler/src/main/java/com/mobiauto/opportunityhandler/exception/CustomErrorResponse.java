package com.mobiauto.opportunityhandler.exception;

import java.time.LocalDateTime;

public record CustomErrorResponse(LocalDateTime timestamp, Integer status, String error, String path) {}