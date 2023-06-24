package com.services;

import javax.ejb.Stateless;

import com.entities.Analista;

/**
 * Session Bean implementation class AnalistaBean
 */
@Stateless
public class AnalistaBean extends CRUDBean<Analista, Long> implements AnalistaBeanRemote {

    /**
     * Default constructor. 
     */
    public AnalistaBean() {
        // TODO Auto-generated constructor stub
    }

}
