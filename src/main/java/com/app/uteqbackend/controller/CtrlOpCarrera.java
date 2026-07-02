package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.Carrera;
import com.app.uteqbackend.service.CarreraService;
import java.util.ArrayList;
import java.util.List;
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
// @CrossOrigin(origins = {"https://webapp.uteq.edu.ec", "https://www.uteq.edu.ec/", "https://uteq.edu.ec"})
@CrossOrigin(origins="*")
@RequestMapping("/ws/data-cr")
public class CtrlOpCarrera {

    //<editor-fold defaultstate="collapsed" desc="SERVICE INTERFACE AND CONSTRUCTOR">
    private final CarreraService objCarreraService;

    public CtrlOpCarrera(CarreraService objCarreraService) {
        super();
        this.objCarreraService = objCarreraService;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @GetMapping("/careers/{id_faculty}")
    public List<Carrera> getListCareersByCodeFac(@PathVariable(name = "id_faculty", required = false) String id_faculty) {
        try {
            List<Carrera> listCareers = new ArrayList<>();
            listCareers = !id_faculty.equals("---") ? objCarreraService.getListCareersGradeUniversityByCodFaculty(id_faculty) : new ArrayList<>();
            return listCareers;
        } catch (Exception ex) {
            System.out.println("Error in function getListCareersByCodeFac(): " + ex.getMessage());
            return null;
        }
    }
//</editor-fold>

}
