package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ReclamosCountByEstudiante;
import com.models.ReclamosCount;

@Remote
public interface ReclamoCountBeanRemote extends CRUDRemote<ReclamosCountByEstudiante, Long> {

	List<ReclamosCount> getReclamoCountBy(Long idEstudiante, String mes, String anio);
	List<String> getAvailableYears();
	List<String> getAvailableMonths();
}
