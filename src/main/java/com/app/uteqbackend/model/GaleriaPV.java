package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
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
 * @author Ryan-
 */
@Data
@Entity
@Table(name = "wp_galeria_pv")
public class GaleriaPV implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evidencia")
    private int gpCodigo;
    
    @ManyToOne
    @JoinColumn(name = "id_proyecto_vinc")
    @JsonIgnoreProperties("pvListadoEvd")
    private ProyectoVinc gpCodPV;
    
    @Column(name = "url_img", nullable = false)
    private String gpUrlImg;
    
    @Column(name = "descripcion", nullable = true)
    private String gpDescripcion;
    
    @Column(name = "fecha_reg", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gpFechaReg;
    
    @Column(name = "orden", nullable = false)
    private int gpOrden;
    
    @Column(name = "estado", nullable = false, columnDefinition="INT CHECK(estado IN (0,1))")
    private int gpEstado;
    
    public GaleriaPV() {
        super();
    }
    
    public GaleriaPV(int gpCodigo, ProyectoVinc gpCodPV, String gpUrlImg, String gpDescripcion, LocalDateTime gpFechaReg, int gpOrden, int gpEstado) {
        super();
        this.gpCodigo = gpCodigo;
        this.gpCodPV = gpCodPV;
        this.gpUrlImg = gpUrlImg;
        this.gpDescripcion = gpDescripcion;
        this.gpFechaReg = gpFechaReg;
        this.gpOrden = gpOrden;
        this.gpEstado = gpEstado;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getGpCodigo() {
        return gpCodigo;
    }
    
    public void setGpCodigo(int gpCodigo) {
        this.gpCodigo = gpCodigo;
    }
    
    public ProyectoVinc getGpCodPV() {
        return gpCodPV;
    }
    
    public void setGpCodPV(ProyectoVinc gpCodPV) {
        this.gpCodPV = gpCodPV;
    }
    
    public String getGpUrlImg() {
        return gpUrlImg;
    }
    
    public void setGpUrlImg(String gpUrlImg) {
        this.gpUrlImg = gpUrlImg;
    }
    
    public String getGpDescripcion() {
        return gpDescripcion;
    }
    
    public void setGpDescripcion(String gpDescripcion) {
        this.gpDescripcion = gpDescripcion;
    }
    
    public LocalDateTime getGpFechaReg() {
        return gpFechaReg;
    }
    
    public void setGpFechaReg(LocalDateTime gpFechaReg) {
        this.gpFechaReg = gpFechaReg;
    }
    
    public int getGpOrden() {
        return gpOrden;
    }
    
    public void setGpOrden(int gpOrden) {
        this.gpOrden = gpOrden;
    }
    
    public int getGpEstado() {
        return gpEstado;
    }
    
    public void setGpEstado(int gpEstado) {
        this.gpEstado = gpEstado;
    }
//</editor-fold>
   
    
}
