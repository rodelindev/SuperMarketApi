FROM maven:4.0.0-rc-5-eclipse-temurin-26 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:25-ea-21-jdk-slim
#ARG JAR_FILE=target/SuperMarketApi-0.0.1.jar
#COPY ${JAR_FILE} app_supermarketapi.jar
WORKDIR /app
COPY --from=build /app/target/SuperMarketApi-0.0.1.jar app_supermarketapi.jar
EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app_supermarketapi.jar"]
ENTRYPOINT ["java", "-jar", "app_supermarketapi.jar"]
