package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.Evento;
import com.app.uteqbackend.model.ImagenEvt;
import com.app.uteqbackend.service.EventoService;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
@RequestMapping("/ws/eventos")
public class CtrlOpEvento {

    //<editor-fold defaultstate="collapsed" desc="SERVICE INTERFACE AND CONSTRUCTOR">
    private final EventoService objEventoService;

    public CtrlOpEvento(EventoService objEventoService) {
        super();
        this.objEventoService = objEventoService;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    
    @GetMapping("/list-filt/{num}")
    public List<Evento> getGeneralListEvents(@PathVariable("num") int num) {
        GregorianCalendar date = new GregorianCalendar();

        try {
            List<Evento> listEvents = objEventoService.getListAllEvents(date.get(Calendar.MONTH) + 1);
            if (listEvents.size() > num) {
                return listEvents.subList(0, num);
            }
            return listEvents;
        } catch (Exception ex) {
            System.out.println("Error in function getGeneralListEvents(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list/{id}")
    public List<Evento> getListEventsByDept(@PathVariable("id") String id) {
        try {
            return objEventoService.getListEventsByDept(id);
        } catch (Exception ex) {
            System.out.println("Error in function getListEventsByDept(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-area/{id}")
    public List<Evento> getListEventsByArea(@PathVariable("id") String id) {
        try {
            return objEventoService.getListEventsByArea(id);
        } catch (Exception ex) {
            System.out.println("Error in function getListEventsByArea(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/imgs-evts/{id}")
    public List<ImagenEvt> getListImagesByArea(@PathVariable("id") String id) {
        try {
            return objEventoService.getListImagesEventsByArea(id);
        } catch (Exception ex) {
            System.out.println("Error in function getListImagesByArea(): " + ex.getMessage());
            return null;
        }
    }
//</editor-fold>

}
