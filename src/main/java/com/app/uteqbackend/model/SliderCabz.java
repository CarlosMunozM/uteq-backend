package com.app.uteqbackend.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Data
@Entity
@Table(name = "wp_slider_cab")
public class SliderCabz implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_slider")
    private int slcCodigo;
    
    @Type(type = "uuid-char")
    @Column(name = "id_entidad", nullable = true)
    private String slcCodigoEntd;
    
    @Column(name = "ubicacion", nullable = false, length = 5, columnDefinition = "CHAR(5) CHECK(ubicacion IN ('PRINC','SECUN'))")
    private String slcUbicacion;
    
    @Column(name = "tipo", nullable = false, length = 4, columnDefinition = "CHAR(4) CHECK(tipo IN ('TEMP','FIJO'))")
    private String slcTipo;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK (estado IN (0,1))")
    private int slcEstado;
    
    @ElementCollection
    @CollectionTable(name = "wp_slider_det", joinColumns = @JoinColumn(name = "id_slider"))
    private List<SliderDet> slcListadoImagenes;
    
    public SliderCabz() {
        super();
    }
    
    public SliderCabz(int slcCodigo, String slcCodigoEntd, String slcUbicacion, String slcTipo, int slcEstado) {
        super();
        this.slcCodigo = slcCodigo;
        this.slcCodigoEntd = slcCodigoEntd;
        this.slcUbicacion = slcUbicacion;
        this.slcTipo = slcTipo;
        this.slcEstado = slcEstado;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getSlcCodigo() {
        return slcCodigo;
    }
    
    public void setSlcCodigo(int slcCodigo) {
        this.slcCodigo = slcCodigo;
    }
    
    public String getSlcCodigoEntd() {
        return slcCodigoEntd;
    }
    
    public void setSlcCodigoEntd(String slcCodigoEntd) {
        this.slcCodigoEntd = slcCodigoEntd;
    }
    
    public String getSlcUbicacion() {
        return slcUbicacion;
    }
    
    public void setSlcUbicacion(String slcUbicacion) {
        this.slcUbicacion = slcUbicacion;
    }
    
    public String getSlcTipo() {
        return slcTipo;
    }
    
    public void setSlcTipo(String slcTipo) {
        this.slcTipo = slcTipo;
    }
    
    public int getSlcEstado() {
        return slcEstado;
    }
    
    public void setSlcEstado(int slcEstado) {
        this.slcEstado = slcEstado;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public String toString() {
        return "SliderCabz{" + "slcCodigo=" + slcCodigo + ", slcCodigoEntd=" + slcCodigoEntd + ", slcUbicacion=" + slcUbicacion + ", slcTipo=" + slcTipo + ", slcEstado=" + slcEstado + '}';
    }
//</editor-fold>
    
    
}
