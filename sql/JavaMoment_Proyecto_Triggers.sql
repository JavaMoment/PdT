CREATE OR REPLACE TRIGGER set_usr_activo_default
BEFORE INSERT ON USUARIOS
FOR EACH ROW
BEGIN
  :NEW.activo := 1; -- Settea el valor de la columna 'activo' (1 para activo, 0 para inactivo)
END;
/

CREATE OR REPLACE TRIGGER set_depa_id_trigger
BEFORE INSERT ON DEPARTAMENTOS
FOR EACH ROW
BEGIN
  :NEW.id_departamento := depa_id_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER set_locali_id_trigger
BEFORE INSERT ON LOCALIDADES
FOR EACH ROW
BEGIN
  :NEW.id_localidad := locali_id_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER set_itr_id_trigger
BEFORE INSERT ON ITR
FOR EACH ROW
BEGIN
  :NEW.id_itr := itr_id_seq.NEXTVAL;
END;
/