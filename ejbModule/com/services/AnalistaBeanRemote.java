package com.services;

import javax.ejb.Remote;

import com.entities.Analista;


@Remote
public interface AnalistaBeanRemote extends CRUDRemote<Analista, Long> {

	Analista selectUserBy(String username);

}
