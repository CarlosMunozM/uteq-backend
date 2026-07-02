package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.SliderDet;
import com.app.uteqbackend.repository.SliderRepository;
import com.app.uteqbackend.service.SliderService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Service
public class SliderServiceImpl implements SliderService{
    
    //<editor-fold defaultstate="collapsed" desc="DECLARATION OF VARIABLES AND CONSTRUCTORS">
    private SliderRepository objSliderRepository;
    
    @Autowired
    public SliderServiceImpl(SliderRepository objSliderRepository) {
        super();
        this.objSliderRepository = objSliderRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public SliderRepository getObjSliderRepository() {
        return objSliderRepository;
    }
    
    public void setObjSliderRepository(SliderRepository objSliderRepository) {
        this.objSliderRepository = objSliderRepository;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public List<SliderDet> getListImageSliderByParamSP(String location, int idSlider) {
        return objSliderRepository.getListImagesSliderByIdAndLocation(location, idSlider);
    }
    
    @Override
    public List<SliderDet> getListImageSliderByEntity(String id_entd) {
        return objSliderRepository.getListImagesSliderByEntity(UUID.fromString(id_entd));
    }
//</editor-fold>
    
}
