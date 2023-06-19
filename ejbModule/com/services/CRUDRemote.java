package com.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.persistence.Entity;

@Remote
public interface CRUDRemote<T, ID extends Serializable> {

	int create(T entity);
	List<T> selectAll();
	int update(T entity);
	int delete(T entity);
	T selectById(Long id);
	String[] getColsNames();
	
}
