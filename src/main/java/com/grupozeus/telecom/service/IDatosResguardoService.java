package com.grupozeus.telecom.service;

import java.util.List;

import com.grupozeus.telecom.Entitys.DatosResguardo;

public interface IDatosResguardoService {
    
    public List<DatosResguardo> listarTodos();

    public DatosResguardo encontrarPorId(Long id);

    public void guardar(DatosResguardo datosResguardo);

    public void actualizar(DatosResguardo datosResguardo);

    public void borrar(DatosResguardo datosResguardo);




}
