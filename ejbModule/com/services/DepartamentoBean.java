package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Departamento;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateless
public class DepartamentoBean extends CRUDBean<Departamento, Long> implements DepartamentoBeanRemote {

    /**
     * Default constructor. 
     */
    public DepartamentoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<String> selectAllNames() {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<String> query = (TypedQuery<String>) super.getEntityManager()
					.createQuery("SELECT d.nombre FROM Departamento d ORDER BY d.idDepartamento", String.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			return null;
		}
	}

	@Override
	public Departamento selectByName(String name) {
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Departamento> query = (TypedQuery<Departamento>) super.getEntityManager()
					.createQuery("SELECT d FROM Departamento d WHERE d.nombre =: name ORDER BY d.idDepartamento", Departamento.class)
					.setParameter("name", name);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}
	
	@Override
	public List<Departamento> getDepartamentosWithoutItr() {
		try {
			TypedQuery<Departamento> query = (TypedQuery<Departamento>) super.getEntityManager()
					.createQuery("SELECT d FROM Departamento d WHERE d.itr = null ORDER BY d.idDepartamento", Departamento.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			return null;
		}
	}

}
