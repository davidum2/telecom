package com.grupozeus.telecom.Entitys;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;

@Data
@Entity
public class Inventario {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idinventario;

private String descripcion;

@Column(name="codigo_barra")
private String codigoBarras;

private String estado;

@ManyToOne
@JoinColumn(name="idsil")
private Sil sil;

}
