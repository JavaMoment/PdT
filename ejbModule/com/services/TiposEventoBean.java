package com.services;

import javax.ejb.Stateless;

import com.entities.TiposEvento;

@Stateless
public class TiposEventoBean extends CRUDBean<TiposEvento, Long> implements TiposEventoBeanRemote{
   
	public TiposEventoBean() {
        // TODO Auto-generated constructor stub
    }

}
