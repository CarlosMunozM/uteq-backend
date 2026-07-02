package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_galeria_lb")
public class GaleriaLb implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imglab")
    private int glbCodigoImg;
    
    @Column(name = "id_lab", nullable = false)
    private int glbCodigoLab;
    
    @Column(name = "url_img", nullable = false)
    private String glbUrlImg;
    
    @Column(name = "descripcion", nullable = true)
    private String glbDescripc;
    
    @Column(name = "fecha_reg", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime glbFechaReg;
    
    @Column(name = "orden", nullable = false)
    private int glbOrden;
    
    @Column(name = "estado", nullable = false, columnDefinition="INT CHECK(estado IN (0,1))")
    private int glbEstado;
    
    public GaleriaLb() {
        super();
    }
    
    public GaleriaLb(String glbUrlImg, String glbDescripc, int glbOrden) {
        super();
        this.glbUrlImg = glbUrlImg;
        this.glbDescripc = glbDescripc;
        this.glbOrden = glbOrden;
    }
    
    public GaleriaLb(int glbCodigoImg, int glbCodigoLab, String glbUrlImg, String glbDescripc, LocalDateTime glbFechaReg, int glbOrden, int glbEstado) {
        super();
        this.glbCodigoImg = glbCodigoImg;
        this.glbCodigoLab = glbCodigoLab;
        this.glbUrlImg = glbUrlImg;
        this.glbDescripc = glbDescripc;
        this.glbFechaReg = glbFechaReg;
        this.glbOrden = glbOrden;
        this.glbEstado = glbEstado;
    }
    
    public GaleriaLb(int glbCodigoLab, String glbUrlImg, String glbDescripc, int glbOrden) {
        super();
        this.glbCodigoLab = glbCodigoLab;
        this.glbUrlImg = glbUrlImg;
        this.glbDescripc = glbDescripc;
        this.glbOrden = glbOrden;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getGlbCodigoImg() {
        return glbCodigoImg;
    }
    
    public void setGlbCodigoImg(int glbCodigoImg) {
        this.glbCodigoImg = glbCodigoImg;
    }
    
    public int getGlbCodigoLab() {
        return glbCodigoLab;
    }
    
    public void setGlbCodigoLab(int glbCodigoLab) {
        this.glbCodigoLab = glbCodigoLab;
    }
    
    public String getGlbUrlImg() {
        return glbUrlImg;
    }
    
    public void setGlbUrlImg(String glbUrlImg) {
        this.glbUrlImg = glbUrlImg;
    }
    
    public String getGlbDescripc() {
        return glbDescripc;
    }
    
    public void setGlbDescripc(String glbDescripc) {
        this.glbDescripc = glbDescripc;
    }
    
    public LocalDateTime getGlbFechaReg() {
        return glbFechaReg;
    }
    
    public void setGlbFechaReg(LocalDateTime glbFechaReg) {
        this.glbFechaReg = glbFechaReg;
    }
    
    public int getGlbOrden() {
        return glbOrden;
    }
    
    public void setGlbOrden(int glbOrden) {
        this.glbOrden = glbOrden;
    }
    
    public int getGlbEstado() {
        return glbEstado;
    }
    
    public void setGlbEstado(int glbEstado) {
        this.glbEstado = glbEstado;
    }
//</editor-fold>
    
}
