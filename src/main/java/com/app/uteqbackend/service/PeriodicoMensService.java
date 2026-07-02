package com.app.uteqbackend.service;

import com.app.uteqbackend.model.PeriodicoMens;
import java.util.List;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface PeriodicoMensService {

    List<PeriodicoMens> getListNewspaperByLimit(int registros);
    
    List<PeriodicoMens> getListAllNewspapers();
    
}
