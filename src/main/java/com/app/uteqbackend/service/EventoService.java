package com.app.uteqbackend.service;

import com.app.uteqbackend.model.Evento;
import com.app.uteqbackend.model.ImagenEvt;
import java.util.List;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface EventoService {

    List<Evento> getListAllEvents(int mes);

    List<Evento> getListEventsByDept(String evCodAreaRel);

    List<Evento> getListEventsByArea(String codArea);

    List<ImagenEvt> getListImagesEventsByArea(String codArea);

}
