package com.services;

import java.util.List;

import javax.ejb.Remote;
import com.entities.Reclamo;

/**
 * Session Bean implementation class ReclamoBeanRemote
 */
@Remote
public interface ReclamoBeanRemote extends CRUDRemote<Reclamo, Long> {

	List<Reclamo> selectAllBy(String nombreUsuario);


}
