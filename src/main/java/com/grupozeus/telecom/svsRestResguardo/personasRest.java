package com.grupozeus.telecom.svsRestResguardo;

import java.util.List;

import com.grupozeus.telecom.Entitys.Persona;
import com.grupozeus.telecom.service.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Personas")
public class personasRest {
    
   

    @Autowired
    public IPersonaService personaService;

    @GetMapping("/")
    public List<Persona> listarPersonas(){
        return personaService.listarTodos();
    }

    @GetMapping(value = "/{id}")
    public Persona  seleccionarPersona(@PathVariable("id") Integer id){

    return personaService.encontrarPorId(id);
    }

    @PostMapping("/guardarPersona")
    public void guardarPersona(Persona persona){
        personaService.guardar(persona);
    }

}
