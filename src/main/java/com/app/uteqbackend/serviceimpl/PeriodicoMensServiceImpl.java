package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.PeriodicoMens;
import com.app.uteqbackend.repository.PeriodicoMensRepository;
import com.app.uteqbackend.service.PeriodicoMensService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Service
public class PeriodicoMensServiceImpl implements PeriodicoMensService{
    
    //<editor-fold defaultstate="collapsed" desc="DECLARATION OF VARIABLES AND CONSTRUCTORS">
    private PeriodicoMensRepository objPeriodicoMensRepository;
    
    public PeriodicoMensServiceImpl(PeriodicoMensRepository objPeriodicoMensRepository) {
        super();
        this.objPeriodicoMensRepository = objPeriodicoMensRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public PeriodicoMensRepository getObjPeriodicoMensRepository() {
        return objPeriodicoMensRepository;
    }
    
    public void setObjPeriodicoMensRepository(PeriodicoMensRepository objPeriodicoMensRepository) {
        this.objPeriodicoMensRepository = objPeriodicoMensRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public List<PeriodicoMens> getListNewspaperByLimit(int registros) {
        return objPeriodicoMensRepository.getListNewspaperByLimit(registros);
    }
    
    @Override
    public List<PeriodicoMens> getListAllNewspapers() {
        return objPeriodicoMensRepository.getListAllNewspapers();
    }
    
//</editor-fold>

    
    
}
