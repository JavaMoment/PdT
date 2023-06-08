package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.entities.Itr;

/**
 * Session Bean implementation class ItrBean
 */
@Stateless
public class ItrBean extends CRUDBean<Itr, Long> implements ItrBeanRemote {

    /**
     * Default constructor. 
     */
    public ItrBean() {
        // TODO Auto-generated constructor stub
    }

}
