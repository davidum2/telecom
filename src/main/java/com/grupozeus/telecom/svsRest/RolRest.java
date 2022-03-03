package com.grupozeus.telecom.svsRest;

import java.util.List;


import com.grupozeus.telecom.Entitys.Rol;

import com.grupozeus.telecom.service.IRolService;

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
@RequestMapping("/api/Rol")
public class RolRest {
   
   
        @Autowired
        public IRolService rolService;
    
        @GetMapping("/")
        public List<Rol> listarRoles(){
            return rolService.getAll();
        }
    
        @GetMapping("/{id}")
        public ResponseEntity<Rol>  seleccionarRolPorId(@PathVariable("id") Long id){
            Rol rol = rolService.get(id);
            return new ResponseEntity<Rol>(rol,HttpStatus.OK);
        }

           
        @PostMapping(value = "/guardarRol")
        public ResponseEntity<Rol> save(@RequestBody Rol rol){
            Rol obj = rolService.save(rol);
            return new ResponseEntity<Rol>(obj, HttpStatus.OK);
    
        }
    
        @GetMapping(value = "/delete/{id}")
        public ResponseEntity<Rol> delete(@PathVariable Long id){
            Rol rol = rolService.get(id);
            if (rol != null){
                rolService.delete(id);
            }else{
                return new ResponseEntity<Rol>(rol, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    
            return new ResponseEntity<Rol>(rol, HttpStatus.OK);
        }   
}
