package com.app.uteqbackend.service;

import com.app.uteqbackend.model.SliderDet;
import java.util.List;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface SliderService {

    List<SliderDet> getListImageSliderByParamSP(String location, int idSlider);

    List<SliderDet> getListImageSliderByEntity(String id_entd);

}
