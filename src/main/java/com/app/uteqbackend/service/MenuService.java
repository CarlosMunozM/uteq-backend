package com.app.uteqbackend.service;

import com.app.uteqbackend.model.Menu;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface MenuService {

    List<Menu> getListMenus();

    Optional<Menu> getListMenusById(int mnCodigo);

    List<Menu> getListElementsMenuByTypeSP(String type);

    List<Menu> getListElementsMenuByCodeID(int codeID);

    List<Menu> getListAllElementsMenuByTypeSP();
    
    List<Menu> getListAllElementsMenuByTypeSPLang();
    
    List<Menu> getListElementsMenuByCodeIDLang(int codeID);

}
