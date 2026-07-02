package com.app.uteqbackend.model;

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
@Table(name = "wp_evento_orgz")
public class EventoOrgz {
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento_orgz")
    private int eoCodigo;
    
    @Column(name = "fecha_reg", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date eoFecha;
    
    @Column(name = "fecha_inc", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date eoFechaInc;
    
    @Column(name = "fecha_fin", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date eoFechaFin;
    
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id_entidad", nullable = true, updatable = false)
    private UUID eoCodEntd;
    
    @Column(name = "titulo", nullable = false)
    private String eoTitulo;
    
    @Column(name = "titulo_en", nullable = false)
    private String eoTituloEn;
    
    @Column(name = "titulo_pt", nullable = false)
    private String eoTituloPt;
    
    @Column(name = "url_afiche", nullable = true, length = 100, columnDefinition = "VARCHAR(100) DEFAULT '#'")
    private String eoUrlAfiche;
    
    @Column(name = "url_afiche_en", nullable = true, length = 100, columnDefinition = "VARCHAR(100) DEFAULT '#'")
    private String eoUrlAficheEn;
    
    @Column(name = "url_afiche_pt", nullable = true, length = 100, columnDefinition = "VARCHAR(100) DEFAULT '#'")
    private String eoUrlAfichePt;
    
    @Column(name = "url_img_rs", nullable = true, length = 100, columnDefinition = "VARCHAR(100) DEFAULT '#'")
    private String eoUrlImgRs;
    
    @Column(name = "url_img_rs_en", nullable = true, length = 100, columnDefinition = "VARCHAR(100) DEFAULT '#'")
    private String eoUrlImgRsEn;
    
    @Column(name = "url_img_rs_pt", nullable = true, length = 100, columnDefinition = "VARCHAR(100) DEFAULT '#'")
    private String eoUrlImgRsPt;
    
    @Column(name = "seccion_cont", nullable = true)
    private String eoSeccionCont;
    
    @Column(name = "seccion_cont_en", nullable = true)
    private String eoSeccionContEn;
    
    @Column(name = "seccion_cont_pt", nullable = true)
    private String eoSeccionContPt;
    
    @Column(name = "seccion_pres", nullable = true)
    private String eoSeccionPres;
    
    @Column(name = "seccion_pres_en", nullable = true)
    private String eoSeccionPresEn;
    
    @Column(name = "seccion_pres_pt", nullable = true)
    private String eoSeccionPresPt;
    
    @Column(name = "seccion_pons", nullable = true)
    private String eoSeccionPons;
    
    @Column(name = "seccion_pons_en", nullable = true)
    private String eoSeccionPonsEn;
    
    @Column(name = "seccion_pons_pt", nullable = true)
    private String eoSeccionPonsPt;
    
    @Column(name = "url_pagina_web", nullable = true, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String eoUrlPaginaWeb;
    
    @Column(name = "url_parcial", nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String eoUrlParcial;
    
    @Column(name = "estado", nullable = false, columnDefinition="INT CHECK(estado IN (0,1))")
    private Integer eoEstado;
    
    public EventoOrgz() {
        super();
    }
    
    public EventoOrgz(int eoCodigo, Date eoFecha, Date eoFechaInc, Date eoFechaFin, UUID eoCodEntd, String eoTitulo, String eoUrlAfiche, String eoUrlImgRs, String eoSeccionCont, String eoSeccionPres, String eoSeccionPons, String eoUrlPaginaWeb, String eoUrlParcial) {
        super();
        this.eoCodigo = eoCodigo;
        this.eoFecha = eoFecha;
        this.eoFechaInc = eoFechaInc;
        this.eoFechaFin = eoFechaFin;
        this.eoCodEntd = eoCodEntd;
        this.eoTitulo = eoTitulo;
        this.eoUrlAfiche = eoUrlAfiche;
        this.eoUrlImgRs = eoUrlImgRs;
        this.eoSeccionCont = eoSeccionCont;
        this.eoSeccionPres = eoSeccionPres;
        this.eoSeccionPons = eoSeccionPons;
        this.eoUrlPaginaWeb = eoUrlPaginaWeb;
        this.eoUrlParcial = eoUrlParcial;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getEoCodigo() {
        return eoCodigo;
    }
    
    public void setEoCodigo(int eoCodigo) {
        this.eoCodigo = eoCodigo;
    }
    
    public Date getEoFecha() {
        return eoFecha;
    }
    
    public void setEoFecha(Date eoFecha) {
        this.eoFecha = eoFecha;
    }
    
    public UUID getEoCodEntd() {
        return eoCodEntd;
    }
    
    public void setEoCodEntd(UUID eoCodEntd) {
        this.eoCodEntd = eoCodEntd;
    }
    
    public String getEoTitulo() {
        return eoTitulo;
    }
    
    public void setEoTitulo(String eoTitulo) {
        this.eoTitulo = eoTitulo;
    }
    
    public String getEoUrlAfiche() {
        return eoUrlAfiche;
    }
    
    public void setEoUrlAfiche(String eoUrlAfiche) {
        this.eoUrlAfiche = eoUrlAfiche;
    }
    
    public String getEoSeccionCont() {
        return eoSeccionCont;
    }
    
    public void setEoSeccionCont(String eoSeccionCont) {
        this.eoSeccionCont = eoSeccionCont;
    }
    
    public String getEoSeccionPres() {
        return eoSeccionPres;
    }
    
    public void setEoSeccionPres(String eoSeccionPres) {
        this.eoSeccionPres = eoSeccionPres;
    }
    
    public String getEoSeccionPons() {
        return eoSeccionPons;
    }
    
    public void setEoSeccionPons(String eoSeccionPons) {
        this.eoSeccionPons = eoSeccionPons;
    }
    
    public String getEoUrlPaginaWeb() {
        return eoUrlPaginaWeb;
    }
    
    public void setEoUrlPaginaWeb(String eoUrlPaginaWeb) {
        this.eoUrlPaginaWeb = eoUrlPaginaWeb;
    }
    
    public String getEoUrlParcial() {
        return eoUrlParcial;
    }
    
    public void setEoUrlParcial(String eoUrlParcial) {
        this.eoUrlParcial = eoUrlParcial;
    }
    
    public Date getEoFechaInc() {
        return eoFechaInc;
    }
    
    public void setEoFechaInc(Date eoFechaInc) {
        this.eoFechaInc = eoFechaInc;
    }
    
    public Date getEoFechaFin() {
        return eoFechaFin;
    }
    
    public void setEoFechaFin(Date eoFechaFin) {
        this.eoFechaFin = eoFechaFin;
    }
    
    public String getEoUrlImgRs() {
        return eoUrlImgRs;
    }
    
    public void setEoUrlImgRs(String eoUrlImgRs) {
        this.eoUrlImgRs = eoUrlImgRs;
    }
    
    public Integer getEoEstado() {
        return eoEstado;
    }
    
    public void setEoEstado(Integer eoEstado) {
        this.eoEstado = eoEstado;
    }
    
    public String getEoTituloEn() {
        return eoTituloEn;
    }

    public void setEoTituloEn(String eoTituloEn) {
        this.eoTituloEn = eoTituloEn;
    }

    public String getEoTituloPt() {
        return eoTituloPt;
    }

    public void setEoTituloPt(String eoTituloPt) {
        this.eoTituloPt = eoTituloPt;
    }

    public String getEoUrlAficheEn() {
        return eoUrlAficheEn;
    }

    public void setEoUrlAficheEn(String eoUrlAficheEn) {
        this.eoUrlAficheEn = eoUrlAficheEn;
    }

    public String getEoUrlAfichePt() {
        return eoUrlAfichePt;
    }

    public void setEoUrlAfichePt(String eoUrlAfichePt) {
        this.eoUrlAfichePt = eoUrlAfichePt;
    }

    public String getEoUrlImgRsEn() {
        return eoUrlImgRsEn;
    }

    public void setEoUrlImgRsEn(String eoUrlImgRsEn) {
        this.eoUrlImgRsEn = eoUrlImgRsEn;
    }

    public String getEoUrlImgRsPt() {
        return eoUrlImgRsPt;
    }

    public void setEoUrlImgRsPt(String eoUrlImgRsPt) {
        this.eoUrlImgRsPt = eoUrlImgRsPt;
    }

    public String getEoSeccionContEn() {
        return eoSeccionContEn;
    }

    public void setEoSeccionContEn(String eoSeccionContEn) {
        this.eoSeccionContEn = eoSeccionContEn;
    }

    public String getEoSeccionContPt() {
        return eoSeccionContPt;
    }

    public void setEoSeccionContPt(String eoSeccionContPt) {
        this.eoSeccionContPt = eoSeccionContPt;
    }

    public String getEoSeccionPresEn() {
        return eoSeccionPresEn;
    }

    public void setEoSeccionPresEn(String eoSeccionPresEn) {
        this.eoSeccionPresEn = eoSeccionPresEn;
    }

    public String getEoSeccionPresPt() {
        return eoSeccionPresPt;
    }

    public void setEoSeccionPresPt(String eoSeccionPresPt) {
        this.eoSeccionPresPt = eoSeccionPresPt;
    }

    public String getEoSeccionPonsEn() {
        return eoSeccionPonsEn;
    }

    public void setEoSeccionPonsEn(String eoSeccionPonsEn) {
        this.eoSeccionPonsEn = eoSeccionPonsEn;
    }

    public String getEoSeccionPonsPt() {
        return eoSeccionPonsPt;
    }

    public void setEoSeccionPonsPt(String eoSeccionPonsPt) {
        this.eoSeccionPonsPt = eoSeccionPonsPt;
    }
    
//</editor-fold>
    
}
