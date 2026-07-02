package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.CalendAcdCabz;
import com.app.uteqbackend.model.CalendAcdDet;
import com.app.uteqbackend.repository.CalendarioRepository;
import com.app.uteqbackend.service.CalendarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Service
public class CalendarioServiceImpl implements CalendarioService {

    //<editor-fold defaultstate="collapsed" desc="DECLARATION OF VARIABLES AND CONSTRUCTORS">
    private CalendarioRepository objCalendarioRepository;
    
    @Autowired
    public CalendarioServiceImpl(CalendarioRepository objCalendarioRepository) {
        super();
        this.objCalendarioRepository = objCalendarioRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public CalendarioRepository getObjCalendarioRepository() {
        return objCalendarioRepository;
    }
    
    public void setObjCalendarioRepository(CalendarioRepository objCalendarioRepository) {
        this.objCalendarioRepository = objCalendarioRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public List<CalendAcdCabz> getListCalendarsOfActivitiesByDepart(String type) {
        List<CalendAcdCabz> listaCalendarios = objCalendarioRepository.getListCalendarsByType(type);
        for (CalendAcdCabz c : listaCalendarios) {
            c.setCbzListadoActvds(objCalendarioRepository.getListCalendarsDetailsByCodeCald(c.getCbzCodigo()));
        }
        return listaCalendarios;
    }
    
    @Override
    public List<CalendAcdDet> getListCalendarsDetailsOfActivitiesByDepart(String type) {
        return objCalendarioRepository.getListCalendarsDetailsByType(type);
    }
//</editor-fold>

}
