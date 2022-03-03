package com.grupozeus.telecom.repository;

import java.util.List;

import com.grupozeus.telecom.Entitys.Sil;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ISil extends JpaRepository<Sil, String> {
    public List<Sil> findByDescripcionContaining(String descripcion); 
}
