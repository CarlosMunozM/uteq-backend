package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.AutoridadCar;
import com.app.uteqbackend.model.Carrera;
import com.app.uteqbackend.model.PlantillaEmail;
import com.app.uteqbackend.repository.AutoridadRepository;
import com.app.uteqbackend.repository.DatosMultRepository;
import com.app.uteqbackend.service.CarreraService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Service
public class CarreraServiceImpl implements CarreraService {

    //<editor-fold defaultstate="collapsed" desc="DECLARATION OF VARIABLES AND CONSTRUCTORS">
    private DatosMultRepository objDatosMultRepository;
    private JavaMailSender objJavaMailSender;
    private AutoridadRepository objAutoridadRepository;
    
    public CarreraServiceImpl(DatosMultRepository objDatosMultRepository, JavaMailSender objJavaMailSender, AutoridadRepository objAutoridadRepository) {
        super();
        this.objDatosMultRepository = objDatosMultRepository;
        this.objJavaMailSender = objJavaMailSender;
        this.objAutoridadRepository = objAutoridadRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public DatosMultRepository getObjDatosMultRepository() {
        return objDatosMultRepository;
    }
    
    public void setObjDatosMultRepository(DatosMultRepository objDatosMultRepository) {
        this.objDatosMultRepository = objDatosMultRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public List<Carrera> getListCareersUniversityByType(String codeDep) {
        return objDatosMultRepository.getListDataCareersUnivsByType(UUID.fromString(codeDep));
    }
    
    @Override
    public Carrera getInformationCareerUniversityByUrlParcial(String urlParcial) {
        return objDatosMultRepository.getInformationCareerByUrlParcial(urlParcial);
    }
    
    @Override 
    public String registerDataInscriptionMaster(String cedula, String nombreComp, String telefono, String correoElec, String codMaestria, String rutaBrochure) {
        Carrera objCarrera = new Carrera();
        AutoridadCar objAutoridad = new AutoridadCar();
        PlantillaEmail objTempInsc = new PlantillaEmail();
        PlantillaEmail objTempMatc = new PlantillaEmail();
        String msgOutput = objDatosMultRepository.registerDataInscription(cedula, nombreComp, correoElec, telefono, UUID.fromString(codMaestria), rutaBrochure.trim()), msj1 = "", msj2 = "", nmbMsc = "", correoDest = "";

        // correoDest = "relacionespublicas@uteq.edu.ec";
        if (msgOutput.trim().equals("INSREX")) {
            objCarrera = objDatosMultRepository.getInformationCareerByCode(UUID.fromString(codMaestria));
            nmbMsc = !objCarrera.getCrNombre().isEmpty() ? objCarrera.getCrNombre().trim() : "";
            objAutoridad = objAutoridadRepository.getInformationAuthorityCareer(UUID.fromString(codMaestria), 140);
            
            objTempInsc = objDatosMultRepository.getInformationTemplateEmail("INSMS");
            if (!objTempInsc.getPePlantilla().isEmpty()) {
                msj1 = objTempInsc.getPePlantilla().trim();
                correoDest = objAutoridad.getAuCorreoElect().trim();
                msj1 = msj1.replace("VAL_DNI", cedula.trim());
                msj1 = msj1.replace("VAL_POSTULANTE", nombreComp.trim());
                msj1 = msj1.replace("VAL_TELEFONO", telefono.replace(" ", ""));
                msj1 = msj1.replace("VAL_CORREO_ELECT", correoElec.trim());
                msj1 = msj1.replace("VAL_PROG_MSC", nmbMsc.trim());
                sendEmailHTMLUser(correoDest, "Solicitud de información de programa de Maestría - UTEQ", msj1, "posgrado@uteq.edu.ec");
            } else {
                msj1 = "Datos del inscrito" + "\n\n" + "C.I/Pasaporte: " + cedula.trim() + "\n\n" + "Postulante: " + nombreComp.trim() + "\n\n" + "Teléfono: " + telefono.replace(" ", "") + "\n\n" + "Correo electrónico: " + correoElec.trim() + "\n\n" + "Programa de Maestría: " + nmbMsc.trim();
                correoDest = objAutoridad.getAuCorreoElect().trim();
                sendEmailSuggestion(correoDest, "Solicitud de información de programa de Maestría - UTEQ", msj1, "posgrado@uteq.edu.ec");
            }
            
            objTempMatc = objDatosMultRepository.getInformationTemplateEmail("MATMS");
            if (!objTempMatc.getPePlantilla().isEmpty()) {
                msj2 = objTempMatc.getPePlantilla().trim();
                msj2 = msj2.replace("VAL_PROG_MSC", nmbMsc.trim());
                msj2 = msj2.replace("VAL_COORDN", (objAutoridad.getAuNombres().trim() + " " + objAutoridad.getAuApellidos().trim()));
                msj2 = msj2.replace("VAL_URL_BROC", ("https://www.uteq.edu.ec" + rutaBrochure + objCarrera.getCrUrlPdfBrochure().trim()));
                sendEmailHTMLUser(correoElec, "Información de programa de Maestría - Universidad Técnica Estatal de Quevedo", msj2, "");
            } else {
                msj2 = "Programa de Maestría: " + nmbMsc.trim() + "\n\n" + "Coordinador/a del programa: " + objAutoridad.getAuApellidos().trim() + " " + objAutoridad.getAuNombres().trim() + "\n\n" + "A continuación, se encuentra el link del brochure del programa: "
                        + "\n\n" + ("<a href='" + ("https://www.uteq.edu.ec/" + rutaBrochure + objCarrera.getCrUrlPdfBrochure().trim()) + "'>Brochure del programa de Maestría</a>");
                sendEmailSuggestion(correoElec, "Información de programa de Maestría - Universidad Técnica Estatal de Quevedo", msj2, "");
            }
            
        }
        return msgOutput;
    }
    
    public void sendEmailSuggestion(String correoDest, String asunto, String mensaje, String cc) {
        SimpleMailMessage objSimpleMailMessage = new SimpleMailMessage();
        objSimpleMailMessage.setTo(correoDest);
        if (!cc.isEmpty()) {
            objSimpleMailMessage.setCc(cc);
        }
        objSimpleMailMessage.setSubject(asunto.trim().toUpperCase());
        objSimpleMailMessage.setText(mensaje.trim());
        objJavaMailSender.send(objSimpleMailMessage);
    }
    
    public void sendMailWithAttachment(String correoDest, String asunto, String mensaje, String cc, List<File> listFilesBytes) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(correoDest));
                mimeMessage.setSubject(asunto);
                if (!cc.isEmpty()) {
                    mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
                }
                mimeMessage.setText(mensaje);
                
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                
                for (File filePdf : listFilesBytes) {
                    FileSystemResource fr = new FileSystemResource(filePdf);
                    helper.addAttachment(filePdf.getName(), fr);
                }
            }
        };
        
        try {
            objJavaMailSender.send(preparator);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
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
    
    public void sendEmailHTMLUserEnrollment(String correoDest, String asunto, String mensaje, String cc, List<File> listFilesBytes) {
        try {
            MimeMessage mimeMessage = objJavaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            helper.setText(mensaje, true);
            helper.setTo(correoDest);
            if (!cc.isEmpty()) {
                helper.setCc(cc);
            }
            helper.setSubject(asunto.trim().toUpperCase());
            
            for (File filePdf : listFilesBytes) {
                FileSystemResource fr = new FileSystemResource(filePdf);
                helper.addAttachment(filePdf.getName(), fr);
            }
            
            objJavaMailSender.send(mimeMessage);
        } catch (MessagingException ex) {
            System.out.println("Error en envío de correo de confirmación de matrícula: " + ex.getMessage());
        }
    }
    
    @Override
    public List<Carrera> getListCareersMatcUniversityByType(String codDepart) {
        return objDatosMultRepository.getListDataCareersMatcUnivsByType(UUID.fromString(codDepart));
    }
    
    @Override
    public String registerDataEnrollmentMaster(String cedula, String nombreComp, String telefono, String correoElec, String codMaestria, String rutaBrochure, byte[] pdf1, String nombre1, byte[] pdf2, String nombre2, byte[] pdf3, String nombre3, byte[] pdf4, String nombre4, byte[] pdf5, String nombre5, byte[] pdf6, String nombre6, byte[] pdf7, String nombre7, byte[] pdf8, String nombre8) {
        Carrera objCarrera = new Carrera();
        AutoridadCar objAutoridad = new AutoridadCar();
        PlantillaEmail objTempMatrc = new PlantillaEmail();
        String msgOutput = "", msj1 = "", msj2 = "", nmbMsc = "", correoDest = "", listadoPdfs = "";
        List<File> listadoArchivos = new ArrayList<>();
        
        msgOutput = objDatosMultRepository.registerDataEnrollment(cedula, nombreComp, correoElec, telefono, UUID.fromString(codMaestria), rutaBrochure.trim(), pdf1, nombre1, pdf2, nombre2, pdf3, nombre3, pdf4, nombre4,
                pdf5, nombre5, pdf6, nombre6, pdf7, nombre7, pdf8, nombre8);
        
        correoDest = "stevencortezchichande@gmail.com";
        if (msgOutput.trim().equals("MATREX")) {
            objCarrera = objDatosMultRepository.getInformationCareerByCode(UUID.fromString(codMaestria));
            nmbMsc = !objCarrera.getCrNombre().isEmpty() ? objCarrera.getCrNombre().trim() : "";
            objAutoridad = objAutoridadRepository.getInformationAuthorityCareer(UUID.fromString(codMaestria), 140);
            
            listadoArchivos.add(writeByte(pdf1, nombre1));
            listadoPdfs = "Documento de identificación,";
            if (pdf2 != null) {
                listadoPdfs += " registro del título de tercer nivel,";
                listadoArchivos.add(writeByte(pdf2, nombre2));
            }
            if (pdf3 != null) {
                listadoPdfs += " título de tercel nivel,";
                listadoArchivos.add(writeByte(pdf3, nombre3));
            }
            if (pdf4 != null) {
                listadoPdfs += " acta de grado,";
                listadoArchivos.add(writeByte(pdf4, nombre4));
            }
            if (pdf5 != null) {
                listadoPdfs += " record académico,";
                listadoArchivos.add(writeByte(pdf5, nombre5));
            }
            if (pdf6 != null) {
                listadoPdfs += " referencias laborales/académicas,";
                listadoArchivos.add(writeByte(pdf6, nombre6));
            }
            if (pdf7 != null) {
                listadoPdfs += " carta de motivación,";
                listadoArchivos.add(writeByte(pdf7, nombre7));
            }
            listadoPdfs += " acuerdo de términos y condiciones.";
            listadoArchivos.add(writeByte(pdf8, nombre8));
            
            //correoDest = !objAutoridad.getAuCorreoElect().isEmpty() ? objAutoridad.getAuCorreoElect().trim() : "posgrado@uteq.edu.ec";
            
            //Correo electrónico para el Coordinador del Programa de Maestría y para la Secretaría
            objTempMatrc = objDatosMultRepository.getInformationTemplateEmail("MATUN");
            //correoDest = !objAutoridad.getAuCorreoElect().isEmpty() ? objAutoridad.getAuCorreoElect().trim() : "posgrado@uteq.edu.ec";
            if (!objTempMatrc.getPePlantilla().isEmpty()) {
                msj2 = objTempMatrc.getPePlantilla().trim();
                msj2 = msj2.replace("VAL_DNI", cedula.trim());
                msj2 = msj2.replace("VAL_POSTULANTE", nombreComp.trim());
                msj2 = msj2.replace("VAL_TELEFONO", telefono.replace(" ", ""));
                msj2 = msj2.replace("VAL_CORREO_ELECT", correoElec.trim());
                msj2 = msj2.replace("VAL_PROG_MSC", nmbMsc.trim());
                msj2 = msj2.replace("VAL_LISTADO_DOCS", listadoPdfs);
                sendEmailHTMLUserEnrollment(correoDest, "Confirmación de matrícula - Universidad Técnica Estatal de Quevedo", msj2, "posgrado@uteq.edu.ec", listadoArchivos);
            } else {
                msj2 = "Datos del estudiante matriculado" + "\n\n" + "C.I/Pasaporte: " + cedula.trim() + "\n\n" + "Postulante: " + nombreComp.trim() + "\n\n" + "Teléfono: " + telefono.replace(" ", "") + "\n\n" + "Correo electrónico: "
                        + correoElec.trim() + "\n\n" + "Programa de Maestría: " + nmbMsc.trim() + "\n\n" + "Documentos adjuntados: " + listadoPdfs;
                sendMailWithAttachment(correoDest, "Confirmación de matrícula - Universidad Técnica Estatal de Quevedo", msj2, "posgrado@uteq.edu.ec", listadoArchivos);
            }
            
            for (File f : listadoArchivos) {
                f.delete();
            }
            
        }
        return msgOutput;
    }
    
    public File writeByte(byte[] bytes, String nameFile) {
        File output = new File(nameFile);
        try {
            OutputStream os = new FileOutputStream(output);
            os.write(bytes);
            os.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
        return output;
    }
    
    @Override
    public List<Carrera> getListCareersGradeUniversityByFaculty() {
        return objDatosMultRepository.getListDataCareersUnivsByFaculty();
    }
    
    @Override
    public List<Carrera> getListCareersGradeUniversityByCodFaculty(String codFaculty) {
        return objDatosMultRepository.getListDataCareersUnivsByCodeFaculty(UUID.fromString(codFaculty));
    }
    
    @Override
    public List<Carrera> getListUrlsCareersGradeUniversityByFaculty() {
        return objDatosMultRepository.getListDataUrlsCareersUnivsByFaculty();
    }
    
    @Override
    public List<Carrera> getListUrlsInfoCareersGradeUniversityByFaculty() {
        List<Carrera> listCareers;
        
        try {
            listCareers = objDatosMultRepository.getListDataUrlsInfoCareersUnivsByFaculty();
            for (Carrera c : listCareers) {
                c.setCrDepartamento(objDatosMultRepository.getInfoShortFaculty(c.getCrDepartamento().getDpCodigo()));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            listCareers = new ArrayList<>();
        }
        
        return listCareers;
    }
    
    @Override
    public List<Carrera> getListUrlsCareersUniversityByType(String codDepart) {
        return objDatosMultRepository.getListDataUrlsCareersUnivsByType(UUID.fromString(codDepart));
    }
    
    @Override
    public List<Carrera> getListShortUrlsCareersUniversityByDepartm(String codDepart) {
        return objDatosMultRepository.getListShortDataUrlsCareersUnivsByType(UUID.fromString(codDepart));
    }
    
    @Override
    public List<Carrera> getListCareersInformation(String textIn) {
        List<Carrera> listCareers;
        
        try {
            listCareers = objDatosMultRepository.getListDataUrlsInfoCareersUnivsByWords(textIn);
            for (Carrera c : listCareers) {
                c.setCrDepartamento(objDatosMultRepository.getInfoFacultySrc(c.getCrDepartamento().getDpCodigo()));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            listCareers = new ArrayList<>();
        }
        
        return listCareers;
    }
    
    @Override
    public List<Carrera> getListSMUrlsCareersUniversityByType(String codDepart) {
        return objDatosMultRepository.getListDataSMUrlsCareersUnivsByType(UUID.fromString(codDepart));
    }
    
    @Override
    public List<Carrera> getListCareersAdms() {
        return objDatosMultRepository.getListCareersUAN();
    }
    
//</editor-fold>

}
