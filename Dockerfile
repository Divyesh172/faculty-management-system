# --------- Stage 1: Build the Application ---------
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the JAR (skipping tests to speed up CI/CD)
RUN mvn clean package -DskipTests

# --------- Stage 2: Run the Application ---------
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/faculty-management-1.0.0.jar app.jar

# Render will override this port, but 8080 is the local default
EXPOSE 8080

# Run the stateless container
ENTRYPOINT ["java", "-jar", "app.jar"]
