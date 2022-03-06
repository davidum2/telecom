package com.grupozeus.telecom.service;



import java.util.List;

import com.grupozeus.telecom.Entitys.ResguardoCompleto;
import com.grupozeus.telecom.Entitys.ResguradoCompletoPK;
import com.grupozeus.telecom.commons.GenericServiceAPI;

public interface IResguardoCompletoService extends GenericServiceAPI<ResguardoCompleto, ResguradoCompletoPK> {
    
   public List<ResguardoCompleto> encontrarPorSil(String codigoBarra);

}
