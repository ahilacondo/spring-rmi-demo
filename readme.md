# Integración de Spring y RMI

Este proyecto demuestra la integración de Spring Framework con RMI (Remote Method Invocation) de Java.

## Descripción

Este proyecto implementa un servicio de calculadora simple utilizando Spring y RMI. El servicio ofrece operaciones básicas de suma y resta que pueden ser invocadas remotamente.

## Requisitos

- JDK 11 o superior
- Maven 3.6 o superior

## Procedimiento para ejecutar

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/ahilacondo/spring-rmi-demo.git
   cd spring-rmi-demo
   ```

2. Compilar y empaquetar el proyecto:
   ```bash
   mvn clean package
   ```

3. Ejecutar el servidor (en una terminal):
   ```bash
   java -jar target/server-jar-with-dependencies.jar
   ```

4. Ejecutar el cliente (en otra terminal):
   ```bash
   java -jar target/client-jar-with-dependencies.jar
   ```

## Estructura del proyecto

- `CalculatorService.java`: Interfaz del servicio remoto
- `CalculatorServiceImpl.java`: Implementación del servicio
- `AppConfig.java`: Configuración de Spring para el servidor
- `Server.java`: Aplicación del servidor
- `RmiClient.java`: Cliente que consume el servicio remoto