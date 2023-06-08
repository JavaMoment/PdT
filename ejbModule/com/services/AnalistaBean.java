package com.services;

import javax.ejb.Stateless;

import com.entities.Usuario;

/**
 * Session Bean implementation class AnalistaBean
 */
@Stateless
public class AnalistaBean extends CRUDBean<Usuario, Long> implements AnalistaBeanRemote {

    /**
     * Default constructor. 
     */
    public AnalistaBean() {
        // TODO Auto-generated constructor stub
    }

}
