package com.grupozeus.telecom.svsRest;

import java.util.List;

import com.grupozeus.telecom.Entitys.ResguardoCompleto;
import com.grupozeus.telecom.Entitys.ResguradoCompletoPK;
import com.grupozeus.telecom.service.IResguardoCompletoService;

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
@RequestMapping("/api/ResCompl")
public class ResCompletoRset {
    
    @Autowired
    private IResguardoCompletoService resguardoService;

    @GetMapping("/")
    public List<ResguardoCompleto> listarTodo(){
        return resguardoService.getAll();
        
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResguardoCompleto>  seleccionarPersona(@PathVariable("id") ResguradoCompletoPK id){
        ResguardoCompleto rc = resguardoService.get(id);
        return new ResponseEntity<ResguardoCompleto>(rc, HttpStatus.OK);
    }

    @GetMapping(value = "/BuscarPorSil/{sil}")
    public ResponseEntity<List<ResguardoCompleto>>  seleccionarporSil(@PathVariable("sil") String sil){
        List<ResguardoCompleto> rc = resguardoService.encontrarPorSil(sil);
        return new ResponseEntity<List<ResguardoCompleto>>(rc, HttpStatus.OK);
    }

    @PostMapping(value = "/guardarResCompl")
    public ResponseEntity<ResguardoCompleto> save(@RequestBody ResguardoCompleto resguardoCompleto){
        ResguardoCompleto obj = resguardoService.save(resguardoCompleto);
        return new ResponseEntity<ResguardoCompleto>(obj, HttpStatus.OK);

    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<ResguardoCompleto> delete(@PathVariable ResguradoCompletoPK id){
        ResguardoCompleto obj = resguardoService.get(id);
        if (obj != null){
            resguardoService.delete(id);;
        }else{
            return new ResponseEntity<ResguardoCompleto>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ResguardoCompleto>(obj, HttpStatus.OK);
    }

}
