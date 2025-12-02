package com.mycompany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Global exception handler for the application.
 * 
 * Provides centralized exception handling across all @RequestMapping methods.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Handles all generic exceptions.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message", ex.getMessage());
    body.put("path", request.getDescription(false));

    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * Handles IllegalArgumentException.
   */
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Object> handleIllegalArgumentException(
      IllegalArgumentException ex, WebRequest request) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message", ex.getMessage());
    body.put("path", request.getDescription(false));

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }
}

