package com.grupozeus.telecom.Entitys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="inventario_has_datos_resguardo")
@IdClass(ResguradoCompletoPK.class)
public class ResguardoCompleto implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name="inventario_idinventario")
    private Inventario inventario;
    
    @Id
    @ManyToOne
    @JoinColumn(name="datos_resguardo_id_resguardo")
    private DatosResguardo datosResguardo;

    public ResguardoCompleto(Inventario inventario, DatosResguardo datosResguardo) {
        this.inventario = inventario;
        this.datosResguardo = datosResguardo;
    }

    public ResguardoCompleto() {
    }

    @Override
    public boolean equals(Object o) {
        
        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }
        
        ResguardoCompleto resguardoCompleto =(ResguardoCompleto) o;
        return Objects.equals(inventario, resguardoCompleto.inventario) && Objects.equals(datosResguardo,
         resguardoCompleto.datosResguardo);
        
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventario,datosResguardo);
    }

   


}
