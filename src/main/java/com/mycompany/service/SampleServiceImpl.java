package com.mycompany.service;

import com.mycompany.dto.SampleResponseDto;
import org.springframework.stereotype.Service;

/**
 * Implementation of SampleService.
 *
 * <p>This is a sample implementation showing the service layer pattern. DELETE THIS class and
 * replace with your actual business logic.
 *
 * <p>Your services should work with OpenAPI-generated models or your own domain models.
 */
@Service
public class SampleServiceImpl implements SampleService {

  @Override
  public SampleResponseDto getSampleData() {
    return new SampleResponseDto("Hello from order-service!", "SUCCESS");
  }
}
