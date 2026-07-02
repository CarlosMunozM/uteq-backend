package com.app.uteqbackend.service;

import com.app.uteqbackend.model.Carrera;
import java.util.List;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface CarreraService {

    List<Carrera> getListCareersUniversityByType(String codDepart);

    List<Carrera> getListUrlsCareersUniversityByType(String codDepart);
    
    List<Carrera> getListSMUrlsCareersUniversityByType(String codDepart);

    List<Carrera> getListShortUrlsCareersUniversityByDepartm(String codDepart);

    Carrera getInformationCareerUniversityByUrlParcial(String urlParcial);

    String registerDataInscriptionMaster(String cedula, String nombreComp, String telefono, String correoElec, String codMaestria, String rutaBrochure);

    List<Carrera> getListCareersMatcUniversityByType(String codDepart);

    String registerDataEnrollmentMaster(String cedula, String nombreComp, String telefono, String correoElec, String codMaestria, String rutaBrochure, byte[] pdf1, String nombre1, byte[] pdf2, String nombre2, byte[] pdf3, String nombre3,
            byte[] pdf4, String nombre4, byte[] pdf5, String nombre5, byte[] pdf6, String nombre6, byte[] pdf7, String nombre7, byte[] pdf8, String nombre8);

    List<Carrera> getListCareersGradeUniversityByFaculty();

    List<Carrera> getListCareersGradeUniversityByCodFaculty(String codFaculty);

    List<Carrera> getListUrlsCareersGradeUniversityByFaculty();

    List<Carrera> getListUrlsInfoCareersGradeUniversityByFaculty();

    List<Carrera> getListCareersInformation(String textIn);
    
    List<Carrera> getListCareersAdms();

}
