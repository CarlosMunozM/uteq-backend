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
@Table(name = "wp_capacitaciones_uth")
public class CapacitacionUTH implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_capacitacion")
    private Integer cuCodigo;
    
    @Column(name="descripcion", nullable=false)
    private String cuDescripcion;
    
    @Column(name = "modalidad", nullable = false, columnDefinition = "INT CHECK(modalidad IN (1,2,3,4,5,6))")
    private int cuModalidad;
    
    @Column(name = "tipo_publico", nullable = false, columnDefinition = "INT CHECK(tipo_publico IN (1,2,3))")
    private int cuTipoPublico;
    
    @Column(name = "numero_horas", nullable = false)
    private int cuNumHoras;
    
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cuFechaInicio;
    
    @Column(name = "fecha_fin", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cuFechaFin;
    
    @Column(name = "link_registro", nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String cuLinkRegistro;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (0,1))")
    private int cuEstado;
    
    @Column(name = "fecha_reg", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cuFechaRegistro;
    
    /*@Column(name="descripcion_en", nullable=false)
    private String cuDescripcionEn;
    
    @Column(name="descripcion_pt", nullable=false)
    private String cuDescripcionPt;*/
    
    public CapacitacionUTH() {
        super();
    }
    
    public CapacitacionUTH(Integer cuCodigo, String cuDescripcion, int cuModalidad, int cuNumHoras, Date cuFechaInicio, Date cuFechaFin, String cuLinkRegistro, int cuEstado, Date cuFechaRegistro) {
        super();
        this.cuCodigo = cuCodigo;
        this.cuDescripcion = cuDescripcion;
        this.cuModalidad = cuModalidad;
        this.cuNumHoras = cuNumHoras;
        this.cuFechaInicio = cuFechaInicio;
        this.cuFechaFin = cuFechaFin;
        this.cuLinkRegistro = cuLinkRegistro;
        this.cuEstado = cuEstado;
        this.cuFechaRegistro = cuFechaRegistro;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public Integer getCuCodigo() {
        return cuCodigo;
    }
    
    public void setCuCodigo(Integer cuCodigo) {
        this.cuCodigo = cuCodigo;
    }
    
    public String getCuDescripcion() {
        return cuDescripcion;
    }
    
    public void setCuDescripcion(String cuDescripcion) {
        this.cuDescripcion = cuDescripcion;
    }
    
    public int getCuModalidad() {
        return cuModalidad;
    }
    
    public void setCuModalidad(int cuModalidad) {
        this.cuModalidad = cuModalidad;
    }
    
    public int getCuTipoPublico() {
        return cuTipoPublico;
    }
    
    public void setCuTipoPublico(int cuTipoPublico) {
        this.cuTipoPublico = cuTipoPublico;
    }
    
    public int getCuNumHoras() {
        return cuNumHoras;
    }
    
    public void setCuNumHoras(int cuNumHoras) {
        this.cuNumHoras = cuNumHoras;
    }
    
    public Date getCuFechaInicio() {
        return cuFechaInicio;
    }
    
    public void setCuFechaInicio(Date cuFechaInicio) {
        this.cuFechaInicio = cuFechaInicio;
    }
    
    public Date getCuFechaFin() {
        return cuFechaFin;
    }
    
    public void setCuFechaFin(Date cuFechaFin) {
        this.cuFechaFin = cuFechaFin;
    }
    
    public String getCuLinkRegistro() {
        return cuLinkRegistro;
    }
    
    public void setCuLinkRegistro(String cuLinkRegistro) {
        this.cuLinkRegistro = cuLinkRegistro;
    }
    
    public int getCuEstado() {
        return cuEstado;
    }
    
    public void setCuEstado(int cuEstado) {
        this.cuEstado = cuEstado;
    }
    
    public Date getCuFechaRegistro() {
        return cuFechaRegistro;
    }
    
    public void setCuFechaRegistro(Date cuFechaRegistro) {
        this.cuFechaRegistro = cuFechaRegistro;
    }
    
    /*public String getCuDescripcionEn() {
        return cuDescripcionEn;
    }

    public void setCuDescripcionEn(String cuDescripcionEn) {
        this.cuDescripcionEn = cuDescripcionEn;
    }

    public String getCuDescripcionPt() {
        return cuDescripcionPt;
    }

    public void setCuDescripcionPt(String cuDescripcionPt) {
        this.cuDescripcionPt = cuDescripcionPt;
    }*/
    
//</editor-fold>
    
}
