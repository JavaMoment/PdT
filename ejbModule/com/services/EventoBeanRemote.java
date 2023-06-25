package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.entities.Evento;

/**
 * Session Bean implementation class EventoBeanRemote
 */
@Remote
public interface EventoBeanRemote extends CRUDRemote<Evento, Long>{

}
