package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.HtEvento;
import com.models.SemestreCount;

@Remote
public interface HtEventoBeanRemote extends CRUDRemote<HtEvento, Long>{
	List<HtEvento> getHtEventosBy(Long skItr, Integer anio);
	List<SemestreCount> getSemestreCount(Long skItr, Integer anio);
}
