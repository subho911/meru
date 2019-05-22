FROM openjdk:8

MAINTAINER Shwethashree Venkatesh <shwethashreeec@gmail.com>

VOLUME /tmp

EXPOSE 8091

ARG JAR_FILE=target/meru-client-0.0.1-SNAPSHOT.war

ADD ${JAR_FILE} meru-client.war

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "meru-client.war"]


