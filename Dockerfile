# Stage 1: Build your app using Maven with JDK 21
FROM maven:3.9.2-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom.xml separately to download dependencies (speed up builds)
COPY pom.xml .

# Download dependencies without building
RUN mvn dependency:go-offline

# Copy your source code
COPY src ./src

# Build your Spring Boot app (skip tests for faster build)
RUN mvn clean package -DskipTests

# Stage 2: Create a lightweight runtime image with just JRE
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Tell Docker the app listens on port 8080
EXPOSE 8080

# Run your app
ENTRYPOINT ["java", "-jar", "app.jar"]