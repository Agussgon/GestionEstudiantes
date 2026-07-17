# Etapa 1: compilar el proyecto con Maven + JDK 21
#descarga una imagen que trae las herramientas instaladas (maven,java y linux)
#Eclipse Temurin es la distribución de Java creada por el proyecto Adoptium (sustituto de AdoptOpenJDK).
#Es la que usa Render, AWS, Azure y la mayoría de los proveedores cloud.
FROM maven:3.9.6-eclipse-temurin-21 AS build
#directorio dentro del contenedor docker para compilar el codigo
#requerimos pasar el codigo de nuestro entorno local al contenedor de Render.
WORKDIR /app
#copiar el pom de tu proyecto
COPY pom.xml .
#descargar dependencias
RUN mvn -q -DskipTests dependency:go-offline
#copiar código fuente
COPY src ./src
#compila el proyecto y genera el ejecutable .jar
RUN mvn -q -DskipTests clean package




# Etapa 2: correr el .jar en un entorno liviano
#utiliza una imagen mas liviana de java y linux
FROM eclipse-temurin:21-jre
#Render recomienda usar imágenes Temurin.
# genera otro directorio de trabajo para tener unicamente el ejecutable más liviano, no todo el proyecto.
WORKDIR /app
#Render asigna un puerto dinámico.
ENV PORT=8080
#Copia el jar generado en la etapa 1 y lo nombra app.jar
COPY --from=build /app/target/*.jar app.jar
#puerto de la app
#EXPOSE 8080
#Render asigna un puerto dinámico a la app esto ejecuta la app
CMD ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]

