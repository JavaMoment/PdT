package com.services;

import javax.ejb.Remote;

import com.entities.Usuario;
import javax.persistence.Entity;

@Remote
public interface UsuarioBeanRemote extends CRUDRemote<Usuario, Long> {
	
	
}
