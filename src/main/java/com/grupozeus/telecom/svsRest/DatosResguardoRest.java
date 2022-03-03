package com.grupozeus.telecom.svsRest;

import java.util.List;

import com.grupozeus.telecom.Entitys.DatosResguardo;
import com.grupozeus.telecom.service.IDatosResguardoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/DatosResguardo")
public class DatosResguardoRest {

    @Autowired
    private IDatosResguardoService datosService;

    @GetMapping("/")
        public List<DatosResguardo> listarDatos(){
            return datosService.getAll();
        }

}
