package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ReclamosCountByEstudiante;

@Remote
public interface ReclamoCountBeanRemote extends CRUDRemote<ReclamosCountByEstudiante, Long> {

	List<ReclamosCountByEstudiante> getReclamoCountBy(Long idEstudiante, String mes, String anio);
}
