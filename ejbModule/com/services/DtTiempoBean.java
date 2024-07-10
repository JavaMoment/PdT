package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.DtTiempo;

/**
 * Session Bean implementation class HtEventoBean
 */
@Stateless
public class DtTiempoBean extends CRUDBean<DtTiempo, Long> implements DtTiempoBeanRemote {

    /**
     * Default constructor. 
     */
    public DtTiempoBean() {
    }

	@Override
	public List<Integer> getAvailableYears() {
		try {
			TypedQuery<Integer> query = (TypedQuery<Integer>) super.getEntityManager()
					.createQuery("SELECT DISTINCT t.anio FROM DtTiempo t ORDER BY t.anio DESC");
			return query.getResultList();
		} catch(PersistenceException e) {
			return null;
		}
	}

}
