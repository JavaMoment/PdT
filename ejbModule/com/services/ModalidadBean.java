package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import com.entities.Modalidad;

/**
 * Session Bean implementation class ModalidadBean
 */
@Stateless
public class ModalidadBean extends CRUDBean<Modalidad, Long> implements ModalidadBeanRemote{

    /**
     * Default constructor. 
     */
    public ModalidadBean() {
        // TODO Auto-generated constructor stub
    }
    public List<String> selectAllNames() {
 		// TODO Auto-generated method stub
 		try {
 			@SuppressWarnings("unchecked")
 			TypedQuery<String> query = (TypedQuery<String>) super.getEntityManager()
 					.createQuery("SELECT i.nombre FROM Modalidades i ORDER BY i.idModalidad", String.class);
 			return query.getResultList();
 		} catch (PersistenceException e) {
 			return null;
 		}
 	}
     
     @Override
 	public Modalidad selectModalidadBy(String name) {
 		try {
 			@SuppressWarnings("unchecked")
 			TypedQuery<Modalidad> query = (TypedQuery<Modalidad>) super.getEntityManager()
 				.createQuery("SELECT i FROM Modalidad i WHERE i.nombre =:name")
 				.setParameter("name", name);
 			return query.getSingleResult();
 		} catch(PersistenceException e) {
 			return null;
 		}
 	} 
     
     @Override
 	public int logicalDeleteBy(String name) {
 		try {
 			Modalidad modalidadToUpdate = selectModalidadBy(name);
 			modalidadToUpdate.setActivo(false);
 			
 			int resultCode = update(modalidadToUpdate);
 			
 			return resultCode == 0  ? 0 : -1;
 		} catch(PersistenceException e) {
 			return -1;
 		}
 	}
 	
 	@Override
 	public int activeModalidadBy(String name) {
 		try {
 			Modalidad modalidadToUpdate = selectModalidadBy(name);
 			modalidadToUpdate.setActivo(true);
 			int resultCode = update(modalidadToUpdate);
 			return resultCode == 0  ? 0 : -1;
 		} catch(PersistenceException e) {
 			return -1;
 		}
 	}
 	
 	@Override
 	public List<Modalidad> selectAllActives() {
 		// TODO Auto-generated method stub
 		try {
 			@SuppressWarnings("unchecked")
 			TypedQuery<Modalidad> query = (TypedQuery<Modalidad>) super.getEntityManager()
 					.createQuery("SELECT i FROM Modalidad i WHERE i.activo = 1 ORDER BY i.idModalidad", Modalidad.class);
 			return query.getResultList();
 		} catch (PersistenceException e) {
 			return null;
 		}
 	}

 	@Override
 	public Modalidad selectBy(String name) {
 		// TODO Auto-generated method stub
 		try {
 			@SuppressWarnings("unchecked")
 			TypedQuery<Modalidad> query = (TypedQuery<Modalidad>) super.getEntityManager()
 					.createQuery("SELECT i FROM Modalidad i WHERE i.nombre =: name ORDER BY i.idModalidad", Modalidad.class)
 					.setParameter("name", name);
 			return query.getSingleResult();
 		} catch (PersistenceException e) {
 			return null;
 		}
 	}
}
