package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.DatosMult;
import com.app.uteqbackend.model.PlantillaEmail;
import com.app.uteqbackend.repository.DatosMultRepository;
import com.app.uteqbackend.repository.RequerimientoCertfRepository;
import com.app.uteqbackend.service.RequerimientoCertfService;
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
public class RequerimientoCertfServiceImpl implements RequerimientoCertfService {

    //<editor-fold defaultstate="collapsed" desc="DECLARATION OF VARIABLES AND CONSTRUCTORS">
    private RequerimientoCertfRepository objRequerimientoCertfRepository;
    private DatosMultRepository objDatosMultRepository;
    private JavaMailSender objJavaMailSender;
    
    @Autowired
    public RequerimientoCertfServiceImpl(RequerimientoCertfRepository objRequerimientoCertfRepository, DatosMultRepository objDatosMultRepository, JavaMailSender objJavaMailSender) {
        super();
        this.objRequerimientoCertfRepository = objRequerimientoCertfRepository;
        this.objDatosMultRepository = objDatosMultRepository;
        this.objJavaMailSender = objJavaMailSender;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public RequerimientoCertfRepository getObjRequerimientoCertfRepository() {
        return objRequerimientoCertfRepository;
    }
    
    public void setObjRequerimientoCertfRepository(RequerimientoCertfRepository objRequerimientoCertfRepository) {
        this.objRequerimientoCertfRepository = objRequerimientoCertfRepository;
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
    public String registerRequestCertification(String cedula, String nombreComp, String correoElect, int tipoCertf, String mensaje) {
        int codDestinatario = 110;
        String msgOutput = objRequerimientoCertfRepository.registerRequestCertification(cedula, nombreComp, correoElect, tipoCertf, mensaje), correoDest;
        if (msgOutput.trim().equals("TCFREX")) {
            correoDest = objDatosMultRepository.getInfoDataMultById(codDestinatario).getDmCorreoElect().trim().toLowerCase();
            sendEmailSuggestion(correoDest, mensaje, cedula, nombreComp, correoElect, tipoCertf);
        }
        return msgOutput;
    }
    
    public void sendEmailSuggestion(String correoDest, String mensaje, String cedula, String nombreComp, String correoElect, int codTipoCertf) {
        String msj1 = "", tipoCertf = "", asunto = "";
        SimpleMailMessage objSimpleMailMessage = new SimpleMailMessage();
        PlantillaEmail objTempReqCertf = new PlantillaEmail();
        DatosMult objDatoMult = new DatosMult();
        //Para prueba
        //correoDest="stevencortezchichande@gmail.com";
        
        objTempReqCertf = objDatosMultRepository.getInformationTemplateEmail("SLCTF");
        objDatoMult = objDatosMultRepository.getInfoDataMultById(codTipoCertf);
        tipoCertf = (objDatoMult!=null ? objDatoMult.getDmDescripcion().trim() :"Certificado UTH");
        asunto="REQUERIMIENTO DE "+tipoCertf.toUpperCase();
        
        if (!objTempReqCertf.getPePlantilla().isEmpty()) {
            msj1 = objTempReqCertf.getPePlantilla().trim();
            msj1 = msj1.replace("VAL_CEDULA", cedula.trim());
            msj1 = msj1.replace("VAL_SOLICITANTE", nombreComp.trim());
            msj1 = msj1.replace("VAL_CORREO_ELECT", correoElect.trim());
            msj1 = msj1.replace("VAL_TIPO_CERTF", tipoCertf.trim());
            msj1 = msj1.replace("VAL_MENSAJE", mensaje.trim());
            sendEmailHTMLUser(correoDest, asunto, msj1, correoElect.trim());
        } else {
            objSimpleMailMessage.setTo(correoDest);
            objSimpleMailMessage.setCc(correoElect.trim());
            objSimpleMailMessage.setSubject(asunto);
            mensaje = "C.I del solicitante: " + cedula.trim() + "\n\n" + "Nombre del solicitante: " + nombreComp.trim() + "\n\n" + "Correo electrónico: " + correoElect.trim() + "\n\n" + "Tipo de certificado: " + tipoCertf.trim()
                    + "\n\n" + "Requerimiento: " + mensaje.trim();
            objSimpleMailMessage.setText(mensaje.trim());
            objJavaMailSender.send(objSimpleMailMessage);
        }
    }
    
    public void sendEmailHTMLUser(String correoDest, String asunto, String mensaje, String cc) {
        try {
            MimeMessage mimeMessage = objJavaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(mensaje, true);
            helper.setTo(correoDest);
            if (!cc.isEmpty()) {
                helper.setCc(cc);
            }
            helper.setSubject(asunto.trim().toUpperCase());
            
            objJavaMailSender.send(mimeMessage);
        } catch (MessagingException ex) {
            Logger.getLogger(CarreraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//</editor-fold>

}
