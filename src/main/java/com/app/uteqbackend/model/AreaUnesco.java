package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_area_unesco")
public class AreaUnesco implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Id
    @Column(name = "id_area_unsc", nullable = false, updatable = false)
    private UUID anCodigo;
    
    @Column(name = "nombre", nullable = false)
    private String anNombre;
    
    @Column(name = "nombre_en", nullable = false)
    private String anNombreEn;
    
    @Column(name = "nombre_pt", nullable = false)
    private String anNombrePt;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (1,0))")
    private int anEstado;
    
    @OneToMany(mappedBy = "liAreaUnesco", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<LineaInv> anLineasInv = new HashSet<LineaInv>();
    
    public AreaUnesco() {
        super();
    }
    
    public AreaUnesco(UUID anCodigo, String anNombre, int anEstado) {
        super();
        this.anCodigo = anCodigo;
        this.anNombre = anNombre;
        this.anEstado = anEstado;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public UUID getAnCodigo() {
        return anCodigo;
    }
    
    public void setAnCodigo(UUID anCodigo) {
        this.anCodigo = anCodigo;
    }
    
    public String getAnNombre() {
        return anNombre;
    }
    
    public void setAnNombre(String anNombre) {
        this.anNombre = anNombre;
    }
    
    public int getAnEstado() {
        return anEstado;
    }
    
    public void setAnEstado(int anEstado) {
        this.anEstado = anEstado;
    }
    
    public Set<LineaInv> getAnLineasInv() {
        return anLineasInv;
    }
    
    public void setAnLineasInv(Set<LineaInv> anLineasInv) {
        this.anLineasInv = anLineasInv;
    }
    
    public String getAnNombreEn() {
        return anNombreEn;
    }

    public void setAnNombreEn(String anNombreEn) {
        this.anNombreEn = anNombreEn;
    }

    public String getAnNombrePt() {
        return anNombrePt;
    }

    public void setAnNombrePt(String anNombrePt) {
        this.anNombrePt = anNombrePt;
    }
    
//</editor-fold>
    
}
