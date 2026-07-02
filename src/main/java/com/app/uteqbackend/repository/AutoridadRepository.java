package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.Autoridad;
import com.app.uteqbackend.model.AutoridadCar;
import com.app.uteqbackend.model.Organigrama;
import com.app.uteqbackend.model.TituloAcad;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface AutoridadRepository extends JpaRepository<Autoridad, UUID> {

    @Query("SELECT a FROM Autoridad a JOIN a.auObjEntDato d JOIN a.auObjCargo c WHERE d.dpEstado=1 AND a.auEstado=1 AND c.dmCodgDato=89 ORDER BY d.dpNombre ASC")
    public List<Autoridad> getListDeansUniversity();

    @Query("SELECT a FROM Autoridad a JOIN a.auObjEntDato d JOIN a.auObjCargo c WHERE d.dpEstado=1 AND a.auEstado=1 AND c.dpCodAreaInt=?1 AND c.dmCategoria='CARGO' ORDER BY c.dmOrdenPreg ASC")
    public List<Autoridad> getListAuthoritiesArea(UUID codArea);

    @Query("SELECT o FROM Organigrama o JOIN o.orObjAutoridad a WHERE o.orObjEstructura.dmCodgDato=?1 AND o.orEstado=1 ORDER BY o.orOrden ASC")
    public List<Organigrama> getListAuthoritiesByType(int type);

    @Query(value = "SELECT t FROM TituloAcad t WHERE t.taCodAutord=?1 ORDER BY t.taNivel ASC, t.taAnioGrad ASC")
    List<TituloAcad> getListTitlesByAuthorts(UUID codigo);

    @Query("SELECT a FROM Autoridad a JOIN a.auObjEntDato d JOIN a.auObjCargo c WHERE d.dpCodigo=?1 AND a.auEstado=1 AND c.dmCodgDato=89")
    Autoridad getInformationCompDean(UUID codigo);

    @Query("SELECT a FROM Autoridad a JOIN a.auObjEntDato d JOIN a.auObjCargo c WHERE d.dpCodigo=?1 AND a.auEstado=1 AND c.dmCodgDato=?2")
    Autoridad getInformationAuthority(UUID codigo, int codCargo);

    @Query("SELECT a FROM AutoridadCar a JOIN a.auObjCarrera r JOIN a.auObjCargo c WHERE r.crCodigo=?1 AND a.auEstado=1 AND c.dmCodgDato=?2")
    AutoridadCar getInformationAuthorityCareer(UUID codigo, int codCargo);

    @Query("SELECT a FROM AutoridadCar a JOIN a.auObjCarrera r JOIN a.auObjCargo c WHERE r.crUrlParcial=?1 AND a.auEstado=1 AND c.dmCodgDato=?2")
    AutoridadCar getInformationAuthorityCareerUrlPage(String urlParcial, int codCargo);

    @Query("SELECT a FROM Autoridad a JOIN a.auObjEntDato d JOIN a.auObjCargo c WHERE d.dpParcialUrl=?1 AND a.auEstado=1 AND c.dmCodgDato=?2")
    Autoridad getInformationAuthorityByFaculty(String url, int codCargo);

    @Query("SELECT new com.app.uteqbackend.model.Autoridad(a.auNombres, a.auApellidos, a.auCorreoElect) FROM Autoridad a WHERE a.auEstado=1 AND (LOWER(UNACCENT(a.auNombres)) LIKE LOWER(UNACCENT(CONCAT('%',?1,'%'))) OR LOWER(UNACCENT(a.auApellidos)) LIKE LOWER(UNACCENT(CONCAT('%',?1,'%')))) ORDER BY a.auNombres ASC, a.auApellidos ASC")
    List<Autoridad> getInformationAuthoriryByWord(@Param("textin") String textin);

}
