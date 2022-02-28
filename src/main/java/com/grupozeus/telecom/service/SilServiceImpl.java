package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.Sil;
import com.grupozeus.telecom.commons.GenericServiceImplements;
import com.grupozeus.telecom.repository.ISil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SilServiceImpl extends GenericServiceImplements<Sil, String> implements ISilService {

    @Autowired
    private ISil silDao;

    @Override
    public List<Sil> findByDescripcion(String descripcion) {
        return silDao.findByDescripcion(descripcion);
    }

    @Override
    public CrudRepository<Sil, String> getDao() {
        return silDao;
    }

  
}
