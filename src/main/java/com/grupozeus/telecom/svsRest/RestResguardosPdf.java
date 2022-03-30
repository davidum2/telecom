package com.grupozeus.telecom.svsRest;

import java.util.List;

import com.grupozeus.telecom.Entitys.ResguardosPDF;
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
@RequestMapping("/api/ResguardoPDF")
@CrossOrigin("*")
public class RestResguardosPdf  {
    
    @Autowired
    public IResguardosPDFService resguardoDao;
   
    @GetMapping("/")
    public List<ResguardosPDF> listarResguardosPDFs(){
        return resguardoDao.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResguardosPDF>  seleccionarResguardosPDF(@PathVariable("id") Long id){
        ResguardosPDF ResguardosPDF = resguardoDao.get(id);
        return new ResponseEntity<ResguardosPDF>(ResguardosPDF,HttpStatus.OK);
    }

    @PostMapping(value = "/guardarResguardosPDF")
    public ResponseEntity<ResguardosPDF> save(@RequestBody ResguardosPDF ResguardosPDF){
        ResguardosPDF obj = resguardoDao.save(ResguardosPDF);
        return new ResponseEntity<ResguardosPDF>(obj, HttpStatus.OK);

    }

    @GetMapping(value = "/inicarResguardo")
    public ResponseEntity<ResguardosPDF> iniciarResguardo(){
        ResguardosPDF iniciarRes = new ResguardosPDF();
        iniciarRes.setCantidadArticulos(0);
        iniciarRes.setValorTotal(0);
        iniciarRes = resguardoDao.inicarResguardo(iniciarRes);
        return new ResponseEntity<ResguardosPDF>(iniciarRes, HttpStatus.OK);

    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<ResguardosPDF> delete(@PathVariable Long id){
        ResguardosPDF ResguardosPDF = resguardoDao.get(id);
        if (ResguardosPDF != null){
            resguardoDao.delete(id);
        }else{
            return new ResponseEntity<ResguardosPDF>(ResguardosPDF, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ResguardosPDF>(ResguardosPDF, HttpStatus.OK);
    }

}
