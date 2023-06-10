package com.services;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

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
		} catch (PersistenceException e) {
			return null;
		}
	}

}
