package com.services;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Area;

/**
 * Session Bean implementation class AreaBean
 */
@Stateless
public class AreaBean extends CRUDBean<Area, Long> implements AreaBeanRemote {

    /**
     * Default constructor. 
     */
    public AreaBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public Area selectBy(String name) {
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Area> query = (TypedQuery<Area>) super.getEntityManager()
					.createQuery("SELECT a FROM Area a WHERE a.nombre =: name ORDER BY a.idArea", Area.class)
					.setParameter("name", name);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

}
