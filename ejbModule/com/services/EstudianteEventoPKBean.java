package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.entities.Constancia;
import com.entities.EstudianteEventoPK;

/**
 * Session Bean implementation class EstudianteEventoPKBean
 */
@Stateless
public class EstudianteEventoPKBean extends CRUDBean<EstudianteEventoPK, Long> implements EstudianteEventoPKBeanRemote{

    /**
     * Default constructor. 
     */
    public EstudianteEventoPKBean() {
        // TODO Auto-generated constructor stub
    }

}
