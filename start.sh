#!/usr/bin/bash
echo "building project..."
mvn clean package -DskipTests

echo "starting application..."
java -jar target/spring-boot-example.jar