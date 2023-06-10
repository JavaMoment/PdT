package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Localidad;

@Remote
public interface LocalidadBeanRemote extends CRUDRemote<Localidad, Long>  {
	List<String> selectAllNames();
}
