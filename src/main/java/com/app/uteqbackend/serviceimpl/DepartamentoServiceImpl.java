package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.Departamento;
import com.app.uteqbackend.repository.DatosMultRepository;
import com.app.uteqbackend.service.DepartamentoService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Service
public class DepartamentoServiceImpl implements DepartamentoService{
    
    //<editor-fold defaultstate="collapsed" desc="DECLARATION OF VARIABLES AND CONSTRUCTORS">
    private DatosMultRepository objDatosMultRepository;
    
    @Autowired
    public DepartamentoServiceImpl(DatosMultRepository objDatosMultRepository) {
        super();
        this.objDatosMultRepository = objDatosMultRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public DatosMultRepository getObjDatosMultRepository() {
        return objDatosMultRepository;
    }
    
    public void setObjDatosMultRepository(DatosMultRepository objDatosMultRepository) {
        this.objDatosMultRepository = objDatosMultRepository;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public Departamento getInformationDepartamentByID(String evCodAreaRel) {
        return objDatosMultRepository.getInformationDepartamentByID(UUID.fromString(evCodAreaRel));
    }
    
    @Override
    public List<Departamento> getListFacultiesOfUniversity() {
        return objDatosMultRepository.getListDepartamentsAsFaculty();
    }
    
    @Override
    public Departamento getInformationFacultyByUrl(String url) {
        return objDatosMultRepository.getInformationDepartamentByUrlParcial(url);
    }
    
    @Override
    public List<Departamento> getListUrlsFacultiesOfUniversity() {
        return objDatosMultRepository.getListUrlsDepartamentsAsFaculty();
    }
    
    @Override
    public List<Departamento> getListUrlsFacultiesOfUniversityV3() {
        return objDatosMultRepository.getListUrlsDepartamentsAsFacultyV3();
    }
//</editor-fold>
    
}
