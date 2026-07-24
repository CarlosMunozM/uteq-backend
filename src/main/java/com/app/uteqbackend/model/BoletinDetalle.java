package com.app.uteqbackend.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 *
 * @author Carlos Muñoz
 */
@Data
@Entity
@Table(name = "adm_boletin_detalle")
public class BoletinDetalle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private int idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_cabecera", nullable = false)
    private BoletinCabecera objCabecera;

    @ManyToOne
    @JoinColumn(name = "id_seccion", nullable = false)
    private BoletinSeccion objSeccion;

    @Column(name = "id_referencia", nullable = false)
    private int idReferencia;

    @Column(name = "orden")
    private int orden;

    public BoletinDetalle() {
    }

    public BoletinDetalle(int idDetalle, BoletinCabecera objCabecera, BoletinSeccion objSeccion, int idReferencia, int orden) {
        this.idDetalle = idDetalle;
        this.objCabecera = objCabecera;
        this.objSeccion = objSeccion;
        this.idReferencia = idReferencia;
        this.orden = orden;
    }

    public BoletinDetalle(BoletinDetalle boletinDetalle) {
        this.idDetalle = boletinDetalle.getIdDetalle();
        this.objCabecera = boletinDetalle.getObjCabecera();
        this.objSeccion = boletinDetalle.getObjSeccion();
        this.idReferencia = boletinDetalle.getIdReferencia();
        this.orden = boletinDetalle.getOrden();
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public BoletinCabecera getObjCabecera() {
        return objCabecera;
    }

    public void setObjCabecera(BoletinCabecera objCabecera) {
        this.objCabecera = objCabecera;
    }

    public BoletinSeccion getObjSeccion() {
        return objSeccion;
    }

    public void setObjSeccion(BoletinSeccion objSeccion) {
        this.objSeccion = objSeccion;
    }

    public int getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(int idReferencia) {
        this.idReferencia = idReferencia;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
}
