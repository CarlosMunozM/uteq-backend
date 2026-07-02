package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
 * @author ANALISTA-TIC 2
 */
@Data
@Entity
@Table(name = "wp_ds_modal")
public class DtsModal implements Serializable{

    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ds_modal")
    private int mdsCodigo;
    
    @ManyToOne
    @JoinColumn(name = "id_dp_modal")
    @JsonIgnoreProperties("mdpDetallesModal")
    private DtpModal mdsModal;
    
    @Column(name = "descripcion", nullable = false)
    private String mdsDescripcion;
    
    @Column(name = "descripcion_en", nullable = false)
    private String mdsDescripcionEn;
    
    @Column(name = "descripcion_pt", nullable = false)
    private String mdsDescripcionPt;
    
    @Column(name = "tipo_rec", nullable = false, columnDefinition = "CHAR(3) CHECK(tipo_rec IN ('IMG','VID'))")
    private String mdsTipoRec;
    
    @Column(name = "url_recurso", nullable = false, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String mdsUrlRecurso;
    
    @Column(name = "url_recurso_en", nullable = false, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String mdsUrlRecursoEn;
    
    @Column(name = "url_recurso_pt", nullable = false, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String mdsUrlRecursoPt;
    
    @Column(name = "url_enlace", nullable = false, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String mdsUrlEnlace;
    
    @Column(name = "url_enlace_en", nullable = false, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String mdsUrlEnlaceEn;
    
    @Column(name = "url_enlace_pt", nullable = false, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String mdsUrlEnlacePt;
    
    @Column(name = "orden", nullable = false)
    private int mdsOrden;
    
    @Column(name = "estado", nullable = false, columnDefinition="INT CHECK(estado IN (0,1))")
    private int mdsEstado;
    
    public DtsModal() {
        super();
    }
    
    public DtsModal(int mdsCodigo, DtpModal mdsModal, String mdsDescripcion, String mdsTipoRec, String mdsUrlRecurso, String mdsUrlEnlace, int mdsOrden, int mdsEstado) {
        super();
        this.mdsCodigo = mdsCodigo;
        this.mdsModal = mdsModal;
        this.mdsDescripcion = mdsDescripcion;
        this.mdsTipoRec = mdsTipoRec;
        this.mdsUrlRecurso = mdsUrlRecurso;
        this.mdsUrlEnlace = mdsUrlEnlace;
        this.mdsOrden = mdsOrden;
        this.mdsEstado = mdsEstado;
    }

    public DtsModal(int mdsCodigo, DtpModal mdsModal, String mdsDescripcion, String mdsDescripcionEn, String mdsDescripcionPt, String mdsTipoRec, String mdsUrlRecurso, String mdsUrlRecursoEn, String mdsUrlRecursoPt, String mdsUrlEnlace, String mdsUrlEnlaceEn, String mdsUrlEnlacePt, int mdsOrden, int mdsEstado) {
        super();
        this.mdsCodigo = mdsCodigo;
        this.mdsModal = mdsModal;
        this.mdsDescripcion = mdsDescripcion;
        this.mdsDescripcionEn = mdsDescripcionEn;
        this.mdsDescripcionPt = mdsDescripcionPt;
        this.mdsTipoRec = mdsTipoRec;
        this.mdsUrlRecurso = mdsUrlRecurso;
        this.mdsUrlRecursoEn = mdsUrlRecursoEn;
        this.mdsUrlRecursoPt = mdsUrlRecursoPt;
        this.mdsUrlEnlace = mdsUrlEnlace;
        this.mdsUrlEnlaceEn = mdsUrlEnlaceEn;
        this.mdsUrlEnlacePt = mdsUrlEnlacePt;
        this.mdsOrden = mdsOrden;
        this.mdsEstado = mdsEstado;
    }
    
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getMdsCodigo() {
        return mdsCodigo;
    }
    
    public void setMdsCodigo(int mdsCodigo) {
        this.mdsCodigo = mdsCodigo;
    }
    
    public DtpModal getMdsModal() {
        return mdsModal;
    }
    
    public void setMdsModal(DtpModal mdsModal) {
        this.mdsModal = mdsModal;
    }
    
    public String getMdsDescripcion() {
        return mdsDescripcion;
    }
    
    public void setMdsDescripcion(String mdsDescripcion) {
        this.mdsDescripcion = mdsDescripcion;
    }
    
    public String getMdsTipoRec() {
        return mdsTipoRec;
    }
    
    public void setMdsTipoRec(String mdsTipoRec) {
        this.mdsTipoRec = mdsTipoRec;
    }
    
    public String getMdsUrlRecurso() {
        return mdsUrlRecurso;
    }
    
    public void setMdsUrlRecurso(String mdsUrlRecurso) {
        this.mdsUrlRecurso = mdsUrlRecurso;
    }
    
    public String getMdsUrlEnlace() {
        return mdsUrlEnlace;
    }
    
    public void setMdsUrlEnlace(String mdsUrlEnlace) {
        this.mdsUrlEnlace = mdsUrlEnlace;
    }
    
    public int getMdsOrden() {
        return mdsOrden;
    }
    
    public void setMdsOrden(int mdsOrden) {
        this.mdsOrden = mdsOrden;
    }
    
    public int getMdsEstado() {
        return mdsEstado;
    }
    
    public void setMdsEstado(int mdsEstado) {
        this.mdsEstado = mdsEstado;
    }
    
    public String getMdsDescripcionEn() {
        return mdsDescripcionEn;
    }

    public void setMdsDescripcionEn(String mdsDescripcionEn) {
        this.mdsDescripcionEn = mdsDescripcionEn;
    }

    public String getMdsDescripcionPt() {
        return mdsDescripcionPt;
    }

    public void setMdsDescripcionPt(String mdsDescripcionPt) {
        this.mdsDescripcionPt = mdsDescripcionPt;
    }

    public String getMdsUrlRecursoEn() {
        return mdsUrlRecursoEn;
    }

    public void setMdsUrlRecursoEn(String mdsUrlRecursoEn) {
        this.mdsUrlRecursoEn = mdsUrlRecursoEn;
    }

    public String getMdsUrlRecursoPt() {
        return mdsUrlRecursoPt;
    }

    public void setMdsUrlRecursoPt(String mdsUrlRecursoPt) {
        this.mdsUrlRecursoPt = mdsUrlRecursoPt;
    }

    public String getMdsUrlEnlaceEn() {
        return mdsUrlEnlaceEn;
    }

    public void setMdsUrlEnlaceEn(String mdsUrlEnlaceEn) {
        this.mdsUrlEnlaceEn = mdsUrlEnlaceEn;
    }

    public String getMdsUrlEnlacePt() {
        return mdsUrlEnlacePt;
    }

    public void setMdsUrlEnlacePt(String mdsUrlEnlacePt) {
        this.mdsUrlEnlacePt = mdsUrlEnlacePt;
    }
//</editor-fold>
    
}
