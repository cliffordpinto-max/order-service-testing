package com.mycompany.controller;

import com.mycompany.dto.SampleResponseDto;
import com.mycompany.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample REST controller.
 * 
 * This is a plain Spring REST controller that can be used as a reference.
 * Replace this with your own controllers that implement the API interfaces
 * generated from your OpenAPI specification.
 * 
 * <p>After defining your API in src/main/resources/openapi/api-spec.yaml:
 * <ol>
 *   <li>Run: ./mvnw clean compile</li>
 *   <li>API interfaces will be generated in target/generated-sources/openapi/.../api/</li>
 *   <li>Model classes will be generated in target/generated-sources/openapi/.../model/</li>
 *   <li>Create controllers that implement the generated API interfaces</li>
 * </ol>
 */
@RestController
@RequestMapping("/api")
public class SampleController {

  private final SampleService sampleService;

  @Autowired
  public SampleController(SampleService sampleService) {
    this.sampleService = sampleService;
  }

  /**
   * Sample endpoint - DELETE THIS and replace with your own endpoints
   * that implement OpenAPI-generated interfaces.
   */
  @GetMapping("/sample")
  public ResponseEntity<SampleResponseDto> getSample() {
    SampleResponseDto response = sampleService.getSampleData();
    return ResponseEntity.ok(response);
  }
}

