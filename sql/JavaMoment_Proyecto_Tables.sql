-- Script para la creacion de la base de datos del Proyecto de Desarrollo y Testing
-- Author: Java Moment Team

CREATE TABLE USUARIOS
(
    nombre_usuario    VARCHAR2(100) NOT NULL,
    nombre1           VARCHAR2(50)  NOT NULL,
    nombre2           VARCHAR2(50)          ,
    apellido1         VARCHAR2(100) NOT NULL,
    apellido2         VARCHAR2(100) NOT NULL,
    fec_nac           DATE          NOT NULL,
    genero            CHAR          NOT NULL,
    id_departamento   INTEGER       NOT NULL,
    id_localidad      INTEGER       NOT NULL,
    id_itr            INTEGER       NOT NULL,
    mail              VARCHAR2(250) NOT NULL,
    contrasenia       VARCHAR2(100) NOT NULL,
    telefono          VARCHAR2(9)           ,
    documento         VARCHAR2(8)   NOT NULL,
    activo            NUMBER(1,0)   NOT NULL,
    
    CONSTRAINT pk_usr_nombre_usuario PRIMARY KEY (nombre_usuario),
    CONSTRAINT uk_usr_documento      UNIQUE      (documento),
    CONSTRAINT chk_usr_genero        CHECK       ( genero IN ('F', 'M', 'O') ),
    CONSTRAINT chk_usr_activo        CHECK       ( activo IN (1, 0)          )
);

CREATE TABLE ITR
(
    id_itr INTEGER      NOT NULL,
    nombre VARCHAR2(50) NOT NULL,
    
    CONSTRAINT pk_id_itr   PRIMARY KEY (id_itr),
    CONSTRAINT uk_itr_nomb UNIQUE      (nombre)
);

CREATE TABLE DEPARTAMENTOS
(
    id_departamento INTEGER      NOT NULL,
    nombre          VARCHAR2(50) NOT NULL,
    id_itr          INTEGER      NOT NULL,
    
    CONSTRAINT pk_id_depa     PRIMARY KEY (id_departamento),
    CONSTRAINT fk_depa_id_itr FOREIGN KEY (id_itr) REFERENCES ITR(id_itr),
    CONSTRAINT uk_depa_nomb   UNIQUE      (nombre)
);

CREATE TABLE LOCALIDADES
(
    id_localidad    INTEGER      NOT NULL,
    nombre          VARCHAR2(50) NOT NULL,
    id_departamento INTEGER      NOT NULL,
    
    CONSTRAINT pk_id_locali      PRIMARY KEY (id_localidad),
    CONSTRAINT uk_locali_nomb    UNIQUE      (nombre),
    CONSTRAINT fk_locali_id_depa FOREIGN KEY (id_departamento) REFERENCES DEPARTAMENTOS(id_departamento)
);

ALTER TABLE USUARIOS
ADD CONSTRAINT fk_usr_id_depa
FOREIGN KEY (id_departamento) REFERENCES DEPARTAMENTOS(id_departamento);

ALTER TABLE USUARIOS
ADD CONSTRAINT fk_usr_id_locali
FOREIGN KEY (id_localidad) REFERENCES LOCALIDADES(id_localidad);

ALTER TABLE USUARIOS
ADD CONSTRAINT fk_usr_id_itr
FOREIGN KEY (id_itr) REFERENCES ITR(id_itr);


COMMIT;

/*
INSERT INTO 
USUARIOS(nombre_usuario, nombre1, apellido1, apellido2, fec_nac, genero, departamento, localidad, mail, contrasenia, documento)
VALUES ('gonza.ruiz', 'gonza', 'ruiz', 'alvez', TO_DATE('03-05-2002', 'dd-mm-yyyy'), 'M', 1, 2, 'gonza@mail.com', '1234', '12345678');

INSERT INTO 
USUARIOS(nombre_usuario, nombre1, apellido1, apellido2, fec_nac, genero, departamento, localidad, mail, contrasenia, documento, activo)
VALUES ('gon.ruiz', 'gonza', 'ruiz', 'alvez', TO_DATE('03-05-2002', 'dd-mm-yyyy'), 'M', 1, 2, 'gonza@mail.com', '1234', '12345679', 0);

select * from USUARIOS;

DELETE FROM USUARIOS;
*/