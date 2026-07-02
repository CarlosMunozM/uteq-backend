package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.Sugerencia;
import com.app.uteqbackend.service.SugerenciaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ANALISTA-TIC 2
 */
@RestController
// @CrossOrigin(origins = {"https://webapp.uteq.edu.ec", "https://www.uteq.edu.ec/", "https://uteq.edu.ec"})
@CrossOrigin(origins = "*")
@RequestMapping("/ws/sugerencias")
public class CtrlOpSugerencia {

    //<editor-fold defaultstate="collapsed" desc="SERVICE INTERFACE AND CONSTRUCTOR">
    private final SugerenciaService objSugerenciaService;

    public CtrlOpSugerencia(SugerenciaService objSugerenciaService) {
        super();
        this.objSugerenciaService = objSugerenciaService;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @PostMapping("/register")
    public String registerDataSuggestion(@RequestBody Sugerencia objSugerencia) {
        try {
            return objSugerenciaService.registerDataSuggestion(objSugerencia.getSgNombreComp(), objSugerencia.getSgCorreoElect(), objSugerencia.getSgDestinatario(), objSugerencia.getSgAsunto(), objSugerencia.getSgMensaje()).trim();
        } catch (Exception ex) {
            System.out.println("Error in function registerDataSuggestion(): " + ex.getMessage());
            return null;
        }
    }

    @PostMapping("/register-ticket-admission")
    public String registerSupportTickerAdmission(
            @RequestParam String tcNombreComp,
            @RequestParam String tcCorreoElect,
            @RequestParam String tcDestinatario,
            @RequestParam String tcAsunto,
            @RequestParam String tcMensaje
    ) {
        try {
            return objSugerenciaService.registerDataSupportAdmission(
                    tcNombreComp,
                    tcCorreoElect,
                    tcDestinatario,
                    tcAsunto,
                    tcMensaje.trim());
        } catch (Exception ex) {
            System.out.println("Error in function registerSupportTickerAdmission(): " + ex.getMessage());
            return null;
        }
    }
//</editor-fold>

}
