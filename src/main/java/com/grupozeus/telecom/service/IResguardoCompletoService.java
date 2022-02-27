package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.ResguardoCompleto;

public interface IResguardoCompletoService {
    
    public List<ResguardoCompleto> listarTodos();

    public ResguardoCompleto encontrarPorId();

    public void guardar();

    public void actualizar();

    public void borrar();

}
