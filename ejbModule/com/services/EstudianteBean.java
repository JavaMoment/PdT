package com.services;

import javax.ejb.Stateless;

import com.entities.Estudiante;


/**
 * Session Bean implementation class EstudianteBean
 */
@Stateless
public class EstudianteBean extends CRUDBean<Estudiante, Long> implements EstudianteBeanRemote {

    /**
     * Default constructor. 
     */
    public EstudianteBean() {
        // TODO Auto-generated constructor stub
    }
    
}
