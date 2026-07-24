package com.app.uteqbackend.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author Carlos Muñoz
 */
@Data
@Entity
@Table(name = "adm_boletin_cabecera")
public class BoletinCabecera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cabecera")
    private int idCabecera;

    @Column(name = "anio", nullable = false)
    private int anio;

    @Column(name = "mes", nullable = false)
    private int mes;

    @Column(name = "url_imagen_banner", nullable = false, length = 255)
    private String urlImagenBanner;

    @Column(name = "url_redireccion_banner", nullable = false, length = 255)
    private String urlRedireccionBanner;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    public BoletinCabecera() {
    }

    public BoletinCabecera(int idCabecera, int anio, int mes, String urlImagenBanner, String urlRedireccionBanner, Date fechaCreacion) {
        this.idCabecera = idCabecera;
        this.anio = anio;
        this.mes = mes;
        this.urlImagenBanner = urlImagenBanner;
        this.urlRedireccionBanner = urlRedireccionBanner;
        this.fechaCreacion = fechaCreacion;
    }

    public BoletinCabecera(BoletinCabecera boletinCabecera) {
        this.idCabecera = boletinCabecera.getIdCabecera();
        this.anio = boletinCabecera.getAnio();
        this.mes = boletinCabecera.getMes();
        this.urlImagenBanner = boletinCabecera.getUrlImagenBanner();
        this.urlRedireccionBanner = boletinCabecera.getUrlRedireccionBanner();
        this.fechaCreacion = boletinCabecera.getFechaCreacion();
    }

    public int getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(int idCabecera) {
        this.idCabecera = idCabecera;
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

    public String getUrlImagenBanner() {
        return urlImagenBanner;
    }

    public void setUrlImagenBanner(String urlImagenBanner) {
        this.urlImagenBanner = urlImagenBanner;
    }

    public String getUrlRedireccionBanner() {
        return urlRedireccionBanner;
    }

    public void setUrlRedireccionBanner(String urlRedireccionBanner) {
        this.urlRedireccionBanner = urlRedireccionBanner;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
