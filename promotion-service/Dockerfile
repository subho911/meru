FROM openjdk:8-jre-slim
COPY target/promotion-service-0.0.1-SNAPSHOT.jar /usr/src/meru/
WORKDIR /usr/src/meru
EXPOSE 8087
CMD ["java", "-jar", "promotion-service-0.0.1-SNAPSHOT.jar"]