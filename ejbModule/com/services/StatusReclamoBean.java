package com.services;

import javax.ejb.Stateless;

import com.entities.StatusReclamo;

/**
 * Session Bean implementation class StatusCertificadosBean
 */
@Stateless
public class StatusReclamoBean extends CRUDBean<StatusReclamo, Long> implements StatusReclamoBeanRemote{

    /**
     * Default constructor. 
     */
    public StatusReclamoBean() {
        // TODO Auto-generated constructor stub
    }

}
