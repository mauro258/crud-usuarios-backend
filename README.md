# CRUD de Usuarios con Spring Boot

Este proyecto es una aplicación backend para gestionar usuarios utilizando operaciones CRUD (Crear, Leer, Actualizar y Eliminar). Está desarrollado con Java y el framework Spring Boot, y utiliza MySQL como base de datos.

## Descripción

El proyecto permite realizar operaciones básicas de gestión de usuarios a través de una API REST. Los usuarios pueden ser creados, consultados, actualizados y eliminados en la base de datos. El objetivo es proporcionar una implementación básica y funcional de un CRUD (Create, Read, Update, Delete) utilizando tecnologías modernas.

### Características

- **Crear usuarios**: Registrar un nuevo usuario en la base de datos.
- **Leer usuarios**: Obtener la lista de todos los usuarios registrados o consultar un usuario por su ID.
- **Actualizar usuarios**: Modificar la información de un usuario existente.
- **Eliminar usuarios**: Borrar un usuario de la base de datos.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación utilizado para el desarrollo de la aplicación.
- **Spring Boot**: Framework para simplificar el desarrollo de aplicaciones Java.
- **Spring Data JPA**: Para la interacción con la base de datos.
- **MySQL**: Sistema de gestión de bases de datos relacional utilizado para almacenar la información de los usuarios.
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.
- **Lombok**: Biblioteca que reduce el código boilerplate mediante anotaciones.
- **Visual Studio Code**: IDE utilizado para el desarrollo del proyecto.
  
## Prerrequisitos

Antes de ejecutar este proyecto, asegúrate de tener instalado lo siguiente:

- **JDK 11 o superior**
- **MySQL** (y configurado en el archivo `application.properties`)
- **Maven** (para gestionar las dependencias y compilar el proyecto)

## Configuración del Proyecto

1. Clona este repositorio:
   ```bash
   git clone https://github.com/mauro258/crud-usuarios-backend

2. Configura tu base de datos MySQL:
- Crea una base de datos llamada usuarios_db.
- Asegúrate de que las credenciales de acceso a la base de datos están correctamente configuradas en el archivo src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/usuarios_db
spring.datasource.username=tu_usuario_mysql
spring.datasource.password=tu_contraseña_mysql
spring.jpa.hibernate.ddl-auto=update

3. Ejecuta el proyecto con Maven:
mvn spring-boot:run
