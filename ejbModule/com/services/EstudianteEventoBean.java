package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Constancia;
import com.entities.Estudiante;
import com.entities.EstudianteEvento;
import com.entities.Usuario;

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
