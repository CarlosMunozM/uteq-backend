package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
@Table(name = "wp_linea_invest")
public class LineaInv implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Id
    @Column(name = "id_linea_inv", nullable = false, updatable = false)
    private UUID liCodigo;
    
    @ManyToOne
    @JoinColumn(name = "id_area_unsc")
    @JsonIgnoreProperties("anLineasInv")
    private AreaUnesco liAreaUnesco;
    
    @Column(name = "nombre", nullable = false)
    private String liNombre;
    
    @Column(name = "nombre_en", nullable = false)
    private String liNombreEn;
    
    @Column(name = "nombre_pt", nullable = false)
    private String liNombrePt;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (1,0))")
    private int liEstado;
    
    @ElementCollection
    @CollectionTable(name = "wp_sublinea_invest", joinColumns = @JoinColumn(name = "idlinea"))
    @Column(name="descripcion")
    private List<String> liSublineasInv;
    
    @ElementCollection
    @CollectionTable(name = "wp_sublinea_invest", joinColumns = @JoinColumn(name = "idlinea"))
    @Column(name="descripcion_en")
    private List<String> liSublineasInvEn;
    
    @ElementCollection
    @CollectionTable(name = "wp_sublinea_invest", joinColumns = @JoinColumn(name = "idlinea"))
    @Column(name="descripcion_pt")
    private List<String> liSublineasInvPt;
    
    public LineaInv(UUID liCodigo, AreaUnesco liAreaUnesco, String liNombre, int liEstado) {
        super();
        this.liCodigo = liCodigo;
        this.liAreaUnesco = liAreaUnesco;
        this.liNombre = liNombre;
        this.liEstado = liEstado;
    }
    
    public LineaInv() {
        super();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public UUID getLiCodigo() {
        return liCodigo;
    }
    
    public void setLiCodigo(UUID liCodigo) {
        this.liCodigo = liCodigo;
    }
    
    public AreaUnesco getLiAreaUnesco() {
        return liAreaUnesco;
    }
    
    public void setLiAreaUnesco(AreaUnesco liAreaUnesco) {
        this.liAreaUnesco = liAreaUnesco;
    }
    
    public String getLiNombre() {
        return liNombre;
    }
    
    public void setLiNombre(String liNombre) {
        this.liNombre = liNombre;
    }
    
    public int getLiEstado() {
        return liEstado;
    }
    
    public void setLiEstado(int liEstado) {
        this.liEstado = liEstado;
    }
    
    public List<String> getLiSublineasInv() {
        return liSublineasInv;
    }
    
    public void setLiSublineasInv(List<String> liSublineasInv) {
        this.liSublineasInv = liSublineasInv;
    }
    
    public String getLiNombreEn() {
        return liNombreEn;
    }

    public void setLiNombreEn(String liNombreEn) {
        this.liNombreEn = liNombreEn;
    }

    public String getLiNombrePt() {
        return liNombrePt;
    }

    public void setLiNombrePt(String liNombrePt) {
        this.liNombrePt = liNombrePt;
    }
    
    public List<String> getLiSublineasInvEn() {
        return liSublineasInvEn;
    }

    public void setLiSublineasInvEn(List<String> liSublineasInvEn) {
        this.liSublineasInvEn = liSublineasInvEn;
    }

    public List<String> getLiSublineasInvPt() {
        return liSublineasInvPt;
    }

    public void setLiSublineasInvPt(List<String> liSublineasInvPt) {
        this.liSublineasInvPt = liSublineasInvPt;
    }
    
//</editor-fold>

}
