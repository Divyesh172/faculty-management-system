# --------- Stage 1: Build the Application ---------
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy the source code and pom.xml to the container
COPY . .

# Build the application inside the container (skipping tests to save time)
RUN mvn clean package -DskipTests

# --------- Stage 2: Run the Application ---------
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copy the WAR file generated in the previous stage
# Note: We grab it from the 'build' stage
COPY --from=build /app/target/faculty-management-1.0.0.war app.war

# Expose the port (Render will override this via Env Variable, which is fine)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.war"]