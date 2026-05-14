FROM openjdk:25-jdk
ARG JAR_FILE=target/SuperMarketApi-0.0.1.jar
COPY ${JAR_FILE} app_supermarketapi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_supermarketapi.jar"]
