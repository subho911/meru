FROM openjdk:8-jre-slim
COPY target/config-server-0.0.1-SNAPSHOT.jar /usr/src/meru/
WORKDIR /usr/src/meru
EXPOSE 8888
CMD ["java", "-jar", "config-server-0.0.1-SNAPSHOT.jar"]