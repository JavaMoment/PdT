package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.entities.ReclamosCountByEstudiante;
import com.models.ReclamosCount;

@Stateless
public class ReclamoCountBean extends CRUDBean<ReclamosCountByEstudiante, Long> implements ReclamoCountBeanRemote {

	public ReclamoCountBean() {
    }

	@Override
	public List<ReclamosCount> getReclamoCountBy(Long idEstudiante, String mes, String anio) {
		try {
    		TypedQuery<ReclamosCount> query =  (TypedQuery<ReclamosCount>) super.getEntityManager()
    				.createQuery(
    						"SELECT NEW com.models.ReclamosCount(rc.fechaCreacion, SUM(rc.cantReclamos)) FROM ReclamosCountByEstudiante rc WHERE rc.idEstudiante = :idEstudiante AND rc.mes = :mes AND rc.anio = :anio GROUP BY rc.fechaCreacion ORDER BY rc.fechaCreacion DESC",
    						ReclamosCount.class
    						)
    				.setParameter("idEstudiante", idEstudiante)
    				.setParameter("mes", mes)
    				.setParameter("anio", anio);
    		return (List<ReclamosCount>) query.getResultList();
    	} catch (Exception e) {
    		return null;
    	}
	}
	
	@Override
	public List<String> getAvailableYears() {
		try {
    		TypedQuery<String> query = (TypedQuery<String>) super.getEntityManager()
    				.createQuery(
    						"SELECT DISTINCT rc.anio FROM ReclamosCountByEstudiante rc ORDER BY rc.anio DESC",
    						String.class
    						);
    		return query.getResultList();
    	} catch (Exception e) {
    		return null;
    	}
	}
	
	@Override
	public List<String> getAvailableMonths() {
		try {
    		TypedQuery<String> query = (TypedQuery<String>) super.getEntityManager()
    				.createQuery(
    						"SELECT DISTINCT rc.mes FROM ReclamosCountByEstudiante rc ORDER BY rc.mes DESC",
    						String.class
    						);
    		return query.getResultList();
    	} catch (Exception e) {
    		return null;
    	}
	}
}
