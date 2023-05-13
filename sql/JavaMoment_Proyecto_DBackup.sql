--------------------------------------------------------
--  File created - Saturday-May-13-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence ANALISTAS_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##PROYECTO"."ANALISTAS_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence AREAS_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##PROYECTO"."AREAS_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence CONSTANCIAS_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##PROYECTO"."CONSTANCIAS_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence DEPA_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##PROYECTO"."DEPA_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence ESTUD_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##PROYECTO"."ESTUD_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence EVENT_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##PROYECTO"."EVENT_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence ITR_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##PROYECTO"."ITR_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence JUSTI_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##PROYECTO"."JUSTI_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence LOCALI_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##PROYECTO"."LOCALI_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence RECL_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##PROYECTO"."RECL_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence STAT_CERT_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##PROYECTO"."STAT_CERT_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence TUTORES_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##PROYECTO"."TUTORES_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table ANALISTAS
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."ANALISTAS" 
   (	"ID_ANALISTA" NUMBER(*,0), 
	"NOMBRE_USUARIO" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ANALISTA_EVENTO
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."ANALISTA_EVENTO" 
   (	"ID_ANALISTA" NUMBER(*,0), 
	"ID_EVENTO" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table AREAS
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."AREAS" 
   (	"ID_AREA" NUMBER(*,0), 
	"NOMBRE" VARCHAR2(100 BYTE), 
	"DESCRIPCION" VARCHAR2(250 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CONSTANCIAS
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."CONSTANCIAS" 
   (	"ID_CONSTANCIA" NUMBER(*,0), 
	"ID_ESTUDIANTE" NUMBER(*,0), 
	"ID_EVENTO" NUMBER(*,0), 
	"ID_ANALISTA" NUMBER(*,0), 
	"DETALLE" VARCHAR2(250 BYTE), 
	"FECHA_HORA" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DEPARTAMENTOS
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."DEPARTAMENTOS" 
   (	"ID_DEPARTAMENTO" NUMBER(*,0), 
	"NOMBRE" VARCHAR2(50 BYTE), 
	"ID_ITR" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ESTUDIANTES
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."ESTUDIANTES" 
   (	"ID_ESTUDIANTE" NUMBER(*,0), 
	"NOMBRE_USUARIO" VARCHAR2(100 BYTE), 
	"GENERACION" VARCHAR2(4 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ESTUDIANTE_EVENTO
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."ESTUDIANTE_EVENTO" 
   (	"ID_ESTUDIANTE" NUMBER(*,0), 
	"ID_EVENTO" NUMBER(*,0), 
	"CALIFICACION" NUMBER(3,2), 
	"ASISTENCIA" CHAR(1 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EVENTOS
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."EVENTOS" 
   (	"ID_EVENTO" NUMBER(*,0), 
	"FECHA_HORA_INICIO" DATE, 
	"FECHA_HORA_FINAL" DATE, 
	"TITULO" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ITR
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."ITR" 
   (	"ID_ITR" NUMBER(*,0), 
	"NOMBRE" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table JUSTIFICACIONES
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."JUSTIFICACIONES" 
   (	"ID_JUSTIFICACION" NUMBER(*,0), 
	"ID_ESTUDIANTE" NUMBER(*,0), 
	"ID_EVENTO" NUMBER(*,0), 
	"ID_ANALISTA" NUMBER(*,0), 
	"DETALLE" VARCHAR2(250 BYTE), 
	"FECHA_HORA" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table LOCALIDADES
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."LOCALIDADES" 
   (	"ID_LOCALIDAD" NUMBER(*,0), 
	"NOMBRE" VARCHAR2(50 BYTE), 
	"ID_DEPARTAMENTO" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table RECLAMOS
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."RECLAMOS" 
   (	"ID_RECLAMO" NUMBER(*,0), 
	"ID_ESTUDIANTE" NUMBER(*,0), 
	"ID_EVENTO" NUMBER(*,0), 
	"ID_ANALISTA" NUMBER(*,0), 
	"DETALLE" VARCHAR2(250 BYTE), 
	"FECHA_HORA" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table STATUS_CERTIFICADOS
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."STATUS_CERTIFICADOS" 
   (	"ID_STATUS" NUMBER(*,0), 
	"NOMBRE_ACCION" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table STATUS_CONSTANCIA
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."STATUS_CONSTANCIA" 
   (	"ID_STATUS" NUMBER(*,0), 
	"ID_CONSTANCIA" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table STATUS_JUSTIFICACION
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."STATUS_JUSTIFICACION" 
   (	"ID_STATUS" NUMBER(*,0), 
	"ID_JUSTIFICACION" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table STATUS_RECLAMO
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."STATUS_RECLAMO" 
   (	"ID_STATUS" NUMBER(*,0), 
	"ID_RECLAMO" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TUTORES
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."TUTORES" 
   (	"ID_TUTOR" NUMBER(*,0), 
	"NOMBRE_USUARIO" VARCHAR2(100 BYTE), 
	"TIPO" VARCHAR2(75 BYTE), 
	"ID_AREA" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TUTOR_EVENTO
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."TUTOR_EVENTO" 
   (	"ID_TUTOR" NUMBER(*,0), 
	"ID_EVENTO" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USUARIOS
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO"."USUARIOS" 
   (	"NOMBRE_USUARIO" VARCHAR2(100 BYTE), 
	"NOMBRE1" VARCHAR2(50 BYTE), 
	"NOMBRE2" VARCHAR2(50 BYTE), 
	"APELLIDO1" VARCHAR2(100 BYTE), 
	"APELLIDO2" VARCHAR2(100 BYTE), 
	"FEC_NAC" DATE, 
	"GENERO" CHAR(1 BYTE), 
	"ID_DEPARTAMENTO" NUMBER(*,0), 
	"ID_LOCALIDAD" NUMBER(*,0), 
	"MAIL" VARCHAR2(250 BYTE), 
	"CONTRASENIA" VARCHAR2(100 BYTE), 
	"TELEFONO" VARCHAR2(9 BYTE), 
	"DOCUMENTO" VARCHAR2(8 BYTE), 
	"ACTIVO" NUMBER(1,0), 
	"ID_ITR" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into C##PROYECTO.ANALISTAS
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.ANALISTA_EVENTO
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.AREAS
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.CONSTANCIAS
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.DEPARTAMENTOS
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.ESTUDIANTES
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.ESTUDIANTE_EVENTO
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.EVENTOS
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.ITR
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.JUSTIFICACIONES
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.LOCALIDADES
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.RECLAMOS
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.STATUS_CERTIFICADOS
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.STATUS_CONSTANCIA
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.STATUS_JUSTIFICACION
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.STATUS_RECLAMO
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.TUTORES
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.TUTOR_EVENTO
SET DEFINE OFF;
REM INSERTING into C##PROYECTO.USUARIOS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PK_ANALISTA_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ANALISTA_ID" ON "C##PROYECTO"."ANALISTAS" ("ID_ANALISTA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ANALI_EVENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ANALI_EVENTO" ON "C##PROYECTO"."ANALISTA_EVENTO" ("ID_ANALISTA", "ID_EVENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_AREA_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_AREA_ID" ON "C##PROYECTO"."AREAS" ("ID_AREA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_CONST_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_CONST_ID" ON "C##PROYECTO"."CONSTANCIAS" ("ID_CONSTANCIA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ESTUD_EVENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ESTUD_EVENTO" ON "C##PROYECTO"."ESTUDIANTE_EVENTO" ("ID_ESTUDIANTE", "ID_EVENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ESTUD_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ESTUD_ID" ON "C##PROYECTO"."ESTUDIANTES" ("ID_ESTUDIANTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_EVENTO_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_EVENTO_ID" ON "C##PROYECTO"."EVENTOS" ("ID_EVENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ID_DEPA
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ID_DEPA" ON "C##PROYECTO"."DEPARTAMENTOS" ("ID_DEPARTAMENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ID_ITR
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ID_ITR" ON "C##PROYECTO"."ITR" ("ID_ITR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ID_LOCALI
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ID_LOCALI" ON "C##PROYECTO"."LOCALIDADES" ("ID_LOCALIDAD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_JUSTIF_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_JUSTIF_ID" ON "C##PROYECTO"."JUSTIFICACIONES" ("ID_JUSTIFICACION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_RECL_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_RECL_ID" ON "C##PROYECTO"."RECLAMOS" ("ID_RECLAMO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_STATUS_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_STATUS_ID" ON "C##PROYECTO"."STATUS_CERTIFICADOS" ("ID_STATUS") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_STAT_CONST_IDS
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_STAT_CONST_IDS" ON "C##PROYECTO"."STATUS_CONSTANCIA" ("ID_STATUS", "ID_CONSTANCIA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_STAT_JUST_IDS
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_STAT_JUST_IDS" ON "C##PROYECTO"."STATUS_JUSTIFICACION" ("ID_STATUS", "ID_JUSTIFICACION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_STAT_RECL_IDS
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_STAT_RECL_IDS" ON "C##PROYECTO"."STATUS_RECLAMO" ("ID_STATUS", "ID_RECLAMO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_TUTOR_EVENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_TUTOR_EVENTO" ON "C##PROYECTO"."TUTOR_EVENTO" ("ID_TUTOR", "ID_EVENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_TUTOR_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_TUTOR_ID" ON "C##PROYECTO"."TUTORES" ("ID_TUTOR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_USR_NOMBRE_USUARIO
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_USR_NOMBRE_USUARIO" ON "C##PROYECTO"."USUARIOS" ("NOMBRE_USUARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_AREA_NOMB
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."UK_AREA_NOMB" ON "C##PROYECTO"."AREAS" ("NOMBRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_DEPA_NOMB
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."UK_DEPA_NOMB" ON "C##PROYECTO"."DEPARTAMENTOS" ("NOMBRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_ITR_NOMB
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."UK_ITR_NOMB" ON "C##PROYECTO"."ITR" ("NOMBRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_LOCALI_NOMB
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."UK_LOCALI_NOMB" ON "C##PROYECTO"."LOCALIDADES" ("NOMBRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_USR_DOCUMENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."UK_USR_DOCUMENTO" ON "C##PROYECTO"."USUARIOS" ("DOCUMENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ANALISTA_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ANALISTA_ID" ON "C##PROYECTO"."ANALISTAS" ("ID_ANALISTA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ANALI_EVENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ANALI_EVENTO" ON "C##PROYECTO"."ANALISTA_EVENTO" ("ID_ANALISTA", "ID_EVENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_AREA_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_AREA_ID" ON "C##PROYECTO"."AREAS" ("ID_AREA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_AREA_NOMB
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."UK_AREA_NOMB" ON "C##PROYECTO"."AREAS" ("NOMBRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_CONST_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_CONST_ID" ON "C##PROYECTO"."CONSTANCIAS" ("ID_CONSTANCIA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ID_DEPA
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ID_DEPA" ON "C##PROYECTO"."DEPARTAMENTOS" ("ID_DEPARTAMENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_DEPA_NOMB
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."UK_DEPA_NOMB" ON "C##PROYECTO"."DEPARTAMENTOS" ("NOMBRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ESTUD_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ESTUD_ID" ON "C##PROYECTO"."ESTUDIANTES" ("ID_ESTUDIANTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ESTUD_EVENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ESTUD_EVENTO" ON "C##PROYECTO"."ESTUDIANTE_EVENTO" ("ID_ESTUDIANTE", "ID_EVENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_EVENTO_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_EVENTO_ID" ON "C##PROYECTO"."EVENTOS" ("ID_EVENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ID_ITR
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ID_ITR" ON "C##PROYECTO"."ITR" ("ID_ITR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_ITR_NOMB
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."UK_ITR_NOMB" ON "C##PROYECTO"."ITR" ("NOMBRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_JUSTIF_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_JUSTIF_ID" ON "C##PROYECTO"."JUSTIFICACIONES" ("ID_JUSTIFICACION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ID_LOCALI
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_ID_LOCALI" ON "C##PROYECTO"."LOCALIDADES" ("ID_LOCALIDAD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_LOCALI_NOMB
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."UK_LOCALI_NOMB" ON "C##PROYECTO"."LOCALIDADES" ("NOMBRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_RECL_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_RECL_ID" ON "C##PROYECTO"."RECLAMOS" ("ID_RECLAMO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_STATUS_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_STATUS_ID" ON "C##PROYECTO"."STATUS_CERTIFICADOS" ("ID_STATUS") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_STAT_CONST_IDS
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_STAT_CONST_IDS" ON "C##PROYECTO"."STATUS_CONSTANCIA" ("ID_STATUS", "ID_CONSTANCIA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_STAT_JUST_IDS
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_STAT_JUST_IDS" ON "C##PROYECTO"."STATUS_JUSTIFICACION" ("ID_STATUS", "ID_JUSTIFICACION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_STAT_RECL_IDS
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_STAT_RECL_IDS" ON "C##PROYECTO"."STATUS_RECLAMO" ("ID_STATUS", "ID_RECLAMO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_TUTOR_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_TUTOR_ID" ON "C##PROYECTO"."TUTORES" ("ID_TUTOR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_TUTOR_EVENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_TUTOR_EVENTO" ON "C##PROYECTO"."TUTOR_EVENTO" ("ID_TUTOR", "ID_EVENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_USR_NOMBRE_USUARIO
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."PK_USR_NOMBRE_USUARIO" ON "C##PROYECTO"."USUARIOS" ("NOMBRE_USUARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_USR_DOCUMENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO"."UK_USR_DOCUMENTO" ON "C##PROYECTO"."USUARIOS" ("DOCUMENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger SET_ANALI_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_ANALI_ID_TRIGGER" 
BEFORE INSERT ON ANALISTAS
FOR EACH ROW
BEGIN
  :NEW.id_analista := analistas_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_ANALI_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_AREAS_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_AREAS_ID_TRIGGER" 
BEFORE INSERT ON AREAS
FOR EACH ROW
BEGIN
  :NEW.id_area := areas_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_AREAS_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_CONST_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_CONST_ID_TRIGGER" 
BEFORE INSERT ON CONSTANCIAS
FOR EACH ROW
BEGIN
  :NEW.id_constancia := constancias_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_CONST_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_DEPA_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_DEPA_ID_TRIGGER" 
BEFORE INSERT ON DEPARTAMENTOS
FOR EACH ROW
BEGIN
  :NEW.id_departamento := depa_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_DEPA_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_ESTUD_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_ESTUD_ID_TRIGGER" 
BEFORE INSERT ON ESTUDIANTES
FOR EACH ROW
BEGIN
  :NEW.id_estudiante := estud_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_ESTUD_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_EVENTOS_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_EVENTOS_ID_TRIGGER" 
BEFORE INSERT ON EVENTOS
FOR EACH ROW
BEGIN
  :NEW.id_evento := event_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_EVENTOS_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_ITR_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_ITR_ID_TRIGGER" 
BEFORE INSERT ON ITR
FOR EACH ROW
BEGIN
  :NEW.id_itr := itr_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_ITR_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_JUSTI_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_JUSTI_ID_TRIGGER" 
BEFORE INSERT ON JUSTIFICACIONES
FOR EACH ROW
BEGIN
  :NEW.id_justificacion := justi_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_JUSTI_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_LOCALI_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_LOCALI_ID_TRIGGER" 
BEFORE INSERT ON LOCALIDADES
FOR EACH ROW
BEGIN
  :NEW.id_localidad := locali_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_LOCALI_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_RECL_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_RECL_ID_TRIGGER" 
BEFORE INSERT ON RECLAMOS
FOR EACH ROW
BEGIN
  :NEW.id_reclamo := recl_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_RECL_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_STAT_CERT_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_STAT_CERT_ID_TRIGGER" 
BEFORE INSERT ON STATUS_CERTIFICADOS
FOR EACH ROW
BEGIN
  :NEW.id_status := stat_cert_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_STAT_CERT_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_TUTORES_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_TUTORES_ID_TRIGGER" 
BEFORE INSERT ON TUTORES
FOR EACH ROW
BEGIN
  :NEW.id_tutor := tutores_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_TUTORES_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_USR_ACTIVO_DEFAULT
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_USR_ACTIVO_DEFAULT" 
BEFORE INSERT ON USUARIOS
FOR EACH ROW
BEGIN
  :NEW.activo := 0; -- Settea el valor de la columna 'activo' (1 para activo, 0 para inactivo)
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_USR_ACTIVO_DEFAULT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_ANALI_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_ANALI_ID_TRIGGER" 
BEFORE INSERT ON ANALISTAS
FOR EACH ROW
BEGIN
  :NEW.id_analista := analistas_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_ANALI_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_AREAS_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_AREAS_ID_TRIGGER" 
BEFORE INSERT ON AREAS
FOR EACH ROW
BEGIN
  :NEW.id_area := areas_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_AREAS_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_CONST_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_CONST_ID_TRIGGER" 
BEFORE INSERT ON CONSTANCIAS
FOR EACH ROW
BEGIN
  :NEW.id_constancia := constancias_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_CONST_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_DEPA_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_DEPA_ID_TRIGGER" 
BEFORE INSERT ON DEPARTAMENTOS
FOR EACH ROW
BEGIN
  :NEW.id_departamento := depa_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_DEPA_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_ESTUD_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_ESTUD_ID_TRIGGER" 
BEFORE INSERT ON ESTUDIANTES
FOR EACH ROW
BEGIN
  :NEW.id_estudiante := estud_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_ESTUD_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_EVENTOS_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_EVENTOS_ID_TRIGGER" 
BEFORE INSERT ON EVENTOS
FOR EACH ROW
BEGIN
  :NEW.id_evento := event_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_EVENTOS_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_ITR_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_ITR_ID_TRIGGER" 
BEFORE INSERT ON ITR
FOR EACH ROW
BEGIN
  :NEW.id_itr := itr_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_ITR_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_JUSTI_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_JUSTI_ID_TRIGGER" 
BEFORE INSERT ON JUSTIFICACIONES
FOR EACH ROW
BEGIN
  :NEW.id_justificacion := justi_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_JUSTI_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_LOCALI_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_LOCALI_ID_TRIGGER" 
BEFORE INSERT ON LOCALIDADES
FOR EACH ROW
BEGIN
  :NEW.id_localidad := locali_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_LOCALI_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_RECL_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_RECL_ID_TRIGGER" 
BEFORE INSERT ON RECLAMOS
FOR EACH ROW
BEGIN
  :NEW.id_reclamo := recl_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_RECL_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_STAT_CERT_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_STAT_CERT_ID_TRIGGER" 
BEFORE INSERT ON STATUS_CERTIFICADOS
FOR EACH ROW
BEGIN
  :NEW.id_status := stat_cert_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_STAT_CERT_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_TUTORES_ID_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_TUTORES_ID_TRIGGER" 
BEFORE INSERT ON TUTORES
FOR EACH ROW
BEGIN
  :NEW.id_tutor := tutores_id_seq.NEXTVAL;
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_TUTORES_ID_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SET_USR_ACTIVO_DEFAULT
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##PROYECTO"."SET_USR_ACTIVO_DEFAULT" 
BEFORE INSERT ON USUARIOS
FOR EACH ROW
BEGIN
  :NEW.activo := 0; -- Settea el valor de la columna 'activo' (1 para activo, 0 para inactivo)
END;

/
ALTER TRIGGER "C##PROYECTO"."SET_USR_ACTIVO_DEFAULT" ENABLE;
--------------------------------------------------------
--  Constraints for Table ANALISTAS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."ANALISTAS" MODIFY ("ID_ANALISTA" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."ANALISTAS" MODIFY ("NOMBRE_USUARIO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."ANALISTAS" ADD CONSTRAINT "PK_ANALISTA_ID" PRIMARY KEY ("ID_ANALISTA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ANALISTA_EVENTO
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."ANALISTA_EVENTO" MODIFY ("ID_ANALISTA" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."ANALISTA_EVENTO" MODIFY ("ID_EVENTO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."ANALISTA_EVENTO" ADD CONSTRAINT "PK_ANALI_EVENTO" PRIMARY KEY ("ID_ANALISTA", "ID_EVENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table AREAS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."AREAS" MODIFY ("ID_AREA" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."AREAS" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."AREAS" MODIFY ("DESCRIPCION" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."AREAS" ADD CONSTRAINT "PK_AREA_ID" PRIMARY KEY ("ID_AREA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##PROYECTO"."AREAS" ADD CONSTRAINT "UK_AREA_NOMB" UNIQUE ("NOMBRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CONSTANCIAS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."CONSTANCIAS" MODIFY ("ID_CONSTANCIA" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."CONSTANCIAS" MODIFY ("ID_ESTUDIANTE" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."CONSTANCIAS" MODIFY ("ID_EVENTO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."CONSTANCIAS" MODIFY ("DETALLE" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."CONSTANCIAS" MODIFY ("FECHA_HORA" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."CONSTANCIAS" ADD CONSTRAINT "PK_CONST_ID" PRIMARY KEY ("ID_CONSTANCIA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table DEPARTAMENTOS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."DEPARTAMENTOS" MODIFY ("ID_DEPARTAMENTO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."DEPARTAMENTOS" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."DEPARTAMENTOS" ADD CONSTRAINT "PK_ID_DEPA" PRIMARY KEY ("ID_DEPARTAMENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##PROYECTO"."DEPARTAMENTOS" ADD CONSTRAINT "UK_DEPA_NOMB" UNIQUE ("NOMBRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##PROYECTO"."DEPARTAMENTOS" MODIFY ("ID_ITR" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ESTUDIANTES
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."ESTUDIANTES" MODIFY ("ID_ESTUDIANTE" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."ESTUDIANTES" MODIFY ("NOMBRE_USUARIO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."ESTUDIANTES" MODIFY ("GENERACION" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."ESTUDIANTES" ADD CONSTRAINT "PK_ESTUD_ID" PRIMARY KEY ("ID_ESTUDIANTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ESTUDIANTE_EVENTO
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."ESTUDIANTE_EVENTO" MODIFY ("ID_ESTUDIANTE" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."ESTUDIANTE_EVENTO" MODIFY ("ID_EVENTO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."ESTUDIANTE_EVENTO" MODIFY ("CALIFICACION" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."ESTUDIANTE_EVENTO" MODIFY ("ASISTENCIA" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."ESTUDIANTE_EVENTO" ADD CONSTRAINT "CHK_ESTUD_EVEN_ASIST" CHECK (calificacion IN ('S', 'N', 'P')) ENABLE;
  ALTER TABLE "C##PROYECTO"."ESTUDIANTE_EVENTO" ADD CONSTRAINT "PK_ESTUD_EVENTO" PRIMARY KEY ("ID_ESTUDIANTE", "ID_EVENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EVENTOS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."EVENTOS" MODIFY ("ID_EVENTO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."EVENTOS" MODIFY ("FECHA_HORA_INICIO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."EVENTOS" MODIFY ("FECHA_HORA_FINAL" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."EVENTOS" MODIFY ("TITULO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."EVENTOS" ADD CONSTRAINT "PK_EVENTO_ID" PRIMARY KEY ("ID_EVENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ITR
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."ITR" MODIFY ("ID_ITR" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."ITR" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."ITR" ADD CONSTRAINT "PK_ID_ITR" PRIMARY KEY ("ID_ITR")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##PROYECTO"."ITR" ADD CONSTRAINT "UK_ITR_NOMB" UNIQUE ("NOMBRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table JUSTIFICACIONES
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."JUSTIFICACIONES" MODIFY ("ID_JUSTIFICACION" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."JUSTIFICACIONES" MODIFY ("ID_ESTUDIANTE" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."JUSTIFICACIONES" MODIFY ("ID_EVENTO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."JUSTIFICACIONES" MODIFY ("DETALLE" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."JUSTIFICACIONES" MODIFY ("FECHA_HORA" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."JUSTIFICACIONES" ADD CONSTRAINT "PK_JUSTIF_ID" PRIMARY KEY ("ID_JUSTIFICACION")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table LOCALIDADES
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."LOCALIDADES" MODIFY ("ID_LOCALIDAD" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."LOCALIDADES" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."LOCALIDADES" MODIFY ("ID_DEPARTAMENTO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."LOCALIDADES" ADD CONSTRAINT "PK_ID_LOCALI" PRIMARY KEY ("ID_LOCALIDAD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##PROYECTO"."LOCALIDADES" ADD CONSTRAINT "UK_LOCALI_NOMB" UNIQUE ("NOMBRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table RECLAMOS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."RECLAMOS" MODIFY ("ID_RECLAMO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."RECLAMOS" MODIFY ("ID_ESTUDIANTE" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."RECLAMOS" MODIFY ("ID_EVENTO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."RECLAMOS" MODIFY ("DETALLE" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."RECLAMOS" MODIFY ("FECHA_HORA" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."RECLAMOS" ADD CONSTRAINT "PK_RECL_ID" PRIMARY KEY ("ID_RECLAMO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table STATUS_CERTIFICADOS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."STATUS_CERTIFICADOS" MODIFY ("ID_STATUS" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."STATUS_CERTIFICADOS" MODIFY ("NOMBRE_ACCION" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."STATUS_CERTIFICADOS" ADD CONSTRAINT "PK_STATUS_ID" PRIMARY KEY ("ID_STATUS")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table STATUS_CONSTANCIA
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."STATUS_CONSTANCIA" MODIFY ("ID_STATUS" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."STATUS_CONSTANCIA" MODIFY ("ID_CONSTANCIA" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."STATUS_CONSTANCIA" ADD CONSTRAINT "PK_STAT_CONST_IDS" PRIMARY KEY ("ID_STATUS", "ID_CONSTANCIA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table STATUS_JUSTIFICACION
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."STATUS_JUSTIFICACION" MODIFY ("ID_STATUS" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."STATUS_JUSTIFICACION" MODIFY ("ID_JUSTIFICACION" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."STATUS_JUSTIFICACION" ADD CONSTRAINT "PK_STAT_JUST_IDS" PRIMARY KEY ("ID_STATUS", "ID_JUSTIFICACION")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table STATUS_RECLAMO
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."STATUS_RECLAMO" MODIFY ("ID_STATUS" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."STATUS_RECLAMO" MODIFY ("ID_RECLAMO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."STATUS_RECLAMO" ADD CONSTRAINT "PK_STAT_RECL_IDS" PRIMARY KEY ("ID_STATUS", "ID_RECLAMO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TUTORES
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."TUTORES" MODIFY ("ID_TUTOR" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."TUTORES" MODIFY ("NOMBRE_USUARIO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."TUTORES" MODIFY ("TIPO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."TUTORES" MODIFY ("ID_AREA" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."TUTORES" ADD CONSTRAINT "PK_TUTOR_ID" PRIMARY KEY ("ID_TUTOR")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TUTOR_EVENTO
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."TUTOR_EVENTO" MODIFY ("ID_TUTOR" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."TUTOR_EVENTO" MODIFY ("ID_EVENTO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."TUTOR_EVENTO" ADD CONSTRAINT "PK_TUTOR_EVENTO" PRIMARY KEY ("ID_TUTOR", "ID_EVENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USUARIOS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."USUARIOS" MODIFY ("NOMBRE_USUARIO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."USUARIOS" MODIFY ("NOMBRE1" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."USUARIOS" MODIFY ("APELLIDO1" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."USUARIOS" MODIFY ("APELLIDO2" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."USUARIOS" MODIFY ("FEC_NAC" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."USUARIOS" MODIFY ("GENERO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."USUARIOS" MODIFY ("ID_DEPARTAMENTO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."USUARIOS" MODIFY ("ID_LOCALIDAD" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."USUARIOS" MODIFY ("MAIL" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."USUARIOS" MODIFY ("CONTRASENIA" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."USUARIOS" MODIFY ("DOCUMENTO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."USUARIOS" MODIFY ("ACTIVO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO"."USUARIOS" ADD CONSTRAINT "CHK_USR_GENERO" CHECK ( genero IN ('F', 'M', 'O') ) ENABLE;
  ALTER TABLE "C##PROYECTO"."USUARIOS" ADD CONSTRAINT "CHK_USR_ACTIVO" CHECK ( activo IN (1, 0)          ) ENABLE;
  ALTER TABLE "C##PROYECTO"."USUARIOS" ADD CONSTRAINT "PK_USR_NOMBRE_USUARIO" PRIMARY KEY ("NOMBRE_USUARIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##PROYECTO"."USUARIOS" ADD CONSTRAINT "UK_USR_DOCUMENTO" UNIQUE ("DOCUMENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##PROYECTO"."USUARIOS" MODIFY ("ID_ITR" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ANALISTAS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."ANALISTAS" ADD CONSTRAINT "FK_ANALI_NOMB_USER" FOREIGN KEY ("NOMBRE_USUARIO")
	  REFERENCES "C##PROYECTO"."USUARIOS" ("NOMBRE_USUARIO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ANALISTA_EVENTO
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."ANALISTA_EVENTO" ADD CONSTRAINT "FK_ANALI_EVEN_ANALISTA" FOREIGN KEY ("ID_ANALISTA")
	  REFERENCES "C##PROYECTO"."ANALISTAS" ("ID_ANALISTA") ENABLE;
  ALTER TABLE "C##PROYECTO"."ANALISTA_EVENTO" ADD CONSTRAINT "FK_ANALI_EVEN_EVENTO" FOREIGN KEY ("ID_EVENTO")
	  REFERENCES "C##PROYECTO"."EVENTOS" ("ID_EVENTO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CONSTANCIAS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."CONSTANCIAS" ADD CONSTRAINT "FK_CONST_ID_ESTUD" FOREIGN KEY ("ID_ESTUDIANTE")
	  REFERENCES "C##PROYECTO"."ESTUDIANTES" ("ID_ESTUDIANTE") ENABLE;
  ALTER TABLE "C##PROYECTO"."CONSTANCIAS" ADD CONSTRAINT "FK_CONST_ID_EVENTO" FOREIGN KEY ("ID_EVENTO")
	  REFERENCES "C##PROYECTO"."EVENTOS" ("ID_EVENTO") ENABLE;
  ALTER TABLE "C##PROYECTO"."CONSTANCIAS" ADD CONSTRAINT "FK_CONST_ID_ANALI" FOREIGN KEY ("ID_ANALISTA")
	  REFERENCES "C##PROYECTO"."ANALISTAS" ("ID_ANALISTA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DEPARTAMENTOS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."DEPARTAMENTOS" ADD CONSTRAINT "FK_DEPA_ID_ITR" FOREIGN KEY ("ID_ITR")
	  REFERENCES "C##PROYECTO"."ITR" ("ID_ITR") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ESTUDIANTES
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."ESTUDIANTES" ADD CONSTRAINT "FK_ESTUD_NOMB_USR" FOREIGN KEY ("NOMBRE_USUARIO")
	  REFERENCES "C##PROYECTO"."USUARIOS" ("NOMBRE_USUARIO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ESTUDIANTE_EVENTO
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."ESTUDIANTE_EVENTO" ADD CONSTRAINT "FK_ESTUD_EVEN_ANALISTA" FOREIGN KEY ("ID_ESTUDIANTE")
	  REFERENCES "C##PROYECTO"."ESTUDIANTES" ("ID_ESTUDIANTE") ENABLE;
  ALTER TABLE "C##PROYECTO"."ESTUDIANTE_EVENTO" ADD CONSTRAINT "FK_ESTUD_EVEN_EVENTO" FOREIGN KEY ("ID_EVENTO")
	  REFERENCES "C##PROYECTO"."EVENTOS" ("ID_EVENTO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JUSTIFICACIONES
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."JUSTIFICACIONES" ADD CONSTRAINT "FK_JUSTIF_ID_ESTUD" FOREIGN KEY ("ID_ESTUDIANTE")
	  REFERENCES "C##PROYECTO"."ESTUDIANTES" ("ID_ESTUDIANTE") ENABLE;
  ALTER TABLE "C##PROYECTO"."JUSTIFICACIONES" ADD CONSTRAINT "FK_JUSTIF_ID_EVENTO" FOREIGN KEY ("ID_EVENTO")
	  REFERENCES "C##PROYECTO"."EVENTOS" ("ID_EVENTO") ENABLE;
  ALTER TABLE "C##PROYECTO"."JUSTIFICACIONES" ADD CONSTRAINT "FK_JUSTIF_ID_ANALI" FOREIGN KEY ("ID_ANALISTA")
	  REFERENCES "C##PROYECTO"."ANALISTAS" ("ID_ANALISTA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table LOCALIDADES
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."LOCALIDADES" ADD CONSTRAINT "FK_LOCALI_ID_DEPA" FOREIGN KEY ("ID_DEPARTAMENTO")
	  REFERENCES "C##PROYECTO"."DEPARTAMENTOS" ("ID_DEPARTAMENTO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RECLAMOS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."RECLAMOS" ADD CONSTRAINT "FK_RECL_ID_ESTUD" FOREIGN KEY ("ID_ESTUDIANTE")
	  REFERENCES "C##PROYECTO"."ESTUDIANTES" ("ID_ESTUDIANTE") ENABLE;
  ALTER TABLE "C##PROYECTO"."RECLAMOS" ADD CONSTRAINT "FK_RECL_ID_EVENTO" FOREIGN KEY ("ID_EVENTO")
	  REFERENCES "C##PROYECTO"."EVENTOS" ("ID_EVENTO") ENABLE;
  ALTER TABLE "C##PROYECTO"."RECLAMOS" ADD CONSTRAINT "FK_RECL_ID_ANALI" FOREIGN KEY ("ID_ANALISTA")
	  REFERENCES "C##PROYECTO"."ANALISTAS" ("ID_ANALISTA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table STATUS_CONSTANCIA
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."STATUS_CONSTANCIA" ADD CONSTRAINT "FK_STAT_CONST_STATUS" FOREIGN KEY ("ID_STATUS")
	  REFERENCES "C##PROYECTO"."STATUS_CERTIFICADOS" ("ID_STATUS") ENABLE;
  ALTER TABLE "C##PROYECTO"."STATUS_CONSTANCIA" ADD CONSTRAINT "FK_STAT_CONST_CONSTANCIA" FOREIGN KEY ("ID_CONSTANCIA")
	  REFERENCES "C##PROYECTO"."CONSTANCIAS" ("ID_CONSTANCIA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table STATUS_JUSTIFICACION
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."STATUS_JUSTIFICACION" ADD CONSTRAINT "FK_STAT_JUST_STATUS" FOREIGN KEY ("ID_STATUS")
	  REFERENCES "C##PROYECTO"."STATUS_CERTIFICADOS" ("ID_STATUS") ENABLE;
  ALTER TABLE "C##PROYECTO"."STATUS_JUSTIFICACION" ADD CONSTRAINT "FK_STAT_JUST_JUSTIFICACION" FOREIGN KEY ("ID_JUSTIFICACION")
	  REFERENCES "C##PROYECTO"."JUSTIFICACIONES" ("ID_JUSTIFICACION") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table STATUS_RECLAMO
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."STATUS_RECLAMO" ADD CONSTRAINT "FK_STAT_RECL_STATUS" FOREIGN KEY ("ID_STATUS")
	  REFERENCES "C##PROYECTO"."STATUS_CERTIFICADOS" ("ID_STATUS") ENABLE;
  ALTER TABLE "C##PROYECTO"."STATUS_RECLAMO" ADD CONSTRAINT "FK_STAT_RECL_RECLAMO" FOREIGN KEY ("ID_RECLAMO")
	  REFERENCES "C##PROYECTO"."RECLAMOS" ("ID_RECLAMO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TUTORES
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."TUTORES" ADD CONSTRAINT "FK_TUTOR_NOMB_USER" FOREIGN KEY ("NOMBRE_USUARIO")
	  REFERENCES "C##PROYECTO"."USUARIOS" ("NOMBRE_USUARIO") ENABLE;
  ALTER TABLE "C##PROYECTO"."TUTORES" ADD CONSTRAINT "FK_TUTOR_ID_AREA" FOREIGN KEY ("ID_AREA")
	  REFERENCES "C##PROYECTO"."AREAS" ("ID_AREA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TUTOR_EVENTO
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."TUTOR_EVENTO" ADD CONSTRAINT "FK_TUTO_EVEN_TUTOR" FOREIGN KEY ("ID_TUTOR")
	  REFERENCES "C##PROYECTO"."TUTORES" ("ID_TUTOR") ENABLE;
  ALTER TABLE "C##PROYECTO"."TUTOR_EVENTO" ADD CONSTRAINT "FK_TUTO_EVEN_EVENTO" FOREIGN KEY ("ID_EVENTO")
	  REFERENCES "C##PROYECTO"."EVENTOS" ("ID_EVENTO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USUARIOS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO"."USUARIOS" ADD CONSTRAINT "FK_USR_ID_ITR" FOREIGN KEY ("ID_ITR")
	  REFERENCES "C##PROYECTO"."ITR" ("ID_ITR") ENABLE;
  ALTER TABLE "C##PROYECTO"."USUARIOS" ADD CONSTRAINT "FK_USR_ID_DEPA" FOREIGN KEY ("ID_DEPARTAMENTO")
	  REFERENCES "C##PROYECTO"."DEPARTAMENTOS" ("ID_DEPARTAMENTO") ENABLE;
  ALTER TABLE "C##PROYECTO"."USUARIOS" ADD CONSTRAINT "FK_USR_ID_LOCALI" FOREIGN KEY ("ID_LOCALIDAD")
	  REFERENCES "C##PROYECTO"."LOCALIDADES" ("ID_LOCALIDAD") ENABLE;
