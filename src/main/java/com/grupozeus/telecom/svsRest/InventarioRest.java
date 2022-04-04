package com.grupozeus.telecom.svsRest;

import java.util.List;

import com.grupozeus.telecom.Entitys.Inventario;
import com.grupozeus.telecom.service.IInventarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Inventario")
@CrossOrigin(origins = "*")
public class InventarioRest {
   
   
        @Autowired
        public IInventarioService inventarioService;
    
        @GetMapping("/")
        public List<Inventario> listarInventarios(){
            return inventarioService.getAll();
        }
    
        @GetMapping("/buscarPorId/{id}")
        public ResponseEntity<Inventario>  seleccionarInventarioPorId(@PathVariable("id") Integer id){
            Inventario inventario = inventarioService.get(id);
            return new ResponseEntity<Inventario>(inventario,HttpStatus.OK);
        }

          


        @GetMapping(value = "/busqueda/cb/{codigoBarra}")
        public ResponseEntity<Inventario>  seleccionarInventaroPorCodigoBarras(@PathVariable("codigoBarra") String codigoBarras){
            Inventario inventario = inventarioService.encontrarPorCodigoBarras(codigoBarras);
            return new ResponseEntity<Inventario>(inventario,HttpStatus.OK);
        }



        @GetMapping(value = "/busqueda/sil/{sil}")
        @ResponseStatus(HttpStatus.OK)
        public List<Inventario>  seleccionarInventaroPorSil(@PathVariable("sil") String idSil){
            List<Inventario> inventario = inventarioService.encontrarPorSil(idSil);
            return inventario;
        }
    
        @PostMapping(value = "/guardarInventario/")
        public ResponseEntity<Inventario> save(@RequestBody Inventario inventario){
            Inventario obj = inventarioService.save(inventario);
            return new ResponseEntity<Inventario>(obj, HttpStatus.OK);
    
        }
    
        @GetMapping(value = "/delete/{id}")
        public ResponseEntity<Inventario> delete(@PathVariable Integer id){
            Inventario inventario = inventarioService.get(id);
            if (inventario != null){
                inventarioService.delete(id);
            }else{
                return new ResponseEntity<Inventario>(inventario, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    
            return new ResponseEntity<Inventario>(inventario, HttpStatus.OK);
        }   
}
