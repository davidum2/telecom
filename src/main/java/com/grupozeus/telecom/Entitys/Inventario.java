package com.grupozeus.telecom.Entitys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



import lombok.Data;

@Data
@Entity
public class Inventario implements Serializable {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idinventario;

private String descripcion;

@Column(name="codigo_barra")
private String codigoBarras;

private String estado;

private String ubicacion;

@ManyToOne (cascade = {CascadeType.ALL})
@JoinColumn(name="sil_idsil")
private Sil sil;

@Override
public boolean equals(Object o) {
    if(this == o){
        return true;
    }
    if(o == null||getClass() != o.getClass()){
        return false;
    }
    Inventario inventario = (Inventario) o;
    return Objects.equals(idinventario, inventario.idinventario);

}

@Override
public int hashCode() {
    return Objects.hash(idinventario);
}

}

