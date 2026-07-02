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
@Table(name = "wp_plantilla_email")
public class PlantillaEmail implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plantilla")
    private int peCodigo;
    
    @Column(name = "uso", nullable = false)
    private String peUso;
    
    @Column(name = "plantilla", nullable = false)
    private String pePlantilla;
    
    @Column(name = "fecha_reg", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date peFechaReg;
    
    @Column(name = "ubicacion", nullable = false, length = 5, columnDefinition = "CHAR(5) CHECK(ubicacion IN ('INSMS','MATMS','SUGGN'))")
    private String peUbicacion;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (0,1))")
    private int peEstado;
    
    public PlantillaEmail() {
        super();
    }
    
    public PlantillaEmail(int peCodigo, String peUso, String pePlantilla, Date peFechaReg, String peUbicacion, int peEstado) {
        super();
        this.peCodigo = peCodigo;
        this.peUso = peUso;
        this.pePlantilla = pePlantilla;
        this.peFechaReg = peFechaReg;
        this.peUbicacion = peUbicacion;
        this.peEstado = peEstado;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getPeCodigo() {
        return peCodigo;
    }
    
    public void setPeCodigo(int peCodigo) {
        this.peCodigo = peCodigo;
    }
    
    public String getPeUso() {
        return peUso;
    }
    
    public void setPeUso(String peUso) {
        this.peUso = peUso;
    }
    
    public String getPePlantilla() {
        return pePlantilla;
    }
    
    public void setPePlantilla(String pePlantilla) {
        this.pePlantilla = pePlantilla;
    }
    
    public Date getPeFechaReg() {
        return peFechaReg;
    }
    
    public void setPeFechaReg(Date peFechaReg) {
        this.peFechaReg = peFechaReg;
    }
    
    public String getPeUbicacion() {
        return peUbicacion;
    }
    
    public void setPeUbicacion(String peUbicacion) {
        this.peUbicacion = peUbicacion;
    }
    
    public int getPeEstado() {
        return peEstado;
    }
    
    public void setPeEstado(int peEstado) {
        this.peEstado = peEstado;
    }
//</editor-fold>
    
}
