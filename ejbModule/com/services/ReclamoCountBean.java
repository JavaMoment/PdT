package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.entities.ReclamosCountByEstudiante;

@Stateless
public class ReclamoCountBean extends CRUDBean<ReclamosCountByEstudiante, Long> implements ReclamoCountBeanRemote {

	public ReclamoCountBean() {
    }

	@Override
	public List<ReclamosCountByEstudiante> getReclamoCountBy(Long idEstudiante, String mes, String anio) {
		try {
    		TypedQuery<ReclamosCountByEstudiante> query = (TypedQuery<ReclamosCountByEstudiante>) super.getEntityManager()
    				.createQuery(
    						"SELECT rc FROM ReclamosCountByEstudiante rc WHERE rc.idEstudiante = :idEstudiante AND rc.mes = :mes AND rc.anio = :anio",
    						ReclamosCountByEstudiante.class
    						)
    				.setParameter("idEstudiante", idEstudiante)
    				.setParameter("mes", mes)
    				.setParameter("anio", anio);
    		return query.getResultList();
    	} catch (Exception e) {
    		return null;
    	}
	}
}
