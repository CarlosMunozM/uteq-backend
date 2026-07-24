package com.app.uteqbackend.model;

import lombok.Data;

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
@Table(name = "adm_boletin_secciones")
public class BoletinSeccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seccion")
    private Integer idSeccion;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "codigo_identificador", nullable = false, unique = true, length = 20)
    private String codigoIdentificador;

    @Column(name = "limite_items")
    private Integer limiteItems;

    @Column(name = "es_automatica")
    private Boolean automatica;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    public BoletinSeccion() {
    }

    public BoletinSeccion(Integer idSeccion, String nombre, String codigoIdentificador, Integer limiteItems, Boolean automatica, Date fechaCreacion) {
        this.idSeccion = idSeccion;
        this.nombre = nombre;
        this.codigoIdentificador = codigoIdentificador;
        this.limiteItems = limiteItems;
        this.automatica = automatica;
        this.fechaCreacion = fechaCreacion;
    }

    public BoletinSeccion(BoletinSeccion boletinSeccion) {
        this.idSeccion = boletinSeccion.getIdSeccion();
        this.nombre = boletinSeccion.getNombre();
        this.codigoIdentificador = boletinSeccion.getCodigoIdentificador();
        this.limiteItems = boletinSeccion.getLimiteItems();
        this.automatica = boletinSeccion.getAutomatica();
        this.fechaCreacion = boletinSeccion.getFechaCreacion();
    }


    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getAutomatica() {
        return automatica;
    }

    public void setAutomatica(Boolean automatica) {
        this.automatica = automatica;
    }

    public Integer getLimiteItems() {
        return limiteItems;
    }

    public void setLimiteItems(Integer limiteItems) {
        this.limiteItems = limiteItems;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(String codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }
}
