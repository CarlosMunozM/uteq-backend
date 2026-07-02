package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.PlantillaEmail;
import com.app.uteqbackend.repository.DatosMultRepository;
import com.app.uteqbackend.repository.SugerenciaRepository;
import com.app.uteqbackend.service.SugerenciaService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Service
public class SugerenciaServiceImpl implements SugerenciaService{
    
    //<editor-fold defaultstate="collapsed" desc="DECLARATION OF VARIABLES AND CONSTRUCTORS">
    private SugerenciaRepository objSugerenciaRepository;
    private DatosMultRepository objDatosMultRepository;
    private JavaMailSender objJavaMailSender;
    
    @Autowired
    public SugerenciaServiceImpl(SugerenciaRepository objSugerenciaRepository, DatosMultRepository objDatosMultRepository, JavaMailSender objJavaMailSender) {
        super();
        this.objSugerenciaRepository = objSugerenciaRepository;
        this.objDatosMultRepository = objDatosMultRepository;
        this.objJavaMailSender = objJavaMailSender;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public SugerenciaRepository getObjSugerenciaRepository() {
        return objSugerenciaRepository;
    }
    
    public void setObjSugerenciaRepository(SugerenciaRepository objSugerenciaRepository) {
        this.objSugerenciaRepository = objSugerenciaRepository;
    }
    
    public DatosMultRepository getObjDatosMultRepository() {
        return objDatosMultRepository;
    }
    
    public void setObjDatosMultRepository(DatosMultRepository objDatosMultRepository) {
        this.objDatosMultRepository = objDatosMultRepository;
    }
    
    public JavaMailSender getObjJavaMailSender() {
        return objJavaMailSender;
    }
    
    public void setObjJavaMailSender(JavaMailSender objJavaMailSender) {
        this.objJavaMailSender = objJavaMailSender;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public String registerDataSuggestion(String nombre, String correoElect, int destinatario, String asunto, String mensaje) {
        String msgOutput=objSugerenciaRepository.registerDataSuggestion(nombre, correoElect, destinatario, asunto, mensaje), correoDest, msgEmail="";
        PlantillaEmail objTempSugr=new PlantillaEmail();
        if(msgOutput.trim().equals("SUGREX")){
            correoDest=objDatosMultRepository.getInfoDataMultById(destinatario).getDmCorreoElect().trim().toLowerCase();
            objTempSugr = objDatosMultRepository.getInformationTemplateEmail("SUGGN");
            
            if(!objTempSugr.getPePlantilla().isEmpty()){
                msgEmail = objTempSugr.getPePlantilla().trim();
                msgEmail = msgEmail.replace("VAL_REMITENTE", nombre.trim());
                msgEmail = msgEmail.replace("VAL_CORREO_ELECT", correoElect.trim());
                msgEmail = msgEmail.replace("VAL_MENSAJE", mensaje.trim());
                sendEmailHTMLUser(correoDest, asunto, msgEmail, correoElect);
            }else{
                msgEmail="Remitente: "+nombre.trim()+"\n\n"+mensaje.trim();
                sendEmailSuggestion(correoDest, asunto, msgEmail, nombre, correoElect);
            }
            
        }
        return msgOutput;
    }
    
    @Override
    public String registerDataSupportAdmission(String nombre, String correoElect, String destinatario, String asunto, String mensaje) {
        String msgOutput=objSugerenciaRepository.registerTicketSupportAdmission(nombre, correoElect, destinatario, asunto, mensaje), correoDest, msgEmail="";
        PlantillaEmail objTempSugr=new PlantillaEmail();
        if(msgOutput.trim().equals("SUGREX")){
            objTempSugr = objDatosMultRepository.getInformationTemplateEmail("TSADM");
            
            if(!objTempSugr.getPePlantilla().isEmpty()){
                msgEmail = objTempSugr.getPePlantilla().trim();
                msgEmail = msgEmail.replace("VAL_REMITENTE", nombre.trim());
                msgEmail = msgEmail.replace("VAL_CORREO_ELECT", correoElect.trim());
                msgEmail = msgEmail.replace("VAL_MENSAJE", mensaje.trim());
                sendEmailHTMLUser(destinatario, asunto, msgEmail, correoElect);
            }else{
                msgEmail="Remitente: "+nombre.trim()+"\n\n"+mensaje.trim();
                sendEmailSuggestion(destinatario, asunto, msgEmail, nombre, correoElect);
            }
        }
        return msgOutput;
    }
    
    public void sendEmailSuggestion(String correoDest,String asunto, String mensaje, String nombreComp, String correoElectCC){
        SimpleMailMessage objSimpleMailMessage=new SimpleMailMessage();
        objSimpleMailMessage.setTo(correoDest);
        objSimpleMailMessage.setCc(correoElectCC.trim());
        objSimpleMailMessage.setSubject(asunto.trim().toUpperCase());
        //mensaje="Remitente: "+nombreComp.trim()+"\n\n"+mensaje.trim();
        objSimpleMailMessage.setText(mensaje.trim());
        objJavaMailSender.send(objSimpleMailMessage);
    }
    
    public void sendEmailHTMLUser(String correoDest, String asunto, String mensaje, String correoElectCC) {
        try {
            MimeMessage mimeMessage = objJavaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(mensaje, true);
            helper.setTo(correoDest);
            helper.setCc(correoElectCC.trim());
            helper.setSubject(asunto.trim().toUpperCase());
            objJavaMailSender.send(mimeMessage);
        } catch (MessagingException ex) {
            Logger.getLogger(CarreraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//</editor-fold>
    
}
