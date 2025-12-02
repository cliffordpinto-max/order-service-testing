# Multi-stage Dockerfile for ${serviceName}
# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-21-jammy AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml ./
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine

# Create non-root user for security
RUN adduser -D -h /home/appuser appuser
USER appuser

# Copy the built artifact from build stage
COPY --from=build /app/target/*.jar /app/${serviceName}.jar

# Expose the application port
EXPOSE ${servicePort}

# Run the application
ENTRYPOINT ["java", "-jar", "/app/${serviceName}.jar"]

