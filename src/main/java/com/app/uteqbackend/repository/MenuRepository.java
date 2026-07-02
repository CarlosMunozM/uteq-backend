package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.Menu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query(value = "SELECT *FROM sm_listado_opciones_menu_por_tipo(:type);", nativeQuery = true)
    List<Menu> getListOptionsMenuByTypeOrderByAscSP(@Param("type") String typeMenu);

    @Query(value = "SELECT *FROM sm_listado_opciones_completa_menus();", nativeQuery = true)
    List<Menu> getListAllOptionsMenuByTypeOrderByAscSP();
    
    @Query(value = "SELECT *FROM sm_listado_opciones_completa_menus_lang();", nativeQuery = true)
    List<Menu> getListAllOptionsMenuByTypeOrderByAscSPLang();

    @Query(value = "SELECT *FROM sm_listado_opciones_menu_por_codigo(:id);", nativeQuery = true)
    List<Menu> getListElementsMenuByCodeID(@Param("id") int codeID);
    
    @Query(value = "SELECT *FROM sm_listado_opciones_menu_por_codigo_lang(:id);", nativeQuery = true)
    List<Menu> getListElementsMenuByCodeIDLang(@Param("id") int codeID);

}
