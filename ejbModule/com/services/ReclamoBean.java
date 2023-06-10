package com.services;

import javax.ejb.Stateless;

import com.entities.Reclamo;

/**
 * Session Bean implementation class ReclamoBean
 */
@Stateless
public class ReclamoBean extends CRUDBean<Reclamo, Long> implements ReclamoBeanRemote {

    /**
     * Default constructor. 
     */
    public ReclamoBean() {
        // TODO Auto-generated constructor stub
    }

}
