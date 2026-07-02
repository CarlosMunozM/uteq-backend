package com.app.uteqbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.uteqbackend.model.PeriodicoMens;
import com.app.uteqbackend.model.keys.PeriodicoMensPK;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface PeriodicoMensRepository extends JpaRepository<PeriodicoMens, PeriodicoMensPK> {

    @Query(value = "SELECT *FROM pr_listado_periodicos_universitarios(:limit);", nativeQuery = true)
    List<PeriodicoMens> getListNewspaperByLimit(@Param("limit") Integer limit);

    @Query("SELECT p FROM PeriodicoMens p ORDER BY p.anio DESC, p.mes DESC")
    public List<PeriodicoMens> getListAllNewspapers();
    
}
