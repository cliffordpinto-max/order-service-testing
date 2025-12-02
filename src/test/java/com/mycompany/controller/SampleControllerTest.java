package com.mycompany.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mycompany.dto.SampleResponseDto;
import com.mycompany.service.SampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Unit tests for SampleController.
 * 
 * <p>DELETE THIS test once you start implementing your own controllers.
 * Write tests for your OpenAPI-generated endpoints instead.
 */
@WebMvcTest(SampleController.class)
class SampleControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private SampleService sampleService;

  @Test
  void testGetSample() throws Exception {
    // Arrange
    SampleResponseDto response = new SampleResponseDto("Test Message", "SUCCESS");
    when(sampleService.getSampleData()).thenReturn(response);

    // Act & Assert
    mockMvc
        .perform(get("/api/sample"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Test Message"))
        .andExpect(jsonPath("$.status").value("SUCCESS"));
  }
}

