package com.app.uteqbackend.service;

import com.app.uteqbackend.model.Autoridad;
import com.app.uteqbackend.model.AutoridadCar;
import com.app.uteqbackend.model.Organigrama;
import com.app.uteqbackend.model.TituloAcad;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface AutoridadService {

    List<Autoridad> getListDeansOfUniversity();

    List<Organigrama> getListAuthoritiesUnivByType(int type);

    List<TituloAcad> getListTitlesAcadm(UUID codAutord);

    Autoridad getInformationDeans(UUID codDepart);

    Autoridad getInformationAuthority(UUID codDepart, int codJob);

    AutoridadCar getInformationAuthorityCareerUniv(UUID codCar, int codJob);

    List<Autoridad> getListAuthoritiesArea(UUID codArea);

    Autoridad getInformationFacultyByUrl(String url, int codJob);

    AutoridadCar getInformationAuthorityCareerUnivByUrl(String urlParcial, int codJob);

    List<Autoridad> getInformationAuthorityUnivs(String word);

}
