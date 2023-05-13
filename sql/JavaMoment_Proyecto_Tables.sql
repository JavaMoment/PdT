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

CREATE TABLE AREAS
(
    id_area     INTEGER           NOT NULL,
    nombre      VARCHAR2(100)     NOT NULL,
    descripcion VARCHAR2(250)     NOT NULL,
    
    CONSTRAINT pk_area_id   PRIMARY KEY (id_area),
    CONSTRAINT uk_area_nomb UNIQUE      (nombre)
);

CREATE TABLE TUTORES
(
    id_tutor        INTEGER         NOT NULL,
    nombre_usuario  VARCHAR2(100)   NOT NULL,
    tipo            VARCHAR2(75)    NOT NULL,
    id_area         INTEGER         NOT NULL,
    
    CONSTRAINT pk_tutor_id          PRIMARY KEY (id_tutor),
    CONSTRAINT fk_tutor_nomb_user   FOREIGN KEY (nombre_usuario) REFERENCES USUARIOS(nombre_usuario),
    CONSTRAINT fk_tutor_id_area     FOREIGN KEY (id_area)        REFERENCES AREAS(id_area)
);

CREATE TABLE ANALISTAS
(
    id_analista     INTEGER         NOT NULL,
    nombre_usuario  VARCHAR2(100)   NOT NULL,
    
    CONSTRAINT pk_analista_id       PRIMARY KEY (id_analista),
    CONSTRAINT fk_anali_nomb_user   FOREIGN KEY (nombre_usuario) REFERENCES USUARIOS(nombre_usuario)
);

CREATE TABLE ESTUDIANTES
(
    id_estudiante  INTEGER       NOT NULL,
    nombre_usuario VARCHAR2(100) NOT NULL,
    generacion     VARCHAR2(4)   NOT NULL,
    
    CONSTRAINT pk_estud_id       PRIMARY KEY (id_estudiante),
    CONSTRAINT fk_estud_nomb_usr FOREIGN KEY (nombre_usuario) REFERENCES USUARIOS(nombre_usuario)
);

CREATE TABLE EVENTOS
(
    id_evento           INTEGER         NOT NULL,
    fecha_hora_inicio   DATE            NOT NULL,
    fecha_hora_final    DATE            NOT NULL,
    titulo              VARCHAR2(100)   NOT NULL,
    
    CONSTRAINT pk_evento_id PRIMARY KEY (id_evento)
);

CREATE TABLE TUTOR_EVENTO
(
    id_tutor  INTEGER NOT NULL,
    id_evento INTEGER NOT NULL,
    
    CONSTRAINT fk_tuto_even_tutor  FOREIGN KEY (id_tutor)  REFERENCES TUTORES(id_tutor),
    CONSTRAINT fk_tuto_even_evento FOREIGN KEY (id_evento) REFERENCES EVENTOS(id_evento),
    CONSTRAINT pk_tutor_evento     PRIMARY KEY (id_tutor, id_evento)
);

CREATE TABLE ANALISTA_EVENTO
(
    id_analista  INTEGER NOT NULL,
    id_evento    INTEGER NOT NULL,
    
    CONSTRAINT fk_anali_even_analista  FOREIGN KEY (id_analista) REFERENCES ANALISTAS(id_analista),
    CONSTRAINT fk_anali_even_evento    FOREIGN KEY (id_evento)   REFERENCES EVENTOS(id_evento),
    CONSTRAINT pk_anali_evento         PRIMARY KEY (id_analista, id_evento)
);

CREATE TABLE ESTUDIANTE_EVENTO
(
    id_estudiante  INTEGER      NOT NULL,
    id_evento      INTEGER      NOT NULL,
    calificacion   NUMBER(3, 2) NOT NULL,
    asistencia     CHAR         NOT NULL,
    
    CONSTRAINT fk_estud_even_analista  FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES(id_estudiante),
    CONSTRAINT fk_estud_even_evento    FOREIGN KEY (id_evento)     REFERENCES EVENTOS(id_evento),
    CONSTRAINT pk_estud_evento         PRIMARY KEY (id_estudiante, id_evento),
    CONSTRAINT chk_estud_even_asist    CHECK       (calificacion IN ('S', 'N', 'P'))
);

CREATE TABLE JUSTIFICACIONES
(
    id_justificacion INTEGER        NOT NULL,
    id_estudiante    INTEGER        NOT NULL,
    id_evento        INTEGER        NOT NULL,
    id_analista      INTEGER,
    detalle          VARCHAR2(250)  NOT NULL,
    fecha_hora       DATE           NOT NULL,
    
    CONSTRAINT pk_justif_id          PRIMARY KEY (id_justificacion),
    CONSTRAINT fk_justif_id_estud    FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES(id_estudiante),
    CONSTRAINT fk_justif_id_evento   FOREIGN KEY (id_evento)     REFERENCES EVENTOS(id_evento),
    CONSTRAINT fk_justif_id_anali    FOREIGN KEY (id_analista)  REFERENCES ANALISTAS(id_analista)
);

CREATE TABLE RECLAMOS
(
    id_reclamo       INTEGER        NOT NULL,
    id_estudiante    INTEGER        NOT NULL,
    id_evento        INTEGER        NOT NULL,
    id_analista      INTEGER,
    detalle          VARCHAR2(250)  NOT NULL,
    fecha_hora       DATE           NOT NULL,
    
    CONSTRAINT pk_recl_id          PRIMARY KEY (id_reclamo),
    CONSTRAINT fk_recl_id_estud    FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES(id_estudiante),
    CONSTRAINT fk_recl_id_evento   FOREIGN KEY (id_evento)     REFERENCES EVENTOS(id_evento),
    CONSTRAINT fk_recl_id_anali    FOREIGN KEY (id_analista)   REFERENCES ANALISTAS(id_analista)
);

CREATE TABLE CONSTANCIAS
(
    id_constancia       INTEGER        NOT NULL,
    id_estudiante       INTEGER        NOT NULL,
    id_evento           INTEGER        NOT NULL,
    id_analista         INTEGER,
    detalle             VARCHAR2(250)  NOT NULL,
    fecha_hora          DATE           NOT NULL,
    
    CONSTRAINT pk_const_id          PRIMARY KEY (id_constancia),
    CONSTRAINT fk_const_id_estud    FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES(id_estudiante),
    CONSTRAINT fk_const_id_evento   FOREIGN KEY (id_evento)     REFERENCES EVENTOS(id_evento),
    CONSTRAINT fk_const_id_anali    FOREIGN KEY (id_analista)   REFERENCES ANALISTAS(id_analista)
);

CREATE TABLE STATUS_CERTIFICADOS
(
    id_status     INTEGER      NOT NULL,
    nombre_accion VARCHAR2(50) NOT NULL,
    
    CONSTRAINT pk_status_id PRIMARY KEY (id_status)
);

CREATE TABLE STATUS_CONSTANCIA
(
    id_status     INTEGER NOT NULL,
    id_constancia INTEGER NOT NULL,
    
    CONSTRAINT fk_stat_const_status     FOREIGN KEY (id_status)     REFERENCES STATUS_CERTIFICADOS(id_status),
    CONSTRAINT fk_stat_const_constancia FOREIGN KEY (id_constancia) REFERENCES CONSTANCIAS(id_constancia),
    CONSTRAINT pk_stat_const_ids        PRIMARY KEY (id_status, id_constancia)
);

CREATE TABLE STATUS_RECLAMO
(
    id_status     INTEGER NOT NULL,
    id_reclamo    INTEGER NOT NULL,
    
    CONSTRAINT fk_stat_recl_status     FOREIGN KEY (id_status)     REFERENCES STATUS_CERTIFICADOS(id_status),
    CONSTRAINT fk_stat_recl_reclamo    FOREIGN KEY (id_reclamo)    REFERENCES RECLAMOS(id_reclamo),
    CONSTRAINT pk_stat_recl_ids        PRIMARY KEY (id_status, id_reclamo)
);

CREATE TABLE STATUS_JUSTIFICACION
(
    id_status           INTEGER NOT NULL,
    id_justificacion    INTEGER NOT NULL,
    
    CONSTRAINT fk_stat_just_status           FOREIGN KEY (id_status)           REFERENCES STATUS_CERTIFICADOS(id_status),
    CONSTRAINT fk_stat_just_justificacion    FOREIGN KEY (id_justificacion)    REFERENCES JUSTIFICACIONES(id_justificacion),
    CONSTRAINT pk_stat_just_ids              PRIMARY KEY (id_status, id_justificacion)
);

COMMIT;
