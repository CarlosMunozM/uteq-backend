package com.app.uteqbackend.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_concursos_mer")
public class ConcursoMer implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_concurso")
    private Integer cmCodigo;
    
    @Column(name = "fecha_inic", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cmFechaInc;
    
    @Column(name = "fecha_finl", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cmFechaFin;
    
    @Column(name="descripcion", nullable=false)
    private String cmDescripcion;
    
    @Column(name = "tipo", nullable = false, columnDefinition = "CHAR(7) CHECK(tipo IN ('MERITOS','MEROPOS'))")
    private String cmTipo;
    
    @Column(name = "regimen_lab", nullable = false, columnDefinition = "CHAR(5) CHECK(regimen_lab IN ('LOES','LOSEP'))")
    private String cmRegimenLab;
    
    @Column(name = "url_enlace", nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String cmUrlEnlace;
    
    @Column(name = "url_documento", nullable = false, length = 100)
    private String cmUrlDocumento;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (0,1))")
    private Integer cmEstado;
    
    @Column(name="descripcion_en", nullable=false)
    private String cmDescripcionEn;
    
    @Column(name="descripcion_pt", nullable=false)
    private String cmDescripcionPt;
    
    public ConcursoMer() {
        super();
    }
    
    public ConcursoMer(Integer cmCodigo, Date cmFechaInc, Date cmFechaFin, String cmDescripcion, String cmTipo, String cmRegimenLab, String cmUrlEnlace, String cmUrlDocumento, Integer cmEstado) {
        super();
        this.cmCodigo = cmCodigo;
        this.cmFechaInc = cmFechaInc;
        this.cmFechaFin = cmFechaFin;
        this.cmDescripcion = cmDescripcion;
        this.cmTipo = cmTipo;
        this.cmRegimenLab = cmRegimenLab;
        this.cmUrlEnlace = cmUrlEnlace;
        this.cmUrlDocumento = cmUrlDocumento;
        this.cmEstado = cmEstado;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public Integer getCmCodigo() {
        return cmCodigo;
    }
    
    public void setCmCodigo(Integer cmCodigo) {
        this.cmCodigo = cmCodigo;
    }
    
    public Date getCmFechaInc() {
        return cmFechaInc;
    }
    
    public void setCmFechaInc(Date cmFechaInc) {
        this.cmFechaInc = cmFechaInc;
    }
    
    public Date getCmFechaFin() {
        return cmFechaFin;
    }
    
    public void setCmFechaFin(Date cmFechaFin) {
        this.cmFechaFin = cmFechaFin;
    }
    
    public String getCmDescripcion() {
        return cmDescripcion;
    }
    
    public void setCmDescripcion(String cmDescripcion) {
        this.cmDescripcion = cmDescripcion;
    }
    
    public String getCmTipo() {
        return cmTipo;
    }
    
    public void setCmTipo(String cmTipo) {
        this.cmTipo = cmTipo;
    }
    
    public String getCmRegimenLab() {
        return cmRegimenLab;
    }
    
    public void setCmRegimenLab(String cmRegimenLab) {
        this.cmRegimenLab = cmRegimenLab;
    }
    
    public String getCmUrlEnlace() {
        return cmUrlEnlace;
    }
    
    public void setCmUrlEnlace(String cmUrlEnlace) {
        this.cmUrlEnlace = cmUrlEnlace;
    }
    
    public String getCmUrlDocumento() {
        return cmUrlDocumento;
    }
    
    public void setCmUrlDocumento(String cmUrlDocumento) {
        this.cmUrlDocumento = cmUrlDocumento;
    }
    
    public Integer getCmEstado() {
        return cmEstado;
    }
    
    public void setCmEstado(Integer cmEstado) {
        this.cmEstado = cmEstado;
    }
    
    public String getCmDescripcionEn() {
        return cmDescripcionEn;
    }

    public void setCmDescripcionEn(String cmDescripcionEn) {
        this.cmDescripcionEn = cmDescripcionEn;
    }

    public String getCmDescripcionPt() {
        return cmDescripcionPt;
    }

    public void setCmDescripcionPt(String cmDescripcionPt) {
        this.cmDescripcionPt = cmDescripcionPt;
    }
    
//</editor-fold>

}
