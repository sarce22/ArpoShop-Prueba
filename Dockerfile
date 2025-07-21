# Usar imagen oficial de OpenJDK 17
FROM openjdk:17-jdk-slim

# Instalar Maven
RUN apt-get update && apt-get install -y maven && apt-get clean

# Establecer directorio de trabajo
WORKDIR /app

# Copiar archivos del proyecto
COPY . .

# Dar permisos de ejecución al Maven Wrapper
RUN chmod +x ./mvnw

# Compilar la aplicación
RUN ./mvnw clean install -DskipTests

# Exponer el puerto
EXPOSE $PORT

# Comando para ejecutar la aplicación
CMD ["sh", "-c", "java -Dserver.port=$PORT -jar target/*.jar --spring.profiles.active=prod"]