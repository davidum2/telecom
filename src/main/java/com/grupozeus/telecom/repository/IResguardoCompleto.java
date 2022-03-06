package com.grupozeus.telecom.repository;

import java.util.List;

import com.grupozeus.telecom.Entitys.Inventario;
import com.grupozeus.telecom.Entitys.ResguardoCompleto;
import com.grupozeus.telecom.Entitys.ResguradoCompletoPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IResguardoCompleto extends JpaRepository<ResguardoCompleto, ResguradoCompletoPK> {
 
    public List<ResguardoCompleto> findByInventario_Sil_IdsilContaining(String codigoBarra);

}
