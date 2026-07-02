package com.app.uteqbackend.model;

import com.app.uteqbackend.model.keys.PeriodicoMensPK;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_periodico_mens")
@IdClass(value = PeriodicoMensPK.class)
public class PeriodicoMens implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @Column(name = "anio", nullable = false, columnDefinition = "INT CHECK(anio>2000)")
    private int anio;
    
    @Id
    @Column(name = "mes", nullable = false, columnDefinition = "INT CHECK(mes>=1 AND mes<=12)")
    private int mes;
    
    @Column(name="url_portada", nullable=false, length = 100)
    private String urlportada;
    
    @Column(name="url_pag_web", nullable=false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String urlpw;
    
    public PeriodicoMens() {
        super();
    }
    
    public PeriodicoMens(int anio, int mes, String urlportada, String urlpw) {
        super();
        this.anio = anio;
        this.mes = mes;
        this.urlportada = urlportada;
        this.urlpw = urlpw;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getAnio() {
        return anio;
    }
    
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public int getMes() {
        return mes;
    }
    
    public void setMes(int mes) {
        this.mes = mes;
    }
    
    public String getUrlportada() {
        return urlportada;
    }
    
    public void setUrlportada(String urlportada) {
        this.urlportada = urlportada;
    }
    
    public String getUrlpw() {
        return urlpw;
    }
    
    public void setUrlpw(String urlpw) {
        this.urlpw = urlpw;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public String toString() {
        return "PeriodicoMens{" + "anio=" + anio + ", mes=" + mes + ", urlportada=" + urlportada + ", urlpw=" + urlpw + '}';
    }
//</editor-fold>
    
}
