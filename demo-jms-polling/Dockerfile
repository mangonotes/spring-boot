# from java 8 base image 
FROM openjdk:8-jdk-alpine
# Maintiner email id 
LABEL maintainer="info@test.com"

#Volume
VOLUME /tmp


#Port number 

EXPOSE 8080


#Target files
ARG JAR_FILE=build/libs/demo-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} demo.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo.jar"]


