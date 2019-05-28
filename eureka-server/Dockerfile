FROM openjdk:8-jre-slim
COPY target/eureka-server-0.0.1-SNAPSHOT.jar /usr/src/meru/
WORKDIR /usr/src/meru
EXPOSE 8081
CMD ["java", "-jar", "eureka-server-0.0.1-SNAPSHOT.jar"]