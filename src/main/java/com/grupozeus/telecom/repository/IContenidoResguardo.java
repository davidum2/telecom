package com.grupozeus.telecom.repository;

import java.util.List;

import com.grupozeus.telecom.Entitys.ContenidoResguardo;
import com.grupozeus.telecom.Entitys.ResguardoCompleto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface IContenidoResguardo extends JpaRepository<ContenidoResguardo, Long> {   
    
    @Query("SELECT C FROM ContenidoResguardo C WHERE C.resguardoPDF.idResguardosPDF=:idResguardoPDF AND C.resguardoPDF.resguardante.idpersona =:idpersona")
    public List<ContenidoResguardo> encntarParaResguardo(Long idResguardoPDF, int idpersona);

}




