# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container
# Ensure you run 'mvn clean package' before 'docker build'
COPY target/faculty-management-1.0.0.war app.war

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.war"]