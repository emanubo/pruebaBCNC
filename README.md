# pruebaBCNC
Spring Boot que utiliza el framework Spring WebFlux para realizar operaciones asincrónicas y consumir servicios web

## Estructura del Proyecto

- `MyConfiguration.java`: Configuración de Spring Boot que define un bean de WebClient.Builder.
- `MyService.java`: Servicio que utiliza WebClient para recuperar datos de usuarios, álbumes y publicaciones.
- `MyController.java`: Controlador que expone un punto de acceso para obtener usuarios con álbumes y publicaciones.
- `Album.java`: Clase de modelo para representar información de álbum.
- `Post.java`: Clase de modelo para representar información de publicaciones.
- `User.java`: Clase de modelo para representar información de usuarios.

## Uso del Proyecto

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu IDE preferido (por ejemplo, IntelliJ IDEA o Eclipse).
3. Ejecuta la aplicación Spring Boot.

La aplicación se ejecutará en `http://localhost:8080` y podrás acceder a la información de usuarios con álbumes y publicaciones mediante una solicitud GET a `/users/{id}`.

## Ejemplo de Uso

Puedes acceder a la información de un usuario específico proporcionando su ID en la URL. Por ejemplo, para obtener información del usuario con ID 1, puedes utilizar la siguiente URL:
http://localhost:8080/users/1

## Dependencias

El proyecto utiliza las siguientes dependencias principales:

- Spring Boot
- Spring Web
- Spring WebFlux
- Jackson para la serialización/deserialización JSON
- Project Lombok para simplificar la creación de modelos de datos

## Manuel Bohorquez

