package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.entities.Constancia;

/**
 * Session Bean implementation class ConstanciaBean
 */
@Stateless
public class ConstanciaBean extends CRUDBean<Constancia, Long> implements ConstanciaBeanRemote{

    /**
     * Default constructor. 
     */
    public ConstanciaBean() {
        // TODO Auto-generated constructor stub
    }

}
