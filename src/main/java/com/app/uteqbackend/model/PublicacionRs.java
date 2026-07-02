package com.app.uteqbackend.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_publicacion_rs")
public class PublicacionRs implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacion")
    private int prCodigo;
    
    @Column(name="codigo_pub", nullable=true)
    private String prCodPub;
    
    @Column(name="texto_twt", nullable=true)
    private String prTextoTwt;
    
    @Column(name = "fecha", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date prFecha;
    
    @Column(name="url_publc", nullable=false)
    private String prUrl;
    
    @Column(name="red_social", nullable=false, columnDefinition = "CHAR(5) CHECK(red_social IN ('FACEB','TWITT'))")
    private String prRedSocial;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (0,1))")
    private int prEstado;
    
    public PublicacionRs() {
        super();
    }
    
    public PublicacionRs(int prCodigo, String prCodPub, String prTextoTwt, Date prFecha, String prUrl, String prRedSocial, int prEstado) {
        this.prCodigo = prCodigo;
        this.prCodPub = prCodPub;
        this.prTextoTwt = prTextoTwt;
        this.prFecha = prFecha;
        this.prUrl = prUrl;
        this.prRedSocial = prRedSocial;
        this.prEstado = prEstado;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getPrCodigo() {
        return prCodigo;
    }
    
    public void setPrCodigo(int prCodigo) {
        this.prCodigo = prCodigo;
    }
    
    public Date getPrFecha() {
        return prFecha;
    }
    
    public void setPrFecha(Date prFecha) {
        this.prFecha = prFecha;
    }
    
    public String getPrUrl() {
        return prUrl;
    }
    
    public void setPrUrl(String prUrl) {
        this.prUrl = prUrl;
    }
    
    public String getPrRedSocial() {
        return prRedSocial;
    }
    
    public void setPrRedSocial(String prRedSocial) {
        this.prRedSocial = prRedSocial;
    }
    
    public int getPrEstado() {
        return prEstado;
    }
    
    public void setPrEstado(int prEstado) {
        this.prEstado = prEstado;
    }
    
    public String getPrCodPub() {
        return prCodPub;
    }
    
    public void setPrCodPub(String prCodPub) {
        this.prCodPub = prCodPub;
    }
    
    public String getPrTextoTwt() {
        return prTextoTwt;
    }
    
    public void setPrTextoTwt(String prTextoTwt) {
        this.prTextoTwt = prTextoTwt;
    }
//</editor-fold>
    
}
