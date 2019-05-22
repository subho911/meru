FROM openjdk:8

MAINTAINER Shwethashree Venkatesh <shwethashreeec@gmail.com>

VOLUME /tmp

EXPOSE 8082

ARG JAR_FILE=target/api-gateway-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} api-gateway.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "api-gateway.jar"]


