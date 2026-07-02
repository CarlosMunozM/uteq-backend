package com.app.uteqbackend.model;

import com.app.uteqbackend.model.keys.VideoInfmPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ANALISTA-TIC 2
 */

//@Data
@Entity
@Table(name = "wp_video_inform")
@IdClass(value = VideoInfmPK.class)
public class VideoInfm implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @Column(name = "anio", nullable = false, columnDefinition = "INT CHECK(anio>2000)")
    private int anio;
    
    @Id
    @Column(name = "mes", nullable = false, columnDefinition = "INT CHECK(mes>=1 AND mes<=12)")
    private int mes;
    
    @Id
    @Column(name = "semana", nullable = false, columnDefinition = "INT CHECK(semana>=1 AND semana<=53)")
    private int semana;
    
    @Column(name = "fecha_pub", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechapub;
    
    @Column(name = "titulo", nullable = false, length = 300)
    private String titulo;
    
    @Column(name="url_video_short", nullable=false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String urlvideo1;
    
    @Column(name="url_video_embed", nullable=false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String urlvideo2;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_video_inform", nullable = false)
    @JsonIgnore
    @Id
    private DatosMult viTipoVideo;
    
    @Column(name="portada_video", nullable=true, length = 200)
    private String portadaVideo;
    
    public VideoInfm() {
        super();
    }
    
    public VideoInfm(int anio, int mes, int semana, Date fechapub, String titulo, String urlvideo1, String urlvideo2, DatosMult viTipoVideo) {
        super();
        this.anio = anio;
        this.mes = mes;
        this.semana = semana;
        this.fechapub = fechapub;
        this.titulo = titulo;
        this.urlvideo1 = urlvideo1;
        this.urlvideo2 = urlvideo2;
        this.viTipoVideo = viTipoVideo;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
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
    
    public Date getFechapub() {
        return fechapub;
    }
    
    public void setFechapub(Date fechapub) {
        this.fechapub = fechapub;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getUrlvideo1() {
        return urlvideo1;
    }
    
    public void setUrlvideo1(String urlvideo1) {
        this.urlvideo1 = urlvideo1;
    }
    
    public String getUrlvideo2() {
        return urlvideo2;
    }
    
    public void setUrlvideo2(String urlvideo2) {
        this.urlvideo2 = urlvideo2;
    }
    
    public DatosMult getViTipoVideo() {
        return viTipoVideo;
    }
    
    public void setViTipoVideo(DatosMult viTipoVideo) {
        this.viTipoVideo = viTipoVideo;
    }
    
    public String getPortadaVideo() {
        return portadaVideo;
    }
    
    public void setPortadaVideo(String portadaVideo) {
        this.portadaVideo = portadaVideo;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public String toString() {
        return "VideoInfm{" + "anio=" + anio + ", mes=" + mes + ", semana=" + semana + ", fechapub=" + fechapub + ", titulo=" + titulo + ", urlvideo1=" + urlvideo1 + ", urlvideo2=" + urlvideo2 + ", viTipoVideo=" + viTipoVideo + '}';
    }
//</editor-fold>
    
}
