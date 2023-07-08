package com.services;

import javax.ejb.Remote;
import com.entities.EstudianteEventoPK;

@Remote
public interface EstudianteEventoPKBeanRemote extends CRUDRemote<EstudianteEventoPK, Long> {

}
