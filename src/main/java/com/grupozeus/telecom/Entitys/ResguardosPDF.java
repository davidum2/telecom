package com.grupozeus.telecom.Entitys;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="resguardospdf")
public class ResguardosPDF {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_resguardospdf")
    private Long idResguardosPDF;

    private double valorTotal;

    @Column(name="cantidad_articulos")
    private int cantidadArticulos;

    @ManyToOne (cascade = {CascadeType.MERGE})
    @JoinColumn(name="persona_id_persona")
    private Persona resguardante;

}
