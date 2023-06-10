package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.entities.Reclamo;

/**
 * Session Bean implementation class ReclamoBeanRemote
 */
@Remote
public interface ReclamoBeanRemote extends CRUDRemote<Reclamo, Long> {


}
