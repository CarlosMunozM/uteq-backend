package com.app.uteqbackend.service;

import com.app.uteqbackend.model.Departamento;
import java.util.List;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface DepartamentoService {

    Departamento getInformationDepartamentByID(String evCodAreaRel);

    List<Departamento> getListFacultiesOfUniversity();

    Departamento getInformationFacultyByUrl(String url);

    List<Departamento> getListUrlsFacultiesOfUniversity();

    List<Departamento> getListUrlsFacultiesOfUniversityV3();

}
