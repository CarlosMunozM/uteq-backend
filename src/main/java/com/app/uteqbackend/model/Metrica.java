package com.app.uteqbackend.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Data
@Entity
@Table(name = "wp_metrica")
public class Metrica implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metrica")
    private int mcCodigo;
    
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "cod_entidad", nullable = false, updatable = false)
    private UUID mcCodigoEntd;
    
    @Column(name = "id_serv_med", nullable = true)
    private Integer mcCodServMedc;
    
    @Column(name = "periodo", nullable = false)
    private int mcPeriodo;
    
    @Column(name = "nombre", nullable = false)
    private String mcNombre;
    
    @Column(name = "cantidad", nullable = false)
    private int mcCantidad;
    
    @Column(name = "url_imagen", nullable = false)
    private String mcUrlImagen;
    
    @Column(name = "nombre_en", nullable = false)
    private String mcNombreEn;
    
    @Column(name = "nombre_pt", nullable = false)
    private String mcNombrePt;
    
    public Metrica() {
        super();
    }
    
    public Metrica(int mcCodigo, UUID mcCodigoEntd, Integer mcCodServMedc, int mcPeriodo, String mcNombre, int mcCantidad, String mcUrlImagen) {
        super();
        this.mcCodigo = mcCodigo;
        this.mcCodigoEntd = mcCodigoEntd;
        this.mcCodServMedc = mcCodServMedc;
        this.mcPeriodo = mcPeriodo;
        this.mcNombre = mcNombre;
        this.mcCantidad = mcCantidad;
        this.mcUrlImagen = mcUrlImagen;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getMcCodigo() {
        return mcCodigo;
    }
    
    public void setMcCodigo(int mcCodigo) {
        this.mcCodigo = mcCodigo;
    }
    
    public UUID getMcCodigoEntd() {
        return mcCodigoEntd;
    }
    
    public void setMcCodigoEntd(UUID mcCodigoEntd) {
        this.mcCodigoEntd = mcCodigoEntd;
    }
    
    public Integer getMcCodServMedc() {
        return mcCodServMedc;
    }
    
    public void setMcCodServMedc(Integer mcCodServMedc) {
        this.mcCodServMedc = mcCodServMedc;
    }
    
    public int getMcPeriodo() {
        return mcPeriodo;
    }
    
    public void setMcPeriodo(int mcPeriodo) {
        this.mcPeriodo = mcPeriodo;
    }
    
    public String getMcNombre() {
        return mcNombre;
    }
    
    public void setMcNombre(String mcNombre) {
        this.mcNombre = mcNombre;
    }
    
    public int getMcCantidad() {
        return mcCantidad;
    }
    
    public void setMcCantidad(int mcCantidad) {
        this.mcCantidad = mcCantidad;
    }
    
    public String getMcUrlImagen() {
        return mcUrlImagen;
    }
    
    public void setMcUrlImagen(String mcUrlImagen) {
        this.mcUrlImagen = mcUrlImagen;
    }
    
    public String getMcNombreEn() {
        return mcNombreEn;
    }

    public void setMcNombreEn(String mcNombreEn) {
        this.mcNombreEn = mcNombreEn;
    }

    public String getMcNombrePt() {
        return mcNombrePt;
    }

    public void setMcNombrePt(String mcNombrePt) {
        this.mcNombrePt = mcNombrePt;
    }
    
//</editor-fold>
    
}