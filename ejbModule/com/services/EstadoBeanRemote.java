package com.services;

import javax.ejb.Remote;

import com.entities.Area;
import com.entities.Estado;

@Remote
public interface EstadoBeanRemote extends CRUDRemote<Estado, Long> {

}