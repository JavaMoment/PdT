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
    public List<Reclamo> selectAllBy(String nombreUsuario, String searchText) {
    	try {
    		TypedQuery<Reclamo> query = (TypedQuery<Reclamo>) super.getEntityManager()
    				.createQuery("SELECT r FROM Reclamo r WHERE r.estudiante.usuario.nombreUsuario = :nombreUsuario AND r.titulo LIKE :title", Reclamo.class)
    				.setParameter("nombreUsuario", nombreUsuario)
    				.setParameter("title", "%" + searchText + "%");
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
    
    @Override
    public List<Reclamo> getReclamosBy(String keyword) {
    	try {
    		TypedQuery<Reclamo> query = (TypedQuery<Reclamo>) super.getEntityManager()
    				.createQuery("SELECT r FROM Reclamo r WHERE r.titulo LIKE :title OR r.estudiante.usuario.nombreUsuario LIKE :username", Reclamo.class)
    				.setParameter("title", "%" + keyword + "%")
    				.setParameter("username", "%" + keyword + "%");
    		return query.getResultList();
    	} catch (Exception e) {
    		return null;
    	}
    }
}
