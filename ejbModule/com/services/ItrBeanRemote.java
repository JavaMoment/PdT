package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Itr;

@Remote
public interface ItrBeanRemote extends CRUDRemote<Itr, Long>  {
	public List<String> selectAllNames();

	Itr selectItrBy(String name);

	int logicalDeleteBy(String name);

	int activeItrBy(String name);

	List<Itr> selectAllActives();
}
