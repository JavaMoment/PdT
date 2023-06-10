package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.entities.StatusCertificados;

/**
 * Session Bean implementation class StatusCertificadosBeanRemote
 */
@Remote
public interface StatusCertificadosBeanRemote extends CRUDRemote<StatusCertificados, Long> {

   

}
