package com.services;

import javax.ejb.Remote;

import com.entities.Usuario;

@Remote
public interface UsuarioBeanRemote extends CRUDRemote<Usuario, Long> {

	String selectPasswBy(String mail);
}
