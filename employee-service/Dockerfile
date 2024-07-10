# Use a base image with JDK 17
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the build artifact from the target directory to the container
COPY target/employee-service-0.0.1-SNAPSHOT.jar employee-service.jar

# Expose port 8080
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "employee-service.jar"]
