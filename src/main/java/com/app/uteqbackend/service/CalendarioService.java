package com.app.uteqbackend.service;

import com.app.uteqbackend.model.CalendAcdCabz;
import com.app.uteqbackend.model.CalendAcdDet;
import java.util.List;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface CalendarioService {

    List<CalendAcdCabz> getListCalendarsOfActivitiesByDepart(String type);

    List<CalendAcdDet> getListCalendarsDetailsOfActivitiesByDepart(String type);

}
