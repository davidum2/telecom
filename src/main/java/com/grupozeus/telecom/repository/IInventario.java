package com.grupozeus.telecom.repository;

import java.util.List;

import com.grupozeus.telecom.Entitys.Inventario;
import com.grupozeus.telecom.Entitys.Sil;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IInventario extends JpaRepository<Inventario, Integer> {
    
    public Inventario findByCodigoBarras(String codigoBarras);

    public List<Inventario> findBySil(Sil sil);

       
}
