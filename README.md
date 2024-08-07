# Knockout

## Descripción del Proyecto

Knockout es un sitio web de juego de cartas basado en personajes de cómic. En esta plataforma, los usuarios pueden:

- Jugar con cartas de personajes de cómic.
- Comprar, vender o intercambiar cartas con otros jugadores.
- Descargar cómics para leer.
- Jugar trivia y poner a prueba sus conocimientos sobre cómics.
- Obtener información detallada sobre sus personajes favoritos.

## Tecnologías Utilizadas

- Java
- Maven
- MySQL
- Apache Tomcat
- Bootstrap
- Spring
- JavaScript

## Requisitos Previos

Asegúrate de tener instalados los siguientes componentes antes de comenzar:

- JDK (Java Development Kit)
- Maven
- MySQL Server
- Apache Tomcat

## Instalación

1. **Clonar el repositorio**:
    ```bash
    git clone https://github.com/1cristianb/Knockout.git
    cd knockout
    ```

2. **Configurar la base de datos**:

   - Crear una base de datos en MySQL:
     ```sql
     CREATE DATABASE db;
     ```


3. **Configurar las credenciales de la base de datos**:

   Modifica el archivo `src/main/resources/hibernateContext.xml` con tus credenciales de MySQL :
    ```properties
    <property name="url" value="jdbc:mysql://localhost:3306/db?serverTimezone=UTC" />
		<property name="username" value="Valor a modificar" />
		<property name="password" value="Valor a modificar" />
    ```

4. **Compilar el proyecto**:

   - Compilar el proyecto con Maven:
     ```bash
     mvn clean install
     ```

5. **Desplegar en Apache Tomcat**:

   - Copiar el archivo WAR generado en el directorio `target` a la carpeta `webapps` de tu instalación de Tomcat.
   - Iniciar el servidor Tomcat desde la línea de comandos o usando el script `startup.sh` (Linux/Mac) o `startup.bat` (Windows) que se encuentra en el directorio `bin` de Tomcat.

## Uso

Una vez que la aplicación esté en funcionamiento, puedes acceder al sitio web a través de tu navegador web en la siguiente dirección: http://localhost:8080/knockout

## Autor

Cristian Boschi , Leandro Martinez y Tabatha Peralta
