package com.app.uteqbackend.service;

import com.app.uteqbackend.model.VideoInfm;
import java.util.List;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface VideoInfmService {

    List<VideoInfm> getListVideosByTypeAndLimit(int tipo);

    List<VideoInfm> getListVideosTypeByLimit(int tipo, int limite);

}
