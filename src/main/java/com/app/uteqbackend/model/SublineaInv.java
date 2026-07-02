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
@Table(name = "wp_sublinea_invest")
public class SublineaInv implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sublinea_inv")
    private int sbCodigo;
    
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name="idlinea", nullable=false, updatable = false)
    private UUID sbCodLineaInv;
    
    @Column(name = "descripcion", nullable = false)
    private String sbDescripcion;
    
    @Column(name = "descripcion_en", nullable = false)
    private String sbDescripcionEn;
    
    @Column(name = "descripcion_pt", nullable = false)
    private String sbDescripcionPt;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (1,0))")
    private int sbEstado;
    
    public SublineaInv() {
        super();
    }
    
    public SublineaInv(int sbCodigo, UUID sbCodLineaInv, String sbDescripcion, int sbEstado) {
        this.sbCodigo = sbCodigo;
        this.sbCodLineaInv = sbCodLineaInv;
        this.sbDescripcion = sbDescripcion;
        this.sbEstado = sbEstado;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getSbCodigo() {
        return sbCodigo;
    }
    
    public void setSbCodigo(int sbCodigo) {
        this.sbCodigo = sbCodigo;
    }
    
    public UUID getSbCodLineaInv() {
        return sbCodLineaInv;
    }
    
    public void setSbCodLineaInv(UUID sbCodLineaInv) {
        this.sbCodLineaInv = sbCodLineaInv;
    }
    
    public String getSbDescripcion() {
        return sbDescripcion;
    }
    
    public void setSbDescripcion(String sbDescripcion) {
        this.sbDescripcion = sbDescripcion;
    }
    
    public int getSbEstado() {
        return sbEstado;
    }
    
    public void setSbEstado(int sbEstado) {
        this.sbEstado = sbEstado;
    }
    
    public String getSbDescripcionEn() {
        return sbDescripcionEn;
    }

    public void setSbDescripcionEn(String sbDescripcionEn) {
        this.sbDescripcionEn = sbDescripcionEn;
    }

    public String getSbDescripcionPt() {
        return sbDescripcionPt;
    }

    public void setSbDescripcionPt(String sbDescripcionPt) {
        this.sbDescripcionPt = sbDescripcionPt;
    }
    
//</editor-fold>
    
}
