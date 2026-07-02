package com.app.uteqbackend.service;

import com.app.uteqbackend.model.Noticia;
import java.util.List;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface NoticiaService {

    List<Noticia> getListFilterNews();

    List<Noticia> getListFilterNewsNotInclude();

    List<Noticia> getListFilterNewsByDept(String codDept);

    List<Noticia> getListNewsDepartaments();

    Noticia getInformationOfNewsUniversity(String urlNewsUniv);

    List<Noticia> getListSixNewsUniversity();

    List<Noticia> getListSixNewsByDepUniversity(int codNews);

    List<Noticia> getListFilterNewsByDepAndCatg(String listDepts, String listCatgs);

    List<Noticia> getListNewsDepByParams(String codeDep, String listCtgs, String listYears);

    List<Noticia> getListUrlNewsDepartaments();

    List<Noticia> getListInfoNewsDepartaments();
    
    List<Noticia> getListInfoSMNewsDepartaments();

}
