-- Script para la creacion de la base de datos del Proyecto de Desarrollo y Testing
-- Author: Java Moment Team

CREATE TABLE USUARIOS
(
    nombre_usuario     VARCHAR2(100) NOT NULL,
    nombre1            VARCHAR2(100)  NOT NULL,
    nombre2            VARCHAR2(100)          ,
    apellido1          VARCHAR2(100) NOT NULL,
    apellido2          VARCHAR2(100) NOT NULL,
    fec_nac            DATE          NOT NULL,
    genero             CHAR          NOT NULL,
    id_localidad       INTEGER       NOT NULL,
    id_itr             INTEGER       NOT NULL,
    mail_institucional VARCHAR2(250) NOT NULL,
    mail_personal      VARCHAR2(250) NOT NULL,
    contrasenia        VARCHAR2(100) NOT NULL,
    telefono           VARCHAR2(9)           ,
    documento          VARCHAR2(8)   NOT NULL,
    activo             NUMBER(1,0)   NOT NULL,
    
    CONSTRAINT pk_usr_nombre_usuario PRIMARY KEY (nombre_usuario),
    CONSTRAINT uk_usr_documento      UNIQUE      (documento),
    CONSTRAINT uk_mail_insti         UNIQUE      (mail_institucional),
    CONSTRAINT chk_usr_genero        CHECK       ( genero IN ('F', 'M', 'O') ),
    CONSTRAINT chk_usr_activo        CHECK       ( activo IN (1, 0)          )
);

CREATE TABLE ITR
(
    id_itr INTEGER      NOT NULL,
    nombre VARCHAR2(50) NOT NULL,
    activo NUMBER(1,0)  NOT NULL,
    
    CONSTRAINT pk_id_itr   PRIMARY KEY (id_itr),
    CONSTRAINT uk_itr_nomb UNIQUE      (nombre)
);

CREATE TABLE DEPARTAMENTOS
(
    id_departamento INTEGER      NOT NULL,
    nombre          VARCHAR2(50) NOT NULL,
    id_itr          INTEGER              ,
    
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
    CONSTRAINT fk_locali_id_depa FOREIGN KEY (id_departamento) REFERENCES DEPARTAMENTOS(id_departamento)
);


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

CREATE TABLE TIPOS_TUTOR
(
    id_tipo_tutor INTEGER       GENERATED ALWAYS AS IDENTITY NOT NULL,
    nombre        VARCHAR2(100)                              NOT NULL,
    
    CONSTRAINT pk_tipo_tutor      PRIMARY KEY (id_tipo_tutor),
    CONSTRAINT uk_tipo_tutor_nomb UNIQUE (nombre)
);

CREATE TABLE TUTORES
(
    id_tutor        INTEGER         NOT NULL,
    nombre_usuario  VARCHAR2(100)   NOT NULL,
    id_tipo_tutor   INTEGER         NOT NULL,
    id_area         INTEGER         NOT NULL,
    
    CONSTRAINT pk_tutor_id          PRIMARY KEY (id_tutor),
    CONSTRAINT fk_tutor_nomb_user   FOREIGN KEY (nombre_usuario) REFERENCES USUARIOS(nombre_usuario),
    CONSTRAINT fk_tutor_id_area     FOREIGN KEY (id_area)        REFERENCES AREAS(id_area),
    CONSTRAINT fk_tipo_tutor        FOREIGN KEY (id_tipo_tutor)  REFERENCES TIPOS_TUTOR(id_tipo_tutor)
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

CREATE TABLE TIPOS_EVENTO
(
    id_tipo_evento INTEGER GENERATED ALWAYS AS IDENTITY NOT NULL,
    nombre         VARCHAR2(100)                        NOT NULL,
    
    CONSTRAINT pk_tipo_evento_id     PRIMARY KEY (id_tipo_evento),
    CONSTRAINT uk_nombre_tipo_evento UNIQUE      (nombre)
);

CREATE TABLE STATUS_EVENTO
(
    id_status   INTEGER      GENERATED ALWAYS AS IDENTITY NOT NULL,
    nombre      VARCHAR(100)                              NOT NULL,
    activo      NUMBER(1, 0)                              NOT NULL,
    
    CONSTRAINT pk_status_evento_id       PRIMARY KEY (id_status),
    CONSTRAINT uk_nombre_status_eventos  UNIQUE      (nombre),
    CONSTRAINT chk_status_eventos_activo CHECK       ( activo IN (1, 0) )
);

CREATE TABLE MODALIDADES
(
    id_modalidad INTEGER        GENERATED ALWAYS AS IDENTITY NOT NULL,
    nombre       VARCHAR2(100)                               NOT NULL,
    activo       NUMBER(1,0)                                 NOT NULL,
    
    CONSTRAINT pk_modalidades_id         PRIMARY KEY (id_modalidad),
    CONSTRAINT uk_nombre_modalidades     UNIQUE      (nombre),
    CONSTRAINT chk_modalidad_activo      CHECK       ( activo IN (1, 0) )
);

CREATE TABLE EVENTOS
(
    id_evento           INTEGER         NOT NULL,
    fecha_hora_inicio   TIMESTAMP       NOT NULL,
    fecha_hora_final    TIMESTAMP       NOT NULL,
    titulo              VARCHAR2(100)   NOT NULL,
    id_tipo_evento      INTEGER                 ,
    id_itr              INTEGER                 ,
    id_status_evento    INTEGER         NOT NULL,
    id_modalidad        INTEGER                 ,
    desc_localizacion   VARCHAR2(150)           ,
    activo              NUMBER(1,0)             ,
    
    CONSTRAINT pk_evento_id         PRIMARY KEY (id_evento),
    CONSTRAINT fk_tipo_evento       FOREIGN KEY (id_tipo_evento) REFERENCES TIPOS_EVENTO(id_tipo_evento),
    CONSTRAINT fk_itr_evento        FOREIGN KEY (id_itr)         REFERENCES ITR(id_itr),
    CONSTRAINT fk_modalidad_evento  FOREIGN KEY (id_modalidad)   REFERENCES MODALIDADES(id_modalidad),
    CONSTRAINT chk_evento_activo    CHECK       ( activo IN (1, 0) )
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

CREATE TABLE ASISTENCIAS
(
	id_asistencia	INTEGER		GENERATED ALWAYS AS IDENTITY 	NOT NULL,
	nombre			VARCHAR(100)								NOT NULL,
	valor			NUMBER(3,2)								    NOT NULL,
	
	CONSTRAINT	pk_asistencia_id PRIMARY KEY (id_asistencia),
	CONSTRAINT  uk_asist_nombre	 UNIQUE      (nombre)
);


CREATE TABLE ESTUDIANTE_EVENTO
(
    id_estudiante  INTEGER       NOT NULL,
    id_evento      INTEGER       NOT NULL,
    id_asistencia  INTEGER		 NOT NULL,
    calificacion   NUMBER(3, 2)  NOT NULL,
    
    CONSTRAINT fk_estud_even_estud	   FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES(id_estudiante),
    CONSTRAINT fk_estud_even_evento    FOREIGN KEY (id_evento)     REFERENCES EVENTOS(id_evento),
    CONSTRAINT fk_asistencia_evento	   FOREIGN KEY (id_asistencia) REFERENCES ASISTENCIAS(id_asistencia),
    CONSTRAINT pk_estud_evento         PRIMARY KEY (id_estudiante, id_evento)
);

CREATE TABLE STATUS_RECLAMO
(
    id_status     INTEGER     GENERATED ALWAYS AS IDENTITY,
    nombre        VARCHAR(50) NOT NULL,
    
    CONSTRAINT pk_stat_recl_id        PRIMARY KEY (id_status),
    CONSTRAINT uk_stat_recl_nomb      UNIQUE (nombre)
);

CREATE TABLE RECLAMOS
(
    id_reclamo       INTEGER         NOT NULL,
    id_estudiante    INTEGER         NOT NULL,
    id_evento        INTEGER         NOT NULL,
    id_analista      INTEGER                 ,
    id_status        INTEGER         NOT NULL,
    titulo           VARCHAR2(150)   NOT NULL,
    descripcion      VARCHAR2(240)   NOT NULL,
    detalle          VARCHAR2(250),
    semestre         NUMBER(1,0),
    creditos         NUMBER(1,0),
    audit_date       TIMESTAMP       NOT NULL,
    modif_user       VARCHAR2(100),
    modif_date       TIMESTAMP,
    
    CONSTRAINT pk_recl_id           PRIMARY KEY (id_reclamo),
    CONSTRAINT fk_recl_id_estud     FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES(id_estudiante),
    CONSTRAINT fk_recl_id_evento    FOREIGN KEY (id_evento)     REFERENCES EVENTOS(id_evento),
    CONSTRAINT fk_recl_id_anali     FOREIGN KEY (id_analista)   REFERENCES ANALISTAS(id_analista),
    CONSTRAINT fk_recl_id_status    FOREIGN KEY (id_status)     REFERENCES STATUS_RECLAMO(id_status),
    CONSTRAINT chk_recl_semestre    CHECK       (semestre BETWEEN 1 AND 8),
    CONSTRAINT chk_recl_creditos    CHECK       (creditos > 0)
);

CREATE TABLE STATUS_CERTIFICADOS
(
    id_status     INTEGER      NOT NULL,
    nombre        VARCHAR2(50) NOT NULL,
    
    CONSTRAINT pk_status_id           PRIMARY KEY (id_status),
    CONSTRAINT uk_stat_cert_nomb      UNIQUE (nombre)
);

CREATE TABLE JUSTIFICACIONES
(
    id_justificacion INTEGER        NOT NULL,
    id_estudiante    INTEGER        NOT NULL,
    id_evento        INTEGER        NOT NULL,
    id_analista      INTEGER                ,
    id_status        INTEGER        NOT NULL,
    detalle          VARCHAR2(250)  NOT NULL,
    fecha_hora       TIMESTAMP      NOT NULL,
    
    CONSTRAINT pk_justif_id          PRIMARY KEY (id_justificacion),
    CONSTRAINT fk_justif_id_estud    FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES(id_estudiante),
    CONSTRAINT fk_justif_id_evento   FOREIGN KEY (id_evento)     REFERENCES EVENTOS(id_evento),
    CONSTRAINT fk_justif_id_anali    FOREIGN KEY (id_analista)   REFERENCES ANALISTAS(id_analista),
    CONSTRAINT fk_status_just        FOREIGN KEY (id_status)     REFERENCES STATUS_CERTIFICADOS(id_status)
);

CREATE TABLE CONSTANCIAS
(
    id_constancia       INTEGER        NOT NULL,
    id_estudiante       INTEGER        NOT NULL,
    id_evento           INTEGER        NOT NULL,
    id_analista         INTEGER                ,
    id_status           INTEGER        NOT NULL,
    detalle             VARCHAR2(250)  NOT NULL,
    fecha_hora          DATE           NOT NULL,
    
    CONSTRAINT pk_const_id          PRIMARY KEY (id_constancia),
    CONSTRAINT fk_const_id_estud    FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES(id_estudiante),
    CONSTRAINT fk_const_id_evento   FOREIGN KEY (id_evento)     REFERENCES EVENTOS(id_evento),
    CONSTRAINT fk_const_id_anali    FOREIGN KEY (id_analista)   REFERENCES ANALISTAS(id_analista),
    CONSTRAINT fk_status_const      FOREIGN KEY (id_status)     REFERENCES STATUS_CERTIFICADOS(id_status)
);

COMMIT;

