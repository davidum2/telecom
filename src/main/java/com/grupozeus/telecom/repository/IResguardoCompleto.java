package com.grupozeus.telecom.repository;

import com.grupozeus.telecom.Entitys.ResguardoCompleto;
import com.grupozeus.telecom.Entitys.ResguradoCompletoPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IResguardoCompleto extends JpaRepository<ResguardoCompleto, ResguradoCompletoPK> {
    
}
