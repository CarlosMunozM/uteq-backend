package com.app.uteqbackend.service;

import com.app.uteqbackend.model.Archivo;
import java.util.List;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface ArchivoService {

    List<Archivo> getListFilesUniversity(String type);

    List<Archivo> getSortListFilesUniversity(String type);

    List<Archivo> getListShortFilesUniversity(String type);

    List<Archivo> getListShortFilesFormatsUniversity(String type);

    List<Archivo> getListShortFilesLogosUniversity(String type);

    List<Archivo> getListShortFilesDocsUniversity(String type);

    List<Archivo> getSortListFilesTransprUniversity(String type);

    List<Archivo> getSortListFilesRendCtasUniversity(String type);
    
    //Methods by languages
    List<Archivo> getListShortFilesDocsUniversityByLanguage(String type, String language);
    
    List<Archivo> getListShortFilesDocsUniversityLanguages(String type);
    
    List<Archivo> getListShortFilesFormatsUniversityLanguages(String type);
    
    List<Archivo> getListShortFilesLogosUniversityLanguages(String type);

}
