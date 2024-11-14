<p align="center">
  <span style="display:inline-block; width: 50px;"></span>
  <a href="#" target="blank"><img src="https://www.pngkey.com/png/full/297-2971509_star-wars-rebel-symbol-png.png" height="125" alt="Rebel Alliance Logo" /></a>
</p>

# **Operación Fuego de Quásar**
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)&nbsp;
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)&nbsp;
![Spring Boot](https://img.shields.io/badge/spring%20boot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)&nbsp;
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)&nbsp;
![ElasticSearch](https://img.shields.io/badge/-ElasticSearch-005571?style=for-the-badge&logo=elasticsearch)&nbsp;
![Git](https://img.shields.io/badge/git-%23F05032.svg?style=for-the-badge&logo=git&logoColor=white)&nbsp;
![Docker](https://img.shields.io/badge/docker-%232496ED.svg?style=for-the-badge&logo=docker&logoColor=white)&nbsp;
![Swagger](https://img.shields.io/badge/-Swagger-%85EA2D?style=for-the-badge&logo=swagger&logoColor=white)&nbsp;

## **Contenido**
- [Propósito del Proyecto](#propósito-del-proyecto)
- [Pre-requisitos](#pre-requisitos)
- [Instalación y Ejecución](#instalación-y-ejecución)
- [Herramientas Principales](#herramientas-principales)
    - [Uso de Swagger](#uso-de-swagger)
    - [Monitoreo con Elastic APM desde Kibana](#monitoreo-con-elastic-apm-desde-kibana)
    - [Procesamiento de Logs con Logstash desde Kibana](#procesamiento-de-logs-con-logstash-desde-kibana)
    - [Acceso a MongoDB desde MongoDB Compass](#acceso-a-mongodb-desde-mongodb-compass)
- [Diagramas de Arquitectura Modelo C4](#diagramas-de-arquitectura-modelo-c4)
    - [Nivel 1: Diagrama de Contexto](#nivel-1-diagrama-de-contexto)
    - [Nivel 2: Diagrama de Contenedores](#nivel-2-diagrama-de-contenedores)
    - [Nivel 3: Diagrama de Componentes](#nivel-3-diagrama-de-componentes)

## **Propósito del Proyecto**
El microservicio "Operación Fuego de Quásar" es una solución desarrollada en Java utilizando el framework Spring Boot 3 y MongoDB como base de datos. Este microservicio se encarga de procesar y analizar la información recibida de varios satélites para determinar la posición y el mensaje original emitido por una fuente desconocida. Implementa un enfoque reactivo utilizando Spring WebFlux para manejar de manera eficiente las solicitudes concurrentes y proporcionar respuestas rápidas.

El microservicio incluye capacidades avanzadas de monitoreo y trazabilidad mediante la integración con Elastic APM, lo que permite registrar errores y realizar un seguimiento detallado de las operaciones. Además, utiliza MongoDB no solo como base de datos principal, sino también para el registro de errores y la trazabilidad de las operaciones.

Para mejorar el rendimiento, el microservicio implementa un manejo de caché en las colecciones de MongoDB, lo que permite reducir la latencia y mejorar la eficiencia en el acceso a los datos. También cuenta con un manejo centralizado de errores y el uso de interceptores para guardar la trazabilidad de las operaciones.

## **Pre-requisitos**
Para clonar y ejecutar esta aplicación, se necesitará [Git](https://git-scm.com), [Java 17.0.11](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html), [MongoDB Compass](https://www.mongodb.com/products/compass) y [Docker](https://docs.docker.com/engine/install/) instalados en la computadora.

## **Instalación y Ejecución**
Desde la línea de comando:
1. Clonar el repositorio
    ```bash
    git clone https://github.com/usuario/ms-quasar-op.git
    ```
2. Navegar al directorio del proyecto y clonar los subproyectos inicializando y actualizando git submodule
    ```bash
    cd ms-quasar-op
    git submodule init
    git submodule update
    ```
3. Compilar e instalar localmente las librerías que son dependencia de la aplicación utilizando Maven Wrapper
    ```bash
    cd unique-parent-spring
    ./mvnw clean install
    cd ..
    cd lib-base-spring-webflux
    ./mvnw clean install
    cd ..
    cd ms-parent-spring-webflux
    ./mvnw clean install
    cd ..
    ```
4. Ejecutar con Docker el archivo compose.yaml.

    ```bash
    cd ms-quasar-fire-op
    docker compose -f "compose.yaml" up -d --build
    ```
5. Correr la aplicación en modo desarrollo

    ```bash
    ./mvnw clean spring-boot:run
    ```
## **Herramientas Principales**
### **Uso de Swagger**
Swagger se utiliza para documentar y probar los endpoints del microservicio. Una vez que la aplicación esté en ejecución, se puede acceder a la interfaz de Swagger haciendo click [aquí](http://localhost:8081)


### **Monitoreo con Elastic APM desde Kibana**
Elastic APM se integra con Kibana para proporcionar monitoreo y trazabilidad de las operaciones del microservicio. Para acceder a los datos de APM desde Kibana:
1. Abrir Kibana en el navegador web.
2. Navegar a la sección "APM" en el menú principal.
3. Aquí se podrán ver las métricas y trazas de las solicitudes manejadas por el microservicio.

### **Procesamiento de Logs con Logstash desde Kibana**
Logstash se utiliza para procesar y transformar los logs generados por el microservicio antes de enviarlos a Elasticsearch. Para visualizar los logs en Kibana:
1. Abrir Kibana en el navegador web. [Click aquí.](http://localhost:5601/app/logs/stream)
2. Click en la opción "Change source configuration".
3. Incluir el índice de logs ```spring-boot-logs-*``` configurado para Logstash.
4. Aquí se podrán buscar y analizar los logs generados por el microservicio.

### **Acceso a MongoDB desde MongoDB Compass**
MongoDB Compass se utiliza para gestionar y visualizar los datos almacenados en MongoDB. Para conectarte a la base de datos:
1. Abrir MongoDB Compass.
2. Ingresar la URI de conexión de tu instancia de MongoDB (por ejemplo, `mongodb://localhost:27017`).
3. Conectarse y navegar a través de las colecciones y documentos almacenados en la base de datos.
## **Diagramas de Arquitectura Modelo C4**
### **Nivel 1: Diagrama de Contexto**
<p align="center">
  <span style="display:inline-block; width: 50px;"></span>
  <a href="#" target="blank"><img src="diagramas/Diagramas%20de%20Arquitectura%20-%20Modelo%20C4%20-%20Context%20Diagram.jpg" width="350" alt="Rebel Alliance Logo" /></a>
</p>

### **Nivel 2: Diagrama de Contenedores**
Los elementos resaltados con borde rojo fueron los desarrollados y utilizados en este proyecto
<p align="center">
  <span style="display:inline-block; width: 50px;"></span>
  <a href="#" target="blank"><img src="diagramas/Diagramas%20de%20Arquitectura%20-%20Modelo%20C4%20-%20Container%20Diagram.jpg" width="600" alt="Rebel Alliance Logo" /></a>
</p>

### **Nivel 3: Diagrama de Componentes**
<p align="center">
  <span style="display:inline-block; width: 50px;"></span>
  <a href="#" target="blank"><img src="diagramas/Diagramas%20de%20Arquitectura%20-%20Modelo%20C4%20-%20Component%20Diagram.jpg" width="600" alt="Rebel Alliance Logo" /></a>
</p>