package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.Archivo;
import com.app.uteqbackend.model.CapacitacionUTH;
import com.app.uteqbackend.model.Carrera;
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
import com.app.uteqbackend.model.InscripcionMsc;
import com.app.uteqbackend.model.IntegranteGI;
import com.app.uteqbackend.model.LineaInv;
import com.app.uteqbackend.model.Menu;
import com.app.uteqbackend.model.Metrica;
import com.app.uteqbackend.model.Noticia;
import com.app.uteqbackend.model.PagWeb;
import com.app.uteqbackend.model.PeriodicoMens;
import com.app.uteqbackend.model.ProyectoInvst;
import com.app.uteqbackend.model.ProyectoVinc;
import com.app.uteqbackend.model.PublicacionRs;
import com.app.uteqbackend.model.ServicioMed;
import com.app.uteqbackend.model.Submenu;
import com.app.uteqbackend.model.VideoInfm;
import com.app.uteqbackend.service.CarreraService;
import com.app.uteqbackend.service.DatosMultService;
import com.app.uteqbackend.service.DepartamentoService;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ANALISTA-TIC 2
 */
@RestController
// @CrossOrigin(origins = {"https://webapp.uteq.edu.ec", "https://www.uteq.edu.ec/", "https://uteq.edu.ec"})
@CrossOrigin(origins="*")
@RequestMapping("/ws/datos")
public class CtrlOpDatosMult {

    //<editor-fold defaultstate="collapsed" desc="SERVICE INTERFACE AND CONSTRUCTOR">
    private final DatosMultService objDatosMultService;
    private final DepartamentoService objDepartamentoService;
    private final CarreraService objCarreraService;

    public CtrlOpDatosMult(DatosMultService objDatosMultService, DepartamentoService objDepartamentoService, CarreraService objCarreraService) {
        super();
        this.objDatosMultService = objDatosMultService;
        this.objDepartamentoService = objDepartamentoService;
        this.objCarreraService = objCarreraService;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @GetMapping("/list-data/{type}")
    public List<DatosMult> getListDataCampusOfUniversity(@PathVariable("type") String type) {
        try {
            return objDatosMultService.getListDataGeneral(type);
        } catch (Exception ex) {
            System.out.println("Error in function getListDataCampusOfUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/info-dept/{id}")
    public Departamento getInformationDepartamentByCodeID(@PathVariable("id") String id) {
        try {
            return objDepartamentoService.getInformationDepartamentByID(id);
        } catch (Exception ex) {
            System.out.println("Error in function getInformationDepartamentByCodeID(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/info-pw/{code}")
    public PagWeb getInformationOfPageWebByCodeID(@PathVariable("code") String code) {
        try {
            return objDatosMultService.getInformationPageWebById(code);
        } catch (Exception ex) {
            System.out.println("Error in function getInformationOfPageWebByCodeID(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-contests")
    public List<ConcursoMer> getListDataContestUnivsty() {
        try {
            Date date = new Date();
            return objDatosMultService.getListDataMeritContests(date);
        } catch (Exception ex) {
            System.out.println("Error in function getListDataContestUnivsty(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-courses-uth")
    public List<CapacitacionUTH> getListDataCoursesUTH() {
        try {
            Date date = new Date();
            return objDatosMultService.getListCoursesUTH(date);
        } catch (Exception ex) {
            System.out.println("Error in function getListDataCoursesUTH(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-careers/{code_dep}")
    public List<Carrera> getListDataCareersUniversity(@PathVariable("code_dep") String code_dep) {
        try {
            return objCarreraService.getListCareersUniversityByType(code_dep);
        } catch (Exception ex) {
            System.out.println("Error in function getListDataCareersUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/urls-list-careers/{code_dep}")
    public List<Carrera> getListUrlsDataCareersUniversity(@PathVariable("code_dep") String code_dep) {
        try {
            return objCarreraService.getListUrlsCareersUniversityByType(code_dep);
        } catch (Exception ex) {
            System.out.println("Error in function getListUrlsDataCareersUniversity(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/urls-sm-list-careers/{code_dep}")
    public List<Carrera> getListUrlsSMDataCareersUniversity(@PathVariable("code_dep") String code_dep) {
        try {
            return objCarreraService.getListSMUrlsCareersUniversityByType(code_dep);
        } catch (Exception ex) {
            System.out.println("Error in function getListUrlsSMDataCareersUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/short-list-careers/{code_dep}")
    public List<Carrera> getListShortUrlsDataCareersUniversity(@PathVariable("code_dep") String code_dep) {
        try {
            return objCarreraService.getListShortUrlsCareersUniversityByDepartm(code_dep);
        } catch (Exception ex) {
            System.out.println("Error in function getListShortUrlsDataCareersUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/grade/list-careers")
    public List<Carrera> getListDataCareersFaculties() {
        try {
            return objCarreraService.getListCareersGradeUniversityByFaculty();
        } catch (Exception ex) {
            System.out.println("Error in function getListDataCareersFaculties(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/grade/list-careers-uan")
    public List<Carrera> getListDataCareersUniversity() {
        try {
            return objCarreraService.getListCareersAdms();
        } catch (Exception ex) {
            System.out.println("Error in function getListDataCareersUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/grade/urls-list-careers")
    public List<Carrera> getListUrlsDataCareersFaculties() {
        try {
            return objCarreraService.getListUrlsCareersGradeUniversityByFaculty();
        } catch (Exception ex) {
            System.out.println("Error in function getListUrlsDataCareersFaculties(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/grade/list-is-careers")
    public List<Carrera> getListShortDataCareersFaculties() {
        try {
            return objCarreraService.getListUrlsInfoCareersGradeUniversityByFaculty();
        } catch (Exception ex) {
            System.out.println("Error in function getListShortDataCareersFaculties(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/grade/careers-lst/{words}")
    public List<Carrera> getListCareersSrc(@PathVariable("words") String words) {
        try {
            return objCarreraService.getListCareersInformation(words);
        } catch (Exception ex) {
            System.out.println("Error in function getListCareersSrc(): " + ex.getMessage());
            return null;
        }
    }

    @PostMapping("/validation/{token}")
    public String getResponseDataValidation(@PathVariable("token") String token) {
        try {
            return objDatosMultService.getResponseValidationRecaptcha(token);
        } catch (Exception ex) {
            System.out.println("Error in function getResponseDataValidation(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/career/{url_parcial}")
    public Carrera getInformationCareerUnivByUrlParcial(@PathVariable("url_parcial") String url_parcial) {
        try {
            return objCarreraService.getInformationCareerUniversityByUrlParcial(url_parcial);
        } catch (Exception ex) {
            System.out.println("Error in function getInformationCareerUnivByUrlParcial(): " + ex.getMessage());
            return null;
        }
    }

    @PostMapping("/register-insc")
    public String registerDataInscriptionMsc(@RequestBody InscripcionMsc objInscripcion) {
        try {
            return objCarreraService.registerDataInscriptionMaster(objInscripcion.getIsCodgDNI(), objInscripcion.getIsNombreComp(), objInscripcion.getIsTelefono(), objInscripcion.getIsCorreoElect(), objInscripcion.getIsCodMaestria().toString(), objInscripcion.getIsUrlBrochure().trim());
        } catch (Exception ex) {
            System.out.println("Error in function registerDataInscriptionMsc(): " + ex.getMessage());
            return null;
        }
    }

    @PostMapping(value = "/register-matc", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, "multipart/form-data;charset=UTF-8"})
    public String uploadFile(@RequestParam("mtCodgDNI") String dni, @RequestParam("mtNombreComp") String nombreComp, @RequestParam("mtCorreoElect") String correoElect, /*@RequestParam(value = "image", required = false)*/
            @RequestParam("mtTelefono") String telefono, @RequestParam("mtCodMaestria") UUID codMaestria, @RequestParam("mtUrlBrochure") String urlBrochure, @RequestParam(value = "mtPdfDni", required = true) MultipartFile mtPdfDni, @RequestParam(value = "mtPdfRgt", required = true) MultipartFile mtPdfRgt, @RequestParam(value = "mtPdfTtn", required = false) MultipartFile mtPdfTtn,
            @RequestParam(value = "mtPdfAgd", required = false) MultipartFile mtPdfAgd, @RequestParam(value = "mtPdfRac", required = false) MultipartFile mtPdfRac, @RequestParam(value = "mtPdfRlb", required = false) MultipartFile mtPdfRlb, @RequestParam(value = "mtPdfCmt", required = false) MultipartFile mtPdfCmt, @RequestParam(value = "mtPdfAtc", required = true) MultipartFile mtPdfAtc) {
        String[] nombresArchivos = new String[8];
        String pattern = "yyyy/MM/dd HH:mm:ss", fecha = "", mensaje = "";
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();
        Random rand = new Random();
        try {
            fecha = df.format(today);
            fecha = fecha.replace("/", "");
            fecha = fecha.replace(":", "");
            fecha = fecha.replace(" ", "");

            if (mtPdfDni != null) {
                nombresArchivos[0] = "DNI-" + dni.trim().replace(" ", "") + "-" + fecha + "-" + String.valueOf(rand.nextInt(9999999)) + ".pdf";
            } else {
                mensaje = "DNIVCO";
            }
            if (mtPdfRgt != null) {
                nombresArchivos[1] = "RGT-" + dni.trim().replace(" ", "") + "-" + fecha + "-" + String.valueOf(rand.nextInt(9999999)) + ".pdf";
            } else {
                mensaje = "RGTVCO";
            }
            if (mtPdfTtn != null) {
                nombresArchivos[2] = "TTN-" + dni.trim().replace(" ", "") + "-" + fecha + "-" + String.valueOf(rand.nextInt(9999999)) + ".pdf";
            } else {
                nombresArchivos[2] = "";
            }
            if (mtPdfAgd != null) {
                nombresArchivos[3] = "AGD-" + dni.trim().replace(" ", "") + "-" + fecha + "-" + String.valueOf(rand.nextInt(9999999)) + ".pdf";
            } else {
                nombresArchivos[3] = "";
            }
            if (mtPdfRac != null) {
                nombresArchivos[4] = "RAC-" + dni.trim().replace(" ", "") + "-" + fecha + "-" + String.valueOf(rand.nextInt(9999999)) + ".pdf";
            } else {
                nombresArchivos[4] = "";
            }
            if (mtPdfRlb != null) {
                nombresArchivos[5] = "RLB-" + dni.trim().replace(" ", "") + "-" + fecha + "-" + String.valueOf(rand.nextInt(9999999)) + ".pdf";
            } else {
                nombresArchivos[5] = "";
            }
            if (mtPdfCmt != null) {
                nombresArchivos[6] = "CMT-" + dni.trim().replace(" ", "") + "-" + fecha + "-" + String.valueOf(rand.nextInt(9999999)) + ".pdf";
            } else {
                nombresArchivos[6] = "";
            }
            if (mtPdfAtc != null) {
                nombresArchivos[7] = "ATC-" + dni.trim().replace(" ", "") + "-" + fecha + "-" + String.valueOf(rand.nextInt(9999999)) + ".pdf";
            } else {
                mensaje = "ATCVCO";
            }
            if (mensaje.isEmpty()) {
                mensaje = objCarreraService.registerDataEnrollmentMaster(dni, nombreComp, telefono, correoElect, codMaestria.toString(), urlBrochure, mtPdfDni.getBytes(), nombresArchivos[0],
                        mtPdfRgt.getBytes(), nombresArchivos[1], (mtPdfTtn != null ? mtPdfTtn.getBytes() : null), nombresArchivos[2], (mtPdfAgd != null ? mtPdfAgd.getBytes() : null),
                        nombresArchivos[3], (mtPdfRac != null ? mtPdfRac.getBytes() : null), nombresArchivos[4], (mtPdfRlb != null ? mtPdfRlb.getBytes() : null),
                        nombresArchivos[5], (mtPdfCmt != null ? mtPdfCmt.getBytes() : null), nombresArchivos[6], mtPdfAtc.getBytes(), nombresArchivos[7]);
            }
        } catch (IOException ex) {
            mensaje = "ERRORR";
            System.out.println("Error in function uploadFile(): " + ex.getMessage());
            Logger.getLogger(CtrlOpDatosMult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }

    @GetMapping("/event-orgz/{url_parcial}")
    public EventoOrgz getInformationEventOrgzByUrlParcial(@PathVariable("url_parcial") String url_parcial) {
        try {
            return objDatosMultService.getInformationEventOrgzUniversity(url_parcial);
        } catch (Exception ex) {
            System.out.println("Error in function getInformationEventOrgzByUrlParcial(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/event-orgz/list")
    public List<EventoOrgz> getListEventsOrgzUniversity() {
        try {
            return objDatosMultService.getListEventsOrgzUniversity();
        } catch (Exception ex) {
            System.out.println("Error in function getListEventsOrgzUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-careers-matc/{code_dep}")
    public List<Carrera> getListDataCareersMatrcUniversity(@PathVariable("code_dep") String code_dep) {
        try {
            return objCarreraService.getListCareersMatcUniversityByType(code_dep);
        } catch (Exception ex) {
            System.out.println("Error in function getListDataCareersMatrcUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/medical-services")
    public List<ServicioMed> getListMedicalServicesUniversity() {
        try {
            return objDatosMultService.getListServicesMedicalUniv();
        } catch (Exception ex) {
            System.out.println("Error in function getListMedicalServicesUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @PostMapping(value = "/register-cv", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, "multipart/form-data;charset=UTF-8"})
    public String registerDataCurriculumVitae(@RequestParam("btNumDni") String valCedula, @RequestParam("btNombreComp") String valNombreComp, @RequestParam("btCodExpLab") int valCodExpLab,
            @RequestParam("btCodCampoProf") String valCampoProf, @RequestParam("btLabCampoProf") /*int*/ String valLblCampoProf, @RequestParam("btCodFormProf") int valCodFrmProf, @RequestParam("btPublicaciones") String valPublicaciones,
            @RequestParam(value = "btArchvHV", required = true) MultipartFile archivoPdfCV, @RequestParam("btNombrePdfHV") String valNombreArchvPdfCV) {
        String mensaje;
        try {
            mensaje = objDatosMultService.registerDataCurriculumVitaeUTH(valCedula, valNombreComp, valCodExpLab, valCampoProf, valLblCampoProf, valCodFrmProf, valPublicaciones, archivoPdfCV.getBytes(), valNombreComp);
        } catch (IOException ex) {
            mensaje = "ERROR";
            System.out.println("Error in function registerDataCurriculumVitae(): " + ex.getMessage());
            Logger.getLogger(CtrlOpDatosMult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }

    @GetMapping("/list-faculties")
    public List<Departamento> getListFacultiesUniv() {
        try {
            return objDepartamentoService.getListFacultiesOfUniversity();
        } catch (Exception ex) {
            System.out.println("Error in function getListFacultiesUniv(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/urls-list-faculties")
    public List<Departamento> getListUrlsFacultiesUniv() {
        try {
            return objDepartamentoService.getListUrlsFacultiesOfUniversity();
        } catch (Exception ex) {
            System.out.println("Error in function getListUrlsFacultiesUniv(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/urls-list-faculties-v3")
    public List<Departamento> getListUrlsFacultiesUnivV3() {
        try {
            return objDepartamentoService.getListUrlsFacultiesOfUniversityV3();
        } catch (Exception ex) {
            System.out.println("Error in function getListUrlsFacultiesUnivV3(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-hors/{id_area}")
    public List<DatosMult> getListScheduleByAreaUBU(@PathVariable("id_area") int id_area) {
        try {
            return objDatosMultService.getListSchedulesUBU(id_area);
        } catch (Exception ex) {
            System.out.println("Error in function getListScheduleByAreaUBU(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/careers/{id_faculty}")
    public List<Carrera> getListCareersByCodeFac(@PathVariable("id_faculty") String id_faculty) {
        try {
            List<Carrera> listCareers;
            listCareers = !id_faculty.isEmpty() ? objCarreraService.getListCareersGradeUniversityByCodFaculty(id_faculty) : new ArrayList<>();
            return listCareers;
        } catch (Exception ex) {
            System.out.println("Error in function getListCareersByCodeFac(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/post-sn/{type}/{limit}")
    public List<PublicacionRs> getListPostUniv(@PathVariable("type") String type, @PathVariable("limit") int limit) {
        try {
            return objDatosMultService.getListPostSocialNetUniversity(type, limit);
        } catch (Exception ex) {
            System.out.println("Error in function getListPostUniv(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-active-departms")
    public List<Departamento> getListActiveDepartaments() {
        try {
            return objDatosMultService.getListDepartamentsActiveUniv();
        } catch (Exception ex) {
            System.out.println("Error in function getListActiveDepartaments(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-active-categories")
    public List<CategoriaNotc> getListActiveCategories() {
        try {
            return objDatosMultService.getListCategoriesUniv();
        } catch (Exception ex) {
            System.out.println("Error in function getListActiveCategories(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/paginas/{tipoent}")
    public List<PagWeb> getListWebPagesUniv(@PathVariable("tipoent") String tipoent) {
        try {
            return objDatosMultService.getListWebPagesIndividual(tipoent);
        } catch (Exception ex) {
            System.out.println("Error in function getListWebPagesUniv(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/urls-paginas/{tipoent}")
    public List<PagWeb> getListUrlsWebPagesUniv(@PathVariable("tipoent") String tipoent) {
        try {
            return objDatosMultService.getListUrlsWebPagesIndividual(tipoent);
        } catch (Exception ex) {
            System.out.println("Error in function getListUrlsWebPagesUniv(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/urls-sm-paginas/{tipoent}")
    public List<PagWeb> getListUrlsWebSMPagesUniv(@PathVariable("tipoent") String tipoent) {
        try {
            return objDatosMultService.getListUrlsWebPagesIndividualSM(tipoent);
        } catch (Exception ex) {
            System.out.println("Error in function getListUrlsWebSMPagesUniv(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/infwebpage/{urlwp}")
    public PagWeb getInfoWebPageByUrlParcial(@PathVariable("urlwp") String urlwp) {
        try {
            return objDatosMultService.getInformationWP(urlwp);
        } catch (Exception ex) {
            System.out.println("Error in function getInfoWebPageByUrlParcial(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/modal/{cod_entd}")
    public List<DtsModal> getInfoModalByPage(@PathVariable("cod_entd") String cod_entd) {
        try {
            return objDatosMultService.getInformationModalByPage(cod_entd);
        } catch (Exception ex) {
            System.out.println("Error in function getInfoModalByPage(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/flt-menu/{frase}")
    public List<Menu> getInfoMenuByPhrase(@PathVariable("frase") String frase) {
        try {
            return objDatosMultService.getListFltInformationMenu(frase);
        } catch (Exception ex) {
            System.out.println("Error in function getInfoMenuByPhrase(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/flt-submenu/{frase}")
    public List<Submenu> getInfoSubMenuByPhrase(@PathVariable("frase") String frase) {
        try {
            return objDatosMultService.getListFltInformationSubMenu(frase);
        } catch (Exception ex) {
            System.out.println("Error in function getInfoSubMenuByPhrase(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/flt-news/{frase}")
    public List<Noticia> getInfoNewsByPhrase(@PathVariable("frase") String frase) {
        List<Noticia> listNews = new ArrayList<>();
        try {
            listNews = objDatosMultService.getListFltInformationNoticia(frase);

            for (Noticia n : listNews) {
                n.setNtUrlPortada("");
                n.setNtUrlSlider("");
                n.setNtCodigo(0);
                n.setObjDepartamento(new Departamento());
                n.setObjCategoriaNotc(new CategoriaNotc());
                n.setNtDescripMeta("");
                n.setNtCuerpo("");
            }

            return listNews;
        } catch (Exception ex) {
            System.out.println("Error in function getInfoNewsByPhrase(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/flt-video/{frase}")
    public List<VideoInfm> getInfoVideoByPhrase(@PathVariable("frase") String frase) {
        try {
            return objDatosMultService.getListFltInformationVideos(frase);
        } catch (Exception ex) {
            System.out.println("Error in function getInfoVideoByPhrase(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/flt-newspaper")
    public List<PeriodicoMens> getInfoNewspaperByPhrase() {
        try {
            return objDatosMultService.getListFltInformationPeriodicos();
        } catch (Exception ex) {
            System.out.println("Error in function getInfoNewspaperByPhrase(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/flt-magazine")
    public List<DatosMult> getInfoMagazineByPhrase() {
        try {
            return objDatosMultService.getListFltInformationRevistas();
        } catch (Exception ex) {
            System.out.println("Error in function getInfoMagazineByPhrase(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/flt-file/{frase}")
    public List<Archivo> getInfoFileByPhrase(@PathVariable("frase") String frase) {
        try {
            return objDatosMultService.getListFltInformationArchivos(frase);
        } catch (Exception ex) {
            System.out.println("Error in function getListDataAgreements(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/employments")
    public List<Empleo> getJobsList() {
        try {
            return objDatosMultService.getListJobsBusiness();
        } catch (Exception ex) {
            System.out.println("Error in function getJobsList(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/metrics/{codent}")
    public List<Metrica> getInfoMetricsUnivs(@PathVariable("codent") String codent) {
        try {
            return objDatosMultService.getListMetricsUniversityByArea(codent);
        } catch (Exception ex) {
            System.out.println("Error in function getInfoMetricsUnivs(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-proj-lkg")
    public List<ProyectoVinc> getListProjectLkg() {
        try {
            return objDatosMultService.getListProjectsLinkage();
        } catch (Exception ex) {
            System.out.println("Error in function getListProjectLkg(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/list-sm-proj-lkg")
    public List<ProyectoVinc> getListSMProjectLkg() {
        try {
            return objDatosMultService.getListSMProjectsLinkage();
        } catch (Exception ex) {
            System.out.println("Error in function getListSMProjectLkg(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/project-lkg/{code_pv}")
    public ProyectoVinc getInfoProject(@PathVariable("code_pv") String code_pv) {
        try {
            return objDatosMultService.getInformationOfProjectByCode(code_pv);
        } catch (Exception ex) {
            System.out.println("Error in function getInfoProject(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/project/images/{code_pv}")
    public List<GaleriaPV> getListProjectLkg(@PathVariable("code_pv") String code_pv) {
        try {
            return objDatosMultService.getListImagesProjectsPV(code_pv);
        } catch (Exception ex) {
            System.out.println("Error in function getListProjectLkg(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/research-lines")
    public List<LineaInv> getInformationResearchLines() {
        try {
            return objDatosMultService.getListResearchLines();
        } catch (Exception ex) {
            System.out.println("Error in function getInformationResearchLines(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/research-groups")
    public List<GrupoInv> getListResGroups() {
        try {
            return objDatosMultService.getListDataResearchGroups();
        } catch (Exception ex) {
            System.out.println("Error in function getListResGroups(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/research-groups-sm")
    public List<GrupoInv> getListSMResGroups() {
        try {
            return objDatosMultService.getListSMDataResearchGroups();
        } catch (Exception ex) {
            System.out.println("Error in function getListSMResGroups(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/urls-research-groups")
    public List<GrupoInv> getListUrlsResGroups() {
        try {
            return objDatosMultService.getListUrlsDataResearchGroups();
        } catch (Exception ex) {
            System.out.println("Error in function getListUrlsResGroups(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/research-group/{code_group}")
    public GrupoInv getInformationResearchGroup(@PathVariable("code_group") String code_group) {
        try {
            return objDatosMultService.getInformationResearchGroup(code_group);
        } catch (Exception ex) {
            System.out.println("Error in function getInformationResearchGroup(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/members-groups/{url_parcial}")
    public List<IntegranteGI> getListResGroups(@PathVariable("url_parcial") String url_parcial) {
        try {
            return objDatosMultService.getListGroupMembersByCode(url_parcial);
        } catch (Exception ex) {
            System.out.println("Error in function getListResGroups(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-proj-resr")
    public List<ProyectoInvst> getListProjectResr() {
        try {
            return objDatosMultService.getListResearchProjects();
        } catch (Exception ex) {
            System.out.println("Error in function getListProjectResr(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/list-sm-proj-resr")
    public List<ProyectoInvst> getListSMProjectResr() {
        try {
            return objDatosMultService.getListSMResearchProjects();
        } catch (Exception ex) {
            System.out.println("Error in function getListSMProjectResr(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-urls-proj-resr")
    public List<ProyectoInvst> getListUrlsProjectResr() {
        try {
            return objDatosMultService.getListUrlsResearchProjects();
        } catch (Exception ex) {
            System.out.println("Error in function getListUrlsProjectResr(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/research-project/{url_parcial}")
    public ProyectoInvst getInformationResearchProject(@PathVariable("url_parcial") String url_parcial) {
        try {
            return objDatosMultService.getInformationResearchProject(url_parcial);
        } catch (Exception ex) {
            System.out.println("Error in function getInformationResearchProject(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/research-project/images/{code_pi}")
    public List<GaleriaPI> getListImagesByProjectRes(@PathVariable("code_pi") String code_pi) {
        try {
            return objDatosMultService.getListImagesResearchProject(code_pi);
        } catch (Exception ex) {
            System.out.println("Error in function getListImagesByProjectRes(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/info-pw-url/{url_parcial}")
    public PagWeb getInformationOfPageWebByUrlParcial(@PathVariable("url_parcial") String url_parcial) {
        try {
            return objDatosMultService.getInformationPageWebByUrlParcial(url_parcial);
        } catch (Exception ex) {
            System.out.println("Error in function getInformationOfPageWebByUrlParcial(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/webpages/{codent}")
    public List<PagWeb> getListWebPagesUnivByCode(@PathVariable("codent") String codent) {
        try {
            return objDatosMultService.getListWebPagesByCodeEntd(codent);
        } catch (Exception ex) {
            System.out.println("Error in function getListWebPagesUnivByCode(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/urlswebpages/{codent}")
    public List<PagWeb> getListUrlsWebPagesUnivByCode(@PathVariable("codent") String codent) {
        try {
            return objDatosMultService.getListUrlsWebPagesByCodeEntd(codent);
        } catch (Exception ex) {
            System.out.println("Error in function getListUrlsWebPagesUnivByCode(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/info-faculty/{url}")
    public Departamento getInformationFacultyByUrl(@PathVariable("url") String url) {
        try {
            return objDepartamentoService.getInformationFacultyByUrl(url);
        } catch (Exception ex) {
            System.out.println("Error in function getInformationFacultyByUrl(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-urls-proj-lkg")
    public List<ProyectoVinc> getListUrlsProjectLkg() {
        try {
            return objDatosMultService.getListUrlsProjectsLinkage();
        } catch (Exception ex) {
            System.out.println("Error in function getListUrlsProjectLkg(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/testimonials")
    public List<DatosMult> getListTestmUnivs() {
        try {
            return objDatosMultService.getListTestimonialUniv();
        } catch (Exception ex) {
            System.out.println("Error in function getListTestmUnivs(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/info-labs")
    public List<DatosMult> getInformationLaboratoriesUniv() {
        try {
            return objDatosMultService.getInformationLaboratories();
        } catch (Exception ex) {
            System.out.println("Error in function getInformationLaboratoriesUniv(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/info-gallery-labs")
    public List<GaleriaLb> getListGalleryLaboratoriesUniv() {
        try {
            return objDatosMultService.getListLaboratoriesGallery();
        } catch (Exception ex) {
            System.out.println("Error in function getListGalleryLaboratoriesUniv(): " + ex.getMessage());
            return null;
        }
    }
//</editor-fold>

}
