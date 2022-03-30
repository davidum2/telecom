package com.grupozeus.telecom.service;

import com.grupozeus.telecom.Entitys.ContenidoResguardo;
import com.grupozeus.telecom.commons.GenericServiceImplements;
import com.grupozeus.telecom.repository.IContenidoResguardo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContenidoResguardoServiceImpl extends GenericServiceImplements<ContenidoResguardo, Long> implements IContenidoResguardoService {

    @Autowired
    private IContenidoResguardo contenidoResguardo;
	
    @Override
	public CrudRepository<ContenidoResguardo, Long> getDao() {
		return contenidoResguardo;
	}
    
}
