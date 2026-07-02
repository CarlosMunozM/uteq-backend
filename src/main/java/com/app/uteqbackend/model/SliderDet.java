package com.app.uteqbackend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;
import org.hibernate.annotations.Type;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_slider_det")
public class SliderDet implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private int sldCodigo;
    
    @Column(name = "id_slider", nullable = false)
    private int sldCodSliderCabz;
    
    @Column(name = "fecha_inic", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sldFechaInicio;
    
    @Column(name = "fecha_finl", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sldFechaFin;
    
    @Column(name = "url_img_vid", nullable = false, length = 2000)
    private String sldUrlImgVid;
    
    @Column(name = "tipo", nullable = false, length = 3, columnDefinition = "CHAR(3) CHECK(tipo IN ('IMG','VID'))")
    private String sldTipo;
    
    @Column(name = "url_enlace", nullable = true, length = 2000)
    private String sldEnlace;
    
    @Column(name = "titulo", nullable = true, length = 500)
    private String sldTitulo;
    
    @Column(name = "descripcion", nullable = true)
    private String sldDescripcion;
    
    @Column(name = "fecha_noticia", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sldFechaNoticia;
    
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id_entidad_notc", nullable = true, updatable = false)
    private UUID sldIdEntidadNotc;
    
    @Column(name = "id_dept_notc", nullable = true, length = 1000)
    private String sldIdDepartamento;
    
    @Column(name = "orden", nullable = false)
    private int sldOrden;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK (estado IN (0,1))")
    private int sldEstado;
    
    @Column(name = "titulo_en", nullable = true, length = 500)
    private String sldTituloEn;
    
    @Column(name = "titulo_pt", nullable = true, length = 500)
    private String sldTituloPt;
    
    @Column(name = "descripcion_en", nullable = true)
    private String sldDescripcionEn;
    
    @Column(name = "descripcion_pt", nullable = true)
    private String sldDescripcionPt;
    
    @Column(name = "url_img_vid_en", nullable = false, length = 2000)
    private String sldUrlImgVidEn;
    
    @Column(name = "url_img_vid_pt", nullable = false, length = 2000)
    private String sldUrlImgVidPt;
    
    @Column(name = "url_enlace_en", nullable = true, length = 2000)
    private String sldEnlaceEn;
    
    @Column(name = "url_enlace_pt", nullable = true, length = 2000)
    private String sldEnlacePt;
    
    public SliderDet() {
        super();
    }
    
    public SliderDet(int sldCodigo, int sldCodSliderCabz, Date sldFechaInicio, Date sldFechaFin, String sldUrlImgVid, String sldTipo, String sldEnlace, String sldTitulo, String sldDescripcion, Date sldFechaNoticia, UUID sldIdEntidadNotc, String sldIdDepartamento, int sldOrden, int sldEstado) {
        super();
        this.sldCodigo = sldCodigo;
        this.sldCodSliderCabz = sldCodSliderCabz;
        this.sldFechaInicio = sldFechaInicio;
        this.sldFechaFin = sldFechaFin;
        this.sldUrlImgVid = sldUrlImgVid;
        this.sldTipo = sldTipo;
        this.sldEnlace = sldEnlace;
        this.sldTitulo = sldTitulo;
        this.sldDescripcion = sldDescripcion;
        this.sldFechaNoticia = sldFechaNoticia;
        this.sldIdEntidadNotc = sldIdEntidadNotc;
        this.sldIdDepartamento = sldIdDepartamento;
        this.sldOrden = sldOrden;
        this.sldEstado = sldEstado;
    }
    
    public SliderDet(int sldCodigo, Date sldFechaInicio, Date sldFechaFin, String sldUrlImgVid, String sldTipo, String sldEnlace, String sldTitulo, String sldDescripcion, Date sldFechaNoticia, UUID sldIdEntidadNotc, String sldIdDepartamento, int sldOrden) {
        this.sldCodigo = sldCodigo;
        this.sldFechaInicio = sldFechaInicio;
        this.sldFechaFin = sldFechaFin;
        this.sldUrlImgVid = sldUrlImgVid;
        this.sldTipo = sldTipo;
        this.sldEnlace = sldEnlace;
        this.sldTitulo = sldTitulo;
        this.sldDescripcion = sldDescripcion;
        this.sldFechaNoticia = sldFechaNoticia;
        this.sldIdEntidadNotc = sldIdEntidadNotc;
        this.sldIdDepartamento = sldIdDepartamento;
        this.sldOrden = sldOrden;
    }
    
    public SliderDet(int sldCodigo, int sldCodSliderCabz, Date sldFechaInicio, Date sldFechaFin, String sldUrlImgVid, String sldTipo, String sldEnlace, String sldTitulo, String sldDescripcion, Date sldFechaNoticia, UUID sldIdEntidadNotc, String sldIdDepartamento, int sldOrden) {
        this.sldCodigo = sldCodigo;
        this.sldCodSliderCabz = sldCodSliderCabz;
        this.sldFechaInicio = sldFechaInicio;
        this.sldFechaFin = sldFechaFin;
        this.sldUrlImgVid = sldUrlImgVid;
        this.sldTipo = sldTipo;
        this.sldEnlace = sldEnlace;
        this.sldTitulo = sldTitulo;
        this.sldDescripcion = sldDescripcion;
        this.sldFechaNoticia = sldFechaNoticia;
        this.sldIdEntidadNotc = sldIdEntidadNotc;
        this.sldIdDepartamento = sldIdDepartamento;
        this.sldOrden = sldOrden;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getSldCodigo() {
        return sldCodigo;
    }
    
    public void setSldCodigo(int sldCodigo) {
        this.sldCodigo = sldCodigo;
    }
    
    public int getSldCodSliderCabz() {
        return sldCodSliderCabz;
    }
    
    public void setSldCodSliderCabz(int sldCodSliderCabz) {
        this.sldCodSliderCabz = sldCodSliderCabz;
    }
    
    public Date getSldFechaInicio() {
        return sldFechaInicio;
    }
    
    public void setSldFechaInicio(Date sldFechaInicio) {
        this.sldFechaInicio = sldFechaInicio;
    }
    
    public Date getSldFechaFin() {
        return sldFechaFin;
    }
    
    public void setSldFechaFin(Date sldFechaFin) {
        this.sldFechaFin = sldFechaFin;
    }
    
    public String getSldUrlImgVid() {
        return sldUrlImgVid;
    }
    
    public void setSldUrlImgVid(String sldUrlImgVid) {
        this.sldUrlImgVid = sldUrlImgVid;
    }
    
    public String getSldTipo() {
        return sldTipo;
    }
    
    public void setSldTipo(String sldTipo) {
        this.sldTipo = sldTipo;
    }
    
    public String getSldEnlace() {
        return sldEnlace;
    }
    
    public void setSldEnlace(String sldEnlace) {
        this.sldEnlace = sldEnlace;
    }
    
    public String getSldTitulo() {
        return sldTitulo;
    }
    
    public void setSldTitulo(String sldTitulo) {
        this.sldTitulo = sldTitulo;
    }
    
    public String getSldDescripcion() {
        return sldDescripcion;
    }
    
    public void setSldDescripcion(String sldDescripcion) {
        this.sldDescripcion = sldDescripcion;
    }
    
    public Date getSldFechaNoticia() {
        return sldFechaNoticia;
    }
    
    public void setSldFechaNoticia(Date sldFechaNoticia) {
        this.sldFechaNoticia = sldFechaNoticia;
    }
    
    public UUID getSldIdEntidadNotc() {
        return sldIdEntidadNotc;
    }
    
    public void setSldIdEntidadNotc(UUID sldIdEntidadNotc) {
        this.sldIdEntidadNotc = sldIdEntidadNotc;
    }
    
    public String getSldIdDepartamento() {
        return sldIdDepartamento;
    }
    
    public void setSldIdDepartamento(String sldIdDepartamento) {
        this.sldIdDepartamento = sldIdDepartamento;
    }
    
    public int getSldOrden() {
        return sldOrden;
    }
    
    public void setSldOrden(int sldOrden) {
        this.sldOrden = sldOrden;
    }
    
    public int getSldEstado() {
        return sldEstado;
    }
    
    public void setSldEstado(int sldEstado) {
        this.sldEstado = sldEstado;
    }

    public String getSldTituloEn() {
        return sldTituloEn;
    }

    public void setSldTituloEn(String sldTituloEn) {
        this.sldTituloEn = sldTituloEn;
    }

    public String getSldTituloPt() {
        return sldTituloPt;
    }

    public void setSldTituloPt(String sldTituloPt) {
        this.sldTituloPt = sldTituloPt;
    }

    public String getSldDescripcionEn() {
        return sldDescripcionEn;
    }

    public void setSldDescripcionEn(String sldDescripcionEn) {
        this.sldDescripcionEn = sldDescripcionEn;
    }

    public String getSldDescripcionPt() {
        return sldDescripcionPt;
    }

    public void setSldDescripcionPt(String sldDescripcionPt) {
        this.sldDescripcionPt = sldDescripcionPt;
    }

    public String getSldUrlImgVidEn() {
        return sldUrlImgVidEn;
    }

    public void setSldUrlImgVidEn(String sldUrlImgVidEn) {
        this.sldUrlImgVidEn = sldUrlImgVidEn;
    }

    public String getSldUrlImgVidPt() {
        return sldUrlImgVidPt;
    }

    public void setSldUrlImgVidPt(String sldUrlImgVidPt) {
        this.sldUrlImgVidPt = sldUrlImgVidPt;
    }

    public String getSldEnlaceEn() {
        return sldEnlaceEn;
    }

    public void setSldEnlaceEn(String sldEnlaceEn) {
        this.sldEnlaceEn = sldEnlaceEn;
    }

    public String getSldEnlacePt() {
        return sldEnlacePt;
    }

    public void setSldEnlacePt(String sldEnlacePt) {
        this.sldEnlacePt = sldEnlacePt;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public String toString() {
        return "SliderDet{" + "sldCodigo=" + sldCodigo + ", sldCodSliderCabz=" + sldCodSliderCabz + ", sldFechaInicio=" + sldFechaInicio + ", sldFechaFin=" + sldFechaFin + ", sldUrlImgVid=" + sldUrlImgVid + ", sldTipo=" + sldTipo + ", sldEnlace=" + sldEnlace + ", sldTitulo=" + sldTitulo + ", sldDescripcion=" + sldDescripcion + ", sldFechaNoticia=" + sldFechaNoticia + ", sldIdEntidadNotc=" + sldIdEntidadNotc + ", sldIdDepartamento=" + sldIdDepartamento + ", sldOrden=" + sldOrden + ", sldEstado=" + sldEstado + '}';
    }
//</editor-fold>
    
}
