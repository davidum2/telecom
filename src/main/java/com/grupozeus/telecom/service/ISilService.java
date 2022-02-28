package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.Sil;
import com.grupozeus.telecom.commons.GenericServiceAPI;

public interface ISilService extends GenericServiceAPI<Sil, String> {
   
    public List<Sil> findByDescripcion(String descripcion);
   


}
