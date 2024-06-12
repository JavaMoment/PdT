create or replace view
    reclamos_count_by_estudiante
as
select
    t.*,
    to_char(t.fecha_creacion, 'mm') mes,
    to_char(t.fecha_creacion, 'yyyy') anio
from(
    select
        id_estudiante,
        audit_date fecha_creacion,
        count(1) cant_reclamos
    from
        reclamos
    group by
        id_estudiante, audit_date
) t
;
/