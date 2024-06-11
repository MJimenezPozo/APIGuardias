# Proyecto API REST de Guardias de Profesores

## Descripción

Este proyecto es una API REST desarrollada en Java con Spring Boot, diseñada para gestionar las guardias de profesores en una institución educativa. 
Proporciona endpoints para crear, leer, actualizar y eliminar registros de guardias, así como para asignar y gestionar las guardias de los profesores.

## Tecnologías usadas

- Spring Boot
- Spring Security
- jsonwebtoken

## Requisitos

- Java 17 o superior
- Maven 3.8.1 o superior
- PostgreSQL 12 o superior (o cualquier otra base de datos relacional compatible)

## Instalación


1. Clona el repositorio en tu máquina local:
    ```bash
    git clone https://github.com/MJimenezPozo/APIGuardias.git
    ```

2. Navega al directorio del proyecto:
    ```bash
    cd APIGuardias
    ```

3. Compila y ejecuta el proyecto con Maven:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
4. Prueba la API Rest usando Postman o Swagger en http://localhost:8080.
