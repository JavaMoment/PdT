CONN c##proyecto_dw/proyecto@localhost:1521/xe

-- DDL para las tablas utilizadas durante el proyecto D|H_*, ODS_*, DT|HT_*
@ETL_DDL.sql

EXEC P_DDL_ODS_EVENTOS;
EXEC P_DDL_ODS_ITR;
EXEC P_DDL_ODS_TIEMPO;
EXEC P_DDL_DT_TIEMPO;
EXEC P_DDL_DT_ITR;
EXEC P_DDL_HT_EVENTO;

-- Crear los objetos procedimiento para ejecutar el proceso
@./etl/extract.sql
@./etl/transform.sql
@./etl/load.sql

-- Extración de datos
EXEC P_H_EVENTOS;
EXEC P_D_ITR;
EXEC P_D_TIEMPO;

-- Transformación de datos
EXEC P_ODS_D_ITR;
EXEC P_ODS_H_EVENTOS;
EXEC P_ODS_D_TIEMPO;

-- Carga al DW
EXEC P_DWH_DT_ITR;
EXEC P_DWH_DT_TIEMPO;
EXEC P_DWH_HT_EVENTO;