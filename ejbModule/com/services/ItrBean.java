package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Itr;
import com.entities.Usuario;

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
    
    @Override
	public Itr selectItrBy(String name) {
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Itr> query = (TypedQuery<Itr>) super.getEntityManager()
				.createQuery("SELECT i FROM Itr i WHERE i.nombre =:name")
				.setParameter("name", name);
			return query.getSingleResult();
		} catch(PersistenceException e) {
			return null;
		}
	} 
    
    @Override
	public int logicalDeleteBy(String name) {
		try {
			Itr itrToUpdate = selectItrBy(name);
			itrToUpdate.setActivo((byte) 0);
			
			int resultCode = update(itrToUpdate);
			
			return resultCode == 0  ? 0 : -1;
		} catch(PersistenceException e) {
			return -1;
		}
	}
	
	@Override
	public int activeItrBy(String name) {
		try {
			Itr itrToUpdate = selectItrBy(name);
			itrToUpdate.setActivo((byte) 1);
			
			int resultCode = update(itrToUpdate);
			
			return resultCode == 0  ? 0 : -1;
		} catch(PersistenceException e) {
			return -1;
		}
	}
	
	@Override
	public List<Itr> selectAllActives() {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Itr> query = (TypedQuery<Itr>) super.getEntityManager()
					.createQuery("SELECT i FROM Itr i WHERE i.activo = 1 ORDER BY i.idItr", Itr.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			return null;
		}
	}

	@Override
	public Itr selectBy(String name) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Itr> query = (TypedQuery<Itr>) super.getEntityManager()
					.createQuery("SELECT i FROM Itr i WHERE i.nombre =: name ORDER BY i.idItr", Itr.class)
					.setParameter("name", name);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}
}
