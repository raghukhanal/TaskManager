# ---------- Stage 1: Build the application ----------
# Use Maven with JDK 21 to compile the project
FROM maven:3.9.2-jdk-21 AS build

# Set working directory inside the container
WORKDIR /app

# Copy Maven configuration first (for layer caching)
COPY pom.xml .
# Download all dependencies (helps cache)
RUN mvn dependency:go-offline

# Copy the source code into the container
COPY src ./src

# Build the application and skip tests to speed up
RUN mvn clean package -DskipTests


# ---------- Stage 2: Run the application ----------
# Use a smaller image with only the JRE
FROM eclipse-temurin:21-jre-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the app runs on (Spring Boot default)
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]