package com.grupozeus.telecom.Entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="persona")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpersona;

    private String matricula;

    private String grado;


    @Column(name="grado_abreviado")
    private String gradoAbreviado;

    private String empleo;

    @Column(name="empleo_abreviado")
    private String empleoAbreviado;

    @Column(name="nombre_completo")
    private String nombreCompleto;

    private String cargo;

    private String unidad;



}
