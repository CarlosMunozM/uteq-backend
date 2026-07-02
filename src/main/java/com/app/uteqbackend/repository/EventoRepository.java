package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.Evento;
import com.app.uteqbackend.model.ImagenEvt;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    @Query("SELECT new com.app.uteqbackend.model.Evento(e.evCodigo, e.evDescripcion, e.evFecha, e.objDepartamento, e.evtUrlAfiche, e.evDescripcionEn, e.evDescripcionPt,e.evtUrlAficheEn, e.evtUrlAfichePt) FROM Evento e JOIN e.objDepartamento d WHERE d.dpEstado=1 AND e.evEstado=1 AND EXTRACT(MONTH FROM e.evFecha)>=?1 AND EXTRACT(YEAR FROM e.evFecha)=?2 ORDER BY e.evFecha ASC")
    public List<Evento> getListAllEvents(int mes, int anio);

    @Query("SELECT e FROM Evento e JOIN e.objDepartamento d WHERE d.dpEstado=1 AND e.evEstado=1 AND d.dpCodigo=?1 AND EXTRACT(YEAR FROM e.evFecha)=?2 ORDER BY e.evFecha DESC")
    public List<Evento> getListAllEventsByDept(UUID codigo, int anio);

    @Query("SELECT e FROM Evento e JOIN e.objAreaRelc a WHERE a.pwEstado=1 AND e.evEstado=1 AND a.pwCodigo=?1 ORDER BY e.evFecha DESC")
    public List<Evento> getListAllEventsByArea(UUID codigoArea);

    @Query("SELECT i FROM ImagenEvt i JOIN i.objEvento e JOIN e.objAreaRelc a WHERE i.ieEstado=1 AND a.pwEstado=1 AND e.evEstado=1 AND a.pwCodigo=?1")
    public List<ImagenEvt> getListAllImagesEvent(UUID codigoArea);

}
