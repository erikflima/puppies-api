#Dockerfile

#Download Maven image from DockerHub (https://hub.docker.com/layers/library/maven/3.8.7-openjdk-18-slim/images/sha256-6e08ab80ed557294e30c9555c923e7620a8125b4f207996d961535789088339b?context=explore)
FROM maven:3.9.4-eclipse-temurin-21-alpine AS MAVEN_IMAGE

#Copy the pom.xml from the project directory to the /build/ directory in the container.
COPY pom.xml /build/

#Copy the src directory from the project directory to the /build/src/ directory in the container.
COPY src /build/src/

#Copy the content of the application-docker.properties file (from the project) to application.properties (in the container).
COPY src/main/resources/application-docker.properties /build/src/main/resources/application.properties

#Change to the /build/ directory in the container.
WORKDIR /build/

#Run the mvn package command in the /build/ directory in the container. This will compile the project and generate the .jar file of the project.
RUN mvn clean package

#Download Java 21 image (https://hub.docker.com/layers/library/openjdk/21-jdk-slim/images/sha256-e4a3bdabc7648f608c03c6b661e05aa1b0d16858d5e7c064f3158135f65760d6?context=explore)
FROM openjdk:21-jdk-slim

#Copy the compiled file from the previous image
COPY --from=MAVEN_IMAGE /build/target/*.jar puppies-api.jar

#Expose the port on which the application will run
EXPOSE 8080

#Command to run the application
ENTRYPOINT ["java", "-jar", "/puppies-api.jar"]