create or replace PROCEDURE P_DWH_DT_ITR
IS
BEGIN

  -- Dejar DT_ITR vacío
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

CREATE OR REPLACE PROCEDURE P_DWH_DT_TIEMPO
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

CREATE OR REPLACE PROCEDURE P_DWH_HT_EVENTO
IS
BEGIN
    DELETE FROM HT_EVENTO;
    
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