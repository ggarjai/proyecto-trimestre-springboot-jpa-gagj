# API de Gestión de Despensa (Spring Boot)

API REST para gestionar alimentos y sus ubicaciones de almacenaje (alacena, nevera, congelador).

## Stack y requisitos
- Java 17
- Maven
- Spring Boot 3.x (Web, JPA, Security)
- H2 (db en memoria), MapStruct (convertir objetos), Lombok (generar boilerplate)


## Ejecución

1) Compilar y ejecutar
```
mvn clean (limpia builds anteriores y evita errores)
mvn install
mvn spring-boot:run
```

2) Accesos
- API: http://localhost:8080
- Swagger: http://localhost:8080/swagger-ui/index.html
- H2: http://localhost:8080/h2-console

## Características
- CRUD de alimentos: crear, leer, actualizar y eliminar.
- Gestión de ubicaciones con validación de nombres únicos.
- Separación Entity/DTO mediante MapStruct.
- Persistencia con JPA sobre H2 en memoria.
- Seguridad básica con Spring Security.
- Documentación interactiva con Swagger.

## Arquitectura
- Controller (REST) -> Service (lógica) -> Repository
Entity <-> DTO <-> Mapper (MapStruct)

### Ejemplos
Crear alimento
```JSON
  {
    "nombre": "Pan",
    "perecedero": true,
    "fechaCaducidad": "2025-12-31",
    "cantidad": 2,
    "ubicacionId": 1
  }
```

Crear ubicación
```JSON
  {
    "nombre": "Nevera-Puerta",
    "tipoAlmacen": "NEVERA"
  }
```

## Seguridad y CORS
- Autenticación: HTTP Basic. Spring genera el usuario 'user' con contraseña aleatoria (se muestra en consola al iniciar).
- Rutas públicas: `/swagger-ui/`, `/v3/api-docs/`, `/actuator/health`.
- CORS: permitido el origen `http://localhost:4200`
