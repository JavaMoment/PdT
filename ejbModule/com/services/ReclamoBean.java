package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Reclamo;

/**
 * Session Bean implementation class ReclamoBean
 */
@Stateless
public class ReclamoBean extends CRUDBean<Reclamo, Long> implements ReclamoBeanRemote {

    /**
     * Default constructor. 
     */
    public ReclamoBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public List<Reclamo> selectAllBy(String nombreUsuario) {
    	try {
    		TypedQuery<Reclamo> query = (TypedQuery<Reclamo>) super.getEntityManager()
    				.createQuery("SELECT r FROM Reclamo r WHERE r.estudiante.usuario.nombreUsuario = :nombreUsuario", Reclamo.class)
    				.setParameter("nombreUsuario", nombreUsuario);
    		return query.getResultList();
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    public Reclamo insert(Reclamo newReclamo) {
    	try {
			getEntityManager().persist(newReclamo);
			getEntityManager().flush();
			return newReclamo;
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
}
