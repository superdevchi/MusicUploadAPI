FROM openjdk:17-jdk

#copy the jar file into docker image
COPY target/*.jar app.jar

#Run jar file
ENTRYPOINT ["java","-jar","/app.jar"]