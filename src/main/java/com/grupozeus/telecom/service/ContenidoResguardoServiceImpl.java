package com.grupozeus.telecom.service;

import java.io.File;


import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;



import com.grupozeus.telecom.Entitys.ContenidoResguardo;
import com.grupozeus.telecom.Entitys.ResguardosPDF;
import com.grupozeus.telecom.commons.GenericServiceImplements;
import com.grupozeus.telecom.repository.IContenidoResguardo;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.repository.CrudRepository;
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
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
@Transactional
public class ContenidoResguardoServiceImpl extends GenericServiceImplements<ContenidoResguardo, Long> implements IContenidoResguardoService {

    @Autowired
    private IContenidoResguardo contenidoResguardo;
	
    @Override
	public CrudRepository<ContenidoResguardo, Long> getDao() {
		return contenidoResguardo;
	}
    
   
    //@NotNull
    @Override
    public ResponseEntity<Resource> exportResguardo(Long idResguardoPDF, int idpersona) {
     List<ContenidoResguardo> cResguardo = contenidoResguardo.encntarParaResguardo(idResguardoPDF, idpersona);
    
    if (cResguardo != null) {
      try {
        ContenidoResguardo datos = cResguardo.get(0);  
        final ResguardosPDF resguardosPDF = datos.getResguardoPDF();
        final File file = ResourceUtils.getFile("classpath:Resguardo2.jasper");
       // final File imgLogo = ResourceUtils.getFile("classpath:images/logoCevicheria.png");
        final JasperReport report = (JasperReport) JRLoader.loadObject(file);

        final HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("responsableAbreviado", resguardosPDF.getResguardante().getAbreviadoCompleto());
        parameters.put("ds", new JRBeanArrayDataSource(cResguardo.toArray()));

        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
        byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);
        String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
        StringBuilder stringBuilder = new StringBuilder().append("InvoicePDF:");
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
