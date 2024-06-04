package com.services;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Evento;
import com.entities.Tutor;
import com.entities.TutorEvento;
import com.entities.TutorEventoPK;



/**
 * Session Bean implementation class TutorBean
 */
@Stateless
public class TutorBean extends CRUDBean<Tutor, Long> implements TutorBeanRemote {

    /**
     * Default constructor. 
     */
    public TutorBean() {

    }
    
    @PersistenceContext
    private EntityManager entityManager;
    
	@Override
	public List<Tutor> selectByUsernames(List<String> nombresUsuarios) {
		try {
			TypedQuery<Tutor> query = (TypedQuery<Tutor>) super.getEntityManager()
	        	.createQuery("SELECT t FROM Tutor t WHERE t.usuario.nombreUsuario IN :usernames", Tutor.class);
	        query.setParameter("usernames", nombresUsuarios);
	        return query.getResultList();
	        
	    } catch (PersistenceException e) {
	        // Manejo de excepciones
	        return Collections.emptyList();
	    }
	}


	@Override
	public boolean asignarEventoTutor(Evento evento, Tutor tutor) {
	    try {
	    	System.out.println(evento.getIdEvento());
	    	System.out.println(tutor.getIdTutor());
	        TutorEventoPK tutorEventoPK = new TutorEventoPK(tutor.getIdTutor(), evento.getIdEvento());
	        TutorEvento tutorEvento = new TutorEvento(tutorEventoPK);
	        entityManager.persist(tutorEvento);
	        entityManager.flush();
	        return true;
	    } catch (PersistenceException e) {
	        System.out.println(e);
	        System.out.println("cai en syso de asignarevento");
	        return false;
	    }
	}
//	 @Override
//	    public boolean asignarEventoTutor(Evento evento, Tutor tutor) {
//	        try {
//	            // Verifica si el evento ya está gestionado por el EntityManager
//	            Evento managedEvento = entityManager.find(Evento.class, evento.getIdEvento());
//	            if (managedEvento == null) {
//	                throw new IllegalArgumentException("El evento no está gestionado por el EntityManager.");
//	            }
//
//	            TutorEventoPK tutorEventoPK = new TutorEventoPK(tutor.getIdTutor(), evento.getIdEvento());
//	            TutorEvento tutorEvento = new TutorEvento(tutorEventoPK);
//	            entityManager.persist(tutorEvento);
//	            entityManager.flush();
//	            return true;
//	        } catch (PersistenceException e) {
//	            System.out.println(e);
//	            System.out.println("cai en syso de asignarevento");
//	            return false;
//	        } catch (IllegalArgumentException e) {
//	            System.out.println(e.getMessage());
//	            return false;
//	        }
//	    }

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
    

