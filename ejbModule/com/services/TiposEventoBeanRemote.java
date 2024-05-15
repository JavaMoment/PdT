package com.services;

import javax.ejb.Remote;

import com.entities.TiposEvento;

@Remote
public interface TiposEventoBeanRemote extends CRUDRemote<TiposEvento, Long>{

}
