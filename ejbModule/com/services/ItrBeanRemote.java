package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.entities.Itr;

/**
 * Session Bean implementation class ItrBeanRemote
 */
@Remote
public interface ItrBeanRemote extends CRUDRemote<Itr, Long> {

  

}
