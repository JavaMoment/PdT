package com.services;

import javax.ejb.Remote;

import com.entities.Modalidad;

@Remote
public interface ModalidadBeanRemote extends CRUDRemote<Modalidad, Long> {

}
