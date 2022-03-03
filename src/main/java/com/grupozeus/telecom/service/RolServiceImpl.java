package com.grupozeus.telecom.service;

import com.grupozeus.telecom.Entitys.Rol;
import com.grupozeus.telecom.commons.GenericServiceImplements;
import com.grupozeus.telecom.repository.IRol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends GenericServiceImplements<Rol, Long> implements IRolService {

    @Autowired
    private IRol rolDao;
    
	@Override
	public CrudRepository<Rol, Long> getDao() {
		
		return rolDao;
	}
    
}
