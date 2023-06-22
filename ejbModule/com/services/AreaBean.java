package com.services;

import javax.ejb.Stateless;

import com.entities.Area;

/**
 * Session Bean implementation class AreaBean
 */
@Stateless
public class AreaBean extends CRUDBean<Area, Long> implements AreaBeanRemote {

    /**
     * Default constructor. 
     */
    public AreaBean() {
        // TODO Auto-generated constructor stub
    }

}
