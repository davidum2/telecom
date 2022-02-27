package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.DatosResguardo;
import com.grupozeus.telecom.repository.IDatosResguardo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosResguardoServiceImpl implements IDatosResguardoService {

    @Autowired
    public IDatosResguardo datos;

    @Override
    public List<DatosResguardo> listarTodos() {
        
        return datos.findAll();
    }

    @Override
    public DatosResguardo encontrarPorId(Long id) {
        
        return datos.findById(id).orElse(null);
    }

    @Override
    public void guardar(DatosResguardo datosResguardo) {
        datos.save(datosResguardo);
        
    }

    @Override
    public void actualizar(DatosResguardo datosResguardo) {
        datos.save(datosResguardo);
        
    }

    @Override
    public void borrar(DatosResguardo datosResguardo) {
        datos.delete(datosResguardo);
        
    }
    
}
