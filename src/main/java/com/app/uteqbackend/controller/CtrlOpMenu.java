package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.Menu;
import com.app.uteqbackend.service.MenuService;
import com.app.uteqbackend.service.SubmenuService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ANALISTA-TIC 2
 */
@RestController
// @CrossOrigin(origins = {"https://webapp.uteq.edu.ec", "https://www.uteq.edu.ec/", "https://uteq.edu.ec"})
@CrossOrigin(origins="*")
@RequestMapping("/ws/menus")
public class CtrlOpMenu {

    //<editor-fold defaultstate="collapsed" desc="SERVICE INTERFACE AND CONSTRUCTOR">
    private final MenuService objMenuService;
    private final SubmenuService objSubmenuService;

    public CtrlOpMenu(MenuService objMenuService, SubmenuService objSubmenuService) {
        super();
        this.objMenuService = objMenuService;
        this.objSubmenuService = objSubmenuService;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    
    @GetMapping("/list-all")
    public List<Menu> getListMenus() {
        try {
            return objMenuService.getListMenus();
        } catch (Exception ex) {
            System.out.println("Error in function getListMenus(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/menu/list-options/{type}")
    public List<Menu> getMenuAndSubmenuByType(@PathVariable("type") String type) {
        List<Menu> listElementsMenu;

        try {
            listElementsMenu = objMenuService.getListElementsMenuByTypeSP(type);
            listElementsMenu.forEach(m -> {
                m.setMnListadoSubmenus(objSubmenuService.getListElementsBySubmenuSPLang(m.getMnCodigo()));
            });
            return listElementsMenu;
        } catch (Exception ex) {
            System.out.println("Error in function getMenuAndSubmenuByType(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/menu/list-all-options")
    public List<Menu> getAllMenuAndSubmenuByType() {
        List<Menu> listElementsMenu;

        try {
            //listElementsMenu = objMenuService.getListAllElementsMenuByTypeSP();
            listElementsMenu = objMenuService.getListAllElementsMenuByTypeSPLang();
            listElementsMenu.forEach(m -> {
                //m.setMnListadoSubmenus(objSubmenuService.getListElementsBySubmenuSP(m.getMnCodigo()));
                m.setMnListadoSubmenus(objSubmenuService.getListElementsBySubmenuSPLang(m.getMnCodigo()));
            });
            return listElementsMenu;
        } catch (Exception ex) {
            System.out.println("Error in function getAllMenuAndSubmenuByType(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/menu/list-all-options-lang")
    public List<Menu> getAllMenuAndSubmenuByTypeLang() {
        List<Menu> listElementsMenu;

        try {
            listElementsMenu = objMenuService.getListAllElementsMenuByTypeSPLang();
            listElementsMenu.forEach(m -> {
                m.setMnListadoSubmenus(objSubmenuService.getListElementsBySubmenuSPLang(m.getMnCodigo()));
            });
            return listElementsMenu;
        } catch (Exception ex) {
            System.out.println("Error in function getAllMenuAndSubmenuByTypeLang(): " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/menu/list/{id}")
    public List<Menu> getMenuAndSubmenuByCodeId(@PathVariable("id") int code_id) {
        List<Menu> listElementsMenu;

        try {
            listElementsMenu = objMenuService.getListElementsMenuByCodeID(code_id);
            listElementsMenu.forEach(m -> {
                m.setMnListadoSubmenus(objSubmenuService.getListElementsBySubmenuSP(m.getMnCodigo()));
            });
            return listElementsMenu;
        } catch (Exception ex) {
            System.out.println("Error in function getMenuAndSubmenuByCodeId(): " + ex.getMessage());
            return null;
        }
    }
    
    @GetMapping("/menu/list-lang/{id}")
    public List<Menu> getMenuAndSubmenuByCodeIdLang(@PathVariable("id") int code_id) {
        List<Menu> listElementsMenu;

        try {
            listElementsMenu = objMenuService.getListElementsMenuByCodeIDLang(code_id);
            listElementsMenu.forEach(m -> {
                m.setMnListadoSubmenus(objSubmenuService.getListElementsBySubmenuSPLang(m.getMnCodigo()));
            });
            return listElementsMenu;
        } catch (Exception ex) {
            System.out.println("Error in function getMenuAndSubmenuByCodeIdLang(): " + ex.getMessage());
            return null;
        }
    }
    
//</editor-fold>

}
