package com.grupozeus.telecom.repository;

import com.grupozeus.telecom.Entitys.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersona extends JpaRepository<Persona, Long> {
    
}
