package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ANALISTA-TIC 2
 */

//@Data
@Entity
@Table(name = "wp_calendario_acad")
public class CalendAcdCabz implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calendario")
    private int cbzCodigo;
    
    @Column(name = "anio_inic", nullable = false, columnDefinition = "INT CHECK(anio_inic>1990)")
    private int cbzAnioInc;
    
    @Column(name = "anio_fin", nullable = false, columnDefinition = "INT CHECK(anio_fin>1990)")
    private int cbzAnioFin;
    
    @Column(name = "tipo", nullable = false, columnDefinition = "CHAR(5) CHECK(tipo IN ('ADMIS','GRADO'))")
    private String cbzTipo;
    
    @Column(name = "mes_inc", nullable = false, columnDefinition = "INT CHECK(mes_inc>1990)")
    private int cbzMesInc;
    
    @Column(name = "mes_fin", nullable = false, columnDefinition = "INT CHECK(mes_fin>1990)")
    private int cbzMesFin;
    
    @Column(name = "url_doc", nullable = true)
    private String cbzUrlDocx;
    
    @Column(name = "target", nullable = true, columnDefinition = "CHAR(7) CHECK(target IN ('_blank','_self','_parent','_top'))")
    private String cbzTarget;
    
    @Column(name = "periodo", nullable = true, columnDefinition = "CHAR(3) CHECK(periodo IN ('PPA','SPA'))")
    private String cbzPeriodo;
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "objCalendarioCabz")
    @JsonIgnoreProperties("objCalendarioCabz")
    private Set<CalendAcdDet> cbzListadoActvds= new HashSet<CalendAcdDet>();
    
    public CalendAcdCabz() {
        super();
    }
    
    public CalendAcdCabz(int cbzCodigo, int cbzAnioInc, int cbzAnioFin, String cbzTipo, int cbzMesInc, int cbzMesFin, String cbzUrlDocx, String cbzTarget, Set<CalendAcdDet> cbzListadoActvds) {
        super();
        this.cbzCodigo = cbzCodigo;
        this.cbzAnioInc = cbzAnioInc;
        this.cbzAnioFin = cbzAnioFin;
        this.cbzTipo = cbzTipo;
        this.cbzMesInc = cbzMesInc;
        this.cbzMesFin = cbzMesFin;
        this.cbzUrlDocx = cbzUrlDocx;
        this.cbzTarget = cbzTarget;
        this.cbzListadoActvds = cbzListadoActvds;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getCbzCodigo() {
        return cbzCodigo;
    }
    
    public void setCbzCodigo(int cbzCodigo) {
        this.cbzCodigo = cbzCodigo;
    }
    
    public int getCbzAnioInc() {
        return cbzAnioInc;
    }
    
    public void setCbzAnioInc(int cbzAnioInc) {
        this.cbzAnioInc = cbzAnioInc;
    }
    
    public int getCbzAnioFin() {
        return cbzAnioFin;
    }
    
    public void setCbzAnioFin(int cbzAnioFin) {
        this.cbzAnioFin = cbzAnioFin;
    }
    
    public String getCbzTipo() {
        return cbzTipo;
    }
    
    public void setCbzTipo(String cbzTipo) {
        this.cbzTipo = cbzTipo;
    }
    
    public int getCbzMesInc() {
        return cbzMesInc;
    }
    
    public void setCbzMesInc(int cbzMesInc) {
        this.cbzMesInc = cbzMesInc;
    }
    
    public int getCbzMesFin() {
        return cbzMesFin;
    }
    
    public void setCbzMesFin(int cbzMesFin) {
        this.cbzMesFin = cbzMesFin;
    }
    
    public String getCbzUrlDocx() {
        return cbzUrlDocx;
    }
    
    public void setCbzUrlDocx(String cbzUrlDocx) {
        this.cbzUrlDocx = cbzUrlDocx;
    }
    
    public String getCbzTarget() {
        return cbzTarget;
    }
    
    public void setCbzTarget(String cbzTarget) {
        this.cbzTarget = cbzTarget;
    }
    
    public Set<CalendAcdDet> getCbzListadoActvds() {
        return cbzListadoActvds;
    }
    
    public void setCbzListadoActvds(Set<CalendAcdDet> cbzListadoActvds) {
        this.cbzListadoActvds = cbzListadoActvds;
    }
    
    public String getCbzPeriodo() {
        return cbzPeriodo;
    }
    
    public void setCbzPeriodo(String cbzPeriodo) {
        this.cbzPeriodo = cbzPeriodo;
    }
    
    @Override
    public String toString() {
        return "CalendAcdCabz{" + "cbzCodigo=" + cbzCodigo + ", cbzAnioInc=" + cbzAnioInc + ", cbzAnioFin=" + cbzAnioFin + ", cbzTipo=" + cbzTipo + ", cbzMesInc=" + cbzMesInc + ", cbzMesFin=" + cbzMesFin + ", cbzUrlDocx=" + cbzUrlDocx + ", cbzTarget=" + cbzTarget + ", cbzPeriodo=" + cbzPeriodo + ", cbzListadoActvds=" + cbzListadoActvds + '}';
    }
//</editor-fold>

}
