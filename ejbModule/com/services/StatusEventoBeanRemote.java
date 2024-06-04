package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.StatusEvento;

@Remote
public interface StatusEventoBeanRemote extends CRUDRemote<StatusEvento, Long> {

	public List<String> selectAllNames();

	StatusEvento selectEstadoBy(String name);

	int logicalDeleteBy(String name);

	int activeEstadoBy(String name);

	List<StatusEvento> selectAllActives();

	StatusEvento selectBy(String name);
}