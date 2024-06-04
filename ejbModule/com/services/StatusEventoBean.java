package com.services;

import javax.ejb.Stateless;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.StatusEvento;

/**
 * Session Bean implementation class EstadoBean
 */
@Stateless
	
public class StatusEventoBean extends CRUDBean<StatusEvento, Long> implements StatusEventoBeanRemote{

    
    public StatusEventoBean() {
        // TODO Auto-generated constructor stub
    }
  
   
    public List<String> selectAllNames() {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<String> query = (TypedQuery<String>) super.getEntityManager()
					.createQuery("SELECT i.nombre FROM StatusEvento i ORDER BY i.idStatus", String.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			return null;
		}
	}
    
    @Override
	public StatusEvento selectEstadoBy(String name) {
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<StatusEvento> query = (TypedQuery<StatusEvento>) super.getEntityManager()
				.createQuery("SELECT i FROM StatusEvento i WHERE i.nombre = :name")
				.setParameter("name", name);
			return query.getSingleResult();
		} catch(PersistenceException e) {
			return null;
		}
	} 
    
    @Override
	public int logicalDeleteBy(String name) {
		try {
			StatusEvento estadoToUpdate = selectEstadoBy(name);
			//itrToUpdate.setActivo((byte) 0);
			estadoToUpdate.setActivo(false);
			
			int resultCode = update(estadoToUpdate);
			
			return resultCode == 0  ? 0 : -1;
		} catch(PersistenceException e) {
			return -1;
		}
	}
	
	@Override
	public int activeEstadoBy(String name) {
		try {
			StatusEvento estadoToUpdate = selectEstadoBy(name);
			//itrToUpdate.setActivo((byte) 1);
			estadoToUpdate.setActivo(true);
			
			int resultCode = update(estadoToUpdate);
			
			return resultCode == 0  ? 0 : -1;
		} catch(PersistenceException e) {
			return -1;
		}
	}
	
	@Override
	public List<StatusEvento> selectAllActives() {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<StatusEvento> query = (TypedQuery<StatusEvento>) super.getEntityManager()
					.createQuery("SELECT i FROM StatusEvento i WHERE i.activo = 1 ORDER BY i.idStatus", StatusEvento.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			return null;
		}
	}

	@Override
	public StatusEvento selectBy(String name) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<StatusEvento> query = (TypedQuery<StatusEvento>) super.getEntityManager()
					.createQuery("SELECT i FROM StatusEvento i WHERE i.nombre =: name ORDER BY i.idStatus", StatusEvento.class)
					.setParameter("name", name);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

}
