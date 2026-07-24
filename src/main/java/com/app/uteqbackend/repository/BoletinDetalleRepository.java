package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.BoletinDetalle;
import com.app.uteqbackend.model.dto.BoletinDetalleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoletinDetalleRepository extends JpaRepository<BoletinDetalle, Integer> {
/*
    @Query("SELECT new com.app.uteqbackend.dto.BoletinDetalleDTO(" +
            "  d.idDetalle, s.limiteItems, s.idSeccion, d.idReferencia, n.ntUrlPortada, n.ntUrlNoticia, n.ntTitular, d.orden" +
            ") " +
            "FROM BoletinCabecera c " +
            "LEFT JOIN BoletinDetalle d ON c.idCabecera = d.objCabecera.idCabecera " +
            "LEFT JOIN BoletinSeccion s ON d.objSeccion.idSeccion = s.idSeccion " +
            "LEFT JOIN Noticia n ON d.idReferencia = n.ntCodigo " +
            "WHERE c.idCabecera = :idCabecera AND s.codigoIdentificador = 'HIST_INS' " +
            "ORDER BY d.orden ASC")
    List<BoletinDetalleDTO> findHistoriasInspiradoras(@Param("idCabecera") Integer idCabecera);
    */

}
