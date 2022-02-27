package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.Rol;

public interface IRolService {

    public List<Rol> listarTodos();

    public Rol encontrarPorId();

    public void guardar();

    public void actualizar();

    public void borrar();


}
