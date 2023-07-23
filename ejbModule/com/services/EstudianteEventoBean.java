package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.entities.EstudianteEvento;

/**
 * Session Bean implementation class EstudianteEventoBean
 */
@Stateless
public class EstudianteEventoBean extends CRUDBean<EstudianteEvento, Long> implements EstudianteEventoBeanRemote{

    /**
     * Default constructor. 
     */
    public EstudianteEventoBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<EstudianteEvento> getEstudianteEventoFrom(long idEstudiante) {
    	try {
			TypedQuery<EstudianteEvento> query = (TypedQuery<EstudianteEvento>) super.getEntityManager()
					.createQuery("SELECT ee FROM EstudianteEvento ee WHERE ee.id.idEstudiante = :idEstudiante", EstudianteEvento.class)
					.setParameter("idEstudiante", idEstudiante);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    }
}
