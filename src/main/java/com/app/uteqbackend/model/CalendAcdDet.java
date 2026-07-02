package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "wp_activds_cald")
public class CalendAcdDet implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private int detCodigo;
    
    @Column(name = "tipo", nullable = false)
    private int detTipo;
    
    @Column(name = "fecha_inc", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date detFechaInc;
    
    @Column(name = "semana_inc", nullable = true)
    private Integer detSemanaInc;
    
    @Column(name = "fecha_fin", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date detFechaFin;
    
    @Column(name = "semana_fin", nullable = true)
    private Integer detSemanaFin;
    
    @Column(name = "descripcion", nullable = false)
    private String detDescripcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_calendario", nullable = false)
    @JsonIgnore
    private CalendAcdCabz objCalendarioCabz;
    
    @Column(name = "descripcion_en", nullable = false)
    private String detDescripcionEn;
    
    @Column(name = "descripcion_pt", nullable = false)
    private String detDescripcionPt;
    
    public CalendAcdDet() {
        super();
    }
    
    public CalendAcdDet(int detCodigo, int detTipo, Date detFechaInc, Integer detSemanaInc, Date detFechaFin, Integer detSemanaFin, String detDescripcion, CalendAcdCabz objCalendarioCabz) {
        super();
        this.detCodigo = detCodigo;
        this.detTipo = detTipo;
        this.detFechaInc = detFechaInc;
        this.detSemanaInc = detSemanaInc;
        this.detFechaFin = detFechaFin;
        this.detSemanaFin = detSemanaFin;
        this.detDescripcion = detDescripcion;
        this.objCalendarioCabz = objCalendarioCabz;
    }

    public CalendAcdDet(int detCodigo, int detTipo, Date detFechaInc, Integer detSemanaInc, Date detFechaFin, Integer detSemanaFin, String detDescripcion, CalendAcdCabz objCalendarioCabz, String detDescripcionEn, String detDescripcionPt) {
        super();
        this.detCodigo = detCodigo;
        this.detTipo = detTipo;
        this.detFechaInc = detFechaInc;
        this.detSemanaInc = detSemanaInc;
        this.detFechaFin = detFechaFin;
        this.detSemanaFin = detSemanaFin;
        this.detDescripcion = detDescripcion;
        this.objCalendarioCabz = objCalendarioCabz;
        this.detDescripcionEn = detDescripcionEn;
        this.detDescripcionPt = detDescripcionPt;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getDetCodigo() {
        return detCodigo;
    }
    
    public void setDetCodigo(int detCodigo) {
        this.detCodigo = detCodigo;
    }
    
    public Date getDetFechaInc() {
        return detFechaInc;
    }
    
    public void setDetFechaInc(Date detFechaInc) {
        this.detFechaInc = detFechaInc;
    }
    
    public Date getDetFechaFin() {
        return detFechaFin;
    }
    
    public void setDetFechaFin(Date detFechaFin) {
        this.detFechaFin = detFechaFin;
    }
    
    public String getDetDescripcion() {
        return detDescripcion;
    }
    
    public void setDetDescripcion(String detDescripcion) {
        this.detDescripcion = detDescripcion;
    }
    
    public CalendAcdCabz getObjCalendarioCabz() {
        return objCalendarioCabz;
    }
    
    public void setObjCalendarioCabz(CalendAcdCabz objCalendarioCabz) {
        this.objCalendarioCabz = objCalendarioCabz;
    }
    
    public Integer getDetSemanaInc() {
        return detSemanaInc;
    }
    
    public void setDetSemanaInc(Integer detSemanaInc) {
        this.detSemanaInc = detSemanaInc;
    }
    
    public Integer getDetSemanaFin() {
        return detSemanaFin;
    }
    
    public void setDetSemanaFin(Integer detSemanaFin) {
        this.detSemanaFin = detSemanaFin;
    }
    
    public int getDetTipo() {
        return detTipo;
    }
    
    public void setDetTipo(int detTipo) {
        this.detTipo = detTipo;
    }

    public String getDetDescripcionEn() {
        return detDescripcionEn;
    }

    public void setDetDescripcionEn(String detDescripcionEn) {
        this.detDescripcionEn = detDescripcionEn;
    }

    public String getDetDescripcionPt() {
        return detDescripcionPt;
    }

    public void setDetDescripcionPt(String detDescripcionPt) {
        this.detDescripcionPt = detDescripcionPt;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public String toString() {
        return "CalendAcdDet{" + "detCodigo=" + detCodigo + ", detTipo=" + detTipo + ", detFechaInc=" + detFechaInc + ", detSemanaInc=" + detSemanaInc + ", detFechaFin=" + detFechaFin + ", detSemanaFin=" + detSemanaFin + ", detDescripcion=" + detDescripcion + ", objCalendarioCabz=" + objCalendarioCabz + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.detCodigo;
        hash = 71 * hash + this.detTipo;
        hash = 71 * hash + Objects.hashCode(this.detFechaInc);
        hash = 71 * hash + Objects.hashCode(this.detSemanaInc);
        hash = 71 * hash + Objects.hashCode(this.detFechaFin);
        hash = 71 * hash + Objects.hashCode(this.detSemanaFin);
        hash = 71 * hash + Objects.hashCode(this.detDescripcion);
        hash = 71 * hash + Objects.hashCode(this.objCalendarioCabz);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CalendAcdDet other = (CalendAcdDet) obj;
        if (this.detCodigo != other.detCodigo) {
            return false;
        }
        if (this.detTipo != other.detTipo) {
            return false;
        }
        if (!Objects.equals(this.detDescripcion, other.detDescripcion)) {
            return false;
        }
        if (!Objects.equals(this.detFechaInc, other.detFechaInc)) {
            return false;
        }
        if (!Objects.equals(this.detSemanaInc, other.detSemanaInc)) {
            return false;
        }
        if (!Objects.equals(this.detFechaFin, other.detFechaFin)) {
            return false;
        }
        if (!Objects.equals(this.detSemanaFin, other.detSemanaFin)) {
            return false;
        }
        if (!Objects.equals(this.objCalendarioCabz, other.objCalendarioCabz)) {
            return false;
        }
        return true;
    }
//</editor-fold>
    
}
