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

    public Persona(int idpersona, String matricula, String grado, String gradoAbreviado, String empleoCompleto,
            String empleoAbreviado, String nombreCompleto, String cargo, String unidad) {
        this.idpersona = idpersona;
        this.matricula = matricula;
        this.grado = grado;
        this.gradoAbreviado = gradoAbreviado;
        this.empleoCompleto = empleoCompleto;
        this.empleoAbreviado = empleoAbreviado;
        this.nombreCompleto = nombreCompleto;
        this.cargo = cargo;
        this.unidad = unidad;
    }

    public Persona() {
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getGradoAbreviado() {
        return gradoAbreviado;
    }

    public void setGradoAbreviado(String gradoAbreviado) {
        this.gradoAbreviado = gradoAbreviado;
    }

    public String getEmpleoCompleto() {
        return empleoCompleto;
    }

    public void setEmpleoCompleto(String empleoCompleto) {
        this.empleoCompleto = empleoCompleto;
    }

    public String getEmpleoAbreviado() {
        return empleoAbreviado;
    }

    public void setEmpleoAbreviado(String empleoAbreviado) {
        this.empleoAbreviado = empleoAbreviado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

   


}
