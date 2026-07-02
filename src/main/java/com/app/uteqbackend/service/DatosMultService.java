package com.app.uteqbackend.service;

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
import java.util.Date;
import java.util.List;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface DatosMultService {

    List<DatosMult> getListDataGeneral(String type);

    DatosMult getInformationDataGeneralById(int code);

    List<DatosMult> getListDataGeneralSort(String type);

    PagWeb getInformationPageWebById(String code);

    List<ConcursoMer> getListDataMeritContests(Date currentDate);

    String getResponseValidationRecaptcha(String valToken);

    EventoOrgz getInformationEventOrgzUniversity(String urlParcial);

    List<EventoOrgz> getListEventsOrgzUniversity();

    PlantillaEmail getInformationTemplateEmail(String location);

    List<DatosMult> getListTypesVideos(String type);

    List<ServicioMed> getListServicesMedicalUniv();

    List<CapacitacionUTH> getListCoursesUTH(Date currentDate);

    String registerDataCurriculumVitaeUTH(String cedula, String nombreComp, int codExpLab, String codCampoProfs, String lblCampoProfs, int codFormProfs, String publicaciones, byte[] pdfHV, String nombrePdfHV);

    List<DatosMult> getListSchedulesUBU(int idArea);

    List<PublicacionRs> getListPostSocialNetUniversity(String tipo, int limit);

    List<Departamento> getListDepartamentsActiveUniv();

    List<CategoriaNotc> getListCategoriesUniv();

    List<PagWeb> getListWebPagesIndividual(String tipoEntd);

    List<PagWeb> getListUrlsWebPagesIndividual(String tipoEntd);

    PagWeb getInformationWP(String urlParcial);

    List<DtsModal> getInformationModalByPage(String codEntd);

    List<Menu> getListFltInformationMenu(String frase);

    List<Submenu> getListFltInformationSubMenu(String frase);

    List<Noticia> getListFltInformationNoticia(String frase);

    List<VideoInfm> getListFltInformationVideos(String frase);

    List<PeriodicoMens> getListFltInformationPeriodicos();

    List<DatosMult> getListFltInformationRevistas();

    List<Archivo> getListFltInformationArchivos(String frase);

    List<Empleo> getListJobsBusiness();

    List<Metrica> getListMetricsUniversityByArea(String codPagWeb);

    List<ProyectoVinc> getListProjectsLinkage();
    
    List<ProyectoVinc> getListSMProjectsLinkage();

    List<ProyectoVinc> getListUrlsProjectsLinkage();

    ProyectoVinc getInformationOfProjectByCode(String code_pv);

    List<GaleriaPV> getListImagesProjectsPV(String codeProj);

    List<LineaInv> getListResearchLines();

    List<GrupoInv> getListDataResearchGroups();
    
    List<GrupoInv> getListSMDataResearchGroups();

    List<GrupoInv> getListUrlsDataResearchGroups();

    GrupoInv getInformationResearchGroup(String codeGroup);

    List<IntegranteGI> getListGroupMembersByCode(String urlParcial);

    List<ProyectoInvst> getListResearchProjects();

    List<ProyectoInvst> getListUrlsResearchProjects();
    
    List<ProyectoInvst> getListSMResearchProjects();

    ProyectoInvst getInformationResearchProject(String url_parcial);

    PagWeb getInformationPageWebByUrlParcial(String url_parcial);

    List<PagWeb> getListWebPagesByCodeEntd(String codEntd);

    List<PagWeb> getListUrlsWebPagesByCodeEntd(String codEntd);
    
    List<PagWeb> getListUrlsWebPagesIndividualSM(String tipoEntd);

    List<GaleriaPI> getListImagesResearchProject(String codeProj);

    List<Departamento> getListFacultiesUniversity();

    List<DatosMult> getListTestimonialUniv();

    List<GaleriaLb> getListLaboratoriesGallery();

    List<DatosMult> getInformationLaboratories();

}
