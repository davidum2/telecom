package com.grupozeus.telecom.service;

import com.grupozeus.telecom.Entitys.Unidad;
import com.grupozeus.telecom.commons.GenericServiceImplements;
import com.grupozeus.telecom.repository.IUnidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UnidadServiceImpl extends GenericServiceImplements<Unidad, Long> implements IUnidadService {

    @Autowired
    private IUnidad unidadDao;
	@Override
	public CrudRepository<Unidad, Long> getDao() {
		
		return unidadDao;
	}
    
}
