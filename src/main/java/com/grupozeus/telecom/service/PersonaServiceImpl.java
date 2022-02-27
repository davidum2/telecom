package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.Persona;
import com.grupozeus.telecom.repository.IPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    public IPersona personaDao;
    
    @Override
    public List<Persona> listarTodos() {
        
        return personaDao.findAll();
    }

    @Override
    public Persona encontrarPorId(Integer id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    public void guardar(Persona persona) {
        personaDao.save(persona);
        
    }

    @Override
    public void actualizar(Persona persona) {
        personaDao.save(persona);
        
    }

    @Override
    public void borrar(Persona persona) {
        personaDao.delete(persona);
        
    }
    


}
