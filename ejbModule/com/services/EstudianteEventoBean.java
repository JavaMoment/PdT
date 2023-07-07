package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.entities.Constancia;
import com.entities.EstudianteEvento;

/**
 * Session Bean implementation class EstudianteEventoBean
 */
@Stateless
public class EstudianteEventoBean extends CRUDBean<EstudianteEvento, Long> implements EstudianteEventoBeanRemote{

    /**
     * Default constructor. 
     */
    public EstudianteEventoBean() {
        // TODO Auto-generated constructor stub
    }

}
