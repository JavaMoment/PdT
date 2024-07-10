package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.HtEvento;
import com.models.SemestreCount;

/**
 * Session Bean implementation class HtEventoBean
 */
@Stateless
public class HtEventoBean extends CRUDBean<HtEvento, Long> implements HtEventoBeanRemote {

    /**
     * Default constructor. 
     */
    public HtEventoBean() {
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<HtEvento> getHtEventosBy(Long skItr, Integer anio) {
		// TODO Auto-generated method stub
		try {
			return (List<HtEvento>) super.getEntityManager()
				.createQuery("SELECT e FROM HtEvento e JOIN e.dtItr JOIN e.dtTiempo WHERE e.dtItr.skItr = :skItr AND e.dtTiempo.anio = :anio ORDER BY e.dtTiempo.pkTiempo ASC", HtEvento.class)
				.setParameter("skItr", skItr)
				.setParameter("anio", anio)
				.getResultList();
		} catch(PersistenceException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SemestreCount> getSemestreCount(Long skItr, Integer anio) {
		try {
			return (List<SemestreCount>) super.getEntityManager()
					.createQuery("SELECT NEW com.models.SemestreCount(e.dtTiempo.semestre, SUM(e.cantEventos)) FROM HtEvento e JOIN e.dtTiempo WHERE e.dtItr.skItr = :skItr AND e.dtTiempo.anio = :anio GROUP BY e.dtTiempo.semestre", SemestreCount.class)
					.setParameter("skItr", skItr)
					.setParameter("anio", anio)
					.getResultList();
		} catch(PersistenceException e) {
			return null;
		}
	}
}
