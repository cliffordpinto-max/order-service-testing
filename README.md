# ${serviceName}

${serviceDescription}

This project was generated using the **Spring Boot OpenAPI Service Archetype**, which provides a comprehensive microservice skeleton with:

- ✅ OpenAPI 3.0 specification support with automatic code generation
- ✅ Spring Boot 3.4.6 with Java 21
- ✅ Comprehensive testing setup (Unit & Integration tests)
- ✅ Code quality tools (Spotless with Google Java Format)
- ✅ Security scanning (SpotBugs with FindSecBugs)
- ✅ Code coverage reporting (JaCoCo with 90% threshold)
- ✅ Docker support with multi-stage builds
- ✅ Swagger UI for API documentation
- ✅ Health checks and metrics (Spring Boot Actuator)

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [OpenAPI Specification](#openapi-specification)
- [Building the Project](#building-the-project)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Code Quality](#code-quality)
- [Docker](#docker)
- [API Documentation](#api-documentation)
- [Project Structure](#project-structure)

## Prerequisites

- Java 21 or higher
- Maven 3.9+ (or use the included Maven wrapper)
- Docker (optional, for containerization)
- PostgreSQL (for local development)
- Kafka (optional, if using messaging)

## Getting Started

### 1. Clone the Repository

```bash
git clone <your-repo-url>
cd ${artifactId}
```

### 2. Configure Database

Update `src/main/resources/application-local.yml` with your database credentials:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/your_database
    username: your_username
    password: your_password
```

### 3. Build the Project

```bash
./mvnw clean install
```

This will:
- Generate API interfaces and models from your OpenAPI specification
- Compile the code
- Run all tests
- Check code formatting
- Run security scans
- Generate coverage reports

## OpenAPI Specification

### Location

The OpenAPI specification is located at:
```
src/main/resources/openapi/api-spec.yaml
```

### Modifying the API

1. Edit the `api-spec.yaml` file to define your API endpoints and models
2. Run `./mvnw clean compile` to regenerate the API interfaces and models
3. The generated code will be in:
   - API interfaces: `target/generated-sources/openapi/src/main/java/${package}/api/`
   - Model classes: `target/generated-sources/openapi/src/main/java/${package}/model/`

### Implementing Controllers

To implement an API endpoint:

1. Create a controller class that implements the generated API interface:

```java
@RestController
public class YourController implements YourApi {
    
    @Override
    public ResponseEntity<YourResponse> yourEndpoint() {
        // Your implementation
    }
}
```

The OpenAPI Generator creates the interface with all the Spring annotations, so you just need to implement the business logic.

## Building the Project

### Compile and Generate OpenAPI Code

```bash
./mvnw clean compile
```

### Run All Tests

```bash
./mvnw test
```

### Package the Application

```bash
./mvnw package
```

### Skip Tests (Not Recommended)

```bash
./mvnw package -DskipTests
```

## Running the Application

### Local Development

```bash
./mvnw spring-boot:run
```

Or run the packaged JAR:

```bash
java -jar target/${serviceName}.jar
```

The application will start on: `http://localhost:${servicePort}${contextPath}`

### Different Profiles

#### Local Profile (default)
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

#### Deployment Profile
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=deployment
```

## Testing

### Run Unit Tests

```bash
./mvnw test
```

### Run with Coverage Report

```bash
./mvnw clean test jacoco:report
```

View the coverage report at: `target/site/jacoco/index.html`

### Coverage Threshold

The project enforces a **90% code coverage** threshold. Build will fail if coverage is below this threshold.

To modify the threshold, edit the `minimum.coverage` property in `pom.xml`:

```xml
<properties>
    <minimum.coverage>90</minimum.coverage>
</properties>
```

## Code Quality

### Code Formatting (Spotless)

Check code formatting:
```bash
./mvnw spotless:check
```

Auto-fix formatting issues:
```bash
./mvnw spotless:apply
```

The project uses **Google Java Format** style.

### Security Scanning (SpotBugs)

Run security scan:
```bash
./mvnw spotbugs:check
```

Generate detailed report:
```bash
./mvnw spotbugs:spotbugs
```

View the report at: `target/site/spotbugs.html`

### Run All Quality Checks

```bash
./mvnw verify
```

This runs:
- Compilation
- Tests
- Code coverage check
- Security scan
- Code formatting check

## Docker

### Build Docker Image

```bash
docker build -t ${serviceName}:latest .
```

### Run Container

```bash
docker run -p ${servicePort}:${servicePort} ${serviceName}:latest
```

### Docker Compose (if applicable)

Create a `docker-compose.yml` file for your service and dependencies (database, Kafka, etc.).

## API Documentation

### Swagger UI

Once the application is running, access the Swagger UI at:

```
http://localhost:${servicePort}${contextPath}/swagger-ui.html
```

### OpenAPI JSON

The OpenAPI specification in JSON format is available at:

```
http://localhost:${servicePort}${contextPath}/api-docs
```

## Project Structure

```
${artifactId}/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ${package}/
│   │   │       ├── Application.java              # Main application class
│   │   │       ├── config/                       # Configuration classes
│   │   │       │   └── OpenApiConfig.java
│   │   │       ├── controller/                   # REST controllers
│   │   │       │   └── SampleController.java
│   │   │       ├── service/                      # Business logic
│   │   │       │   ├── SampleService.java
│   │   │       │   └── SampleServiceImpl.java
│   │   │       ├── repository/                   # Data access layer (create JPA repos here)
│   │   │       └── exception/                    # Exception handling
│   │   │           └── GlobalExceptionHandler.java
│   │   └── resources/
│   │       ├── openapi/
│   │       │   └── api-spec.yaml                # OpenAPI specification
│   │       ├── application.yml                  # Main configuration
│   │       ├── application-local.yml            # Local profile config
│   │       └── application-deployment.yml       # Deployment profile config
│   └── test/
│       └── java/
│           └── ${package}/
│               ├── ApplicationTests.java
│               ├── controller/
│               │   └── SampleControllerTest.java
│               └── service/
│                   └── SampleServiceImplTest.java
├── target/
│   └── generated-sources/
│       └── openapi/                             # Auto-generated API code
│           └── src/main/java/
│               └── ${package}/
│                   ├── api/                     # Generated API interfaces
│                   └── model/                   # Generated model classes
├── Dockerfile                                   # Multi-stage Docker build
├── spotbugs-security-include.xml               # Security scan rules
├── spotbugs-security-exclude.xml               # Security scan exclusions
├── pom.xml                                      # Maven configuration
└── README.md                                    # This file
```

## Development Workflow

### 1. Define Your API

Edit `src/main/resources/openapi/api-spec.yaml` to define your API endpoints, request/response models, and validations.

### 2. Generate Code

```bash
./mvnw clean compile
```

This generates the API interfaces and model classes.

### 3. Implement Business Logic

Create controllers that implement the generated API interfaces and add your business logic in service classes.

### 4. Write Tests

Write unit tests for your services and integration tests for your controllers.

### 5. Check Quality

```bash
./mvnw verify
```

Ensures all tests pass, coverage is met, code is formatted, and no security issues exist.

### 6. Run Locally

```bash
./mvnw spring-boot:run
```

### 7. Test with Swagger UI

Open `http://localhost:${servicePort}${contextPath}/swagger-ui.html` and test your endpoints.

## Common Issues and Solutions

### Issue: OpenAPI code generation fails

**Solution:** Ensure your `api-spec.yaml` is valid OpenAPI 3.0 syntax. Use the [Swagger Editor](https://editor.swagger.io/) to validate.

### Issue: Tests fail due to missing beans

**Solution:** Ensure your test configuration includes all necessary dependencies. Use `@MockBean` for mocking dependencies in controller tests.

### Issue: Coverage threshold not met

**Solution:** Add more unit tests to cover untested code paths. Exclude only DTOs, configuration, and generated code from coverage.

### Issue: Spotless formatting check fails

**Solution:** Run `./mvnw spotless:apply` to auto-fix formatting issues.

## CI/CD Integration

This project is ready for CI/CD pipelines. The Maven build includes:

- Automated testing
- Code coverage verification (90% threshold)
- Security scanning
- Code formatting validation

Example GitHub Actions workflow:

```yaml
name: CI

on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK 21
        uses: actions/setup-java@v3
        with:
          java-version: '21'
          distribution: 'temurin'
      - name: Build and Test
        run: ./mvnw clean verify
```

## Contributing

1. Follow the existing code style (Google Java Format)
2. Write tests for new features
3. Ensure `./mvnw verify` passes before committing
4. Update the OpenAPI spec for API changes

## License

[Add your license information here]

## Contact

[Add contact information here]

---

**Generated from Spring Boot OpenAPI Service Archetype v1.0.0**

