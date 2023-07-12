FROM openjdk:8
EXPOSE 8080

COPY target/employeeapp-0.0.1-SNAPSHOT.jar employeeapp-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java", "-jar", "/employeeapp-0.0.1-SNAPSHOT.jar"]
