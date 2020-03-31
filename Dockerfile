# the first stage of our build will use a maven 3.6.3 parent image
FROM maven:3.6.3-jdk-8 AS MAVEN_BUILD

# copy the pom and src code to the container
COPY ./ ./

# package our application code
RUN mvn clean package

FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/acs-assignment.jar

# cd /opt/app
WORKDIR acs-assignment.jar

# copy only the artifacts we need from the first stage and discard the rest
# cp target/acs-assignment.jar /opt/app/app.jar
COPY --from=MAVEN_BUILD ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]





#FROM openjdk:8-jdk-alpine
#
## Refer to Maven build -> finalName
#ARG JAR_FILE=target/acs-assignment.jar
#
## cd /opt/app
#WORKDIR acs-assignment.jar
#
## cp target/acs-assignment.jar /opt/app/app.jar
#COPY ${JAR_FILE} app.jar
#
## java -jar /opt/app/app.jar
#ENTRYPOINT ["java","-jar","app.jar"]