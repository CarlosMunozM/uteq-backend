package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.Archivo;
import com.app.uteqbackend.model.CapacitacionUTH;
import com.app.uteqbackend.model.CategoriaNotc;
import com.app.uteqbackend.model.ConcursoMer;
import com.app.uteqbackend.model.DatosMult;
import com.app.uteqbackend.model.Departamento;
import com.app.uteqbackend.model.DtsModal;
import com.app.uteqbackend.model.Empleo;
import com.app.uteqbackend.model.EventoOrgz;
import com.app.uteqbackend.model.GaleriaLb;
import com.app.uteqbackend.model.GaleriaPI;
import com.app.uteqbackend.model.GaleriaPV;
import com.app.uteqbackend.model.GrupoInv;
import com.app.uteqbackend.model.IntegranteGI;
import com.app.uteqbackend.model.LineaInv;
import com.app.uteqbackend.model.Menu;
import com.app.uteqbackend.model.Metrica;
import com.app.uteqbackend.model.Noticia;
import com.app.uteqbackend.model.PagWeb;
import com.app.uteqbackend.model.PeriodicoMens;
import com.app.uteqbackend.model.PlantillaEmail;
import com.app.uteqbackend.model.ProyectoInvst;
import com.app.uteqbackend.model.ProyectoVinc;
import com.app.uteqbackend.model.PublicacionRs;
import com.app.uteqbackend.model.ServicioMed;
import com.app.uteqbackend.model.Submenu;
import com.app.uteqbackend.model.VideoInfm;
import com.app.uteqbackend.repository.DatosMultRepository;
import com.app.uteqbackend.service.DatosMultService;
import com.app.uteqbackend.utils.Recaptcha;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Service
public class DatosMultServiceImpl implements DatosMultService {

    //<editor-fold defaultstate="collapsed" desc="DECLARATION OF VARIABLES AND CONSTRUCTORS">
    private DatosMultRepository objDatosMultRepository;
    private JavaMailSender objJavaMailSender;
    
    @Autowired
    public DatosMultServiceImpl(DatosMultRepository objDatosMultRepository, JavaMailSender objJavaMailSender) {
        super();
        this.objDatosMultRepository = objDatosMultRepository;
        this.objJavaMailSender = objJavaMailSender;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
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
    public List<DatosMult> getListDataGeneral(String type) {
        return objDatosMultRepository./*getDataMultiplesOfUniversity*/getDataMultiplesOfUniversityLang(type);
    }
    
    @Override
    public DatosMult getInformationDataGeneralById(int codigo) {
        return objDatosMultRepository.getInfoDataMultById(codigo);
    }
    
    @Override
    public List<DatosMult> getListDataGeneralSort(String type) {
        return objDatosMultRepository.getDataMultiplesOfUniversitySort(type);
    }
    
    @Override
    public PagWeb getInformationPageWebById(String code) {
        return objDatosMultRepository.getInformationPageWebByCode(UUID.fromString(code));
    }
    
    @Override
    public List<ConcursoMer> getListDataMeritContests(Date currentDate) {
        return objDatosMultRepository.getListDataMeritContests(currentDate);
    }
    
    @Override
    public String getResponseValidationRecaptcha(String valToken) {
        String outMessage = "";
        try {
            boolean verify = Recaptcha.verify(valToken);
            outMessage = (verify == true ? "OK" : "NOK");
        } catch (IOException ex) {
            outMessage = "ERR";
            Logger.getLogger(DatosMultServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return outMessage;
    }
    
    @Override
    public EventoOrgz getInformationEventOrgzUniversity(String urlParcial) {
        return objDatosMultRepository.getInformationEventOrgz(urlParcial);
    }
    
    @Override
    public List<EventoOrgz> getListEventsOrgzUniversity() {
        return objDatosMultRepository.getListEventsOrgzUniversity();
    }
    
    @Override
    public PlantillaEmail getInformationTemplateEmail(String location) {
        return objDatosMultRepository.getInformationTemplateEmail(location);
    }
    
    @Override
    public List<DatosMult> getListTypesVideos(String type) {
        return objDatosMultRepository.getDataTypesVideos(type);
    }
    
    @Override
    public List<ServicioMed> getListServicesMedicalUniv() {
        return objDatosMultRepository.getListMedicalServices();
    }
    
    @Override
    public List<CapacitacionUTH> getListCoursesUTH(Date currentDate) {
        return objDatosMultRepository.getListCoursesUTH(currentDate);
    }
    
    @Override
    public String registerDataCurriculumVitaeUTH(String cedula, String nombreComp, int codExpLab, String codCampoProfs, String lblCampoProfs, int codFormProfs, String publicaciones, byte[] pdfHV, String nombrePdfHV) {
        int codDestinatario = 110;
        PlantillaEmail objTempHV = new PlantillaEmail();
        String msgOutput = "", msj1 = "", msj2 = "", nmbMsc = "", correoDest = "";
        
        nombrePdfHV = cedula.trim() + "-hoja-de-vida.pdf";
        
        msgOutput = objDatosMultRepository.registerDataCurriculumVitaeUTH(cedula, nombreComp, codExpLab, codCampoProfs, codFormProfs, publicaciones, pdfHV, nombrePdfHV);
        
        if (msgOutput.trim().equals("DTSREX")) {
            correoDest = objDatosMultRepository.getInfoDataMultById(codDestinatario).getDmCorreoElect().trim().toLowerCase();
            sendEmailDataCV(correoDest, cedula, nombreComp, codExpLab, lblCampoProfs, codFormProfs, publicaciones, pdfHV, nombrePdfHV);
        }
        return msgOutput;
        
    }
    
    public void sendEmailDataCV(String correoDest, String cedula, String nombreComp, int codExpLab, /*int*/ String codCampoProfs, int codFormProfs, String publicaciones, byte[] archivoPdfHV, String nombrePdfHV) {
        String msj1 = "", tipoCertf = "", asunto = "", descExpLab = "", descCampoProfs = "", descFormProfs = "";
        SimpleMailMessage objSimpleMailMessage = new SimpleMailMessage();
        PlantillaEmail objTempHV = new PlantillaEmail();
        DatosMult objDatoMult = new DatosMult();
        File arcPdfHV = null;
        
        //Para prueba
        //correoDest = "stevencortezchichande@gmail.com";
        
        objTempHV = objDatosMultRepository.getInformationTemplateEmail("ENVHV");
        objDatoMult = objDatosMultRepository.getInfoDataMultById(codExpLab);
        descExpLab = (objDatoMult != null ? objDatoMult.getDmDescripcion().trim() : "---");
        //objDatoMult = objDatosMultRepository.getInfoDataMultById(codCampoProfs);
        //descCampoProfs = (objDatoMult != null ? objDatoMult.getDmDescripcion().trim() : "---");
        descCampoProfs = codCampoProfs;
        objDatoMult = objDatosMultRepository.getInfoDataMultById(codFormProfs);
        descFormProfs = (objDatoMult != null ? objDatoMult.getDmDescripcion().trim() : "---");
        asunto = "HOJA DE VIDA - " + cedula.trim() + " - " + descCampoProfs.trim().toUpperCase();
        arcPdfHV = writeByte(archivoPdfHV, nombrePdfHV);
        
        if (!objTempHV.getPePlantilla().isEmpty()) {
            msj1 = objTempHV.getPePlantilla().trim();
            msj1 = msj1.replace("VAL_CEDULA", cedula.trim());
            msj1 = msj1.replace("VAL_NOMB_COMP", nombreComp.trim());
            msj1 = msj1.replace("VAL_EXP_LAB", descExpLab.trim());
            msj1 = msj1.replace("VAL_CAMPO_PROF", descCampoProfs.trim());
            msj1 = msj1.replace("VAL_FORM_PROF", descFormProfs.trim());
            msj1 = msj1.replace("VAL_PUBLICACIONES", (publicaciones.isEmpty() ? "No cuenta con publicaciones" : publicaciones));
            sendEmailHTMLUser(correoDest, asunto, msj1, arcPdfHV);
        } else {
            msj1 = "C.I del postulante: " + cedula.trim() + "\n\n" + "Nombre del postulante: " + nombreComp.trim() + "\n\n" + "Experiencia laboral: " + descExpLab.trim() + "\n\n" + "Campo profesional: " + descCampoProfs.trim()
                    + "\n\n" + "Formación profesional: " + descFormProfs.trim() + "\n\n" + "Publicaciones: " + (publicaciones.isEmpty() ? "No cuenta con publicaciones" : publicaciones);
            sendMailWithAttachment(correoDest, asunto, msj1.trim(), arcPdfHV);
        }
        arcPdfHV.delete();
    }
    
    public void sendEmailHTMLUser(String correoDest, String asunto, String mensaje, File archivoPdfHV) {
        try {
            MimeMessage mimeMessage = objJavaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            helper.setText(mensaje, true);
            helper.setTo(correoDest);
            helper.setSubject(asunto.trim());
            
            if (archivoPdfHV != null) {
                FileSystemResource fr = new FileSystemResource(archivoPdfHV);
                helper.addAttachment(archivoPdfHV.getName(), fr);
            }
            
            objJavaMailSender.send(mimeMessage);
        } catch (MessagingException ex) {
            System.out.println("Error en envío de correo: " + ex.getMessage());
        }
    }
    
    public void sendMailWithAttachment(String correoDest, String asunto, String mensaje, File archivoPdfHV) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(correoDest));
                mimeMessage.setSubject(asunto);
                mimeMessage.setText(mensaje);
                
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                
                if (archivoPdfHV != null) {
                    FileSystemResource fr = new FileSystemResource(archivoPdfHV);
                    helper.addAttachment(archivoPdfHV.getName(), fr);
                }
            }
        };
        
        try {
            objJavaMailSender.send(preparator);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
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
    public List<DatosMult> getListSchedulesUBU(int idArea) {
        return objDatosMultRepository.getListSchedulesUBU(idArea);
    }
    
    @Override
    public List<PublicacionRs> getListPostSocialNetUniversity(String tipo, int limit) {
        return (limit>0 ? objDatosMultRepository.getListPublicationsUniversity(tipo, PageRequest.of(0,limit)): new ArrayList<PublicacionRs>());
    }
    
    @Override
    public List<Departamento> getListDepartamentsActiveUniv() {
        return objDatosMultRepository.getListDepartamentsActive();
    }
    
    @Override
    public List<CategoriaNotc> getListCategoriesUniv() {
        return objDatosMultRepository.getListCategoriesActive();
    }
    
    @Override
    public List<PagWeb> getListWebPagesIndividual(String tipoEntd) {
        return objDatosMultRepository.getListOthersWebPagesByEntity(tipoEntd);
    }
    
    @Override
    public PagWeb getInformationWP(String urlParcial) {
        return objDatosMultRepository.getInformationPageWebByUrlParcial(urlParcial);
    }
    
    @Override
    public List<DtsModal> getInformationModalByPage(String codEntd) {
        return objDatosMultRepository.getListElementsModal(UUID.fromString(codEntd));
    }
    
    @Override
    public List<Menu> getListFltInformationMenu(String frase) {
        return objDatosMultRepository.getListFilterInformationMenu(frase,Sort.by(Sort.Direction.ASC,new String[]{"mnUrlAsoc","mnNombre"}));
    }
    
    @Override
    public List<Submenu> getListFltInformationSubMenu(String frase) {
        return objDatosMultRepository.getListFilterInformationSubMenu(frase,Sort.by(Sort.Direction.ASC,new String[]{"smUrlAsoc","smNombre"}));
    }
    
    @Override
    public List<Noticia> getListFltInformationNoticia(String frase) {
        return objDatosMultRepository.getListFilterInformationNoticia(frase,Sort.by(Sort.Direction.DESC,new String[]{"ntFecha"}));
    }
    
    @Override
    public List<VideoInfm> getListFltInformationVideos(String frase) {
        return objDatosMultRepository.getListFilterInformationVideos(frase,Sort.by(Sort.Direction.DESC,new String[]{"fechapub"}));
    }
    
    @Override
    public List<PeriodicoMens> getListFltInformationPeriodicos() {
        return objDatosMultRepository.getListFilterInformationPeriodicos(Sort.by(Sort.Direction.DESC,new String[]{"anio","mes"}));
    }
    
    @Override
    public List<DatosMult> getListFltInformationRevistas() {
        return objDatosMultRepository.getListFilterInformationRevistas();
    }
    
    @Override
    public List<Archivo> getListFltInformationArchivos(String frase) {
        return objDatosMultRepository.getListFilterInformationArchivos(frase,Sort.by(Sort.Direction.ASC,new String[]{"arDescripcion"}));
    }
    
    @Override
    public List<Empleo> getListJobsBusiness() {
        return objDatosMultRepository.getListJobsEmployments();
    }
    
    @Override
    public List<Metrica> getListMetricsUniversityByArea(String codPagWeb) {
        return objDatosMultRepository.getListMetricsUnivs(UUID.fromString(codPagWeb));
    }
    
    @Override
    public List<ProyectoVinc> getListProjectsLinkage() {
        return objDatosMultRepository.getListProjectsLinkage();
    }
    
    @Override
    public List<ProyectoVinc> getListSMProjectsLinkage() {
        return objDatosMultRepository.getListSMProjectsLinkage();
    }
    
    @Override
    public ProyectoVinc getInformationOfProjectByCode(String code_pv) {
        return objDatosMultRepository.getInformationOfProjectLinkageByUrl(code_pv);
    }
    
    @Override
    public List<GaleriaPV> getListImagesProjectsPV(String urlParcial) {
        return objDatosMultRepository.getListImgProjectsPV(urlParcial);
    }
    
    @Override
    public List<LineaInv> getListResearchLines() {
        return objDatosMultRepository.getListResearchLines();
    }
    
    @Override
    public List<GrupoInv> getListDataResearchGroups() {
        return objDatosMultRepository.getListInformationResearchGroups();
    }
    
    @Override
    public List<GrupoInv> getListSMDataResearchGroups() {
        return objDatosMultRepository.getListSMUrlsInformationResearchGroups();
    }
    
    @Override
    public GrupoInv getInformationResearchGroup(String codeGroup) {
        return objDatosMultRepository.getInformationResearchGroup(UUID.fromString(codeGroup));
    }
    
    @Override
    public List<IntegranteGI> getListGroupMembersByCode(String urlParcial) {
        return objDatosMultRepository.getListGroupsMembers(urlParcial);
    }
    
    @Override
    public List<ProyectoInvst> getListResearchProjects() {
        // return objDatosMultRepository.getListResProjects();
        return objDatosMultRepository.getListResProjectsV1();
    }
    
    @Override
    public List<ProyectoInvst> getListSMResearchProjects() {
        return objDatosMultRepository.getListSMResProjects();
    }
    
    @Override
    public ProyectoInvst getInformationResearchProject(String url_parcial) {
        return objDatosMultRepository.getInformationProjectByCode(url_parcial.trim().toLowerCase());
    }
    
    @Override
    public PagWeb getInformationPageWebByUrlParcial(String url_parcial) {
        return objDatosMultRepository.getInformationPageWebByUrl(url_parcial.trim().toLowerCase());
    }
    
    @Override
    public List<PagWeb> getListWebPagesByCodeEntd(String codEntd) {
        return objDatosMultRepository.getListPagesByCode(UUID.fromString(codEntd));
    }
    
    @Override
    public List<GaleriaPI> getListImagesResearchProject(String codeProj) {
        return objDatosMultRepository.getListImgProjectsPI(codeProj);
    }
    
    @Override
    public List<Departamento> getListFacultiesUniversity() {
        return objDatosMultRepository.getListDepartamentsAsFaculty();
    }
    
    @Override
    public List<PagWeb> getListUrlsWebPagesByCodeEntd(String codEntd) {
        return objDatosMultRepository.getListUrlsPagesByCode(UUID.fromString(codEntd));
    }
    
    @Override
    public List<GrupoInv> getListUrlsDataResearchGroups() {
        return objDatosMultRepository.getListUrlsInformationResearchGroups();
    }
    
    @Override
    public List<ProyectoInvst> getListUrlsResearchProjects() {
        return objDatosMultRepository.getListUrlsResProjects();
    }
    
    @Override
    public List<PagWeb> getListUrlsWebPagesIndividual(String tipoEntd) {
        return objDatosMultRepository.getListUrlsOthersWebPagesByEntity(tipoEntd);
    }
    
    @Override
    public List<PagWeb> getListUrlsWebPagesIndividualSM(String tipoEntd) {
        return objDatosMultRepository.getListUrlsOthersWebSMPagesByEntity(tipoEntd);
    }
    
    @Override
    public List<ProyectoVinc> getListUrlsProjectsLinkage() {
        return objDatosMultRepository.getListUrlsProjectsLinkage();
    }
    
    @Override
    public List<DatosMult> getListTestimonialUniv() {
        return objDatosMultRepository.getListTestimonialUniversity();
    }
    
    @Override
    public List<GaleriaLb> getListLaboratoriesGallery() {
        return objDatosMultRepository.getListImagesLaboratory();
    }
    
    @Override
    public List<DatosMult> getInformationLaboratories() {
        return objDatosMultRepository.getInformationLaboratories();
    }
//</editor-fold>

}
