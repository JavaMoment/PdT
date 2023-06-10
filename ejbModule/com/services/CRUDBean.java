package com.services;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.Entity;

/**
 * Session Bean implementation class CRUDBean
 */
@Stateless
public class CRUDBean<T, ID extends Serializable> implements CRUDRemote<T, ID> {

	@PersistenceContext
	private EntityManager em = Persistence.createEntityManagerFactory("PDTServerSide").createEntityManager();
	
    /**
     * Default constructor. 
     */
    public CRUDBean() {
        // TODO Auto-generated constructor stub
    }
    
    public EntityManager getEntityManager() {
    	return em;
    }

	@Override
	public int create(T entity) {
		// TODO Auto-generated method stub
		try {
			em.persist(entity);
			em.flush();
			return 0;
		} catch(PersistenceException e) {
			return -1;
		}
	}

	@Override
	public int update(T entity) {
		// TODO Auto-generated method stub
		try {
			em.merge(entity);
			em.flush();
			return 0;
		} catch(PersistenceException e) {
			return -1;
		}
	}

	@Override
	public int delete(T entity) {
		// TODO Auto-generated method stub
		try {
			em.remove(entity);
			em.flush();
			return 0;
		} catch(PersistenceException e) {
			return -1;
		}
	}

	@Override
	public List<T> selectAll() {
		// TODO Auto-generated method stub
		Class<T> entityClass = getEntityClass();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> root = cq.from(entityClass);
        cq.select(root);
        TypedQuery<T> query = em.createQuery(cq);
        return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T selectById(Long id) {
		// TODO Auto-generated method stub
		try {
			Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	        
	        return em.find(entityClass, id);
		} catch(PersistenceException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
