package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Data
@Entity
@Table(name = "wp_evento")
public class Evento implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private int evCodigo;
    
    @Column(name = "descripcion", nullable = false)
    private String evDescripcion;
    
    @Column(name = "dirigido", nullable = false)
    private String evDirigido;
    
    @Column(name = "fecha_evt", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date evFecha;
    
    @Column(name = "hora_evt", nullable = true)
    private Time evHora;
    
    @ManyToOne
    @JoinColumn(name = "id_area_relc")
    @JsonIgnoreProperties("dpListadoEventos")
    private Departamento objDepartamento;
    
    @ManyToOne
    @JoinColumn(name = "id_seccion")
    @JsonIgnoreProperties("pwListadoArea")
    private PagWeb objAreaRelc;
    
    @OneToMany(mappedBy = "objEvento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<ImagenEvt> evListadoImgs = new HashSet<ImagenEvt>();
    
    @Column(name = "url_video_facb", nullable = true)
    private String evUrlVidFac;
    
    @Column(name = "url_video_yout", nullable = true)
    private String evUrlVidYout;
    
    @Column(name = "url_pagina_web", nullable = true)
    private String evUrlPagWeb;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK (estado IN (0,1))")
    private int evEstado;
    
    @Column(name = "url_afiche", nullable = false)
    private String evtUrlAfiche;
    
    @Column(name = "descripcion_en", nullable = false)
    private String evDescripcionEn;
    
    @Column(name = "descripcion_pt", nullable = false)
    private String evDescripcionPt;
    
    @Column(name = "dirigido_en", nullable = false)
    private String evDirigidoEn;
    
    @Column(name = "dirigido_pt", nullable = false)
    private String evDirigidoPt;
    
    @Column(name = "url_afiche_en", nullable = false)
    private String evtUrlAficheEn;
    
    @Column(name = "url_afiche_pt", nullable = false)
    private String evtUrlAfichePt;
    
    public Evento() {
        super();
    }
    
    public Evento(int evCodigo, String evDescripcion, String evDirigido, Date evFecha, Time evHora, Departamento objDepartamento, int evEstado) {
        super();
        this.evCodigo = evCodigo;
        this.evDescripcion = evDescripcion;
        this.evDirigido = evDirigido;
        this.evFecha = evFecha;
        this.evHora = evHora;
        this.objDepartamento = objDepartamento;
        this.evEstado = evEstado;
    }
    
    public Evento(int evCodigo, String evDescripcion, Date evFecha, Departamento objDepartamento, String evtUrlAfiche) {
        super();
        this.evCodigo = evCodigo;
        this.evDescripcion = evDescripcion;
        this.evFecha = evFecha;
        this.objDepartamento = objDepartamento;
        this.evtUrlAfiche = evtUrlAfiche;
    }
    
    public Evento(int evCodigo, String evDescripcion, Date evFecha, Departamento objDepartamento, String evtUrlAfiche, String evtUrlAficheEn, String evtUrlAfichePt) {
        super();
        this.evCodigo = evCodigo;
        this.evDescripcion = evDescripcion;
        this.evFecha = evFecha;
        this.objDepartamento = objDepartamento;
        this.evtUrlAfiche = evtUrlAfiche;
        this.evtUrlAficheEn = evtUrlAficheEn;
        this.evtUrlAfichePt = evtUrlAfichePt;
    }
    
    public Evento(int evCodigo, String evDescripcion, Date evFecha, Departamento objDepartamento, String evtUrlAfiche, String evDescripcionEn, String evDescripcionPt, String evtUrlAficheEn, String evtUrlAfichePt) {
        super();
        this.evCodigo = evCodigo;
        this.evDescripcion = evDescripcion;
        this.evFecha = evFecha;
        this.objDepartamento = objDepartamento;
        this.evtUrlAfiche = evtUrlAfiche;
        this.evDescripcionEn = evDescripcionEn;
        this.evDescripcionPt = evDescripcionPt;
        this.evtUrlAficheEn = evtUrlAficheEn;
        this.evtUrlAfichePt = evtUrlAfichePt;
    }
    
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getEvCodigo() {
        return evCodigo;
    }
    
    public void setEvCodigo(int evCodigo) {
        this.evCodigo = evCodigo;
    }
    
    public String getEvDescripcion() {
        return evDescripcion;
    }
    
    public void setEvDescripcion(String evDescripcion) {
        this.evDescripcion = evDescripcion;
    }
    
    public String getEvDirigido() {
        return evDirigido;
    }
    
    public void setEvDirigido(String evDirigido) {
        this.evDirigido = evDirigido;
    }
    
    public Date getEvFecha() {
        return evFecha;
    }
    
    public void setEvFecha(Date evFecha) {
        this.evFecha = evFecha;
    }
    
    public Time getEvHora() {
        return evHora;
    }
    
    public void setEvHora(Time evHora) {
        this.evHora = evHora;
    }
    
    public int getEvEstado() {
        return evEstado;
    }
    
    public void setEvEstado(int evEstado) {
        this.evEstado = evEstado;
    }
    
    public Departamento getObjDepartamento() {
        return objDepartamento;
    }
    
    public void setObjDepartamento(Departamento objDepartamento) {
        this.objDepartamento = objDepartamento;
    }
    
    public String getEvUrlVidFac() {
        return evUrlVidFac;
    }
    
    public void setEvUrlVidFac(String evUrlVidFac) {
        this.evUrlVidFac = evUrlVidFac;
    }
    
    public String getEvUrlVidYout() {
        return evUrlVidYout;
    }
    
    public void setEvUrlVidYout(String evUrlVidYout) {
        this.evUrlVidYout = evUrlVidYout;
    }
    
    public String getEvUrlPagWeb() {
        return evUrlPagWeb;
    }
    
    public void setEvUrlPagWeb(String evUrlPagWeb) {
        this.evUrlPagWeb = evUrlPagWeb;
    }
    
    public PagWeb getObjAreaRelc() {
        return objAreaRelc;
    }
    
    public void setObjAreaRelc(PagWeb objAreaRelc) {
        this.objAreaRelc = objAreaRelc;
    }
    
    public Set<ImagenEvt> getEvListadoImgs() {
        return evListadoImgs;
    }
    
    public void setEvListadoImgs(Set<ImagenEvt> evListadoImgs) {
        this.evListadoImgs = evListadoImgs;
    }
    
    public String getEvtUrlAfiche() {
        return evtUrlAfiche;
    }
    
    public void setEvtUrlAfiche(String evtUrlAfiche) {
        this.evtUrlAfiche = evtUrlAfiche;
    }
    
    public String getEvDescripcionEn() {
        return evDescripcionEn;
    }

    public void setEvDescripcionEn(String evDescripcionEn) {
        this.evDescripcionEn = evDescripcionEn;
    }

    public String getEvDescripcionPt() {
        return evDescripcionPt;
    }

    public void setEvDescripcionPt(String evDescripcionPt) {
        this.evDescripcionPt = evDescripcionPt;
    }

    public String getEvDirigidoEn() {
        return evDirigidoEn;
    }

    public void setEvDirigidoEn(String evDirigidoEn) {
        this.evDirigidoEn = evDirigidoEn;
    }

    public String getEvDirigidoPt() {
        return evDirigidoPt;
    }

    public void setEvDirigidoPt(String evDirigidoPt) {
        this.evDirigidoPt = evDirigidoPt;
    }
    
    public String getEvtUrlAficheEn() {
        return evtUrlAficheEn;
    }

    public void setEvtUrlAficheEn(String evtUrlAficheEn) {
        this.evtUrlAficheEn = evtUrlAficheEn;
    }

    public String getEvtUrlAfichePt() {
        return evtUrlAfichePt;
    }

    public void setEvtUrlAfichePt(String evtUrlAfichePt) {
        this.evtUrlAfichePt = evtUrlAfichePt;
    }
//</editor-fold>
    
}
