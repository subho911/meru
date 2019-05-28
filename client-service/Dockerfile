FROM openjdk:8-jre-slim
COPY target/client-service-0.0.1-SNAPSHOT.jar /usr/src/meru/
WORKDIR /usr/src/meru
EXPOSE 8089
CMD ["java", "-jar", "client-service-0.0.1-SNAPSHOT.jar"]