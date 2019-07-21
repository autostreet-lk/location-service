FROM openjdk:12
LABEL maintainer="chathurangat@gmail.com"
WORKDIR /app
COPY target/location-service.jar /app/location-service.jar
ENTRYPOINT ["java","-jar","location-service.jar"]