package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.Inventario;

public interface IInventarioService {

    public List<Inventario> listarTodos();

    public Inventario encontrarPorId();

    public void guardar();

    public void actualizar();

    public void borrar();

}
