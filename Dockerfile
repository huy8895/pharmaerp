FROM amazoncorretto:19-alpine
ARG JAR_FILE=phamarerp.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]