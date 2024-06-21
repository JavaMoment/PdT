package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.DtItr;

/**
 * Session Bean implementation class HtEventoBean
 */
@Stateless
public class DtItrBean extends CRUDBean<DtItr, Long> implements DtItrBeanRemote {

    /**
     * Default constructor. 
     */
    public DtItrBean() {
    }

	@Override
	public DtItr getDtItrBy(String pkItr) {
		// TODO Auto-generated method stub
		try {
			return (DtItr) super.getEntityManager()
					.createQuery("SELECT i FROM DtItr i WHERE i.pkItr = :pkItr")
					.setParameter("pkItr", pkItr)
					.getSingleResult();
		} catch(PersistenceException e) {
			return null;
		}
	}
}
