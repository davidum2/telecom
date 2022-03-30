package com.grupozeus.telecom.service;
import com.grupozeus.telecom.Entitys.ResguardosPDF;
import com.grupozeus.telecom.commons.GenericServiceAPI;


public interface IResguardosPDFService extends GenericServiceAPI<ResguardosPDF, Long> {

    public ResguardosPDF inicarResguardo(ResguardosPDF resguardosPDF);

    
    
}




