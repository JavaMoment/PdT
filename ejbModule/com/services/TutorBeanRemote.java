package com.services;

import javax.ejb.Remote;

import com.entities.Tutor;

@Remote
public interface TutorBeanRemote extends CRUDRemote<Tutor, Long> {

}
