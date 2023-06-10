package com.services;

import javax.ejb.Remote;

import com.entities.Constancia;

@Remote
public interface ConstanciaBeanRemote extends CRUDRemote<Constancia, Long> {
	
}
