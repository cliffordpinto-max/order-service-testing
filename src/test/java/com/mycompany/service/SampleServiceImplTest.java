package com.mycompany.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.mycompany.dto.SampleResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit tests for SampleServiceImpl.
 *
 * <p>DELETE THIS test once you start implementing your own services. Write tests for your actual
 * business logic instead.
 */
@ExtendWith(MockitoExtension.class)
class SampleServiceImplTest {

  @InjectMocks private SampleServiceImpl sampleService;

  @Test
  void testGetSampleData() {
    // Act
    SampleResponseDto response = sampleService.getSampleData();

    // Assert
    assertNotNull(response);
    assertNotNull(response.getMessage());
    assertEquals("SUCCESS", response.getStatus());
    assertNotNull(response.getTimestamp());
  }
}
