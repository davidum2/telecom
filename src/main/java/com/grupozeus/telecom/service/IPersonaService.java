package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.Persona;

public interface IPersonaService {

    public List<Persona> listarTodos();

    public Persona encontrarPorId(Integer id);

    public void guardar(Persona persona);

    public void actualizar(Persona persona);

    public void borrar(Persona persona);

}
