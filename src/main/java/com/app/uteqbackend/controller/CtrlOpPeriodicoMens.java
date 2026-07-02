package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.PeriodicoMens;
import com.app.uteqbackend.service.PeriodicoMensService;
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
@RequestMapping("/ws/newspapers")
public class CtrlOpPeriodicoMens {

    //<editor-fold defaultstate="collapsed" desc="SERVICE INTERFACE AND CONSTRUCTOR">
    private final PeriodicoMensService objPeriodicoMensService;

    public CtrlOpPeriodicoMens(PeriodicoMensService objPeriodicoMensService) {
        super();
        this.objPeriodicoMensService = objPeriodicoMensService;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @GetMapping("/list-newspapers/{limit}")
    public List<PeriodicoMens> getListVideosByTypeAndLimit(@PathVariable("limit") int limit) {
        try {
            return objPeriodicoMensService.getListNewspaperByLimit(limit);
        } catch (Exception ex) {
            System.out.println("Error in function getListVideosByTypeAndLimit(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/list-newspapers/all")
    public List<PeriodicoMens> getListAllHistoryNewspapers() {
        try {
            return objPeriodicoMensService.getListAllNewspapers();
        } catch (Exception ex) {
            System.out.println("Error in function getListAllHistoryNewspapers(): " + ex.getMessage());
            return null;
        }
    }
//</editor-fold>

}
