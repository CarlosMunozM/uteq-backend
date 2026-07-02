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
@Table(name = "wp_noticia_inst")
public class Noticia implements Serializable{
   
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private int ntCodigo;
    
    @Column(name = "url_portada", nullable = false)
    private String ntUrlPortada;
    
    @Column(name = "url_slider", nullable = false)
    private String ntUrlSlider;
    
    @Column(name = "titular", nullable = false)
    private String ntTitular;
    
    @Column(name = "titular_en", nullable = false)
    private String ntTitularEn;
    
    @Column(name = "titular_pt", nullable = false)
    private String ntTitularPt;
    
    @Column(name = "url_noticia", nullable = false)
    private String ntUrlNoticia;
    
    @Column(name = "fecha", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ntFecha;
    
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    @JsonIgnoreProperties("dpListadoNoticias")
    private Departamento objDepartamento;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonIgnoreProperties("gtListadoNoticias")
    private CategoriaNotc objCategoriaNotc;
    
    @Column(name = "descrip_meta_og", nullable = false)
    private String ntDescripMeta;
    
    @Column(name = "descrip_meta_og_en", nullable = false)
    private String ntDescripMetaEn;
    
    @Column(name = "descrip_meta_og_pt", nullable = false)
    private String ntDescripMetaPt;
    
    @Column(name = "cuerpo", nullable = false)
    private String ntCuerpo;
    
    @Column(name = "cuerpo_en", nullable = false)
    private String ntCuerpoEn;
    
    @Column(name = "cuerpo_pt", nullable = false)
    private String ntCuerpoPt;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK (estado IN (0,1))")
    private int ntEstado;
    
    public Noticia() {
        super();
    }
    
    public Noticia(String ntUrlNoticia) {
        super();
        this.ntUrlNoticia = ntUrlNoticia;
    }
    
    public Noticia(String ntUrlPortada, String ntTitular, String ntUrlNoticia, Date ntFecha, Departamento objDepartamento, String ntDescripMeta) {
        super();
        this.ntUrlPortada = ntUrlPortada;
        this.ntTitular = ntTitular;
        this.ntUrlNoticia = ntUrlNoticia;
        this.ntFecha = ntFecha;
        this.objDepartamento = objDepartamento;
        this.ntDescripMeta = ntDescripMeta;
    }
    
    public Noticia(int ntCodigo, String ntUrlPortada, String ntUrlSlider, String ntTitular, Date ntFecha, Departamento objDepartamento, String ntDescripMeta, String ntCuerpo, int ntEstado) {
        super();
        this.ntCodigo = ntCodigo;
        this.ntUrlPortada = ntUrlPortada;
        this.ntUrlSlider = ntUrlSlider;
        this.ntTitular = ntTitular;
        this.ntFecha = ntFecha;
        this.objDepartamento = objDepartamento;
        this.ntDescripMeta = ntDescripMeta;
        this.ntCuerpo = ntCuerpo;
        this.ntEstado = ntEstado;
    }

    public Noticia(String ntTitular, String ntUrlNoticia) {
        super();
        this.ntTitular = ntTitular;
        this.ntUrlNoticia = ntUrlNoticia;
    }
    
    public Noticia(String ntUrlPortada, String ntTitular, String ntTitularEn, String ntTitularPt, String ntUrlNoticia, Date ntFecha, Departamento objDepartamento, String ntDescripMeta, String ntDescripMetaEn, String ntDescripMetaPt) {
        super();
        this.ntUrlPortada = ntUrlPortada;
        this.ntTitular = ntTitular;
        this.ntTitularEn = ntTitularEn;
        this.ntTitularPt = ntTitularPt;
        this.ntUrlNoticia = ntUrlNoticia;
        this.ntFecha = ntFecha;
        this.objDepartamento = objDepartamento;
        this.ntDescripMeta = ntDescripMeta;
        this.ntDescripMetaEn = ntDescripMetaEn;
        this.ntDescripMetaPt = ntDescripMetaPt;
    }

    public Noticia(String ntTitular, String ntTitularEn, String ntTitularPt, String ntUrlNoticia) {
        super();
        this.ntTitular = ntTitular;
        this.ntTitularEn = ntTitularEn;
        this.ntTitularPt = ntTitularPt;
        this.ntUrlNoticia = ntUrlNoticia;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getNtCodigo() {
        return ntCodigo;
    }
    
    public void setNtCodigo(int ntCodigo) {
        this.ntCodigo = ntCodigo;
    }
    
    public String getNtUrlPortada() {
        return ntUrlPortada;
    }
    
    public void setNtUrlPortada(String ntUrlPortada) {
        this.ntUrlPortada = ntUrlPortada;
    }
    
    public String getNtUrlSlider() {
        return ntUrlSlider;
    }
    
    public void setNtUrlSlider(String ntUrlSlider) {
        this.ntUrlSlider = ntUrlSlider;
    }
    
    public String getNtTitular() {
        return ntTitular;
    }
    
    public void setNtTitular(String ntTitular) {
        this.ntTitular = ntTitular;
    }
    
    public Date getNtFecha() {
        return ntFecha;
    }
    
    public void setNtFecha(Date ntFecha) {
        this.ntFecha = ntFecha;
    }
    
    public Departamento getObjDepartamento() {
        return objDepartamento;
    }
    
    public void setObjDepartamento(Departamento objDepartamento) {
        this.objDepartamento = objDepartamento;
    }
    
    public String getNtDescripMeta() {
        return ntDescripMeta;
    }
    
    public void setNtDescripMeta(String ntDescripMeta) {
        this.ntDescripMeta = ntDescripMeta;
    }
    
    public String getNtCuerpo() {
        return ntCuerpo;
    }
    
    public void setNtCuerpo(String ntCuerpo) {
        this.ntCuerpo = ntCuerpo;
    }
    
    public int getNtEstado() {
        return ntEstado;
    }
    
    public void setNtEstado(int ntEstado) {
        this.ntEstado = ntEstado;
    }
    
    public String getNtUrlNoticia() {
        return ntUrlNoticia;
    }
    
    public void setNtUrlNoticia(String ntUrlNoticia) {
        this.ntUrlNoticia = ntUrlNoticia;
    }
    
    public CategoriaNotc getObjCategoriaNotc() {
        return objCategoriaNotc;
    }
    
    public void setObjCategoriaNotc(CategoriaNotc objCategoriaNotc) {
        this.objCategoriaNotc = objCategoriaNotc;
    }
    
    public String getNtTitularEn() {
        return ntTitularEn;
    }

    public void setNtTitularEn(String ntTitularEn) {
        this.ntTitularEn = ntTitularEn;
    }

    public String getNtTitularPt() {
        return ntTitularPt;
    }

    public void setNtTitularPt(String ntTitularPt) {
        this.ntTitularPt = ntTitularPt;
    }

    public String getNtDescripMetaEn() {
        return ntDescripMetaEn;
    }

    public void setNtDescripMetaEn(String ntDescripMetaEn) {
        this.ntDescripMetaEn = ntDescripMetaEn;
    }

    public String getNtDescripMetaPt() {
        return ntDescripMetaPt;
    }

    public void setNtDescripMetaPt(String ntDescripMetaPt) {
        this.ntDescripMetaPt = ntDescripMetaPt;
    }

    public String getNtCuerpoEn() {
        return ntCuerpoEn;
    }

    public void setNtCuerpoEn(String ntCuerpoEn) {
        this.ntCuerpoEn = ntCuerpoEn;
    }

    public String getNtCuerpoPt() {
        return ntCuerpoPt;
    }

    public void setNtCuerpoPt(String ntCuerpoPt) {
        this.ntCuerpoPt = ntCuerpoPt;
    }
    
//</editor-fold>

}
