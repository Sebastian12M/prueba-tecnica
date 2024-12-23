CREATE TABLE clientes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cedula BIGINT,
    correo VARCHAR(255),
    nombre VARCHAR(255),
    dias_multa INT
);

CREATE TABLE marcas (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    direccion VARCHAR(255)
);

CREATE TABLE peliculas(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    marca VARCHAR(255),
    sensibilidad_iso INT,
    formato VARCHAR(255)
);

CREATE TABLE camaras(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    soporte_flash BOOLEAN,
    estado VARCHAR(255),
    modelo VARCHAR(255),
    marca_id BIGINT,
    
    FOREIGN KEY (marca_id) REFERENCES marcas(id)
);

CREATE TABLE peliculas_camaras(
    camara_id BIGINT,
    peliculas_id BIGINT,
    PRIMARY KEY (camara_id, peliculas_id),
    FOREIGN KEY (peliculas_id) REFERENCES peliculas(id),
    FOREIGN KEY (camara_id) REFERENCES camaras(id)
);

CREATE TABLE alquileres(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    estado BOOLEAN,
    fecha_entrega DATE,
    fecha_inicio DATE,
    camara_id BIGINT,
    cliente_id BIGINT,
    FOREIGN KEY (camara_id) REFERENCES camaras(id),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);


INSERT INTO clientes (cedula, correo, nombre, dias_multa)
VALUES
    (123456789, 'cliente1@example.com', 'Juan Pérez', 0),
    (987654321, 'cliente2@example.com', 'Ana Gómez', 0),
    (555555555, 'cliente3@example.com', 'Carlos Sánchez', 0);


INSERT INTO marcas (nombre, direccion)
VALUES
    ('Canon', 'Av. de la Tecnología 123, Ciudad ABC'),
    ('Nikon', 'Calle Innovación 456, Ciudad XYZ'),
    ('Sony', 'Avenida de la Fotografía 789, Ciudad DEF');


INSERT INTO peliculas (nombre, marca, sensibilidad_iso, formato)
VALUES
    ('Película A', 'Canon', 800, '35mm'),
    ('Película B', 'Nikon', 1600, '120mm'),
    ('Película C', 'Sony', 400, '35mm');


INSERT INTO camaras (soporte_flash, estado, modelo, marca_id)
VALUES
    (TRUE, 'DISPONIBLE', 'Canon EOS 5D', 1),
    (FALSE, 'DISPONIBLE', 'Nikon D850', 2),
    (TRUE, 'DISPONIBLE', 'Sony Alpha 7', 3);


INSERT INTO peliculas_camaras (camara_id, peliculas_id)
VALUES
    (1, 1),  
    (1, 3),  
    (2, 2),  
    (3, 1);  






