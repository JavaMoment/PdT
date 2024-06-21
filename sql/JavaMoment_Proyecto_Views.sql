create or replace view
    reclamos_count_by_estudiante
as
select
    t.*,
    to_char(to_date(t.fecha_creacion, 'yyyymmdd'), 'mm') mes,
    to_char(to_date(t.fecha_creacion, 'yyyymmdd'), 'yyyy') anio
from(
    select
        id_estudiante,
        to_char(audit_date, 'yyyymmdd') fecha_creacion,
        count(1) cant_reclamos
    from
        reclamos
    group by
        id_estudiante, to_char(audit_date, 'yyyymmdd')
) t
;
/