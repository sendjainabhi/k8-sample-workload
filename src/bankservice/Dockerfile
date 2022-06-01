FROM openjdk:8-jdk-alpine
ADD target/bankservice-mysql.jar bankservice-mysql.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "bankservice-mysql.jar"]