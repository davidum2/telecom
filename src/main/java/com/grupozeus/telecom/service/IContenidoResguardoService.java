package com.grupozeus.telecom.service;

import org.springframework.core.io.Resource;
import com.grupozeus.telecom.Entitys.ContenidoResguardo;
import com.grupozeus.telecom.commons.GenericServiceAPI;

import org.springframework.http.ResponseEntity;

public interface IContenidoResguardoService extends GenericServiceAPI<ContenidoResguardo, Long> {
    
    public ResponseEntity<Resource> exportResguardo(Long idResguardoPDF, int idpersona);
    
}

