package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.Archivo;
import com.app.uteqbackend.service.ArchivoService;
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
@RequestMapping("/ws/files")
public class CtrlOpArchivo {

    //<editor-fold defaultstate="collapsed" desc="SERVICE INTERFACE AND CONSTRUCTOR">
    private final ArchivoService objArchivoService;

    public CtrlOpArchivo(ArchivoService objArchivoService) {
        super();
        this.objArchivoService = objArchivoService;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @GetMapping("/list/{type}")
    public List<Archivo> getListLogosUniversity(@PathVariable("type") String type) {
        try {
            return objArchivoService.getListFilesUniversity(type);
        } catch (Exception ex) {
            System.out.println("Error in function getListLogosUniversity(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/short-list/{type}")
    public List<Archivo> getListShortFilesUniversity(@PathVariable("type") String type) {
        try {
            return objArchivoService.getListShortFilesUniversity(type);
        } catch (Exception ex) {
            System.out.println("Error in function getListShortFilesUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/short-list-formats/{type}")
    public List<Archivo> getListShortFilesFormtsUniversity(@PathVariable("type") String type) {
        try {
            return objArchivoService.getListShortFilesFormatsUniversity(type);
        } catch (Exception ex) {
            System.out.println("Error in function getListShortFilesFormtsUniversity(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/short-list-formats-lang/{type}")
    public List<Archivo> getListShortFilesFormtsUniversityLang(@PathVariable("type") String type) {
        try {
            return objArchivoService.getListShortFilesFormatsUniversityLanguages(type);
        } catch (Exception ex) {
            System.out.println("Error in function getListShortFilesFormtsUniversityLang(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/short-list-logos/{type}")
    public List<Archivo> getListShortFilesLogosUniversity(@PathVariable("type") String type) {
        try {
            return objArchivoService.getListShortFilesLogosUniversity(type);
        } catch (Exception ex) {
            System.out.println("Error in function getListShortFilesLogosUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/short-list-fls/{type}")
    public List<Archivo> getListShortDocsFilesUniversity(@PathVariable("type") String type) {
        try {
            return objArchivoService.getListShortFilesDocsUniversity(type);
        } catch (Exception ex) {
            System.out.println("Error in function getListShortDocsFilesUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/sort-list/{type}")
    public List<Archivo> getSortListLogosUniversity(@PathVariable("type") String type) {
        try {
            return objArchivoService.getSortListFilesUniversity(type);
        } catch (Exception ex) {
            System.out.println("Error in function getSortListLogosUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/sort-transp-list/{type}")
    public List<Archivo> getSortListTransprUniversity(@PathVariable("type") String type) {
        try {
            return objArchivoService.getSortListFilesTransprUniversity(type);
        } catch (Exception ex) {
            System.out.println("Error in function getSortListTransprUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/sort-rendctas-list/{type}")
    public List<Archivo> getSortListRendCtasUniversity(@PathVariable("type") String type) {
        try {
            return objArchivoService.getSortListFilesRendCtasUniversity(type);
        } catch (Exception ex) {
            System.out.println("Error in function getSortListRendCtasUniversity(): " + ex.getMessage());
            return null;
        }
    }
    
    //Methods by language
    @GetMapping("/list-files-lang/{type}/{language}")
    public List<Archivo> getListShortDocsFilesUniversityByLanguage(@PathVariable("type") String type, @PathVariable("language") String language) {
        try {
            return objArchivoService.getListShortFilesDocsUniversityByLanguage(type, language);
        } catch (Exception ex) {
            System.out.println("Error in function getListShortDocsFilesUniversityByLanguage(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/files-languages/{type}")
    public List<Archivo> getListShortDocsFilesUniversityLanguages(@PathVariable("type") String type) {
        try {
            return objArchivoService.getListShortFilesDocsUniversityLanguages(type);
        } catch (Exception ex) {
            System.out.println("Error in function getListShortDocsFilesUniversityLanguages(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/short-list-logos-lang/{type}")
    public List<Archivo> getListShortFilesLogosUniversityLang(@PathVariable("type") String type) {
        try {
            return objArchivoService.getListShortFilesLogosUniversityLanguages(type);
        } catch (Exception ex) {
            System.out.println("Error in function getListShortFilesLogosUniversityLang(): " + ex.getMessage());
            return null;
        }
    }
    
    
//</editor-fold>

}
