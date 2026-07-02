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
@Table(name = "wp_produccion_ctf")
public class ProduccionCtf implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prodc")
    private int psCodigo;
    
    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    @JsonIgnoreProperties("ptListadoProdCtf")
    private ProyectoInvst psProyectoInvst;
    
    @Column(name = "anio", nullable = false, columnDefinition = "INT CHECK(anio > 1950)")
    private int psAnio;
    
    @Column(name = "titulo", nullable = false)
    private String psTitulo;
    
    @Column(name = "tipo", nullable = false, columnDefinition = "CHAR(11) CHECK(tipo IN ('LIBRO','ARTICULO','CONFERENCIA','INFORME','TÉSIS'))")
    private String psTipo;
    
    @Column(name = "url_archv_pdf", nullable = true)
    private String psUrlArchivo;
    
    @Column(name = "url_pag_web", nullable = false, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String psUrlPaginaWeb;
    
    public ProduccionCtf() {
        super();
    }
    
    public ProduccionCtf(int psCodigo, ProyectoInvst psProyectoInvst, int psAnio, String psTitulo, String psTipo, String psUrlArchivo, String psUrlPaginaWeb) {
        super();
        this.psCodigo = psCodigo;
        this.psProyectoInvst = psProyectoInvst;
        this.psAnio = psAnio;
        this.psTitulo = psTitulo;
        this.psTipo = psTipo;
        this.psUrlArchivo = psUrlArchivo;
        this.psUrlPaginaWeb = psUrlPaginaWeb;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getPsCodigo() {
        return psCodigo;
    }
    
    public void setPsCodigo(int psCodigo) {
        this.psCodigo = psCodigo;
    }
    
    public ProyectoInvst getPsProyectoInvst() {
        return psProyectoInvst;
    }
    
    public void setPsProyectoInvst(ProyectoInvst psProyectoInvst) {
        this.psProyectoInvst = psProyectoInvst;
    }
    
    public int getPsAnio() {
        return psAnio;
    }
    
    public void setPsAnio(int psAnio) {
        this.psAnio = psAnio;
    }
    
    public String getPsTitulo() {
        return psTitulo;
    }
    
    public void setPsTitulo(String psTitulo) {
        this.psTitulo = psTitulo;
    }
    
    public String getPsTipo() {
        return psTipo;
    }
    
    public void setPsTipo(String psTipo) {
        this.psTipo = psTipo;
    }
    
    public String getPsUrlArchivo() {
        return psUrlArchivo;
    }
    
    public void setPsUrlArchivo(String psUrlArchivo) {
        this.psUrlArchivo = psUrlArchivo;
    }
    
    public String getPsUrlPaginaWeb() {
        return psUrlPaginaWeb;
    }
    
    public void setPsUrlPaginaWeb(String psUrlPaginaWeb) {
        this.psUrlPaginaWeb = psUrlPaginaWeb;
    }
//</editor-fold>
    
}
