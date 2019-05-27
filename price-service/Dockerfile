FROM openjdk:8-jre-slim
COPY target/price-service-0.0.1-SNAPSHOT.jar /usr/src/meru/
WORKDIR /usr/src/meru
EXPOSE 8090
CMD ["java", "-jar", "price-service-0.0.1-SNAPSHOT.jar"]