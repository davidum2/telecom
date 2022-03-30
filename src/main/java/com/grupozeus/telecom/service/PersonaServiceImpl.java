package com.grupozeus.telecom.service;
import com.grupozeus.telecom.Entitys.Persona;
import com.grupozeus.telecom.commons.GenericServiceImplements;
import com.grupozeus.telecom.repository.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaServiceImpl extends GenericServiceImplements<Persona, Integer> implements IPersonaService {

    @Autowired
    private IPersona personaDao;

    @Override
    public CrudRepository<Persona, Integer> getDao() {
        return personaDao;
    }


}
