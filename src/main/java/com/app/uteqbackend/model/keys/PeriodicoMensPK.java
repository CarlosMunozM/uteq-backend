package com.app.uteqbackend.model.keys;

import java.io.Serializable;

/**
 *
 * @author ANALISTA-TIC 2
 */
public class PeriodicoMensPK implements Serializable{
    
    private int anio;
    private int mes;

    public PeriodicoMensPK() {
    }

    public PeriodicoMensPK(int anio, int mes) {
        this.anio = anio;
        this.mes = mes;
    }
    
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.anio;
        hash = 59 * hash + this.mes;
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
        final PeriodicoMensPK other = (PeriodicoMensPK) obj;
        if (this.anio != other.anio) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        return true;
    }
    
}
