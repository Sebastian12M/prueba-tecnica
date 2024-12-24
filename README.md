## Estructura del Proyecto

- **Backend:** Implementado en Java con Spring Boot.
- **Frontend:** Basado en Angular.
- **Base de Datos:** MySQL, con un esquema relacional.
- **Scripts SQL:** Incluidos en la carpeta `ScripSql`.

La carpeta **Alquiler_peliculas** incluye tanto el código del frontend como el del backend.

## Instrucciones para Ejecutar el Proyecto

### Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener lo siguiente instalado:

- **Java 17 o superior.**
- **Node.js** y **Angular CLI**.

### 1. **Ejecutar el Script SQL**

Primero, asegúrate de ejecutar el script SQL que se encuentra en la carpeta `ScripSql` para configurar la base de datos.

### 2. **Ejecutar el Frontend**

Para ejecutar el frontend:

1. **Instalar dependencias**:
   - Asegúrate de tener **Node.js** y **Angular CLI** instalados.
   - Dirígete al directorio del frontend y ejecuta el siguiente comando para instalar las dependencias:
     ```bash
     npm install
     ```

2. **Iniciar el servidor**:
   - Una vez instaladas las dependencias, ejecuta el siguiente comando para iniciar el servidor:
     ```bash
     ng serve
     ```
   - **Nota importante**: Es importante que el frontend se ejecute en el puerto **4200**, ya que el backend está configurado para recibir solicitudes solo desde ese puerto.

### 3. **Ejecutar el Backend**

Para ejecutar el backend:

1. **Verifica que Java 17 o superior esté instalado**.

2. **Ejecutar el archivo JAR**:
   - Dirígete al directorio donde se encuentra el archivo **`tecnica-0.0.1-SNAPSHOT.jar`** (en la carpeta **`target`** del backend).
   - Ejecuta el siguiente comando para iniciar el servidor:
     ```bash
     java -jar tecnica-0.0.1-SNAPSHOT.jar
     ```
   - Asegúrate de que el puerto **8080** esté disponible.



