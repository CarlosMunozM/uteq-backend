package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.ParticipanteDbq;
import com.app.uteqbackend.model.Sugerencia;
import com.app.uteqbackend.model.dto.ClasificacionDesfDTO;
import com.app.uteqbackend.service.DesafioService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author R.PP_UTEQ
 */

@RestController
// @CrossOrigin(origins = {"https://webapp.uteq.edu.ec", "https://www.uteq.edu.ec/", "https://uteq.edu.ec"})
@CrossOrigin(origins="*")
@RequestMapping("/ws/desafio-uteq")
public class CtrlOpDesafio {
    
    private final DesafioService objDesafioService;

    public CtrlOpDesafio(DesafioService objDesafioService) {
        super();
        this.objDesafioService = objDesafioService;
    }
    
    @PostMapping("/register-points")
    public String registerPointsParticipant(@RequestBody ParticipanteDbq objParticipanteDbq) {
        try {
            return objDesafioService.operation_register_participant(objParticipanteDbq.getPdbqDni(), objParticipanteDbq.getPdbqNombres(), objParticipanteDbq.getPdbqTelefono(), objParticipanteDbq.getPdbqEdad(), objParticipanteDbq.getPdbqEmail(), objParticipanteDbq.getPdbqCodigoReq());
        } catch (Exception ex) {
            System.out.println("Error in function registerPointsParticipant(): " + ex.getMessage());
            return "EXCAPI";
        }
    }
    
    @GetMapping("/clasificacion")
    public ResponseEntity<List<ClasificacionDesfDTO>> obtenerClasificacion() {
        List<ClasificacionDesfDTO> clasificacion = objDesafioService.operation_list_participants_ranking();
        return ResponseEntity.ok(clasificacion);
    }
    
    @GetMapping("/clasificacion-v2")
    public ResponseEntity<List<ClasificacionDesfDTO>> obtenerClasificacionV2() {
        List<ClasificacionDesfDTO> clasificacion = objDesafioService.operation_list_participants_ranking_v2();
        return ResponseEntity.ok(clasificacion);
    }
    
}
