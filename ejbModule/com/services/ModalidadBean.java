package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.entities.Modalidad;

/**
 * Session Bean implementation class ModalidadBean
 */
@Stateless
public class ModalidadBean extends CRUDBean<Modalidad, Long> implements ModalidadBeanRemote{

    /**
     * Default constructor. 
     */
    public ModalidadBean() {
        // TODO Auto-generated constructor stub
    }

}
