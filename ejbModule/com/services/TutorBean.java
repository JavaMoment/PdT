package com.services;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Analista;
import com.entities.Tutor;

/**
 * Session Bean implementation class TutorBean
 */
@Stateless
public class TutorBean extends CRUDBean<Tutor, Long> implements TutorBeanRemote {

    /**
     * Default constructor. 
     */
    public TutorBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
   	public Tutor selectUserBy(String username) {
   		try {
   			@SuppressWarnings("unchecked")
   			TypedQuery<Tutor> query = (TypedQuery<Tutor>) super.getEntityManager()
   				.createQuery("SELECT t FROM Tutor t JOIN t.usuario u WHERE u.nombreUsuario =:username")
   				.setParameter("username", username);
   			return query.getSingleResult();
   		} catch(PersistenceException e) {
   			return null;
   		}
   	} 
}
