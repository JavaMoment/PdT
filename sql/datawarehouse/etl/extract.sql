create or replace procedure P_H_EVENTOS
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

create or replace procedure P_D_ITR
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

create or replace procedure P_D_TIEMPO
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
    or  fecha_hora_final between trunc(current_date, ''mm'') and last_day(current_dat) -- carga de datos mensuales
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