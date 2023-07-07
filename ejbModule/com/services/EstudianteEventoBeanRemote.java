package com.services;

import javax.ejb.Remote;

import com.entities.EstudianteEvento;

@Remote
public interface EstudianteEventoBeanRemote extends CRUDRemote<EstudianteEvento, Long>{

}
