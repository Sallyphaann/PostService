# Build Stage
FROM gradle:7.6-jdk17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the build files
COPY build.gradle settings.gradle ./
COPY src ./src

# Build the application
RUN gradle build --no-daemon

# Runtime Stage
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Specify the command to run your app
CMD ["java", "-jar", "app.jar"]
