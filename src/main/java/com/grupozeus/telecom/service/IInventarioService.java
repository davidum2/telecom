package com.grupozeus.telecom.service;



import java.util.List;

import com.grupozeus.telecom.Entitys.Inventario;
import com.grupozeus.telecom.commons.GenericServiceAPI;

public interface IInventarioService extends GenericServiceAPI<Inventario, Integer> {

    public Inventario encontrarPorCodigoBarras(String codigoBarras);

    public List<Inventario> encontrarPorSil(String idSil);

   

}
