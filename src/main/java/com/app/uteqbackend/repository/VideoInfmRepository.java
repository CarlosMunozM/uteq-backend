package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.VideoInfm;
import com.app.uteqbackend.model.keys.VideoInfmPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface VideoInfmRepository extends JpaRepository<VideoInfm, VideoInfmPK> {

    @Query(value = "SELECT *FROM vi_listado_videos_institucionales_por_tipo(:type,:limit);", nativeQuery = true)
    List<VideoInfm> getListVideosSummaryByTypeAndLimit(@Param("type") Integer type, @Param("limit") Integer limit);

    @Query("SELECT v FROM VideoInfm v JOIN v.viTipoVideo d WHERE d.dmCodgDato=?1 ORDER BY v.anio DESC, v.mes DESC, v.semana DESC")
    public List<VideoInfm> getListVideosSummarySMAndLimit(int codTipoVideo);

}
