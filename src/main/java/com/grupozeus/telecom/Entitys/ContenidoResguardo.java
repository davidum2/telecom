package com.grupozeus.telecom.Entitys;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="contenido_reportes")
public class ContenidoResguardo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_contenido_reportes")
    private Long idContenidoReportes;

    private String numeroInventario;

    private String descripcionString;

    private double valorUnitario;

    private String observaciones;
    
    @ManyToOne (cascade = {CascadeType.MERGE})
    @JoinColumn(name="resguardospdf_idresguardospdf")
    private ResguardosPDF resguardoPDF;

    
}
