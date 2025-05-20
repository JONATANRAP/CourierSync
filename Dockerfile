# Etapa de construcción
FROM eclipse-temurin:17-jdk-alpine AS builder

# Directorio de trabajo
WORKDIR /app

# Copiamos todo el código fuente al contenedor
COPY . .

# Damos permisos al wrapper de Maven si se usa
RUN chmod +x mvnw

# Compilamos el proyecto sin correr los tests
RUN ./mvnw clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jre-alpine

# Directorio de trabajo
WORKDIR /app

# Copiamos el JAR desde la etapa de construcción
COPY --from=builder /app/target/*.jar app.jar

# Exponemos el puerto
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
