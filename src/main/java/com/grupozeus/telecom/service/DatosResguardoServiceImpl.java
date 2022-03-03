package com.grupozeus.telecom.service;



import com.grupozeus.telecom.Entitys.DatosResguardo;
import com.grupozeus.telecom.commons.GenericServiceImplements;
import com.grupozeus.telecom.repository.IDatosResguardo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DatosResguardoServiceImpl extends GenericServiceImplements<DatosResguardo, Long> implements IDatosResguardoService {

    @Autowired
    public IDatosResguardo datos;

    @Override
    public CrudRepository<DatosResguardo, Long> getDao() {
        
        return datos;
    }
    
}
