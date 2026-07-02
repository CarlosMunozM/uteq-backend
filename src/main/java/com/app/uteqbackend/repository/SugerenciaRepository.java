package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.Sugerencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface SugerenciaRepository extends JpaRepository<Sugerencia, Integer> {

    @Query(value = "select *FROM sg_registrar_datos_sugerencia(:name, :email, :addressee, :subject, :message);", nativeQuery = true)
    String registerDataSuggestion(@Param("name") String name, @Param("email") String email, @Param("addressee") int addressee, @Param("subject") String subject, @Param("message") String message);
    
    @Query(value = "select *FROM ad_registrar_ticket_soporte_admision(:name, :email, :addressee, :subject, :message);", nativeQuery = true)
    String registerTicketSupportAdmission(@Param("name") String name, @Param("email") String email, @Param("addressee") String addressee, @Param("subject") String subject, @Param("message") String message);

}
