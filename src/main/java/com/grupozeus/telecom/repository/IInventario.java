package com.grupozeus.telecom.repository;

import com.grupozeus.telecom.Entitys.Inventario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventario extends JpaRepository<Inventario, Long> {
    
}
