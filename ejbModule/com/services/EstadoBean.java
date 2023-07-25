package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.entities.Area;
import com.entities.Estado;

/**
 * Session Bean implementation class EstadoBean
 */
@Stateless
	
public class EstadoBean extends CRUDBean<Estado, Long> implements EstadoBeanRemote{

    /**
     * Default constructor. 
     */
    public EstadoBean() {
        // TODO Auto-generated constructor stub
    }

}
