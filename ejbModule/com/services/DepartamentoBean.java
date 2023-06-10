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

}
