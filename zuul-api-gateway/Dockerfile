FROM openjdk:8-jre-slim
COPY target/zuul-api-gateway-0.0.1-SNAPSHOT.jar /usr/src/meru/
WORKDIR /usr/src/meru
EXPOSE 8082
CMD ["java", "-jar", "zuul-api-gateway-0.0.1-SNAPSHOT.jar"]