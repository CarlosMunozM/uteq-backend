package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.ParticipanteDbq;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author R.PP_UTEQ
 */
public interface DesafioRepository extends JpaRepository<ParticipanteDbq, Integer>{
    
    @Query(value = "select *FROM pt_registrar_puntos_participante(:val_dni, :val_nombres, :val_telefono, :val_edad, :val_email, :val_codigo_reg);", nativeQuery = true)
    String registerParticipant(@Param("val_dni") String cedula, @Param("val_nombres") String nombrescomp, @Param("val_telefono") String telefono, @Param("val_edad") int edad, @Param("val_email") String email,
            @Param("val_codigo_reg") String codigo);
    
    @Query(value = "SELECT * FROM pt_clasificacion_participantes()", nativeQuery = true)
    List<Object[]> getClasificacionParticipantes();
    
    @Query(value = "SELECT * FROM pt_clasificacion_participantes_v2()", nativeQuery = true)
    List<Object[]> getClasificacionParticipantesV2();
}
