package com.services;

import javax.ejb.Stateless;

import com.entities.Usuario;

/**
 * Session Bean implementation class TutorBean
 */
@Stateless
public class TutorBean extends CRUDBean<Usuario, Long> implements TutorBeanRemote {

    /**
     * Default constructor. 
     */
    public TutorBean() {
        // TODO Auto-generated constructor stub
    }

}
