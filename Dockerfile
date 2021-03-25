FROM openjdk:11-jdk-slim
VOLUME /tmp
ADD target/gender-validator-0.0.1-SNAPSHOT.jar gender-validator.jar
ENTRYPOINT ["java","-jar","/gender-validator.jar"]
