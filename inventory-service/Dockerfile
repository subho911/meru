FROM openjdk:8-jre-slim
COPY target/inventory-service-0.0.1-SNAPSHOT.jar /usr/src/meru/
WORKDIR /usr/src/meru
EXPOSE 8086
CMD ["java", "-jar", "inventory-service-0.0.1-SNAPSHOT.jar"]