package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Estudiante;
import com.entities.EstudianteEvento;

@Remote
public interface EstudianteBeanRemote extends CRUDRemote<Estudiante, Long> {

	Estudiante selectUserBy(String username);

	List<Estudiante> getEstudiantesBy(long idEvento);

	EstudianteEvento selectUserByEvent(long idEvento);

}
