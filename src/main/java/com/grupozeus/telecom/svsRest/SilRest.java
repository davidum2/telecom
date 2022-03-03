package com.grupozeus.telecom.svsRest;

import java.util.List;

import com.grupozeus.telecom.Entitys.Sil;
import com.grupozeus.telecom.service.ISilService;

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
@RequestMapping("/api/Sil")
public class SilRest {
   
   
        @Autowired
        private ISilService silService;
    
        @GetMapping("/")
        public List<Sil> listarSil(){
            return silService.getAll();
        }
    
        @GetMapping(value = "/{id}")
        public ResponseEntity<Sil>  seleccionarSilPorId(@PathVariable("id") String id){
            Sil sil = silService.get(id);
            if (sil != null){
                return new ResponseEntity<Sil>(sil,HttpStatus.OK);
            }
            return new ResponseEntity<Sil>(sil, HttpStatus.NOT_FOUND);
            
        }

        @GetMapping(value = "/buscar/{descripcion}")
        public ResponseEntity<List<Sil>>  seleccionarSilPorDescripcion(@PathVariable("descripcion") String descripcion){
            List<Sil> listResult = silService.findByDescripcion(descripcion); 
            if (listResult == null || listResult.isEmpty()){
                System.out.println("no encontrado");
                return new ResponseEntity<List<Sil>>(listResult, HttpStatus.NOT_FOUND);
            }else{
                
                for (Sil s  : listResult) {
                    System.out.println(s.getDescripcion());
                }
                return  new ResponseEntity<List<Sil>>(listResult, HttpStatus.OK);
            }

            
        }
    
        @PostMapping(value = "/guardarSil")
        public ResponseEntity<Sil> save(@RequestBody Sil sil){
            Sil obj = silService.save(sil);
            return new ResponseEntity<Sil>(obj, HttpStatus.OK);
    
        }
    
        @GetMapping(value = "/delete/{id}")
        public ResponseEntity<Sil> delete(@PathVariable String id){
            Sil sil = silService.get(id);
            if (sil != null){
                silService.delete(id);
            }else{
                return new ResponseEntity<Sil>(sil, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
            return new ResponseEntity<Sil>(sil, HttpStatus.OK);
        }   
}
