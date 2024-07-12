--------------------------------------------------------
--  File created - Friday-June-21-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DT_ITR
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO_DW"."DT_ITR" 
   (	"SK_ITR" NUMBER(*,0) GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"PK_ITR" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DT_TIEMPO
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO_DW"."DT_TIEMPO" 
   (	"SK_TIEMPO" NUMBER(*,0) GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"PK_TIEMPO" NUMBER(*,0), 
	"ANIO" NUMBER(*,0), 
	"MES" NUMBER(*,0), 
	"SEMESTRE" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table D_ITR
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO_DW"."D_ITR" 
   (	"NOMBRE" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table D_TIEMPO
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO_DW"."D_TIEMPO" 
   (	"FECHA_HORA_INICIO" TIMESTAMP (6), 
	"FECHA_HORA_FINAL" TIMESTAMP (6)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HT_EVENTO
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO_DW"."HT_EVENTO" 
   (	"SK_EVENTO" NUMBER(*,0) GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"SK_ITR" NUMBER(*,0), 
	"SK_TIEMPO" NUMBER(*,0), 
	"CANT_EVENTOS" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table H_EVENTOS
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO_DW"."H_EVENTOS" 
   (	"FECHA_HORA_FINAL" TIMESTAMP (6), 
	"FECHA_HORA_INICIO" TIMESTAMP (6), 
	"ID_EVENTO" NUMBER(*,0), 
	"ITR_NOMBRE" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ODS_EVENTOS
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO_DW"."ODS_EVENTOS" 
   (	"PK_ITR" VARCHAR2(100 BYTE), 
	"PK_TIEMPO" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ODS_ITR
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO_DW"."ODS_ITR" 
   (	"PK_ITR" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ODS_TIEMPO
--------------------------------------------------------

  CREATE TABLE "C##PROYECTO_DW"."ODS_TIEMPO" 
   (	"PK_TIEMPO" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

  Insert into C##PROYECTO_DW.DT_ITR (PK_ITR) values ('CENTRO-SUR');
Insert into C##PROYECTO_DW.DT_ITR (PK_ITR) values ('CENTRO-OESTE');
Insert into C##PROYECTO_DW.DT_ITR (PK_ITR) values ('ESTE');
Insert into C##PROYECTO_DW.DT_ITR (PK_ITR) values ('NORTE');
Insert into C##PROYECTO_DW.DT_ITR (PK_ITR) values ('ONLINE');
Insert into C##PROYECTO_DW.DT_ITR (PK_ITR) values ('SUROESTE');

Insert into C##PROYECTO_DW.DT_TIEMPO (PK_TIEMPO,ANIO,MES,SEMESTRE) values (20240625,2024,6,1);
Insert into C##PROYECTO_DW.DT_TIEMPO (PK_TIEMPO,ANIO,MES,SEMESTRE) values (20240626,2024,6,1);
Insert into C##PROYECTO_DW.DT_TIEMPO (PK_TIEMPO,ANIO,MES,SEMESTRE) values (20240628,2024,6,1);
Insert into C##PROYECTO_DW.DT_TIEMPO (PK_TIEMPO,ANIO,MES,SEMESTRE) values (20240629,2024,6,1);
Insert into C##PROYECTO_DW.DT_TIEMPO (PK_TIEMPO,ANIO,MES,SEMESTRE) values (20240624,2024,6,1);
Insert into C##PROYECTO_DW.DT_TIEMPO (PK_TIEMPO,ANIO,MES,SEMESTRE) values (20240627,2024,6,1);

Insert into C##PROYECTO_DW.D_ITR (NOMBRE) values ('Centro Sur');
Insert into C##PROYECTO_DW.D_ITR (NOMBRE) values ('Centro-Oeste');
Insert into C##PROYECTO_DW.D_ITR (NOMBRE) values ('Este');
Insert into C##PROYECTO_DW.D_ITR (NOMBRE) values ('Norte');
Insert into C##PROYECTO_DW.D_ITR (NOMBRE) values ('Online');
Insert into C##PROYECTO_DW.D_ITR (NOMBRE) values ('Suroeste');

Insert into C##PROYECTO_DW.D_TIEMPO (FECHA_HORA_INICIO,FECHA_HORA_FINAL) values (to_timestamp('25-JUN-24 09.30.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('26-JUN-24 11.59.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into C##PROYECTO_DW.D_TIEMPO (FECHA_HORA_INICIO,FECHA_HORA_FINAL) values (to_timestamp('26-JUN-24 06.59.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('27-JUN-24 08.59.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into C##PROYECTO_DW.D_TIEMPO (FECHA_HORA_INICIO,FECHA_HORA_FINAL) values (to_timestamp('28-JUN-24 12.59.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('28-JUN-24 11.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into C##PROYECTO_DW.D_TIEMPO (FECHA_HORA_INICIO,FECHA_HORA_FINAL) values (to_timestamp('29-JUN-24 09.30.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('29-JUN-24 06.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into C##PROYECTO_DW.D_TIEMPO (FECHA_HORA_INICIO,FECHA_HORA_FINAL) values (to_timestamp('26-JUN-24 09.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('26-JUN-24 06.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into C##PROYECTO_DW.D_TIEMPO (FECHA_HORA_INICIO,FECHA_HORA_FINAL) values (to_timestamp('24-JUN-24 09.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('28-JUN-24 06.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into C##PROYECTO_DW.D_TIEMPO (FECHA_HORA_INICIO,FECHA_HORA_FINAL) values (to_timestamp('24-JUN-24 02.25.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('24-JUN-24 11.59.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into C##PROYECTO_DW.D_TIEMPO (FECHA_HORA_INICIO,FECHA_HORA_FINAL) values (to_timestamp('24-JUN-24 09.30.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('24-JUN-24 04.15.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));
Insert into C##PROYECTO_DW.D_TIEMPO (FECHA_HORA_INICIO,FECHA_HORA_FINAL) values (to_timestamp('24-JUN-24 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('24-JUN-24 11.59.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'));

Insert into C##PROYECTO_DW.HT_EVENTO (SK_ITR,SK_TIEMPO,CANT_EVENTOS) values (2,1,1);
Insert into C##PROYECTO_DW.HT_EVENTO (SK_ITR,SK_TIEMPO,CANT_EVENTOS) values (2,2,2);
Insert into C##PROYECTO_DW.HT_EVENTO (SK_ITR,SK_TIEMPO,CANT_EVENTOS) values (2,3,1);
Insert into C##PROYECTO_DW.HT_EVENTO (SK_ITR,SK_TIEMPO,CANT_EVENTOS) values (2,5,3);
Insert into C##PROYECTO_DW.HT_EVENTO (SK_ITR,SK_TIEMPO,CANT_EVENTOS) values (2,6,1);
Insert into C##PROYECTO_DW.HT_EVENTO (SK_ITR,SK_TIEMPO,CANT_EVENTOS) values (3,2,1);
Insert into C##PROYECTO_DW.HT_EVENTO (SK_ITR,SK_TIEMPO,CANT_EVENTOS) values (3,4,1);
Insert into C##PROYECTO_DW.HT_EVENTO (SK_ITR,SK_TIEMPO,CANT_EVENTOS) values (5,3,1);
Insert into C##PROYECTO_DW.HT_EVENTO (SK_ITR,SK_TIEMPO,CANT_EVENTOS) values (5,5,1);

Insert into C##PROYECTO_DW.H_EVENTOS (FECHA_HORA_FINAL,FECHA_HORA_INICIO,ID_EVENTO,ITR_NOMBRE) values (to_timestamp('26-JUN-24 11.59.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('25-JUN-24 09.30.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),20,'Centro-Oeste');
Insert into C##PROYECTO_DW.H_EVENTOS (FECHA_HORA_FINAL,FECHA_HORA_INICIO,ID_EVENTO,ITR_NOMBRE) values (to_timestamp('27-JUN-24 08.59.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('26-JUN-24 06.59.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),22,'Centro-Oeste');
Insert into C##PROYECTO_DW.H_EVENTOS (FECHA_HORA_FINAL,FECHA_HORA_INICIO,ID_EVENTO,ITR_NOMBRE) values (to_timestamp('28-JUN-24 11.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('28-JUN-24 12.59.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),24,'Centro-Oeste');
Insert into C##PROYECTO_DW.H_EVENTOS (FECHA_HORA_FINAL,FECHA_HORA_INICIO,ID_EVENTO,ITR_NOMBRE) values (to_timestamp('29-JUN-24 06.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('29-JUN-24 09.30.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),8,'Este');
Insert into C##PROYECTO_DW.H_EVENTOS (FECHA_HORA_FINAL,FECHA_HORA_INICIO,ID_EVENTO,ITR_NOMBRE) values (to_timestamp('26-JUN-24 06.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('26-JUN-24 09.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),10,'Este');
Insert into C##PROYECTO_DW.H_EVENTOS (FECHA_HORA_FINAL,FECHA_HORA_INICIO,ID_EVENTO,ITR_NOMBRE) values (to_timestamp('28-JUN-24 06.00.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('24-JUN-24 09.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),12,'Online');
Insert into C##PROYECTO_DW.H_EVENTOS (FECHA_HORA_FINAL,FECHA_HORA_INICIO,ID_EVENTO,ITR_NOMBRE) values (to_timestamp('24-JUN-24 11.59.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('24-JUN-24 02.25.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),14,'Centro-Oeste');
Insert into C##PROYECTO_DW.H_EVENTOS (FECHA_HORA_FINAL,FECHA_HORA_INICIO,ID_EVENTO,ITR_NOMBRE) values (to_timestamp('24-JUN-24 04.15.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('24-JUN-24 09.30.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),16,'Centro-Oeste');
Insert into C##PROYECTO_DW.H_EVENTOS (FECHA_HORA_FINAL,FECHA_HORA_INICIO,ID_EVENTO,ITR_NOMBRE) values (to_timestamp('24-JUN-24 11.59.00.000000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('24-JUN-24 12.00.00.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),18,'Centro-Oeste');

Insert into C##PROYECTO_DW.ODS_EVENTOS (PK_ITR,PK_TIEMPO) values ('CENTRO-OESTE',20240625);
Insert into C##PROYECTO_DW.ODS_EVENTOS (PK_ITR,PK_TIEMPO) values ('CENTRO-OESTE',20240626);
Insert into C##PROYECTO_DW.ODS_EVENTOS (PK_ITR,PK_TIEMPO) values ('CENTRO-OESTE',20240628);
Insert into C##PROYECTO_DW.ODS_EVENTOS (PK_ITR,PK_TIEMPO) values ('ESTE',20240629);
Insert into C##PROYECTO_DW.ODS_EVENTOS (PK_ITR,PK_TIEMPO) values ('ESTE',20240626);
Insert into C##PROYECTO_DW.ODS_EVENTOS (PK_ITR,PK_TIEMPO) values ('ONLINE',20240624);
Insert into C##PROYECTO_DW.ODS_EVENTOS (PK_ITR,PK_TIEMPO) values ('CENTRO-OESTE',20240624);
Insert into C##PROYECTO_DW.ODS_EVENTOS (PK_ITR,PK_TIEMPO) values ('CENTRO-OESTE',20240624);
Insert into C##PROYECTO_DW.ODS_EVENTOS (PK_ITR,PK_TIEMPO) values ('CENTRO-OESTE',20240624);
Insert into C##PROYECTO_DW.ODS_EVENTOS (PK_ITR,PK_TIEMPO) values ('CENTRO-OESTE',20240626);
Insert into C##PROYECTO_DW.ODS_EVENTOS (PK_ITR,PK_TIEMPO) values ('CENTRO-OESTE',20240627);
Insert into C##PROYECTO_DW.ODS_EVENTOS (PK_ITR,PK_TIEMPO) values ('ONLINE',20240628);

Insert into C##PROYECTO_DW.ODS_ITR (PK_ITR) values ('CENTRO-SUR');
Insert into C##PROYECTO_DW.ODS_ITR (PK_ITR) values ('CENTRO-OESTE');
Insert into C##PROYECTO_DW.ODS_ITR (PK_ITR) values ('ESTE');
Insert into C##PROYECTO_DW.ODS_ITR (PK_ITR) values ('NORTE');
Insert into C##PROYECTO_DW.ODS_ITR (PK_ITR) values ('ONLINE');
Insert into C##PROYECTO_DW.ODS_ITR (PK_ITR) values ('SUROESTE');

Insert into C##PROYECTO_DW.ODS_TIEMPO (PK_TIEMPO) values (to_date('25-JUN-24','DD-MON-RR'));
Insert into C##PROYECTO_DW.ODS_TIEMPO (PK_TIEMPO) values (to_date('26-JUN-24','DD-MON-RR'));
Insert into C##PROYECTO_DW.ODS_TIEMPO (PK_TIEMPO) values (to_date('28-JUN-24','DD-MON-RR'));
Insert into C##PROYECTO_DW.ODS_TIEMPO (PK_TIEMPO) values (to_date('29-JUN-24','DD-MON-RR'));
Insert into C##PROYECTO_DW.ODS_TIEMPO (PK_TIEMPO) values (to_date('24-JUN-24','DD-MON-RR'));
Insert into C##PROYECTO_DW.ODS_TIEMPO (PK_TIEMPO) values (to_date('27-JUN-24','DD-MON-RR'));
--------------------------------------------------------
--  DDL for Index SYS_C0012360
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO_DW"."SYS_C0012360" ON "C##PROYECTO_DW"."DT_TIEMPO" ("SK_TIEMPO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012362
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO_DW"."SYS_C0012362" ON "C##PROYECTO_DW"."DT_ITR" ("SK_ITR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012367
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO_DW"."SYS_C0012367" ON "C##PROYECTO_DW"."HT_EVENTO" ("SK_EVENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012362
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO_DW"."SYS_C0012362" ON "C##PROYECTO_DW"."DT_ITR" ("SK_ITR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012360
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO_DW"."SYS_C0012360" ON "C##PROYECTO_DW"."DT_TIEMPO" ("SK_TIEMPO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012367
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##PROYECTO_DW"."SYS_C0012367" ON "C##PROYECTO_DW"."HT_EVENTO" ("SK_EVENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Procedure P_DDL_DT_ITR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_DDL_DT_ITR" 
IS
  v_sql clob;
  d_sql clob;
  table_exists EXCEPTION;
  PRAGMA EXCEPTION_INIT(table_exists, -955);
begin
  v_sql := '
    CREATE TABLE DT_ITR
    (
        SK_ITR INTEGER GENERATED ALWAYS AS IDENTITY START WITH 1 NOT NULL PRIMARY KEY,
        PK_ITR VARCHAR2(100)
    )
    '
    ;

  execute immediate v_sql;
exception
  when table_exists then -- ora-00955 exception: tabla ya existente
      d_sql := 'drop table DT_ITR cascade constraints';
      execute immediate d_sql; -- eliminar el objeto para nueva extracción
      execute immediate v_sql; -- extraer
end; 

/
--------------------------------------------------------
--  DDL for Procedure P_DDL_DT_TIEMPO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_DDL_DT_TIEMPO" 
IS
  v_sql clob;
  d_sql clob;
  table_exists EXCEPTION;
  PRAGMA EXCEPTION_INIT(table_exists, -955);
begin
  v_sql := '
    CREATE TABLE DT_TIEMPO
    (
        SK_TIEMPO INTEGER GENERATED ALWAYS AS IDENTITY START WITH 1 NOT NULL PRIMARY KEY,
        PK_TIEMPO INTEGER,
        ANIO INTEGER, 
        MES INTEGER,
        SEMESTRE INTEGER
    )
    '
    ;

  execute immediate v_sql;
exception
  when table_exists then -- ora-00955 exception: tabla ya existente
      d_sql := 'drop table DT_TIEMPO cascade constraints';
      execute immediate d_sql; -- eliminar el objeto para nueva carga
      execute immediate v_sql; -- crear
end; 

/
--------------------------------------------------------
--  DDL for Procedure P_DDL_HT_EVENTO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_DDL_HT_EVENTO" 
IS
  v_sql clob;
  d_sql clob;
  table_exists EXCEPTION;
  PRAGMA EXCEPTION_INIT(table_exists, -955);
begin
  v_sql := '
    CREATE TABLE HT_EVENTO
    (
        SK_EVENTO INTEGER GENERATED ALWAYS AS IDENTITY START WITH 1 NOT NULL PRIMARY KEY,
        SK_ITR INTEGER NOT NULL,
        SK_TIEMPO INTEGER NOT NULL,
        CANT_EVENTOS INTEGER NOT NULL,

        FOREIGN KEY (SK_ITR) REFERENCES DT_ITR(SK_ITR),
        FOREIGN KEY (SK_TIEMPO) REFERENCES DT_TIEMPO(SK_TIEMPO)
    )
    '
    ;

  execute immediate v_sql;
exception
  when table_exists then -- ora-00955 exception: tabla ya existente
      d_sql := 'drop table HT_EVENTO';
      execute immediate d_sql; -- eliminar el objeto para nueva extracción
      execute immediate v_sql; -- extraer
end; 

/
--------------------------------------------------------
--  DDL for Procedure P_DDL_ODS_EVENTOS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_DDL_ODS_EVENTOS" 
IS
  v_sql clob;
  d_sql clob;
  table_exists EXCEPTION;
  PRAGMA EXCEPTION_INIT(table_exists, -955);
begin
  v_sql := '
    CREATE TABLE ODS_EVENTOS
    (
        PK_ITR VARCHAR2(100),
        PK_TIEMPO INTEGER 
    )
    '
    ;

  execute immediate v_sql;
exception
  when table_exists then -- ora-00955 exception: tabla ya existente
      d_sql := 'drop table ODS_EVENTOS';
      execute immediate d_sql; -- eliminar el objeto para nueva extracción
      execute immediate v_sql; -- extraer
end; 

/
--------------------------------------------------------
--  DDL for Procedure P_DDL_ODS_ITR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_DDL_ODS_ITR" 
IS
  v_sql clob;
  d_sql clob;
  table_exists EXCEPTION;
  PRAGMA EXCEPTION_INIT(table_exists, -955);
begin
  v_sql := '
    CREATE TABLE ODS_ITR
    (
        PK_ITR VARCHAR2(100)
    )
    '
    ;

  execute immediate v_sql;
exception
  when table_exists then -- ora-00955 exception: tabla ya existente
      d_sql := 'drop table ODS_ITR';
      execute immediate d_sql; -- eliminar el objeto para nueva extracción
      execute immediate v_sql; -- extraer
end; 

/
--------------------------------------------------------
--  DDL for Procedure P_DDL_ODS_TIEMPO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_DDL_ODS_TIEMPO" 
IS
  v_sql clob;
  d_sql clob;
  table_exists EXCEPTION;
  PRAGMA EXCEPTION_INIT(table_exists, -955);
begin
  v_sql := '
    CREATE TABLE ODS_TIEMPO
    (
        PK_TIEMPO DATE 
    )
    '
    ;

  execute immediate v_sql;
exception
  when table_exists then -- ora-00955 exception: tabla ya existente
      d_sql := 'drop table ODS_TIEMPO';
      execute immediate d_sql; -- eliminar el objeto para nueva extracción
      execute immediate v_sql; -- extraer
end; 

/
--------------------------------------------------------
--  DDL for Procedure P_DWH_DT_ITR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_DWH_DT_ITR" 
IS
BEGIN
  -- Los ITR no son muchos por definicion por lo que no es una operacion costosa el volverlos a cargar
  DELETE FROM DT_ITR;

  -- Cargar datos desde ODS_ITR
  INSERT INTO DT_ITR(
    -- Por DDL, la sk es identidad autogenerada.
    PK_ITR
  )
  SELECT
    PK_ITR
  FROM ODS_ITR;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transform process completed successfully.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('An error occurred during the transform process: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Procedure P_DWH_DT_TIEMPO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_DWH_DT_TIEMPO" 
IS
BEGIN
    INSERT INTO DT_TIEMPO(
        PK_TIEMPO,
        ANIO,
        MES,
        SEMESTRE
    )
    SELECT
        TO_NUMBER(TO_CHAR(PK_TIEMPO, 'yyyymmdd')),
        TO_CHAR(PK_TIEMPO, 'yyyy'),
        TO_CHAR(PK_TIEMPO, 'mm'),
        CASE WHEN(TO_NUMBER(TO_CHAR(PK_TIEMPO, 'mm')) < 7) THEN 1 ELSE 2 END
    FROM ODS_TIEMPO
    ;

    COMMIT;
END P_DWH_DT_TIEMPO;

/
--------------------------------------------------------
--  DDL for Procedure P_DWH_HT_EVENTO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_DWH_HT_EVENTO" 
IS
BEGIN
    INSERT INTO HT_EVENTO(
        SK_TIEMPO,
        SK_ITR,
        CANT_EVENTOS
    )
    SELECT
        t.SK_TIEMPO,
        i.SK_ITR,
        COUNT(1)
    FROM
        ODS_EVENTOS e
    LEFT OUTER JOIN DT_TIEMPO t ON t.PK_TIEMPO = e.PK_TIEMPO
    LEFT OUTER JOIN DT_ITR i ON i.PK_ITR = e.PK_ITR
    GROUP BY t.SK_TIEMPO, i.SK_ITR
    ;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('FACT process completed successfully.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('An error occurred during the FACT process: ' || SQLERRM);
END P_DWH_HT_EVENTO;

/
--------------------------------------------------------
--  DDL for Procedure P_D_ITR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_D_ITR" 
IS
  v_sql clob;
  d_sql clob;
  table_exists EXCEPTION;
  PRAGMA EXCEPTION_INIT(table_exists, -955);
begin
  v_sql := '
    create table d_itr as
    select 
        nombre 
    from c##proyecto.itr
    '
    ;

  execute immediate v_sql;
exception
  when table_exists then -- ora-00955 exception: tabla ya existente
      d_sql := 'drop table d_itr';
      execute immediate d_sql; -- eliminar el objeto para nueva extracción
      execute immediate v_sql; -- extraer
end; 

/
--------------------------------------------------------
--  DDL for Procedure P_D_TIEMPO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_D_TIEMPO" 
IS
  v_sql clob;
  d_sql clob;
  table_exists EXCEPTION;
  PRAGMA EXCEPTION_INIT(table_exists, -955);
begin
  v_sql := '
    create table d_tiempo as
    select 
        fecha_hora_inicio,
        fecha_hora_final
    from c##proyecto.eventos
    where fecha_hora_final is not null -- La fecha_hora de finalizacion puede ser null por definicion. Agregaria mugre estos eventos no finalizados.
    and fecha_hora_inicio between trunc(current_date, ''mm'') and last_day(current_date)
    or  fecha_hora_final between trunc(current_date, ''mm'') and last_day(current_date) -- carga de datos mensuales
    '
    ;

  execute immediate v_sql;
exception
  when table_exists then -- ora-00955 exception: tabla ya existente
      d_sql := 'drop table d_tiempo';
      execute immediate d_sql; -- eliminar el objeto para nueva extracción
      execute immediate v_sql; -- extraer
end; 

/
--------------------------------------------------------
--  DDL for Procedure P_H_EVENTOS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_H_EVENTOS" 
IS
  v_sql clob;
  d_sql clob;
  table_exists EXCEPTION;
  PRAGMA EXCEPTION_INIT(table_exists, -955);
begin
  v_sql := '
    create table h_eventos as
    select
        e.fecha_hora_final,
        e.fecha_hora_inicio,
        e.id_evento,
        i.nombre itr_nombre
    from c##proyecto.eventos e
    join c##proyecto.itr i on e.id_itr = i.id_itr
    where e.fecha_hora_final is not null -- La fecha_hora de finalizacion puede ser null por definicion. Agregaria mugre estos eventos no finalizados.
    and e.fecha_hora_inicio between trunc(current_date, ''mm'') and last_day(current_date)
    or e.fecha_hora_final between trunc(current_date, ''mm'') and last_day(current_date) -- carga de datos mensuales
    '
    ;

  execute immediate v_sql;
exception
  when table_exists then -- ora-00955 exception: tabla ya existente
      d_sql := 'drop table h_eventos';
      execute immediate d_sql; -- eliminar el objeto para nueva extracción
      execute immediate v_sql; -- extraer
end; 

/
--------------------------------------------------------
--  DDL for Procedure P_ODS_D_ITR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_ODS_D_ITR" 
IS
BEGIN

  -- Dejar ODS_ITR vacío
  DELETE FROM ODS_ITR;

  -- Cargar datos desde D_ITR
  INSERT INTO ODS_ITR(
    pk_itr
  )
  SELECT
    DISTINCT(nombre)
  FROM D_ITR;

  -- Transformar
  -- Eliminamos los caracteres no alfanumericos que esten al final del string, lo pasamos a mayusculas, eliminamos espacios laterales, convertimos vocales con ácentos a sin acentos y convertimos espacios entre palabras a guiones.
  UPDATE ODS_ITR
  SET pk_itr = REPLACE(TRANSLATE(TRIM(UPPER(REGEXP_REPLACE(pk_itr, '[^a-zA-Z0-9]$', ''))), 'ÁÉÍÓÚáéíóú', 'AEIOU'), ' ', '-');

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transform process completed successfully.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('An error occurred during the transform process: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Procedure P_ODS_D_TIEMPO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_ODS_D_TIEMPO" 
IS
BEGIN

  -- Dejar ODS_TIEMPO vacío
  DELETE FROM ODS_TIEMPO;

  -- Cargar datos desde D_TIEMPO
   -- Conseguir todas las fechas utilizadas (tanto en inicio del evento como en el final)
  INSERT INTO ODS_TIEMPO(
    pk_tiempo
  )
  SELECT
    DISTINCT(fecha_hora_inicio)
  FROM D_TIEMPO;
  INSERT INTO ODS_TIEMPO(
    pk_tiempo
  )
  SELECT
    DISTINCT(fecha_hora_final)
  FROM D_TIEMPO;

  -- Remover duplicados
  DELETE FROM ODS_TIEMPO
  WHERE rowid not in
  (SELECT MIN(rowid)
  FROM ODS_TIEMPO
  GROUP BY TO_NUMBER(TO_CHAR(PK_TIEMPO, 'yyyymmdd')));

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transform process completed successfully.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('An error occurred during the transform process: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  DDL for Procedure P_ODS_H_EVENTOS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "C##PROYECTO_DW"."P_ODS_H_EVENTOS" 
IS
BEGIN

  -- Dejar ODS_EVENTOS vacío
  DELETE FROM ODS_EVENTOS;

  -- Cargar datos desde H_EVENTOS
  INSERT INTO ODS_EVENTOS(
    pk_itr,
    pk_tiempo
  )
  SELECT
    REPLACE(TRANSLATE(TRIM(UPPER(REGEXP_REPLACE(itr_nombre, '[^a-zA-Z0-9]$', ''))), 'ÁÉÍÓÚáéíóú', 'AEIOU'), ' ', '-'), -- Aplicamos mismas transformaciones para luego poder joinear
    TO_NUMBER(TO_CHAR(fecha_hora_inicio, 'yyyymmdd'))
  FROM H_EVENTOS
  ;

  INSERT INTO ODS_EVENTOS(
    pk_itr,
    pk_tiempo
  )
  SELECT
    REPLACE(TRANSLATE(TRIM(UPPER(REGEXP_REPLACE(itr_nombre, '[^a-zA-Z0-9]$', ''))), 'ÁÉÍÓÚáéíóú', 'AEIOU'), ' ', '-'), -- Aplicamos mismas transformaciones para luego poder joinear
    TO_NUMBER(TO_CHAR(fecha_hora_final, 'yyyymmdd'))
  FROM H_EVENTOS
  WHERE TO_CHAR(fecha_hora_inicio, 'ddmmyyyy') != TO_CHAR(fecha_hora_final, 'ddmmyyyy')
  ;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transform process completed successfully.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('An error occurred during the transform process: ' || SQLERRM);
END;

/
--------------------------------------------------------
--  Constraints for Table DT_ITR
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO_DW"."DT_ITR" MODIFY ("SK_ITR" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO_DW"."DT_ITR" ADD PRIMARY KEY ("SK_ITR")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table DT_TIEMPO
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO_DW"."DT_TIEMPO" MODIFY ("SK_TIEMPO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO_DW"."DT_TIEMPO" ADD PRIMARY KEY ("SK_TIEMPO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table D_ITR
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO_DW"."D_ITR" MODIFY ("NOMBRE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table D_TIEMPO
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO_DW"."D_TIEMPO" MODIFY ("FECHA_HORA_INICIO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO_DW"."D_TIEMPO" MODIFY ("FECHA_HORA_FINAL" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HT_EVENTO
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO_DW"."HT_EVENTO" MODIFY ("SK_EVENTO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO_DW"."HT_EVENTO" MODIFY ("SK_ITR" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO_DW"."HT_EVENTO" MODIFY ("SK_TIEMPO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO_DW"."HT_EVENTO" MODIFY ("CANT_EVENTOS" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO_DW"."HT_EVENTO" ADD PRIMARY KEY ("SK_EVENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table H_EVENTOS
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO_DW"."H_EVENTOS" MODIFY ("FECHA_HORA_FINAL" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO_DW"."H_EVENTOS" MODIFY ("FECHA_HORA_INICIO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO_DW"."H_EVENTOS" MODIFY ("ID_EVENTO" NOT NULL ENABLE);
  ALTER TABLE "C##PROYECTO_DW"."H_EVENTOS" MODIFY ("ITR_NOMBRE" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table HT_EVENTO
--------------------------------------------------------

  ALTER TABLE "C##PROYECTO_DW"."HT_EVENTO" ADD FOREIGN KEY ("SK_ITR")
	  REFERENCES "C##PROYECTO_DW"."DT_ITR" ("SK_ITR") ENABLE;
  ALTER TABLE "C##PROYECTO_DW"."HT_EVENTO" ADD FOREIGN KEY ("SK_TIEMPO")
	  REFERENCES "C##PROYECTO_DW"."DT_TIEMPO" ("SK_TIEMPO") ENABLE;
