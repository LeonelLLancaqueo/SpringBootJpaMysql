FROM  eclipse-temurin:17-jdk-alpine
ARG JAR_FILE= ./build/libs/empresa*.war
COPY ./build/libs/empresa.war empresa.war
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/empresa.war"]
