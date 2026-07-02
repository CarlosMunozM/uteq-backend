package com.app.uteqbackend.model.keys;

import com.app.uteqbackend.model.Departamento;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author ANALISTA-TIC 2
 */
public class CarreraPK implements Serializable{
    private UUID crCodigo;
    private Departamento crDepartamento;

    public CarreraPK() {
    }

    public CarreraPK(UUID crCodigo, Departamento crDepartamento) {
        this.crCodigo = crCodigo;
        this.crDepartamento = crDepartamento;
    }

    public UUID getCrCodigo() {
        return crCodigo;
    }

    public void setCrCodigo(UUID crCodigo) {
        this.crCodigo = crCodigo;
    }

    public Departamento getCrDepartamento() {
        return crDepartamento;
    }

    public void setCrDepartamento(Departamento crDepartamento) {
        this.crDepartamento = crDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.crCodigo);
        hash = 29 * hash + Objects.hashCode(this.crDepartamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CarreraPK other = (CarreraPK) obj;
        if (!Objects.equals(this.crCodigo, other.crCodigo)) {
            return false;
        }
        if (!Objects.equals(this.crDepartamento, other.crDepartamento)) {
            return false;
        }
        return true;
    }
    
}
