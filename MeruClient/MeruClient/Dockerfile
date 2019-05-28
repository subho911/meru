FROM openjdk:8-jre-slim
COPY target/promotion-client-service-0.0.1-SNAPSHOT.jar /usr/src/meru/
WORKDIR /usr/src/meru
EXPOSE 8093
CMD ["java", "-jar", "promotion-client-service-0.0.1-SNAPSHOT.jar"]