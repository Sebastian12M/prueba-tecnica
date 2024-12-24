
## Estructura del Proyecto

- **Backend:** Está hecho con Java y Spring Boot.
- **Frontend:** Está hecho con Angular.
- **Base de Datos:** Se usa MySQL.
- **Scripts SQL:** Los puedes encontrar en la carpeta `ScripSql`.

La carpeta **Alquiler_peliculas** tiene todo el código del frontend y del backend.

## Cómo Ejecutar el Proyecto

### Qué Necesitas Tener

Antes de empezar, asegúrate de tener esto instalado en tu computadora:

- **Java 17 o más reciente.**
- **Node.js** y **Angular CLI**.

### 1. **Ejecutar el Script SQL**

Primero, necesitas ejecutar el script SQL que está en la carpeta `ScripSql` para que se configure la base de datos.

### 2. **Ejecutar el Frontend**

Para hacer que funcione el frontend:

1. **Instalar las dependencias**:
   - Asegúrate de tener **Node.js** y **Angular CLI** instalados.
   - Luego, ve a la carpeta donde está el frontend y abre la terminal o línea de comandos. Ahí, ejecuta el siguiente comando para instalar lo que necesita:
     ```bash
     npm install
     ```

2. **Iniciar el servidor**:
   - Una vez que las dependencias estén instaladas, ejecuta este comando para que el servidor arranque:
     ```bash
     ng serve
     ```
   - **Nota importante**: Asegúrate de que el frontend se ejecute en el puerto **4200**, porque el backend está preparado para recibir las solicitudes solo desde ese puerto.

### 3. **Ejecutar el Backend**

Para ejecutar el backend:

1. Asegúrate de tener **Java 17 o más reciente** instalado.

2. **Ejecutar el archivo JAR**:
   - Ve a la carpeta donde está el archivo **`tecnica-0.0.1-SNAPSHOT.jar`** (está en la carpeta **`target`** dentro del backend).
   - Una vez ahí, ejecuta este comando para iniciar el servidor:
     ```bash
     java -jar tecnica-0.0.1-SNAPSHOT.jar
     ```
   - Verifica que el puerto **8080** esté libre para que el servidor funcione bien.


