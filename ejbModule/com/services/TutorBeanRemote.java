package com.services;

import javax.ejb.Remote;

import com.entities.Usuario;

@Remote
public interface TutorBeanRemote extends CRUDRemote<Usuario, Long> {

}
