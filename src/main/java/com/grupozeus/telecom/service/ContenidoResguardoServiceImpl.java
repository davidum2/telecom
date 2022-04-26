package com.grupozeus.telecom.service;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.grupozeus.telecom.Entitys.ContenidoResguardo;
import com.grupozeus.telecom.Entitys.ResguardosPDF;
import com.grupozeus.telecom.Entitys.Rol;
import com.grupozeus.telecom.commons.GenericServiceImplements;
import com.grupozeus.telecom.repository.IContenidoResguardo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
@Transactional
public class ContenidoResguardoServiceImpl extends GenericServiceImplements<ContenidoResguardo, Long> implements IContenidoResguardoService {

    @Autowired
    private IContenidoResguardo contenidoResguardo;

    @Autowired
    private IPersonaService rolPersona;

    @Autowired
    private IRolService rol;
	
    
    @Override
	public CrudRepository<ContenidoResguardo, Long> getDao() {
		return contenidoResguardo;
	}
    
   
    //@NotNull
    @Override
    public ResponseEntity<Resource> exportResguardo(Long idResguardoPDF, int idpersona) {
     List<ContenidoResguardo> cResguardo = contenidoResguardo.encntarParaResguardo(idResguardoPDF, idpersona);
     long controladorID = 1, subsidiarioID = 2;
     Rol controlador = rol.get(controladorID), subsidiario = rol.get(subsidiarioID);
      
    if (cResguardo != null) {
      try {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd ' de ' MMMM ' de ' yyyy"); 

        
        
        ContenidoResguardo datos = cResguardo.get(0);  
        final ResguardosPDF resguardosPDF = datos.getResguardoPDF();
        final File file = ResourceUtils.getFile("classpath:Resguardo2.jasper");

        final File image = ResourceUtils.getFile("classpath:images/sedena.png");
        final JasperReport report = (JasperReport) JRLoader.loadObject(file);

        final HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("imgLogo", new FileInputStream(image));
        parameters.put("responsableAbreviado", resguardosPDF.getResguardante().getAbreviadoCompleto());
        parameters.put("ds", new JRBeanArrayDataSource(cResguardo.toArray()));
        parameters.put("valorTotal", resguardosPDF.getValorTotal());
        parameters.put("cantidadBienes", resguardosPDF.getCantidadArticulos());
        parameters.put("fecha", fecha.format(format));
        parameters.put("cargoRolControlador", controlador.getPersona().getGradoYEmpleoAbreviado() 
                                      + " " + controlador.getDescripcion());
                                    //  "(" + controlador.getPersona().getMatricula() +")"
        parameters.put("nombreControlador", controlador.getPersona().getNombreCompleto());
        parameters.put("matriculacontrolador","(" + controlador.getPersona().getMatricula() +")" );
        parameters.put("matriculaSubsidiario", "(" + subsidiario.getPersona().getMatricula() +")" );
        parameters.put("gradoResponsable", resguardosPDF.getResguardante().getGradoYEmpleoAbreviado());
        parameters.put("nombreResponsable", resguardosPDF.getResguardante().getNombreCompleto());
        parameters.put("matriculaResponsable", "(" + resguardosPDF.getResguardante().getMatricula()+")");
        parameters.put("matriculaResponsable", "(" + resguardosPDF.getResguardante().getMatricula()+")");
        parameters.put("nombreSubsidiario", subsidiario.getPersona().getNombreCompleto());
        parameters.put("empleoSubsidiario", subsidiario.getPersona().getGradoYEmpleoAbreviado() + subsidiario.getDescripcion());
        

        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
        byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);
        String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
        StringBuilder stringBuilder = new StringBuilder().append("ResguardoPDF:");
        ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
            .filename(stringBuilder.append(resguardosPDF.getIdResguardosPDF())
                .append("generateDate:")
                .append(sdf)
                .append(".pdf")
                .toString())
            .build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(contentDisposition);
        return ResponseEntity.ok().contentLength((long) reporte.length)
            .contentType(MediaType.APPLICATION_PDF)
            .headers(headers).body(new ByteArrayResource(reporte));
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      return ResponseEntity.noContent().build(); //No se encontro el reporte
    }
    return null;
  }
}
