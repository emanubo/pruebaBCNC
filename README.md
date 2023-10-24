# pruebaBCNC
Spring Boot que utiliza el framework Spring WebFlux para realizar operaciones asincrónicas y consumir servicios web

## Estructura del Proyecto

- `MyConfiguration.java`: Configuración de Spring Boot que define un bean de WebClient.Builder.
- `UserService.java`: Servicio que utiliza WebClient para recuperar datos de usuarios, álbumes y publicaciones.
- `UserController.java`: Controlador que expone un punto de acceso para obtener usuarios con álbumes y publicaciones.
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

## Pruebas

### Pruebas Unitarias

Se han implementado pruebas unitarias para asegurar el funcionamiento correcto de las componentes individuales del proyecto. A continuación, se detallan las pruebas unitarias disponibles:

- `UserControllerTest`: Prueba la funcionalidad del controlador `UserController`. Verifica que el controlador responde correctamente a las solicitudes y proporciona datos válidos al usuario. Se utiliza Mockito para simular el servicio y verificar que el controlador devuelve la respuesta esperada.

- `UserServiceTest`: Prueba la lógica del servicio `UserService`. Asegura que el servicio pueda obtener datos de usuarios, álbumes y publicaciones y combinarlos en un solo resultado. Se utilizan simulaciones de WebClient y Mockito para controlar el flujo de datos.

### Pruebas de Integración

Se han implementado pruebas de integración para verificar el funcionamiento del proyecto en su conjunto, incluyendo las solicitudes HTTP. A continuación, se describe la prueba de integración disponible:

- `UserControllerIntegrationTest`: Prueba la integración del controlador `UserController` con un servidor web embebido. Realiza solicitudes HTTP al punto de acceso `/users/{id}` y verifica que se reciban respuestas válidas. Esta prueba asegura que el proyecto funcione correctamente en un entorno de ejecución real.

Todas las pruebas se ejecutan automáticamente en un entorno de construcción y prueba, y son una parte fundamental del proceso de desarrollo para garantizar la calidad y fiabilidad del proyecto.

## Manuel Bohorquez

