package com.services;


import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import com.entities.EstudianteEvento;
import com.entities.Usuario;


/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
public class UsuarioBean extends CRUDBean<Usuario, Long> implements UsuarioBeanRemote {

    /**
     * Default constructor. 
     */
    public UsuarioBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String selectPasswBy(String mail) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Usuario> query = (TypedQuery<Usuario>) super.getEntityManager()
					.createQuery("SELECT u FROM Usuario u WHERE u.mail=:mail")
					.setParameter("mail", mail);
			return query.getSingleResult().getContrasenia();
		} catch(PersistenceException e) {
			return null;
		}
	}
	
	@Override
	public boolean isUserRegistered(String username) {
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<String> query = (TypedQuery<String>) super.getEntityManager()
				.createQuery("SELECT u.nombreUsuario FROM Usuario u WHERE u.nombreUsuario=:username")
				.setParameter("username", username);
			return !query.getSingleResult().isEmpty();
		} catch(PersistenceException e) {
			return false;
		}
	}
	
	@Override
	public Usuario selectUserBy(String mailOrUsername) {
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Usuario> query = (TypedQuery<Usuario>) super.getEntityManager()
				.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario =:mailOrUsername OR u.mailInstitucional =:mailOrUsername")
				.setParameter("mailOrUsername", mailOrUsername);
			return query.getSingleResult();
		} catch(PersistenceException e) {
			return null;
		}
	}
	
	
	@Override
	public int logicalDeleteByUsername(String username) {
		try {
			Usuario userToUpdate = selectUserBy(username);
			userToUpdate.setActivo((byte) 0);
			
			int resultCode = update(userToUpdate);
			
			return resultCode == 0  ? 0 : -1;
		} catch(PersistenceException e) {
			return -1;
		}
	}
	
	@Override
	public int activeUserBy(String username) {
		try {
			Usuario userToUpdate = selectUserBy(username);
			userToUpdate.setActivo((byte) 1);
			
			int resultCode = update(userToUpdate);
			
			return resultCode == 0  ? 0 : -1;
		} catch(PersistenceException e) {
			return -1;
		}
	}

}
