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

CREATE OR REPLACE TRIGGER set_anali_id_trigger
BEFORE INSERT ON ANALISTAS
FOR EACH ROW
BEGIN
  :NEW.id_analista := analistas_id_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER set_areas_id_trigger
BEFORE INSERT ON AREAS
FOR EACH ROW
BEGIN
  :NEW.id_area := areas_id_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER set_const_id_trigger
BEFORE INSERT ON CONSTANCIAS
FOR EACH ROW
BEGIN
  :NEW.id_constancia := constancias_id_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER set_estud_id_trigger
BEFORE INSERT ON ESTUDIANTES
FOR EACH ROW
BEGIN
  :NEW.id_estudiante := estud_id_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER set_eventos_id_trigger
BEFORE INSERT ON EVENTOS
FOR EACH ROW
BEGIN
  :NEW.id_evento := event_id_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER set_justi_id_trigger
BEFORE INSERT ON JUSTIFICACIONES
FOR EACH ROW
BEGIN
  :NEW.id_justificacion := justi_id_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER set_recl_id_trigger
BEFORE INSERT ON RECLAMOS
FOR EACH ROW
BEGIN
  :NEW.id_reclamo := recl_id_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER set_stat_cert_id_trigger
BEFORE INSERT ON STATUS_CERTIFICADOS
FOR EACH ROW
BEGIN
  :NEW.id_status := stat_cert_id_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER set_tutores_id_trigger
BEFORE INSERT ON TUTORES
FOR EACH ROW
BEGIN
  :NEW.id_tutor := tutores_id_seq.NEXTVAL;
END;
/

COMMIT;