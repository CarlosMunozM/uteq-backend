package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.BoletinSeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoletinSeccionRepository extends JpaRepository<BoletinSeccion, Integer> {

    Optional<BoletinSeccion> findByCodigoIdentificador(String codigoIdentificador);
}
