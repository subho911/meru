FROM openjdk:8-jre-slim
COPY target/price-client-service-0.0.1-SNAPSHOT.jar /usr/src/meru/
WORKDIR /usr/src/meru
EXPOSE 8091
CMD ["java", "-jar", "price-client-service-0.0.1-SNAPSHOT.jar"]