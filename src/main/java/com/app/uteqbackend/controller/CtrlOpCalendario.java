package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.CalendAcdCabz;
import com.app.uteqbackend.model.CalendAcdDet;
import com.app.uteqbackend.service.CalendarioService;
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
@RequestMapping("/ws/calendar")
public class CtrlOpCalendario {

    //<editor-fold defaultstate="collapsed" desc="SERVICE INTERFACE AND CONSTRUCTOR">
    private final CalendarioService objCalendarioService;

    public CtrlOpCalendario(CalendarioService objCalendarioService) {
        super();
        this.objCalendarioService = objCalendarioService;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    
    @GetMapping("/list-calendars/{type}")
    public List<CalendAcdCabz> getListCalendarsOfUniversity(@PathVariable("type") String type) {
        try {
            return objCalendarioService.getListCalendarsOfActivitiesByDepart(type);
        } catch (Exception ex) {
            System.out.println("Error in function getListCalendarsOfUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-activities/{type}")
    public List<CalendAcdDet> getListDetailsCalendarsOfUniversity(@PathVariable("type") String type) {
        try {
            return objCalendarioService.getListCalendarsDetailsOfActivitiesByDepart(type);
        } catch (Exception ex) {
            System.out.println("Error in function getListDetailsCalendarsOfUniversity(): " + ex.getMessage());
            return null;
        }
    }
//</editor-fold>

}
