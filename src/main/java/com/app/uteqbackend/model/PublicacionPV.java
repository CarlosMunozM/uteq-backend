package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_publicacion_pv")
public class PublicacionPV implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Id
    @Column(name = "id_publicacion", nullable = false, updatable = false)
    private UUID pcCodigo;
    
    @ManyToOne
    @JoinColumn(name = "id_proyecto_vinc")
    @JsonIgnoreProperties("pvListadoPublcs")
    private ProyectoVinc pcInformPV;
    
    @Column(name = "anio", nullable = false, columnDefinition = "INT CHECK(anio>1990)")
    private int pcAnio;
    
    @Column(name = "titulo", nullable = false)
    private String pcTitulo;
    
    @Column(name = "tipo", nullable = false, columnDefinition = "CHAR(11) CHECK(tipo IN ('LIBRO','ARTICULO','CONFERENCIA','INFORME','TÉSIS'))")
    private String pcTipo;
    
    @Column(name = "url_archv_pdf", nullable = true)
    private String pcUrlArchivo;
    
    @Column(name = "url_pag_web", nullable = false, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String pcUrlPagWeb;
    
    public PublicacionPV() {
        super();
    }
    
    public PublicacionPV(UUID pcCodigo, ProyectoVinc pcInformPV, int pcAnio, String pcTitulo, String pcTipo, String pcUrlArchivo, String pcUrlPagWeb) {
        super();
        this.pcCodigo = pcCodigo;
        this.pcInformPV = pcInformPV;
        this.pcAnio = pcAnio;
        this.pcTitulo = pcTitulo;
        this.pcTipo = pcTipo;
        this.pcUrlArchivo = pcUrlArchivo;
        this.pcUrlPagWeb = pcUrlPagWeb;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public UUID getPcCodigo() {
        return pcCodigo;
    }
    
    public void setPcCodigo(UUID pcCodigo) {
        this.pcCodigo = pcCodigo;
    }
    
    public ProyectoVinc getPcInformPV() {
        return pcInformPV;
    }
    
    public void setPcInformPV(ProyectoVinc pcInformPV) {
        this.pcInformPV = pcInformPV;
    }
    
    public int getPcAnio() {
        return pcAnio;
    }
    
    public void setPcAnio(int pcAnio) {
        this.pcAnio = pcAnio;
    }
    
    public String getPcTitulo() {
        return pcTitulo;
    }
    
    public void setPcTitulo(String pcTitulo) {
        this.pcTitulo = pcTitulo;
    }
    
    public String getPcTipo() {
        return pcTipo;
    }
    
    public void setPcTipo(String pcTipo) {
        this.pcTipo = pcTipo;
    }
    
    public String getPcUrlArchivo() {
        return pcUrlArchivo;
    }
    
    public void setPcUrlArchivo(String pcUrlArchivo) {
        this.pcUrlArchivo = pcUrlArchivo;
    }
    
    public String getPcUrlPagWeb() {
        return pcUrlPagWeb;
    }
    
    public void setPcUrlPagWeb(String pcUrlPagWeb) {
        this.pcUrlPagWeb = pcUrlPagWeb;
    }
//</editor-fold>
    
}
