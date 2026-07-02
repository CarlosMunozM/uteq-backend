package com.app.uteqbackend.model;

import com.app.uteqbackend.model.keys.OrganigramaPK;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "wp_organigrama_est")
@IdClass(value = OrganigramaPK.class)
public class Organigrama  implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @ManyToOne
    @JoinColumn(name = "id_estructura")
    @JsonIgnoreProperties("dpListadoOrganigramas")
    @Id
    private DatosMult orObjEstructura;
    
    @ManyToOne
    @JoinColumn(name = "id_autoridad")
    @JsonIgnoreProperties("dpListadoOrganigramas")
    @Id
    private Autoridad orObjAutoridad;
    
    @Id
    @Column(name = "anio_inicio", nullable = false, columnDefinition = "INT CHECK(anio_inicio>1990)")
    private int orAnioInicio;
    
    @Id
    @Column(name = "anio_fin", nullable = false, columnDefinition = "INT CHECK(anio_fin>1990)")
    private int orAnioFin;
    
    @Column(name = "voz", nullable = true, columnDefinition = "CHAR(1) CHECK(voz IN ('S','N'))")
    private String orVoz;
    
    @Column(name = "voto", nullable = true, columnDefinition = "CHAR(1) CHECK(voto IN ('S','N'))")
    private String orVoto;
    
    @Column(name = "orden", nullable = false)
    private int orOrden;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (0,1))")
    private int orEstado;
    
    public Organigrama() {
        super();
    }
    
    public Organigrama(DatosMult orObjEstructura, Autoridad orObjAutoridad, int orAnioInicio, int orAnioFin, int orOrden, int orEstado) {
        super();
        this.orObjEstructura=orObjEstructura;
        this.orObjAutoridad= orObjAutoridad;
        this.orAnioInicio = orAnioInicio;
        this.orAnioFin = orAnioFin;
        this.orOrden = orOrden;
        this.orEstado = orEstado;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public DatosMult getOrObjEstructura() {
        return orObjEstructura;
    }
    
    public void setOrObjEstructura(DatosMult orObjEstructura) {
        this.orObjEstructura = orObjEstructura;
    }
    
    public Autoridad getOrObjAutoridad() {
        return orObjAutoridad;
    }
    
    public void setOrObjAutoridad(Autoridad orObjAutoridad) {
        this.orObjAutoridad = orObjAutoridad;
    }
    
    public int getOrAnioInicio() {
        return orAnioInicio;
    }
    
    public void setOrAnioInicio(int orAnioInicio) {
        this.orAnioInicio = orAnioInicio;
    }
    
    public int getOrAnioFin() {
        return orAnioFin;
    }
    
    public void setOrAnioFin(int orAnioFin) {
        this.orAnioFin = orAnioFin;
    }
    
    public int getOrOrden() {
        return orOrden;
    }
    
    public void setOrOrden(int orOrden) {
        this.orOrden = orOrden;
    }
    
    public int getOrEstado() {
        return orEstado;
    }
    
    public void setOrEstado(int orEstado) {
        this.orEstado = orEstado;
    }
    
    public String getOrVoz() {
        return orVoz;
    }
    
    public void setOrVoz(String orVoz) {
        this.orVoz = orVoz;
    }
    
    public String getOrVoto() {
        return orVoto;
    }
    
    public void setOrVoto(String orVoto) {
        this.orVoto = orVoto;
    }
//</editor-fold>
    
}
