package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Itr;

/**
 * Session Bean implementation class ItrBean
 */
@Stateless
public class ItrBean extends CRUDBean<Itr, Long> implements ItrBeanRemote {

    /**
     * Default constructor. 
     */
    public ItrBean() {
        // TODO Auto-generated constructor stub
    }
    
    public List<String> selectAllNames() {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<String> query = (TypedQuery<String>) super.getEntityManager()
					.createQuery("SELECT i.nombre FROM Itr i ORDER BY i.idItr", String.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			return null;
		}
	}
}
