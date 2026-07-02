package com.app.uteqbackend.model.keys;

import com.app.uteqbackend.model.Autoridad;
import com.app.uteqbackend.model.DatosMult;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ANALISTA-TIC 2
 */
public class OrganigramaPK implements Serializable{
    
    private DatosMult orObjEstructura;
    private Autoridad orObjAutoridad;
    private int orAnioInicio;
    private int orAnioFin;

    public OrganigramaPK() {
    }

    public OrganigramaPK(DatosMult orObjEstructura, Autoridad orObjAutoridad, int orAnioInicio, int orAnioFin) {
        this.orObjEstructura=orObjEstructura;
        this.orObjAutoridad=orObjAutoridad;
        this.orAnioInicio = orAnioInicio;
        this.orAnioFin = orAnioFin;
    }

    public DatosMult getOrObjEstructura() {
        return orObjEstructura;
    }

    public void setOrObjEstructura(DatosMult orObjEstructura) {
        this.orObjEstructura = orObjEstructura;
    }

    public Autoridad getOrObjAutoridad() {
        return orObjAutoridad;
    }

    public void setOrObjAutoridad(Autoridad orObjAutoridad) {
        this.orObjAutoridad = orObjAutoridad;
    }
    
    public int getOrAnioInicio() {
        return orAnioInicio;
    }

    public void setOrAnioInicio(int orAnioInicio) {
        this.orAnioInicio = orAnioInicio;
    }
    
    public int getOrAnioFin() {
        return orAnioFin;
    }

    public void setOrAnioFin(int orAnioFin) {
        this.orAnioFin = orAnioFin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.orObjEstructura);
        hash = 47 * hash + Objects.hashCode(this.orObjAutoridad);
        hash = 47 * hash + this.orAnioInicio;
        hash = 47 * hash + this.orAnioFin;
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
        final OrganigramaPK other = (OrganigramaPK) obj;
        if (this.orAnioInicio != other.orAnioInicio) {
            return false;
        }
        if (this.orAnioFin != other.orAnioFin) {
            return false;
        }
        if (!Objects.equals(this.orObjEstructura, other.orObjEstructura)) {
            return false;
        }
        if (!Objects.equals(this.orObjAutoridad, other.orObjAutoridad)) {
            return false;
        }
        return true;
    }
    
}
