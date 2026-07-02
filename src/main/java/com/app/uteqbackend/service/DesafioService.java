package com.app.uteqbackend.service;

import com.app.uteqbackend.model.dto.ClasificacionDesfDTO;
import java.util.List;

/**
 *
 * @author R.PP_UTEQ
 */
public interface DesafioService {
    
    String operation_register_participant(String cedula, String nombrescomp, String telefono, int edad, String email, String codigo);
    
    List<ClasificacionDesfDTO> operation_list_participants_ranking();
    
    List<ClasificacionDesfDTO> operation_list_participants_ranking_v2();
}
