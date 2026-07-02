package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.Archivo;
import com.app.uteqbackend.repository.ArchivoRepository;
import com.app.uteqbackend.service.ArchivoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Service
public class ArchivoServiceImpl implements ArchivoService {

    //<editor-fold defaultstate="collapsed" desc="DECLARATION OF VARIABLES AND CONSTRUCTORS">
    private ArchivoRepository objArchivoRepository;

    @Autowired
    public ArchivoServiceImpl(ArchivoRepository objArchivoRepository) {
        super();
        this.objArchivoRepository = objArchivoRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public ArchivoRepository getObjArchivoRepository() {
        return objArchivoRepository;
    }

    public void setObjArchivoRepository(ArchivoRepository objArchivoRepository) {
        this.objArchivoRepository = objArchivoRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public List<Archivo> getListFilesUniversity(String type) {
        return objArchivoRepository.getListLogosUTEQ(type);
    }

    @Override
    public List<Archivo> getSortListFilesUniversity(String type) {
        return objArchivoRepository.getSortListLogosUTEQ(type);
    }

    @Override
    public List<Archivo> getListShortFilesUniversity(String type) {
        //return objArchivoRepository.getShortListLogosUTEQ(type);
        return objArchivoRepository.getShortListLogosUTEQLanguages(type);
    }

    @Override
    public List<Archivo> getListShortFilesFormatsUniversity(String type) {
        return objArchivoRepository.getShortListFormatsUTEQ(type);
    }

    @Override
    public List<Archivo> getListShortFilesLogosUniversity(String type) {
        return objArchivoRepository.getShortListImagesUTEQ(type);
    }

    @Override
    public List<Archivo> getListShortFilesDocsUniversity(String type) {
        return objArchivoRepository.getShortListDocsUTEQ(type);
    }

    @Override
    public List<Archivo> getSortListFilesTransprUniversity(String type) {
        return objArchivoRepository.getSortListTransprUTEQ(type);
    }

    @Override
    public List<Archivo> getSortListFilesRendCtasUniversity(String type) {
        return objArchivoRepository.getSortListRendCtasUTEQ(type);
    }
//</editor-fold>

    @Override
    public List<Archivo> getListShortFilesDocsUniversityByLanguage(String type, String language) {
        List<Archivo> listFls;
        
        switch (language) {
            case "en":
                listFls = objArchivoRepository.getShortListDocsUTEQLangEN(type);
                break;
            case "pt":
                listFls = objArchivoRepository.getShortListDocsUTEQLangPT(type);
                break;
            default:
                listFls = objArchivoRepository.getShortListDocsUTEQ(type);
                break;
        }
        
        return listFls;
    }

    @Override
    public List<Archivo> getListShortFilesDocsUniversityLanguages(String type) {
        return objArchivoRepository.getShortListDocsUTEQLanguages(type);
    }
    
    @Override
    public List<Archivo> getListShortFilesFormatsUniversityLanguages(String type) {
        return objArchivoRepository.getShortListFormatsUTEQLanguages(type);
    }

    @Override
    public List<Archivo> getListShortFilesLogosUniversityLanguages(String type) {
        return objArchivoRepository.getShortListImagesUTEQLanguages(type);
    }

}
