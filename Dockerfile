FROM openjdk:8

WORKDIR /app

COPY build/libs/desafio-0.0.1-SNAPSHOT.jar desafio-api.jar

CMD ["java", "-jar", "desafio-api.jar"]