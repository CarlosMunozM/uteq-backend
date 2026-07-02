package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Data
@Entity
@Table(name = "wp_evento_img")
public class ImagenEvt implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento_img")
    private int ieCodigo;
    
    @ManyToOne
    @JoinColumn(name = "id_evento")
    @JsonIgnoreProperties("evListadoImgs")
    private Evento objEvento;
    
    @Column(name = "descripcion", nullable = true)
    private String ieDescripcion;
    
    @Column(name = "url_img", nullable = false)
    private String ieUrl;
    
    @Column(name = "orden", nullable = false)
    private int ieOrden;
    
    @Column(name = "fecha_reg", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ieFechaReg;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (1,0))")
    private int ieEstado;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getIeCodigo() {
        return ieCodigo;
    }
    
    public void setIeCodigo(int ieCodigo) {
        this.ieCodigo = ieCodigo;
    }
    
    public Evento getObjEvento() {
        return objEvento;
    }
    
    public void setObjEvento(Evento objEvento) {
        this.objEvento = objEvento;
    }
    
    public String getIeDescripcion() {
        return ieDescripcion;
    }
    
    public void setIeDescripcion(String ieDescripcion) {
        this.ieDescripcion = ieDescripcion;
    }
    
    public String getIeUrl() {
        return ieUrl;
    }
    
    public void setIeUrl(String ieUrl) {
        this.ieUrl = ieUrl;
    }
    
    public int getIeOrden() {
        return ieOrden;
    }
    
    public void setIeOrden(int ieOrden) {
        this.ieOrden = ieOrden;
    }
    
    public Date getIeFechaReg() {
        return ieFechaReg;
    }
    
    public void setIeFechaReg(Date ieFechaReg) {
        this.ieFechaReg = ieFechaReg;
    }
    
    public int getIeEstado() {
        return ieEstado;
    }
    
    public void setIeEstado(int ieEstado) {
        this.ieEstado = ieEstado;
    }
//</editor-fold>
    
}
