package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.entities.Evento;

/**
 * Session Bean implementation class EventoBean
 */
@Stateless
public class EventoBean extends CRUDBean<Evento, Long> implements EventoBeanRemote{

    /**
     * Default constructor. 
     */
    public EventoBean() {
        // TODO Auto-generated constructor stub
    }

}
