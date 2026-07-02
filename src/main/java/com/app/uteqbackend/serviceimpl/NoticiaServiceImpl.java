package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.Noticia;
import com.app.uteqbackend.repository.NoticiaRepository;
import com.app.uteqbackend.service.NoticiaService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Service
public class NoticiaServiceImpl implements NoticiaService {

    //<editor-fold defaultstate="collapsed" desc="DECLARATION OF VARIABLES AND CONSTRUCTORS">
    private NoticiaRepository objNoticiaRepository;
    
    @Autowired
    public NoticiaServiceImpl(NoticiaRepository objNoticiaRepository) {
        super();
        this.objNoticiaRepository = objNoticiaRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public NoticiaRepository getObjNoticiaRepository() {
        return objNoticiaRepository;
    }
    
    public void setObjNoticiaRepository(NoticiaRepository objNoticiaRepository) {
        this.objNoticiaRepository = objNoticiaRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public List<Noticia> getListFilterNews() {
        return objNoticiaRepository.getListAllEvents();
    }
    
    @Override
    public List<Noticia> getListFilterNewsByDept(String codDept) {
        return objNoticiaRepository.getListEventsByDept(UUID.fromString(codDept));
    }
    
    @Override
    public List<Noticia> getListFilterNewsNotInclude() {
        return objNoticiaRepository.getListAllEventsNotIncld();
    }
    
    @Override
    public List<Noticia> getListNewsDepartaments() {
        return objNoticiaRepository.getListNewsUniversity();
    }
    
    @Override
    public Noticia getInformationOfNewsUniversity(String urlNewsUniv) {
        return objNoticiaRepository.getInformationNewsByUrlParcial(urlNewsUniv);
    }
    
    @Override
    public List<Noticia> getListSixNewsUniversity() {
        return objNoticiaRepository.getListTopSixNewsUniversity();
    }
    
    @Override
    public List<Noticia> getListSixNewsByDepUniversity(int codNews) {
        return objNoticiaRepository.getListTopSixNewsByDepartmUniversity(codNews);
    }
    
    @Override
    public List<Noticia> getListFilterNewsByDepAndCatg(String listDepts, String listCatgs) {
        return objNoticiaRepository.getListNewsFilterByParameters(listDepts, listCatgs);
    }
    
    @Override
    public List<Noticia> getListNewsDepByParams(String codeDep, String listCtgs, String listYears) {
        return objNoticiaRepository.getListNewsDepFilterByParameters(UUID.fromString(codeDep), listCtgs, listYears);
    }
    
    @Override
    public List<Noticia> getListUrlNewsDepartaments() {
        return objNoticiaRepository.getListUrlsNewsUniversity();
    }
    
    @Override
    public List<Noticia> getListInfoNewsDepartaments() {
        List<Noticia> listNews = new ArrayList<>();
        
        listNews = objNoticiaRepository.getListInfoPrincNewsUniversity();
        if (!listNews.isEmpty()) {
            for(Noticia n: listNews){
                n.setObjDepartamento(objNoticiaRepository.getInfoShortDepartament(n.getObjDepartamento().getDpCodigo()));
            }
        }
        
        return listNews;
    }
    
    @Override
    public List<Noticia> getListInfoSMNewsDepartaments() {
        //return objNoticiaRepository.getListSMPrincNewsUniversity();
        return objNoticiaRepository.getListSMPrincNewsUniversityLang();
    }
    
//</editor-fold>

}
