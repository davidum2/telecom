package com.grupozeus.telecom.svsRest;

import java.util.List;

import com.grupozeus.telecom.Entitys.Persona;
import com.grupozeus.telecom.service.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Personas")
public class personasRest {
    
    @Autowired
    public IPersonaService personaService;

    @GetMapping("/")
    public List<Persona> listarPersonas(){
        return personaService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Persona>  seleccionarPersona(@PathVariable("id") Integer id){
        Persona persona = personaService.get(id);
        return new ResponseEntity<Persona>(persona,HttpStatus.OK);
    }

    @PostMapping(value = "/guardarPersona")
    public ResponseEntity<Persona> save(@RequestBody Persona persona){
        Persona obj = personaService.save(persona);
        return new ResponseEntity<Persona>(obj, HttpStatus.OK);

    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Persona> delete(@PathVariable Integer id){
        Persona persona = personaService.get(id);
        if (persona != null){
            personaService.delete(id);
        }else{
            return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }

}
