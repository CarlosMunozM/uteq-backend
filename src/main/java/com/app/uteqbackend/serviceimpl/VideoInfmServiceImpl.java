package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.VideoInfm;
import com.app.uteqbackend.repository.VideoInfmRepository;
import com.app.uteqbackend.service.VideoInfmService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Service
public class VideoInfmServiceImpl implements VideoInfmService{
    
    //<editor-fold defaultstate="collapsed" desc="DECLARATION OF VARIABLES AND CONSTRUCTORS">
    private VideoInfmRepository objVideoInfmRepository;
    
    @Autowired
    public VideoInfmServiceImpl(VideoInfmRepository objVideoInfmRepository) {
        super();
        this.objVideoInfmRepository = objVideoInfmRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public VideoInfmRepository getObjVideoInfmRepository() {
        return objVideoInfmRepository;
    }
    
    public void setObjVideoInfmRepository(VideoInfmRepository objVideoInfmRepository) {
        this.objVideoInfmRepository = objVideoInfmRepository;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public List<VideoInfm> getListVideosByTypeAndLimit(int tipo) {
        return objVideoInfmRepository.getListVideosSummarySMAndLimit(tipo);
    }
    
    @Override
    public List<VideoInfm> getListVideosTypeByLimit(int tipo, int limite) {
        return objVideoInfmRepository.getListVideosSummaryByTypeAndLimit(tipo, limite);
    }
//</editor-fold>
    
}
