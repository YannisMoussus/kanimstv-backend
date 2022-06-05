FROM openjdk:11.0.15-jdk
ARG JAR_FILE=/target/kanimstv-backend-0.0.1-SNAPSHOT.jar
COPY  ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]