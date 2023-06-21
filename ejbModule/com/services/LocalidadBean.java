package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Departamento;
import com.entities.Localidad;

/**
 * Session Bean implementation class LocalidadBean
 */
@Stateless
public class LocalidadBean extends CRUDBean<Localidad, Long> implements LocalidadBeanRemote {

    /**
     * Default constructor. 
     */
    public LocalidadBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public List<Localidad> selectAll() {
    	try {
			@SuppressWarnings("unchecked")
			TypedQuery<Localidad> query = (TypedQuery<Localidad>) super.getEntityManager()
					.createQuery("SELECT l FROM Localidad l ORDER BY l.idLocalidad", Localidad.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			return null;
		}
    }

    @Override
    public List<String> selectAllNames() {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<String> query = (TypedQuery<String>) super.getEntityManager()
					.createQuery("SELECT l.nombre FROM Localidad l ORDER BY l.idLocalidad", String.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			return null;
		}
	}
    
    @Override
    public List<String> selectAllNamesBy(long idDepa) {
    	try {
    		@SuppressWarnings("unchecked")
			TypedQuery<String> query = (TypedQuery<String>) super.getEntityManager()
					.createQuery("SELECT l.nombre FROM Localidad l WHERE l.departamento.idDepartamento=:idDepa ORDER BY l.idLocalidad", String.class)
					.setParameter("idDepa", idDepa);
			return query.getResultList();
    	} catch(PersistenceException e) {
    		return null;
    	}
    }

	@Override
	public List<Localidad> selectAllBy(long idDepa) {
		try {
    		@SuppressWarnings("unchecked")
			TypedQuery<Localidad> query = (TypedQuery<Localidad>) super.getEntityManager()
					.createQuery("SELECT l FROM Localidad l WHERE l.departamento.idDepartamento=:idDepa ORDER BY l.idLocalidad", Localidad.class)
					.setParameter("idDepa", idDepa);
			return query.getResultList();
    	} catch(PersistenceException e) {
    		return null;
    	}
	}
}
