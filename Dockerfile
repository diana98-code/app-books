FROM openjdk:17-jdk-slim

LABEL NAME="DIANA MEDIAVILLA"
LABEL MATERIA="DISTRIBUIDA"

# copiar librerías
COPY ./build/quarkus-app/lib ./lib
COPY ./build/quarkus-app/app ./app
COPY ./build/quarkus-app/quarkus ./quarkus
# copiar archivo txt de dependencias
COPY ./build/quarkus-app/quarkus-app-dependencies.txt ./
COPY ./build/quarkus-app/quarkus-run.jar ./
# copiar archivo jar
CMD ["java", "-jar", "quarkus-run.jar"]

EXPOSE 4545