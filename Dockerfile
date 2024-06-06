
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template
FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn

RUN chmod +x mvnw

RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17-jdk-slim
WORKDIR /APIGuardias
COPY --from=build target/*.jar Guardias-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Guardias-0.0.1-SNAPSHOT.jar"]

