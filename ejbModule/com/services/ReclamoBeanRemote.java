package com.services;

import javax.ejb.Remote;
import com.entities.Reclamo;

/**
 * Session Bean implementation class ReclamoBeanRemote
 */
@Remote
public interface ReclamoBeanRemote extends CRUDRemote<Reclamo, Long> {


}
