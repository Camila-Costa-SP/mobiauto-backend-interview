package com.mobiauto.opportunities.exception;

import java.time.LocalDateTime;

public record CustomErrorResponse(LocalDateTime timestamp, Integer status, String error, String path) {}
