package com.app.uteqbackend.service;

import com.app.uteqbackend.model.Submenu;
import java.util.List;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface SubmenuService {

    List<Submenu> getListElementsBySubmenuSP(int id_menu);
    
    List<Submenu> getListElementsBySubmenuSPLang(int id_menu);

}
