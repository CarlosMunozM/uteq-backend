package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.Evento;
import com.app.uteqbackend.model.ImagenEvt;
import com.app.uteqbackend.repository.DatosMultRepository;
import com.app.uteqbackend.repository.EventoRepository;
import com.app.uteqbackend.service.EventoService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Service
public class EventoServiceImpl implements EventoService {

    //<editor-fold defaultstate="collapsed" desc="DECLARATION OF VARIABLES AND CONSTRUCTORS">
    private EventoRepository objEventoRepository;
    private DatosMultRepository objDatosMultRepository;
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    
    @Autowired
    public EventoServiceImpl(EventoRepository objEventoRepository, DatosMultRepository objDatosMultRepository) {
        super();
        this.objEventoRepository = objEventoRepository;
        this.objDatosMultRepository = objDatosMultRepository;
        calendar.setTime(date);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public EventoRepository getObjEventoRepository() {
        return objEventoRepository;
    }
    
    public void setObjEventoRepository(EventoRepository objEventoRepository) {
        this.objEventoRepository = objEventoRepository;
    }
    
    public DatosMultRepository getObjDatosMultRepository() {
        return objDatosMultRepository;
    }
    
    public void setObjDatosMultRepository(DatosMultRepository objDatosMultRepository) {
        this.objDatosMultRepository = objDatosMultRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public List<Evento> getListAllEvents(int mes) {
        List<Evento> listEvents;
        try {
            listEvents = objEventoRepository.getListAllEvents(mes, calendar.get(Calendar.YEAR));
            for (Evento e : listEvents) {
                e.setObjDepartamento(objDatosMultRepository.getInfoShortFaculty(e.getObjDepartamento().getDpCodigo()));
            }
        } catch (Exception ex) {
            System.out.println("Function getListAllEvents(): " + ex.getMessage());
            listEvents = new ArrayList<>();
        }
        return listEvents;
    }
    
    @Override
    public List<Evento> getListEventsByDept(String evCodAreaRel) {
        return objEventoRepository.getListAllEventsByDept(UUID.fromString(evCodAreaRel), calendar.get(Calendar.YEAR));
    }
    
    @Override
    public List<Evento> getListEventsByArea(String codArea) {
        List<Evento> listEvents = new ArrayList<>();
        listEvents = objEventoRepository.getListAllEventsByArea(UUID.fromString(codArea));
        return listEvents;
    }
    
    @Override
    public List<ImagenEvt> getListImagesEventsByArea(String codArea) {
        return objEventoRepository.getListAllImagesEvent(UUID.fromString(codArea));
    }
//</editor-fold>

}
