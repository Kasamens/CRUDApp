FROM openjdk:17
EXPOSE 9090
ADD target/crud-app.jar crud-app.jar
ENTRYPOINT ["java","-jar","/crud-app.jar"]