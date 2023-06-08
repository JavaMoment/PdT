package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.entities.StatusCertificados;

/**
 * Session Bean implementation class StatusCertificadosBean
 */
@Stateless
public class StatusCertificadosBean extends CRUDBean<StatusCertificados, Long> implements StatusCertificadosBeanRemote{

    /**
     * Default constructor. 
     */
    public StatusCertificadosBean() {
        // TODO Auto-generated constructor stub
    }

}
