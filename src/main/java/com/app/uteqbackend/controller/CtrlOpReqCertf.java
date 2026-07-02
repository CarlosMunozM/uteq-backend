package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.RequerimientoCertf;
import com.app.uteqbackend.service.RequerimientoCertfService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ANALISTA-TIC 2
 */
@RestController
// @CrossOrigin(origins = {"https://webapp.uteq.edu.ec", "https://www.uteq.edu.ec/", "https://uteq.edu.ec"})
@CrossOrigin(origins="*")
@RequestMapping("/ws/reqcertf")
public class CtrlOpReqCertf {

    //<editor-fold defaultstate="collapsed" desc="SERVICE INTERFACE AND CONSTRUCTOR">
    private final RequerimientoCertfService objRequerimientoCertfService;

    public CtrlOpReqCertf(RequerimientoCertfService objRequerimientoCertfService) {
        super();
        this.objRequerimientoCertfService = objRequerimientoCertfService;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @PostMapping("/register")
    public String registerDataSuggestion(@RequestBody RequerimientoCertf objRequerimientoCertf) {
        try {
            return objRequerimientoCertfService.registerRequestCertification(objRequerimientoCertf.getRcNumDNI(), objRequerimientoCertf.getRcNombreComp(), objRequerimientoCertf.getRcCorreoElect(), objRequerimientoCertf.getRcTipoCertf(), objRequerimientoCertf.getRcMensaje()).trim();
        } catch (Exception ex) {
            System.out.println("Error in function registerDataSuggestion(): " + ex.getMessage());
            return null;
        }
    }
//</editor-fold>

}
