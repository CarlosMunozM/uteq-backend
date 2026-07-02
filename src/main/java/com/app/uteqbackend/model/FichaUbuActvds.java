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
@Table(name = "wp_ficha_datos_ubu_actv")
public class FichaUbuActvds implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actv")
    private int uaCodigo;
    
    @ManyToOne
    @JoinColumn(name = "id_ficha")
    @JsonIgnoreProperties("fuListadoActividades")
    @Id
    private FichaUbu uaFichaUbu;
    
    @Column(name = "id_actividad", nullable = false)
    private int uaCodActividad;
    
    @Column(name = "actividad", nullable = false)
    private String uaActividad;
    
    @Column(name = "id_horario", nullable = false)
    private int uaCodHorario;
    
    @Column(name = "horario", nullable = false)
    private String uaHorario;
    
    @Column(name = "fecha_reg", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date uaFechaReg;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (0,1))")
    private int uaEstado;
    
    public FichaUbuActvds() {
        super();
    }
    
    public FichaUbuActvds(int uaCodigo, FichaUbu uaFichaUbu, int uaCodActividad, String uaActividad, int uaCodHorario, String uaHorario, Date uaFechaReg, int uaEstado) {
        super();
        this.uaCodigo = uaCodigo;
        this.uaFichaUbu = uaFichaUbu;
        this.uaCodActividad = uaCodActividad;
        this.uaActividad = uaActividad;
        this.uaCodHorario = uaCodHorario;
        this.uaHorario = uaHorario;
        this.uaFechaReg = uaFechaReg;
        this.uaEstado = uaEstado;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getUaCodigo() {
        return uaCodigo;
    }
    
    public void setUaCodigo(int uaCodigo) {
        this.uaCodigo = uaCodigo;
    }
    
    public FichaUbu getUaFichaUbu() {
        return uaFichaUbu;
    }
    
    public void setUaFichaUbu(FichaUbu uaFichaUbu) {
        this.uaFichaUbu = uaFichaUbu;
    }
    
    public int getUaCodActividad() {
        return uaCodActividad;
    }
    
    public void setUaCodActividad(int uaCodActividad) {
        this.uaCodActividad = uaCodActividad;
    }
    
    public String getUaActividad() {
        return uaActividad;
    }
    
    public void setUaActividad(String uaActividad) {
        this.uaActividad = uaActividad;
    }
    
    public int getUaCodHorario() {
        return uaCodHorario;
    }
    
    public void setUaCodHorario(int uaCodHorario) {
        this.uaCodHorario = uaCodHorario;
    }
    
    public String getUaHorario() {
        return uaHorario;
    }
    
    public void setUaHorario(String uaHorario) {
        this.uaHorario = uaHorario;
    }
    
    public Date getUaFechaReg() {
        return uaFechaReg;
    }
    
    public void setUaFechaReg(Date uaFechaReg) {
        this.uaFechaReg = uaFechaReg;
    }
    
    public int getUaEstado() {
        return uaEstado;
    }
    
    public void setUaEstado(int uaEstado) {
        this.uaEstado = uaEstado;
    }
//</editor-fold>
    
}
