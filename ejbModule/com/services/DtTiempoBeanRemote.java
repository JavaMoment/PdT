package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.DtTiempo;

@Remote
public interface DtTiempoBeanRemote extends CRUDRemote<DtTiempo, Long>{
	List<Integer> getAvailableYears();
}
