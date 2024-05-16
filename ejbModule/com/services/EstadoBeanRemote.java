package com.services;

import javax.ejb.Remote;

import com.entities.StatusEvento;

@Remote
public interface EstadoBeanRemote extends CRUDRemote<StatusEvento, Long> {

}