package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.ResguardoCompleto;
import com.grupozeus.telecom.Entitys.ResguradoCompletoPK;
import com.grupozeus.telecom.commons.GenericServiceImplements;
import com.grupozeus.telecom.repository.IResguardoCompleto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ResguardoComplServiceImpl extends GenericServiceImplements<ResguardoCompleto, ResguradoCompletoPK> implements IResguardoCompletoService {

@Autowired
private IResguardoCompleto resComDao;

    @Override
    public CrudRepository<ResguardoCompleto, ResguradoCompletoPK> getDao() {
        
        return resComDao;
    }

    @Override
    public List<ResguardoCompleto> encontrarPorSil(String codigoBarra) {
        
        return resComDao.findByInventario_Sil_IdsilContaining(codigoBarra);
    }
    
   
}
