FROM ubuntujdk11

MAINTAINER Mike "lamprakism9@gmail.com"

CMD ["catalina.sh", "run"]

ENV version=docker

WORKDIR /usr/local/bin

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]
