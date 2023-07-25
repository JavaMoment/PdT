package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Estudiante;


/**
 * Session Bean implementation class EstudianteBean
 */
@Stateless
public class EstudianteBean extends CRUDBean<Estudiante, Long> implements EstudianteBeanRemote {

    /**
     * Default constructor. 
     */
    public EstudianteBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public Estudiante selectUserBy(String username) {
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Estudiante> query = (TypedQuery<Estudiante>) super.getEntityManager()
				.createQuery("SELECT e FROM Estudiante e JOIN e.usuario u WHERE u.nombreUsuario =:username")
				.setParameter("username", username);
			return query.getSingleResult();
		} catch(PersistenceException e) {
			return null;
		}
	} 
    
    @Override
	public List<Estudiante> getEstudiantesBy(long idEvento) {
		try {
			TypedQuery<Estudiante> query = (TypedQuery<Estudiante>) super.getEntityManager()
					.createQuery("SELECT e FROM Estudiante e JOIN EstudianteEvento ee ON ee.id.idEstudiante = e.idEstudiante WHERE ee.id.idEvento = :idEvento", Estudiante.class)
					.setParameter("idEvento", idEvento);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
