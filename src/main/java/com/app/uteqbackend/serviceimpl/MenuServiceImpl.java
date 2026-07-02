package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.Menu;
import com.app.uteqbackend.model.Submenu;
import com.app.uteqbackend.repository.MenuRepository;
import com.app.uteqbackend.repository.SubmenuRepository;
import com.app.uteqbackend.service.MenuService;
import com.app.uteqbackend.service.SubmenuService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Service
public class MenuServiceImpl implements MenuService, SubmenuService{

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private MenuRepository objMenuRepository;
    private SubmenuRepository objSubmenuRepository;
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor and gets/sets">
    @Autowired
    public MenuServiceImpl(MenuRepository objMenuRepository, SubmenuRepository objSubmenuRepository) {
        super();
        this.objMenuRepository = objMenuRepository;
        this.objSubmenuRepository = objSubmenuRepository;
    }
    
    public MenuRepository getObjMenuRepository() {
        return objMenuRepository;
    }
    
    public void setObjMenuRepository(MenuRepository objMenuRepository) {
        this.objMenuRepository = objMenuRepository;
    }
    
    public SubmenuRepository getObjSubmenuRepository() {
        return objSubmenuRepository;
    }
    
    public void setObjSubmenuRepository(SubmenuRepository objSubmenuRepository) {
        this.objSubmenuRepository = objSubmenuRepository;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    @Override
    public List<Menu> getListMenus() {
        return objMenuRepository.findAll();
    }
    
    @Override
    public Optional<Menu> getListMenusById(int mnCodigo) {
        return objMenuRepository.findById(mnCodigo);
    }
    
    /*@Override
    public List<Menu> getListElementsMenuByType(String type){
        return objMenuRepository.getListOptionsMenuByTypeOrderByAsc(type);
    }*/
    
    @Override
    public List<Menu> getListElementsMenuByTypeSP(String type){
        return objMenuRepository.getListOptionsMenuByTypeOrderByAscSP(type);
    }
    
    /*@Override
    public List<Submenu> getListElementsBySubmenuID(int id_menu) {
        return objSubmenuRepository.getListElementsSubmenuByIdMenu(id_menu);
    }*/
    
    @Override
    public List<Submenu> getListElementsBySubmenuSP(int id_menu) {
        return objSubmenuRepository.getListElementsSubmenuByIdMenuSP(id_menu);
    }
    
    @Override
    public List<Menu> getListElementsMenuByCodeID(int codeID) {
        return objMenuRepository.getListElementsMenuByCodeID(codeID);
    }
    
    @Override
    public List<Menu> getListAllElementsMenuByTypeSP() {
        return objMenuRepository.getListAllOptionsMenuByTypeOrderByAscSP();
    }
    
    
    //Methods by languages
    @Override
    public List<Menu> getListAllElementsMenuByTypeSPLang() {
        return objMenuRepository.getListAllOptionsMenuByTypeOrderByAscSPLang();
    }
    
    @Override
    public List<Submenu> getListElementsBySubmenuSPLang(int id_menu) {
        return objSubmenuRepository.getListElementsSubmenuByIdMenuSPLang(id_menu);
    }
    
    @Override
    public List<Menu> getListElementsMenuByCodeIDLang(int codeID) {
        return objMenuRepository.getListElementsMenuByCodeIDLang(codeID);
    }
    
//</editor-fold>
    
}
