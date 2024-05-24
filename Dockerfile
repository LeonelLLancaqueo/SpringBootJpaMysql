FROM  openjdk:17-sdk-slim
ARG JAR_FILE= build/libs/empresa-0.0.1.jar
COPY ${JAR_FILE} app_empresa.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app_empresa.jar"]
