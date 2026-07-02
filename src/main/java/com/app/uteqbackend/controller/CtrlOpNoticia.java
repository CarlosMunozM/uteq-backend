package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.Noticia;
import com.app.uteqbackend.service.NoticiaService;
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
@RequestMapping("/ws/noticias")
public class CtrlOpNoticia {

    //<editor-fold defaultstate="collapsed" desc="SERVICE INTERFACE AND CONSTRUCTOR">
    private final NoticiaService objNoticiaService;

    public CtrlOpNoticia(NoticiaService objNoticiaService) {
        super();
        this.objNoticiaService = objNoticiaService;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @GetMapping("/list-all/{num}")
    public List<Noticia> getListAllNews(@PathVariable("num") int num) {
        try {
            List<Noticia> listNews = objNoticiaService.getListFilterNews();
            if (listNews.size() > num) {
                return listNews.subList(0, num);
            }
            return listNews;
        } catch (Exception ex) {
            System.out.println("Error in function getListAllNews(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-nic/{num}")
    public List<Noticia> getListAllNewsNotIncld(@PathVariable("num") int num) {
        try {
            List<Noticia> listNews = objNoticiaService.getListFilterNewsNotInclude();
            if (listNews.size() > num) {
                return listNews.subList(0, num);
            }
            return listNews;
        } catch (Exception ex) {
            System.out.println("Error in function getListAllNewsNotIncld(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-dep/{num}/{id}")
    public List<Noticia> getListNewsByDept(@PathVariable("id") String id, @PathVariable("num") int num) {
        try {
            List<Noticia> listNews = objNoticiaService.getListFilterNewsByDept(id);
            if (listNews.size() > num) {
                return listNews.subList(0, num);
            }
            return listNews;
        } catch (Exception ex) {
            System.out.println("Error in function getListNewsByDept(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/all-news-univs")
    public List<Noticia> getListCustomNewsUniversity() {
        try {
            return objNoticiaService.getListNewsDepartaments();
        } catch (Exception ex) {
            System.out.println("Error in function getListCustomNewsUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/all-urls-news-univs")
    public List<Noticia> getListCustomUrlsNewsUniversity() {
        try {
            return objNoticiaService.getListUrlNewsDepartaments();
        } catch (Exception ex) {
            System.out.println("Error in function getListCustomUrlsNewsUniversity(): " + ex.getMessage());
            return null;
        }
    }

    //
    @GetMapping("/all-sm-urls-news-univs")
    public List<Noticia> getListCustomSMUrlsNewsUniversity() {
        try {
            return objNoticiaService.getListInfoSMNewsDepartaments();
        } catch (Exception ex) {
            System.out.println("Error in function getListCustomSMUrlsNewsUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/all-info-news-univs")
    public List<Noticia> getListCustomInfoNewsUniversity() {
        try {
            return objNoticiaService.getListInfoNewsDepartaments();
        } catch (Exception ex) {
            System.out.println("Error in function getListCustomInfoNewsUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/info/{url_news}")
    public Noticia getInfoNewsUniv(@PathVariable("url_news") String url_news) {
        try {
            return objNoticiaService.getInformationOfNewsUniversity(url_news);
        } catch (Exception ex) {
            System.out.println("Error in function getInfoNewsUniv(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/six-news-univs")
    public List<Noticia> getListTopNewsUniversity() {
        try {
            return objNoticiaService.getListSixNewsUniversity();
        } catch (Exception ex) {
            System.out.println("Error in function getListTopNewsUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-six-news/{cod_news}")
    public List<Noticia> getListTopNewsDepartUniversity(@PathVariable("cod_news") int cod_news) {
        try {
            return objNoticiaService.getListSixNewsByDepUniversity(cod_news);
        } catch (Exception ex) {
            System.out.println("Error in function getListTopNewsDepartUniversity(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-flt/{list_d}/{list_c}")
    public List<Noticia> getListNewsFilter(@PathVariable("list_d") String list_d, @PathVariable("list_c") String list_c) {
        try {
            return objNoticiaService.getListFilterNewsByDepAndCatg(list_d, list_c);
        } catch (Exception ex) {
            System.out.println("Error in function getListNewsFilter(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/list-dep-flt/{code_dep}/{list_c}/{list_y}")
    public List<Noticia> getListDepartamentNewsFilter(@PathVariable("code_dep") String code_dep, @PathVariable("list_c") String list_c, @PathVariable("list_y") String list_y) {
        try {
            return objNoticiaService.getListNewsDepByParams(code_dep, list_c.trim(), list_y.trim());
        } catch (Exception ex) {
            System.out.println("Error in function getListDepartamentNewsFilter(): " + ex.getMessage());
            return null;
        }
    }
//</editor-fold>

}
