package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.DatosMult;
import com.app.uteqbackend.model.VideoInfm;
import com.app.uteqbackend.service.DatosMultService;
import com.app.uteqbackend.service.VideoInfmService;
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
@RequestMapping("/ws/videos")
public class CtrlOpVideoInfm {

    //<editor-fold defaultstate="collapsed" desc="SERVICE INTERFACE AND CONSTRUCTOR">
    private final VideoInfmService objVideoInfmService;
    private final DatosMultService objDatosMultService;

    public CtrlOpVideoInfm(VideoInfmService objVideoInfmService, DatosMultService objDatosMultService) {
        super();
        this.objVideoInfmService = objVideoInfmService;
        this.objDatosMultService = objDatosMultService;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @GetMapping("/list-videos-sd")
    public List<DatosMult> getListVideosSideMenuByLimit() {
        try {
            List<DatosMult> listadoTiposVideos = objDatosMultService.getListDataGeneralSort("TIPO_VIDEO");
            for (DatosMult d : listadoTiposVideos) {
                List<VideoInfm> listadoVids = objVideoInfmService.getListVideosByTypeAndLimit(d.getDmCodgDato());
                if (!listadoVids.isEmpty()) {
                    listadoVids = listadoVids.subList(0, 1);
                }
                d.setDpListadoVideos(listadoVids);
            }
            return listadoTiposVideos;
        } catch (Exception ex) {
            System.out.println("Error in function getListVideosSideMenuByLimit(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/last-videos-sd/{length}")
    public List<DatosMult> getListVideosSideMenuByLimit(@PathVariable("length") int length) {
        try {
            List<DatosMult> listadoTiposVideos = objDatosMultService.getListTypesVideos("TIPO_VIDEO");
            for (DatosMult d : listadoTiposVideos) {
                List<VideoInfm> listadoVids = objVideoInfmService.getListVideosByTypeAndLimit(d.getDmCodgDato());
                if (listadoVids.size() >= length) {
                    listadoVids = listadoVids.subList(0, length);
                }
                d.setDpListadoVideos(listadoVids);
            }
            return listadoTiposVideos;
        } catch (Exception ex) {
            System.out.println("Error in function getListVideosSideMenuByLimit(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list/{type}/{length}")
    public List<VideoInfm> getListVideosUniversity(@PathVariable("type") int type, @PathVariable("length") int length) {
        try {
            return objVideoInfmService.getListVideosTypeByLimit(type, length);
        } catch (Exception ex) {
            System.out.println("Error in function getListVideosUniversity(): " + ex.getMessage());
            return null;
        }
    }
//</editor-fold>

}
