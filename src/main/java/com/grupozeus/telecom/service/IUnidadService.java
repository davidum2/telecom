package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.Unidad;

public interface IUnidadService {
    
    public List<Unidad> listarTodos();

    public Unidad encontrarPorId();

    public void guardar();

    public void actualizar();

    public void borrar();


}
