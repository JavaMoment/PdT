package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

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
}
