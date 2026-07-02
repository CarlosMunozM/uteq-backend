package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.Autoridad;
import com.app.uteqbackend.model.AutoridadCar;
import com.app.uteqbackend.model.Organigrama;
import com.app.uteqbackend.service.AutoridadService;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ANALISTA-TIC 2
 */
@RestController
// @CrossOrigin(origins = {"https://webapp.uteq.edu.ec", "https://www.uteq.edu.ec/", "https://uteq.edu.ec", "http://chatbotwebscript.neocities.org/"})
@CrossOrigin(origins="*")
@RequestMapping("/ws/authorities")
public class CtrlOpAutoridad {

    //<editor-fold defaultstate="collapsed" desc="SERVICE INTERFACE AND CONSTRUCTOR">
    private final AutoridadService objAutoridadService;

    public CtrlOpAutoridad(AutoridadService objAutoridadService) {
        super();
        this.objAutoridadService = objAutoridadService;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @GetMapping("/list-deans")
    public List<Autoridad> getListDeansOfUniversity() {
        try {
            List<Autoridad> listAuthrs = objAutoridadService.getListDeansOfUniversity();
            listAuthrs.forEach(a -> {
                a.setAuListadoTitulosAcad(objAutoridadService.getListTitlesAcadm(a.getAuCodigo()));
            });
            return listAuthrs;
        } catch (Exception ex) {
            System.out.println("Error in function getListDeansOfUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-area/{code_area}")
    public List<Autoridad> getListAreaAuthorities(@PathVariable("code_area") UUID code_area) {
        try {
            List<Autoridad> listAuthrs = objAutoridadService.getListAuthoritiesArea(code_area);
            listAuthrs.forEach(a -> {
                a.setAuListadoTitulosAcad(objAutoridadService.getListTitlesAcadm(a.getAuCodigo()));
            });
            return listAuthrs;
        } catch (Exception ex) {
            System.out.println("Error in function getListAreaAuthorities(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/dean/{code_dep}")
    public Autoridad getInfoDean(@PathVariable("code_dep") UUID code_dep) {
        try {
            Autoridad objAutoridad = objAutoridadService.getInformationDeans(code_dep);
            if (objAutoridad != null) {
                objAutoridad.setAuListadoTitulosAcad(objAutoridadService.getListTitlesAcadm(objAutoridad.getAuCodigo()));
            }
            return objAutoridad;
        } catch (Exception ex) {
            System.out.println("Error in function getInfoDean(): " + ex.getMessage());
            return null;
        }

    }

    @GetMapping("/info-job/{code_dep}/{code_job}")
    public Autoridad getInfoAuthority(@PathVariable("code_dep") UUID code_dep, @PathVariable("code_job") int code_job) {
        try {
            Autoridad objAutoridad = objAutoridadService.getInformationAuthority(code_dep, code_job);
            if (objAutoridad != null) {
                objAutoridad.setAuListadoTitulosAcad(objAutoridadService.getListTitlesAcadm(objAutoridad.getAuCodigo()));
            }
            return objAutoridad;
        } catch (Exception ex) {
            System.out.println("Error in function getInfoAuthority(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/information-pers/{url}/{code_job}")
    public Autoridad getInformationAuthorityByDep(@PathVariable("url") String url, @PathVariable("code_job") int code_job) {
        try {
            Autoridad objAutoridad = objAutoridadService.getInformationFacultyByUrl(url.trim(), code_job);
            if (objAutoridad != null) {
                objAutoridad.setAuListadoTitulosAcad(objAutoridadService.getListTitlesAcadm(objAutoridad.getAuCodigo()));
            }
            return objAutoridad;
        } catch (Exception ex) {
            System.out.println("Error in function getInformationAuthorityByDep(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/info-car/{code_car}/{code_job}")
    public AutoridadCar getInfoAuthorityByCareer(@PathVariable("code_car") UUID code_car, @PathVariable("code_job") int code_job) {
        try {
            AutoridadCar objAutoridad = objAutoridadService.getInformationAuthorityCareerUniv(code_car, code_job);
            if (objAutoridad != null) {
                objAutoridad.setAuListadoTitulosAcad(objAutoridadService.getListTitlesAcadm(objAutoridad.getAuCodigo()));
            }
            return objAutoridad;
        } catch (Exception ex) {
            System.out.println("Error in function getInfoAuthorityByCareer(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/information/{url}/{code_job}")
    public AutoridadCar getInfoAuthorityCareerByUrl(@PathVariable("url") String url, @PathVariable("code_job") int code_job) {
        try {
            AutoridadCar objAutoridad = objAutoridadService.getInformationAuthorityCareerUnivByUrl(url, code_job);
            if (objAutoridad != null) {
                objAutoridad.setAuListadoTitulosAcad(objAutoridadService.getListTitlesAcadm(objAutoridad.getAuCodigo()));
            }
            return objAutoridad;
        } catch (Exception ex) {
            System.out.println("Error in function getInfoAuthorityCareerByUrl(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-org-inst/{type}")
    public List<Organigrama> getListAuthoritiesByType(@PathVariable("type") int type) {
        try {
            List<Organigrama> listAuthr = objAutoridadService.getListAuthoritiesUnivByType(type);
            listAuthr.forEach(o -> {
                o.getOrObjAutoridad().setAuListadoTitulosAcad(objAutoridadService.getListTitlesAcadm(o.getOrObjAutoridad().getAuCodigo()));
            });
            return listAuthr;
        } catch (Exception ex) {
            System.out.println("Error in function getListAuthoritiesByType(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/search/{word}")
    public List<Autoridad> getInfoAuthorityByWord(@PathVariable("word") String word) {
        try {
            return objAutoridadService.getInformationAuthorityUnivs(word);
        } catch (Exception ex) {
            System.out.println("Error in function getInfoAuthorityByWord(): " + ex.getMessage());
            return null;
        }
    }
//</editor-fold>

}
