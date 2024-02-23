FROM openjdk:17
ADD target/Cache_Task-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
