FROM openjdk:8

MAINTAINER Shwethashree Venkatesh <shwethashreeec@gmail.com>

VOLUME /tmp

EXPOSE 8082

ARG JAR_FILE=target/product-service-0.0.1-SNAPSHOT.war

ADD ${JAR_FILE} product-service.war

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "product-service.war"]


