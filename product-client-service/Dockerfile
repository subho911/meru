FROM openjdk:8-jre-slim
COPY target/product-client-service-0.0.1-SNAPSHOT.jar /usr/src/meru/
WORKDIR /usr/src/meru
EXPOSE 8092
CMD ["java", "-jar", "product-client-service-0.0.1-SNAPSHOT.jar"]