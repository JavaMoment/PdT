create or replace procedure P_DDL_DT_TIEMPO
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

create or replace procedure P_DDL_DT_ITR
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

create or replace procedure P_DDL_HT_EVENTO
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

create or replace procedure P_DDL_ODS_ITR
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

create or replace procedure P_DDL_ODS_EVENTOS
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

create or replace procedure P_DDL_ODS_TIEMPO
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
