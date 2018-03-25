FROM openjdk:8-jre
MAINTAINER Kleber Faustino <faustikle@gmail.com>

ARG API_VERSION

ADD target/desafio-analise-credito-${API_VERSION}.jar /usr/share/desafio/analise-credito-api.jar

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/desafio/analise-credito-api.jar"]
