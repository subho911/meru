FROM openjdk:8-jre-slim
COPY product-service-0.0.1-SNAPSHOT.jar /usr/src/meru/
WORKDIR /usr/src/meru
EXPOSE 8085
CMD ["java", "-jar", "product-service-0.0.1-SNAPSHOT.jar"]