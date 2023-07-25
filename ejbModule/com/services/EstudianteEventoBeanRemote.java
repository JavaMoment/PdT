package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.EstudianteEvento;

@Remote
public interface EstudianteEventoBeanRemote extends CRUDRemote<EstudianteEvento, Long>{

	List<EstudianteEvento> getEstudianteEventoFrom(long idEstudiante);

}
