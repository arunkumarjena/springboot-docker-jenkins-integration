FROM openjdk:8
EXPOSE 8080
ADD target/spring-boot-rest-tutorial-0.0.1-SNAPSHOT.jar spring-boot-rest-tutorial-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spring-boot-rest-tutorial-0.0.1-SNAPSHOT.jar"]