FROM openjdk:8
EXPOSE 8080
ADD target/spring-boot-docker-parking.jar spring-boot-docker-parking.jar
ENTRYPOINT ["java","/jar","/spring-boot-docker-parking.jar"]
