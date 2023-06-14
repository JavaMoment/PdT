package com.services;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Usuario;
import javax.persistence.Entity;

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

}
