package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.RequerimientoCertf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface RequerimientoCertfRepository extends JpaRepository<RequerimientoCertf, Integer> {

    @Query(value = "select *FROM cr_datos_requerimiento_certificado(:cedula, :nombrecomp, :correoelect, :tipocertf, :mensaje);", nativeQuery = true)
    String registerRequestCertification(@Param("cedula") String cedula, @Param("nombrecomp") String nombrecomp, @Param("correoelect") String correoelect, @Param("tipocertf") int tipocertf, @Param("mensaje") String mensaje);

}
