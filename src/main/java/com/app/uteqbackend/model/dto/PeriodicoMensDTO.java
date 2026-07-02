package com.app.uteqbackend.model.dto;

import java.io.Serializable;

/**
 *
 * @author R.PP_UTEQ
 */
public class PeriodicoMensDTO implements Serializable{
    
    private int anio;
    private int mes;
    private String urlportada;
    private String urlpw;

    public PeriodicoMensDTO() {
    }

    public PeriodicoMensDTO(int anio, int mes, String urlportada, String urlpw) {
        this.anio = anio;
        this.mes = mes;
        this.urlportada = urlportada;
        this.urlpw = urlpw;
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

    public String getUrlportada() {
        return urlportada;
    }

    public void setUrlportada(String urlportada) {
        this.urlportada = urlportada;
    }

    public String getUrlpw() {
        return urlpw;
    }

    public void setUrlpw(String urlpw) {
        this.urlpw = urlpw;
    }
    
}
