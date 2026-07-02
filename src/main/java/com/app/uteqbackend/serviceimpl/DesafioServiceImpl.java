package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.dto.ClasificacionDesfDTO;
import com.app.uteqbackend.repository.DesafioRepository;
import com.app.uteqbackend.service.DesafioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author R.PP_UTEQ
 */
@Service
public class DesafioServiceImpl implements DesafioService {

    private DesafioRepository objDesafioRepository;

    @Autowired
    public DesafioServiceImpl(DesafioRepository objDesafioRepository) {
        super();
        this.objDesafioRepository = objDesafioRepository;
    }

    public DesafioRepository getObjDesafioRepository() {
        return objDesafioRepository;
    }

    public void setObjDesafioRepository(DesafioRepository objDesafioRepository) {
        this.objDesafioRepository = objDesafioRepository;
    }

    @Override
    public String operation_register_participant(String cedula, String nombrescomp, String telefono, int edad, String email, String codigo) {
        String msg = "";

        try {
            msg = objDesafioRepository.registerParticipant(cedula, nombrescomp, telefono, edad, email, codigo);
        } catch (Exception ex) {
            System.out.println("Function operation_register_participant(): " + ex.getMessage());
            msg = "ERREXC";
        }

        return msg;
    }
    
    @Override
    public List<ClasificacionDesfDTO> operation_list_participants_ranking() {
        List<Object[]> resultados = objDesafioRepository.getClasificacionParticipantes();
        List<ClasificacionDesfDTO> participantes = new ArrayList<>();

        for (Object[] fila : resultados) {
            String nombres = (String) fila[0];
            Integer puntos = (Integer) fila[1];
            participantes.add(new ClasificacionDesfDTO(nombres, puntos));
        }

        return participantes;
    }

    @Override
    public List<ClasificacionDesfDTO> operation_list_participants_ranking_v2() {
        List<Object[]> resultados = objDesafioRepository.getClasificacionParticipantesV2();
        List<ClasificacionDesfDTO> participantes = new ArrayList<>();

        for (Object[] fila : resultados) {
            String nombres = (String) fila[0];
            Integer puntos = (Integer) fila[1];
            String tiempo = (String) fila[2];
            participantes.add(new ClasificacionDesfDTO(nombres, puntos, tiempo));
        }

        return participantes;
    }

}
