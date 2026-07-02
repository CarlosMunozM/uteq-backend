package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.Submenu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface SubmenuRepository extends JpaRepository<Submenu, Integer> {

    @Query(value = "SELECT *FROM sm_listado_opciones_submenu_por_menu(:idMenu);", nativeQuery = true)
    List<Submenu> getListElementsSubmenuByIdMenuSP(@Param("idMenu") Integer idMenu);
    
    @Query(value = "SELECT *FROM sm_listado_opciones_submenu_por_menu_lang(:idMenu);", nativeQuery = true)
    List<Submenu> getListElementsSubmenuByIdMenuSPLang(@Param("idMenu") Integer idMenu);

}
