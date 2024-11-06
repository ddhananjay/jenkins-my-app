FROM openjdk:17
LABEL authors="ddhananjay"

RUN mkdir /home/app

COPY ./build/libs/my-app-0.1-SNAPSHOT.jar /home/app/my-app-0.1-SNAPSHOT.jar

WORKDIR /home/app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "my-app-0.1-SNAPSHOT.jar"]