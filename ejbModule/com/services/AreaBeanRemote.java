package com.services;

import javax.ejb.Remote;

import com.entities.Area;

@Remote
public interface AreaBeanRemote extends CRUDRemote<Area, Long> {
	Area selectBy(String name);
}
