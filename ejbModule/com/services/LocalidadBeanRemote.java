package com.services;

import java.util.List;

import javax.ejb.Remote;
import javax.swing.JTextField;

import com.entities.Localidad;

@Remote
public interface LocalidadBeanRemote extends CRUDRemote<Localidad, Long>  {
	List<String> selectAllNames();

	List<String> selectAllNamesBy(long idDepa);

	List<Localidad> selectAllBy(long l);
}
