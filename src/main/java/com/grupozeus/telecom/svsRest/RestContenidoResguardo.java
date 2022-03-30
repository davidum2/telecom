package com.grupozeus.telecom.svsRest;

import java.util.List;

import com.grupozeus.telecom.Entitys.ContenidoResguardo;
import com.grupozeus.telecom.service.IContenidoResguardoService;
import com.grupozeus.telecom.service.IResguardosPDFService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ContenidoResguardo")
@CrossOrigin("*")
public class RestContenidoResguardo {
    
    @Autowired
    public IContenidoResguardoService contenidoDao;

    @Autowired
    public IResguardosPDFService resguardoService;
   
    @GetMapping("/")
    public List<ContenidoResguardo> listarContenidoResguardos(){
        return contenidoDao.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContenidoResguardo>  seleccionarContenidoResguardo(@PathVariable("id") Long id){
        ContenidoResguardo contenidoResguardo = contenidoDao.get(id);
        return new ResponseEntity<ContenidoResguardo>(contenidoResguardo,HttpStatus.OK);
    }

    @PostMapping(value = "/guardarContenidoResguardo")
    public ResponseEntity<ContenidoResguardo> save(@RequestBody ContenidoResguardo contenidoResguardo){
        resguardoService.save(contenidoResguardo.getResguardoPDF());
        contenidoDao.save(contenidoResguardo);
        return new ResponseEntity<ContenidoResguardo>(contenidoResguardo, HttpStatus.OK);

    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<ContenidoResguardo> delete(@PathVariable Long id){
        ContenidoResguardo contenidoResguardo = contenidoDao.get(id);
        if (contenidoResguardo != null){
            contenidoDao.delete(id);
        }else{
            return new ResponseEntity<ContenidoResguardo>(contenidoResguardo, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ContenidoResguardo>(contenidoResguardo, HttpStatus.OK);
    }

}