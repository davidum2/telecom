package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.Sil;

public interface ISilService {
    
    public List<Sil> listarTodos();

    public Sil encontrarPorId();

    public void guardar();

    public void actualizar();

    public void borrar();


}
