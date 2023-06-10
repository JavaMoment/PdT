package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Departamento;

@Remote
public interface DepartamentoBeanRemote extends CRUDRemote<Departamento, Long> {
	List<String> selectAllNames();
}
