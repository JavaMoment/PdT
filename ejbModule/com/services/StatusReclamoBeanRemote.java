package com.services;

import javax.ejb.Remote;

import com.entities.StatusReclamo;

@Remote
public interface StatusReclamoBeanRemote extends CRUDRemote<StatusReclamo, Long> {

}
