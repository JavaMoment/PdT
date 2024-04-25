package com.services;

import javax.ejb.Remote;

import com.entities.TiposTutor;

@Remote
public interface TiposTutorBeanRemote extends CRUDRemote<TiposTutor, Long> {

	TiposTutor selectBy(String name);

}
