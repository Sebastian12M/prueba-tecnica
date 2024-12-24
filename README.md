
## Estructura del Proyecto

- **Backend:** Está hecho con Java y Spring Boot.
- **Frontend:** Está hecho con Angular.
- **Base de Datos:** MySQL.
- **Scripts SQL:** Los puedes encontrar en la carpeta `ScripSql`.

La carpeta **Alquiler_peliculas** tiene todo el código del frontend y del backend.
La carpeta **Ejercicios** contiene el ejertcicio 1 y 2

## Cómo Ejecutar el Proyecto

### Necesario

Antes de empezar asegúrate de tener esto instalado en tu computadora:

- **Java 17 o más reciente.**
- **Node.js** y **Angular CLI**.
- **Mysql** para configurar la base de datos

### 1. **Ejecutar el Script SQL**

Primero, necesita ejecutar el script SQL que está en la carpeta `ScripSql` para que se configure la base de datos.

### 2. **Ejecutar el Frontend**

Para hacer que funcione el frontend:

1. **Instalar las dependencias**:
   - Asegúrate de tener **Node.js** y **Angular CLI** instalados
   - Luego ve a la carpeta donde está el frontend y abre la terminal o línea de comandos, Ahí ejecuta el siguiente comando para instalar lo que necesita:
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

1. Tener **Java 21 o más reciente** instalado.
2. - **Maven** instalado para compilar las dependencias.

3. Ir al directorio del backend
4. Instalar las dependencias con el siguiente comando
     ```bash
     mvn install
     ```
5. Ejecutar el proyecto
   ```bash
     mvn spring-boot:run
     ```  

## Funcionamiento de la aplicacion
Al entrar a la aplicacion nos vamos a encontrar con todas las camaras que tiene la aplicacion actualmente, cada camara tiene su nombre y modelo. 
Aparte de esto cada una cuenta con 3 botones los cuales hacen lo siguiente:

**ALQUILAR :** al dar click en este boton nos llevara a otra parte donde podemos ver todo los detalle de la camara y otra vez el boton de alquilar
para confirmar que queremos alquilar la camara, si le damos click este nos manda a un  formulaio donde vamos a tener que insertar la
 cedula del cliente que quiere alquilar la camara, para que un cliente puedo alquilar la camara debe de estar registrado y no tener alguna camara 
 de alquiler pendiente por entregar y tampoco puede tener multas, al dar click en registrar alquiler  si el cliente cumple con los requisitos
 la camara va ser asignada al cliente y por lo tanto la camara ya no va estar disponible para ser alquilada hasta que se haga la devolucion.

 **EDITAR:** al dar click en este boton nos llevara a un formulario donde vamos a poder actuzalizar los datos de las camaras ya sea el modelo, marca etc.

 **REPARACION:** al dar click en este boton la camara a la cual le dimos click en el botn pasara a estar en reparacion por lo tanto no estara disponiblle
 para ser alquilada por algun cliente, al dar click veremos que aparecera un nuevo boton llamado liberar.

 **LIBERAR:** al hacer click en este boton lo que pasara es que la camara que estaba en reparacion pasara a estar diponible de nuevo
 por lo tanto podra ser alquilada.

## Barra de navegacion
 En la barra de navegacion de la parte de arriba contamos con 4 opciones(Inicio, Devolucion Camara, Registrar cliente y Registrar Camara)

 **Devolucion de camara:** Al dar click en esta opcion nos llevara a la parte donde nosostros vamos a registrar devoluciones de las camaras
 aca vamos a tener que digitar la cedula del cliente que alquilo la camara y tambien la fecha de entrega, el formulario solo nos va a permitir 
 ingresar clientes existentes y que tengan una  camara alquilada, si el cliente el cual entrego la camara paso los 7 dias limites se le pondra 
 una multa de 1 mes por cada dia de retraso, por lo tanto ya no podra alquilar mas camaras.

 **Registrar Cliente:** Aca vamos a poder registrar los clientes que van alquilar las camaras, se piden datos basicos como la cedula, correo y nombre.

 **Registrar Camara:** Aca vamos a poder registrar las camaras que queramos poner en alquiler, este formulario nos pide los siguientes datos: modelo, marca, soporte flash(Si, No),
 y las peliculas compatibles con la camara aca podermos seleccionar varias opciones dejando presionado el control y dando clik a las opciones, al dar click en registrar la camara
 aparecera en el incio para poder ser alquilada.
 
 
