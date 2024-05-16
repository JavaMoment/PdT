package com.services;

import javax.ejb.Stateless;


import com.entities.StatusEvento;

/**
 * Session Bean implementation class EstadoBean
 */
@Stateless
	
public class EstadoBean extends CRUDBean<StatusEvento, Long> implements EstadoBeanRemote{

    /**
     * Default constructor. 
     */
    public EstadoBean() {
        // TODO Auto-generated constructor stub
    }

}
