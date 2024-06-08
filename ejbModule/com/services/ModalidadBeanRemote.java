package com.services;

import javax.ejb.Remote;
import java.util.List;


import com.entities.Modalidad;

@Remote
public interface ModalidadBeanRemote extends CRUDRemote<Modalidad, Long> {

	public List<String> selectAllNames();

	Modalidad selectModalidadBy(String name);

	int logicalDeleteBy(String name);

	int activeModalidadBy(String name);

	List<Modalidad> selectAllActives();

	Modalidad selectBy(String name);
	
}
