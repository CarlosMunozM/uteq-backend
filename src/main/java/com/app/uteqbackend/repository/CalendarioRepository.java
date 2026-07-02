package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.CalendAcdCabz;
import com.app.uteqbackend.model.CalendAcdDet;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface CalendarioRepository extends JpaRepository<CalendAcdCabz, Integer> {

    @Query("SELECT c FROM CalendAcdCabz c WHERE c.cbzTipo=?1 ORDER BY c.cbzAnioFin DESC, c.cbzMesFin DESC")
    public List<CalendAcdCabz> getListCalendarsByType(String type);

    @Query("SELECT d FROM CalendAcdDet d JOIN d.objCalendarioCabz c WHERE c.cbzTipo=?1 ORDER BY c.cbzAnioFin DESC, c.cbzMesFin DESC")
    public List<CalendAcdDet> getListCalendarsDetailsByType(String type);

    @Query("SELECT d FROM CalendAcdDet d JOIN d.objCalendarioCabz c WHERE c.cbzCodigo=?1 ORDER BY d.detFechaInc ASC")
    public Set<CalendAcdDet> getListCalendarsDetailsByCodeCald(int id);

}
