FROM maven:3.8.5-openjdk-17 AS build
COPY music-stream .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

#copy the jar file into docker image
COPY --from=build /target/*.jar app.jar
EXPOSE 9090
#Run jar file
ENTRYPOINT ["java","-jar","/app.jar"]