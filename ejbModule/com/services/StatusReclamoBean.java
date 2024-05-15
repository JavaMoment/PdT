package com.services;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.StatusReclamo;

/**
 * Session Bean implementation class StatusCertificadosBean
 */
@Stateless
public class StatusReclamoBean extends CRUDBean<StatusReclamo, Long> implements StatusReclamoBeanRemote{

    /**
     * Default constructor. 
     */
    public StatusReclamoBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public StatusReclamo selectBy(String name) {
    	try {
			@SuppressWarnings("unchecked")
			TypedQuery<StatusReclamo> query = (TypedQuery<StatusReclamo>) super.getEntityManager()
					.createQuery("SELECT sr FROM StatusReclamo sr WHERE sr.nombre=:name")
					.setParameter("name", name);
			return query.getSingleResult();
		} catch(PersistenceException e) {
			return null;
		}
    }
}
