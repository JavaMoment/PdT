package com.services;

import javax.ejb.Stateless;

import com.entities.Usuario;

/**
 * Session Bean implementation class EstudianteBean
 */
@Stateless
public class EstudianteBean extends CRUDBean<Usuario, Long> implements EstudianteBeanRemote {

    /**
     * Default constructor. 
     */
    public EstudianteBean() {
        // TODO Auto-generated constructor stub
    }
    
}
