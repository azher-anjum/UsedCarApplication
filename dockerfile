# syntax=docker/dockerfile:1
# --- Stage 1: Build ---
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
# Speed boost: cache dependencies
RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline -B
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn clean package -DskipTests

# --- Stage 2: Runtime ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# JSP requirement: Create a writable temp directory
RUN mkdir -p /tmp/tomcat && chown -R 1000:1000 /tmp/tomcat
COPY --from=build /app/target/*.jar app.jar

USER 1000
EXPOSE 8080

# Run with tmpdir defined for JSP compilation
ENTRYPOINT ["java", "-Djava.io.tmpdir=/tmp/tomcat", "-jar", "app.jar"]