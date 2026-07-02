package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.Autoridad;
import com.app.uteqbackend.model.AutoridadCar;
import com.app.uteqbackend.model.Organigrama;
import com.app.uteqbackend.model.TituloAcad;
import com.app.uteqbackend.repository.AutoridadRepository;
import com.app.uteqbackend.service.AutoridadService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Service
public class AutoridadServiceImpl implements AutoridadService {

    //<editor-fold defaultstate="collapsed" desc="DECLARATION OF VARIABLES AND CONSTRUCTORS">
    private AutoridadRepository objAutoridadRepository;
    
    @Autowired
    public AutoridadServiceImpl(AutoridadRepository objAutoridadRepository) {
        super();
        this.objAutoridadRepository = objAutoridadRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public AutoridadRepository getObjAutoridadRepository() {
        return objAutoridadRepository;
    }
    
    public void setObjAutoridadRepository(AutoridadRepository objAutoridadRepository) {
        this.objAutoridadRepository = objAutoridadRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public List<Autoridad> getListDeansOfUniversity() {
        return objAutoridadRepository.getListDeansUniversity();
    }
    
    @Override
    public List<TituloAcad> getListTitlesAcadm(UUID codAutord) {
        return objAutoridadRepository.getListTitlesByAuthorts(codAutord);
    }
    
    @Override
    public List<Organigrama> getListAuthoritiesUnivByType(int type) {
        return objAutoridadRepository.getListAuthoritiesByType(type);
    }
    
    @Override
    public Autoridad getInformationDeans(UUID codDepart) {
        return objAutoridadRepository.getInformationCompDean(codDepart);
    }
    
    @Override
    public Autoridad getInformationAuthority(UUID codDepart, int codJob) {
        return objAutoridadRepository.getInformationAuthority(codDepart, codJob);
    }
    
    @Override
    public AutoridadCar getInformationAuthorityCareerUniv(UUID codCar, int codJob) {
        return objAutoridadRepository.getInformationAuthorityCareer(codCar, codJob);
    }
    
    @Override
    public List<Autoridad> getListAuthoritiesArea(UUID codArea) {
        return objAutoridadRepository.getListAuthoritiesArea(codArea);
    }
    
    @Override
    public Autoridad getInformationFacultyByUrl(String url, int codJob) {
        return objAutoridadRepository.getInformationAuthorityByFaculty(url, codJob);
    }
    
    @Override
    public AutoridadCar getInformationAuthorityCareerUnivByUrl(String urlParcial, int codJob) {
        return objAutoridadRepository.getInformationAuthorityCareerUrlPage(urlParcial, codJob);
    }
    
    @Override
    public List<Autoridad> getInformationAuthorityUnivs(String word) {
        return objAutoridadRepository.getInformationAuthoriryByWord(word);
    }
//</editor-fold>

}
