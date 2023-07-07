package com.services;

import javax.ejb.Remote;

import com.entities.Estudiante;

@Remote
public interface EstudianteBeanRemote extends CRUDRemote<Estudiante, Long> {

	Estudiante selectUserBy(String username);
	
}
