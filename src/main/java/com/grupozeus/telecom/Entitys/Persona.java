package com.grupozeus.telecom.Entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="persona")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_persona")
    private int idpersona;

    private String matricula;

    private String grado;


    @Column(name="grado_abreviado")
    private String gradoAbreviado;

    @Column(name="empleo_completo")
    private String empleoCompleto;

    @Column(name="empleo_abreviado")
    private String empleoAbreviado;

    @Column(name="nombre_completo")
    private String nombreCompleto;

    private String cargo;

    private String unidad;

    public String getAbreviadoCompleto(){
        return this.gradoAbreviado != null && this.empleoAbreviado != null &&  this.nombreCompleto != null ?
                this.gradoAbreviado + " " + this.empleoAbreviado + " " + this.nombreCompleto : "---";
    }


   


}
