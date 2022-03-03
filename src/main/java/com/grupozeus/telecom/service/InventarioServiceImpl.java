package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.Inventario;
import com.grupozeus.telecom.Entitys.Sil;
import com.grupozeus.telecom.commons.GenericServiceImplements;
import com.grupozeus.telecom.repository.IInventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class InventarioServiceImpl extends GenericServiceImplements<Inventario, Integer> implements IInventarioService  {

    @Autowired
    private IInventario inventarioDao;

    @Autowired
    private ISilService silDao;

    @Override
    public Inventario encontrarPorCodigoBarras(String codigoBarras) {
        return inventarioDao.findByCodigoBarras(codigoBarras);
    }

    @Override
    public CrudRepository<Inventario, Integer> getDao() {
        return inventarioDao;
    }

    @Override
    public List<Inventario> encontrarPorSil(String idSil) {
       Sil sil = silDao.get(idSil);
    return inventarioDao.findBySil(sil);
    }

 
    
}
