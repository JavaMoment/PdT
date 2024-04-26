package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.TiposTutor;

/**
 * Session Bean implementation class StatusCertificadosBean
 */
@Stateless
public class TiposTutorBean extends CRUDBean<TiposTutor, Long> implements TiposTutorBeanRemote{

    /**
     * Default constructor. 
     */
    public TiposTutorBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public TiposTutor selectBy(String name) {
		try {
    		@SuppressWarnings("unchecked")
			TypedQuery<TiposTutor> query = (TypedQuery<TiposTutor>) super.getEntityManager()
					.createQuery("SELECT tt FROM TiposTutor tt WHERE tt.nombre =:name ORDER BY tt.idTipoTutor", TiposTutor.class)
					.setParameter("name", name);
			return query.getSingleResult();
    	} catch(PersistenceException e) {
    		return null;
    	}
	}
}
