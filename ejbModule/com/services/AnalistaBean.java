package com.services;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Analista;
import com.entities.Estudiante;

/**
 * Session Bean implementation class AnalistaBean
 */
@Stateless
public class AnalistaBean extends CRUDBean<Analista, Long> implements AnalistaBeanRemote {

    /**
     * Default constructor. 
     */
    public AnalistaBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public Analista selectUserBy(String username) {
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Analista> query = (TypedQuery<Analista>) super.getEntityManager()
				.createQuery("SELECT a FROM Analista a JOIN a.usuario u WHERE u.nombreUsuario =:username")
				.setParameter("username", username);
			return query.getSingleResult();
		} catch(PersistenceException e) {
			return null;
		}
	} 
}
