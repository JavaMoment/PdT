package com.services;

import javax.ejb.Remote;

import com.entities.Usuario;

@Remote
public interface AnalistaBeanRemote extends CRUDRemote<Usuario, Long> {

}
