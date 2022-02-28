package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.Rol;

public interface IRolService {

    public List<Rol> listarTodos();

    public Rol encontrarPorId(int id);

    public void guardar(Rol rol);

    public void actualizar(Rol rol);

    public void borrar();


}
