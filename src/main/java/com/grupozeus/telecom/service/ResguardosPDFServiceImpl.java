package com.grupozeus.telecom.service;

import com.grupozeus.telecom.Entitys.ResguardosPDF;
import com.grupozeus.telecom.commons.GenericServiceImplements;
import com.grupozeus.telecom.repository.IResguardoPDF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ResguardosPDFServiceImpl extends GenericServiceImplements<ResguardosPDF, Long> implements IResguardosPDFService  {

    @Autowired
    private IResguardoPDF resguardoPDFDao;
	@Override
	public CrudRepository<ResguardosPDF, Long> getDao() {
		
		return resguardoPDFDao;
	}
	@Override
	public ResguardosPDF inicarResguardo(ResguardosPDF resguardosPDF) {
		return resguardoPDFDao.saveAndFlush(resguardosPDF);
	}
	
}
