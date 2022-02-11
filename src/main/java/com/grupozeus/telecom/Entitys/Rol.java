package com.grupozeus.telecom.Entitys;

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
@Table(name="rol")
public class Rol {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idRol;

private String descripcion;

@ManyToOne
@JoinColumn(name="idPersona")
private Persona persona;




}
