package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.SliderDet;
import com.app.uteqbackend.service.SliderService;
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
@RequestMapping("/ws/sliders")
public class CtrlOpSlider {

    //<editor-fold defaultstate="collapsed" desc="SERVICE INTERFACE AND CONSTRUCTOR">
    private final SliderService objSliderService;

    public CtrlOpSlider(SliderService objSliderService) {
        super();
        this.objSliderService = objSliderService;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    
    @GetMapping("/slider/list-images/{location}/{idserial}")
    public List<SliderDet> getMenuAndSubmenuByType(@PathVariable("location") String location, @PathVariable("idserial") int idserial) {
        try {
            return objSliderService.getListImageSliderByParamSP(location, idserial);
        } catch (Exception ex) {
            System.out.println("Error in function getMenuAndSubmenuByType(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/slider/images/{id_entd}")
    public List<SliderDet> getSliderDetailsByEntity(@PathVariable("id_entd") String id_entd) {
        try {
            return objSliderService.getListImageSliderByEntity(id_entd);
        } catch (Exception ex) {
            System.out.println("Error in function getSliderDetailsByEntity(): " + ex.getMessage());
            return null;
        }
    }
//</editor-fold>

}
