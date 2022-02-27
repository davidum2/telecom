package com.grupozeus.telecom.Entitys;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ResguradoCompletoPK implements Serializable {
    
   
    private Inventario inventario;
    
   
    private DatosResguardo datosResguardo;
}
