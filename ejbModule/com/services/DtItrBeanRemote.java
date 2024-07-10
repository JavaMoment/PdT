package com.services;


import javax.ejb.Remote;

import com.entities.DtItr;

@Remote
public interface DtItrBeanRemote extends CRUDRemote<DtItr, Long>{
	DtItr getDtItrBy(String pkItr);
}
