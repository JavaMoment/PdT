create or replace PROCEDURE P_ODS_D_ITR
IS
BEGIN

  -- Dejar ODS_ITR vacÌo
  DELETE FROM ODS_ITR;

  -- Cargar datos desde D_ITR
  INSERT INTO ODS_ITR(
    pk_itr
  )
  SELECT
    DISTINCT(nombre)
  FROM D_ITR;

  -- Transformar
  -- Eliminamos los caracteres no alfanumericos que esten al final del string, lo pasamos a mayusculas, eliminamos espacios laterales, convertimos vocales con ·centos a sin acentos y convertimos espacios entre palabras a guiones.
  UPDATE ODS_ITR
  SET pk_itr = REPLACE(TRANSLATE(TRIM(UPPER(REGEXP_REPLACE(pk_itr, '[^a-zA-Z0-9]$', ''))), '¡…Õ”⁄·ÈÌÛ˙', 'AEIOU'), ' ', '-');

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transform process completed successfully.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('An error occurred during the transform process: ' || SQLERRM);
END;
/

create or replace PROCEDURE P_ODS_D_TIEMPO
IS
BEGIN

  -- Dejar ODS_TIEMPO vacÌo
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

create or replace PROCEDURE P_ODS_H_EVENTOS
IS
BEGIN

  -- Dejar ODS_EVENTOS vacÌo
  DELETE FROM ODS_EVENTOS;

  -- Cargar datos desde H_EVENTOS
  INSERT INTO ODS_EVENTOS(
    pk_itr,
    pk_tiempo
  )
  SELECT
    REPLACE(TRANSLATE(TRIM(UPPER(REGEXP_REPLACE(itr_nombre, '[^a-zA-Z0-9]$', ''))), '¡…Õ”⁄·ÈÌÛ˙', 'AEIOU'), ' ', '-'), -- Aplicamos mismas transformaciones para luego poder joinear
    TO_NUMBER(TO_CHAR(fecha_hora_inicio, 'yyyymmdd'))
  FROM H_EVENTOS;
  
  INSERT INTO ODS_EVENTOS(
    pk_itr,
    pk_tiempo
  )
  SELECT
    REPLACE(TRANSLATE(TRIM(UPPER(REGEXP_REPLACE(itr_nombre, '[^a-zA-Z0-9]$', ''))), '¡…Õ”⁄·ÈÌÛ˙', 'AEIOU'), ' ', '-'), -- Aplicamos mismas transformaciones para luego poder joinear
    TO_NUMBER(TO_CHAR(fecha_hora_final, 'yyyymmdd'))
  FROM H_EVENTOS;
  
  -- Remover duplicados
  DELETE FROM ODS_EVENTOS
  WHERE rowid not in
  (SELECT MIN(rowid)
  FROM ODS_EVENTOS
  GROUP BY PK_ITR, PK_TIEMPO);

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transform process completed successfully.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('An error occurred during the transform process: ' || SQLERRM);
END;
/
