package com.app.uteqbackend.model.keys;

import com.app.uteqbackend.model.DatosMult;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ANALISTA-TIC 2
 */
public class VideoInfmPK implements Serializable{
    
    private int anio;
    private int mes;
    private int semana;
    private DatosMult viTipoVideo;

    public VideoInfmPK() {
    }

    public VideoInfmPK(int anio, int mes, int semana, DatosMult viTipoVideo) {
        this.anio = anio;
        this.mes = mes;
        this.semana = semana;
        this.viTipoVideo = viTipoVideo;
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

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public DatosMult getViTipoVideo() {
        return viTipoVideo;
    }

    public void setViTipoVideo(DatosMult viTipoVideo) {
        this.viTipoVideo = viTipoVideo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.anio;
        hash = 29 * hash + this.mes;
        hash = 29 * hash + this.semana;
        hash = 29 * hash + Objects.hashCode(this.viTipoVideo);
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
        final VideoInfmPK other = (VideoInfmPK) obj;
        if (this.anio != other.anio) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        if (this.semana != other.semana) {
            return false;
        }
        if (!Objects.equals(this.viTipoVideo, other.viTipoVideo)) {
            return false;
        }
        return true;
    }
    
}
