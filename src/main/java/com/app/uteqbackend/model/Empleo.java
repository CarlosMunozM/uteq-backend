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
@Table(name = "wp_empleo_bt")
public class Empleo implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleo")
    private Integer epCodigo;
    
    @Column(name = "fecha_inicio", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime epFechaInc;
    
    @Column(name = "fecha_fin", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime epFechaFin;
    
    @Column(name = "url_img", nullable = false)
    private String epUrlImg;
    
    @Column(name = "url_img_en", nullable = false)
    private String epUrlImgEn;
    
    @Column(name = "url_img_pt", nullable = false)
    private String epUrlImgPt;
    
    @Column(name = "estado", nullable = false, columnDefinition="INT CHECK(estado IN (0,1))")
    private Integer epEstado;
    
    @Column(name = "fecha_reg", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime epFechaReg;
    
    public Empleo() {
        super();
    }
    
    public Empleo(int epCodigo, LocalDateTime epFechaInc, LocalDateTime epFechaFin, String epUrlImg, int epEstado, LocalDateTime epFechaReg) {
        super();
        this.epCodigo = epCodigo;
        this.epFechaInc = epFechaInc;
        this.epFechaFin = epFechaFin;
        this.epUrlImg = epUrlImg;
        this.epEstado = epEstado;
        this.epFechaReg = epFechaReg;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getEpCodigo() {
        return epCodigo;
    }
    
    public void setEpCodigo(int epCodigo) {
        this.epCodigo = epCodigo;
    }
    
    public LocalDateTime getEpFechaInc() {
        return epFechaInc;
    }
    
    public void setEpFechaInc(LocalDateTime epFechaInc) {
        this.epFechaInc = epFechaInc;
    }
    
    public LocalDateTime getEpFechaFin() {
        return epFechaFin;
    }
    
    public void setEpFechaFin(LocalDateTime epFechaFin) {
        this.epFechaFin = epFechaFin;
    }
    
    public String getEpUrlImg() {
        return epUrlImg;
    }
    
    public void setEpUrlImg(String epUrlImg) {
        this.epUrlImg = epUrlImg;
    }
    
    public int getEpEstado() {
        return epEstado;
    }
    
    public void setEpEstado(int epEstado) {
        this.epEstado = epEstado;
    }
    
    public LocalDateTime getEpFechaReg() {
        return epFechaReg;
    }
    
    public void setEpFechaReg(LocalDateTime epFechaReg) {
        this.epFechaReg = epFechaReg;
    }
    
    public String getEpUrlImgEn() {
        return epUrlImgEn;
    }

    public void setEpUrlImgEn(String epUrlImgEn) {
        this.epUrlImgEn = epUrlImgEn;
    }

    public String getEpUrlImgPt() {
        return epUrlImgPt;
    }

    public void setEpUrlImgPt(String epUrlImgPt) {
        this.epUrlImgPt = epUrlImgPt;
    }
//</editor-fold>
    
}
