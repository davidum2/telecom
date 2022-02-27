package com.grupozeus.telecom.Entitys;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="datos_resguardo")
public class DatosResguardo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idresguardo")
    private int idResguardo;

    private Date fecha;

    private int estado;

    @OneToOne
    @JoinColumn(name="idPersona")
    private Persona resguardante;

    @ManyToOne
    @JoinColumn(name="idRol")
    private Persona controlador;
    
    @ManyToOne
    @JoinColumn(name="idRol1")
    private Persona subsidiario;
    
    @ManyToOne
    @JoinColumn(name="idUnidad")
    private Unidad unidad;

    @Override
public boolean equals(Object o) {
    if(this == o){
        return true;
    }
    if(o == null||getClass() != o.getClass()){
        return false;
    }
    DatosResguardo datosResguardo = (DatosResguardo) o;
    return Objects.equals(idResguardo, datosResguardo.idResguardo);

}

@Override
public int hashCode() {
    return Objects.hash(idResguardo);
}

}
