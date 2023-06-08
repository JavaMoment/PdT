package com.services;

import javax.ejb.Remote;

import com.entities.Usuario;

@Remote
public interface EstudianteBeanRemote extends CRUDRemote<Usuario, Long> {

}
