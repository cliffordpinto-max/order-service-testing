package com.mycompany.dto;

import java.time.LocalDateTime;

/**
 * Sample DTO (Data Transfer Object).
 *
 * <p>This is a simple DTO for demonstration purposes. DELETE THIS class once you start using
 * OpenAPI-generated models.
 *
 * <p>Your OpenAPI specification will generate model classes automatically. Use those generated
 * models in your controllers instead of creating DTOs manually.
 */
public class SampleResponseDto {

  private String message;
  private String status;
  private LocalDateTime timestamp;

  public SampleResponseDto() {
    this.timestamp = LocalDateTime.now();
  }

  public SampleResponseDto(String message, String status) {
    this.message = message;
    this.status = status;
    this.timestamp = LocalDateTime.now();
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}
