package com.mobiauto.resale.exceptions;

import java.time.LocalDateTime;

public record CustomErrorResponse(LocalDateTime timestamp, Integer status, String error) {}