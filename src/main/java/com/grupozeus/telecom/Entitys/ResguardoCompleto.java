package com.grupozeus.telecom.Entitys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="inventario_has_datos_resguardo")
public class ResguardoCompleto implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name="inventario_idinventario")
    private Inventario inventario;
    
    
    @ManyToOne
    @JoinColumn(name="idresguardo")
    private DatosResguardo datosResguardo;
}
