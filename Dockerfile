# Use an official JDK as a builder
FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR /app

COPY target/*.jar app.jar

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/app.jar .

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
