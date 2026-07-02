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
@Table(name = "wp_req_certificado")
public class RequerimientoCertf implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_req")
    private int rcCodigo;
    
    @Column(name="num_dni", nullable=false, columnDefinition = "CHAR(10) CHECK(num_dni ~ '^[0-9]*$')")
    private String rcNumDNI;
    
    @Column(name="nombre_comp", nullable=false, length = 250)
    private String rcNombreComp;
    
    @Column(name="correo_elect", nullable=false, length = 200)
    private String rcCorreoElect;
    
    @Column(name="id_tipo_certf", nullable=false)
    private int rcTipoCertf;
    
    @Column(name="tipo_certf", nullable=false, length = 300)
    private String rcNmbTipoCertf;
    
    @Column(name="mensaje", nullable=false)
    private String rcMensaje;
    
    @Column(name = "fecha_reg", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rcFechaReg;
    
    public RequerimientoCertf() {
        super();
    }
    
    public RequerimientoCertf(int rcCodigo, String rcNumDNI, String rcNombreComp, int rcTipoCertf, String rcNmbTipoCertf, String rcMensaje, Date rcFechaReg) {
        super();
        this.rcCodigo = rcCodigo;
        this.rcNumDNI = rcNumDNI;
        this.rcNombreComp = rcNombreComp;
        this.rcTipoCertf = rcTipoCertf;
        this.rcNmbTipoCertf = rcNmbTipoCertf;
        this.rcMensaje = rcMensaje;
        this.rcFechaReg = rcFechaReg;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getRcCodigo() {
        return rcCodigo;
    }
    
    public void setRcCodigo(int rcCodigo) {
        this.rcCodigo = rcCodigo;
    }
    
    public String getRcNumDNI() {
        return rcNumDNI;
    }
    
    public void setRcNumDNI(String rcNumDNI) {
        this.rcNumDNI = rcNumDNI;
    }
    
    public String getRcNombreComp() {
        return rcNombreComp;
    }
    
    public void setRcNombreComp(String rcNombreComp) {
        this.rcNombreComp = rcNombreComp;
    }
    
    public int getRcTipoCertf() {
        return rcTipoCertf;
    }
    
    public void setRcTipoCertf(int rcTipoCertf) {
        this.rcTipoCertf = rcTipoCertf;
    }
    
    public String getRcMensaje() {
        return rcMensaje;
    }
    
    public void setRcMensaje(String rcMensaje) {
        this.rcMensaje = rcMensaje;
    }
    
    public Date getRcFechaReg() {
        return rcFechaReg;
    }
    
    public void setRcFechaReg(Date rcFechaReg) {
        this.rcFechaReg = rcFechaReg;
    }
    
    public String getRcNmbTipoCertf() {
        return rcNmbTipoCertf;
    }
    
    public void setRcNmbTipoCertf(String rcNmbTipoCertf) {
        this.rcNmbTipoCertf = rcNmbTipoCertf;
    }
    
    public String getRcCorreoElect() {
        return rcCorreoElect;
    }
    
    public void setRcCorreoElect(String rcCorreoElect) {
        this.rcCorreoElect = rcCorreoElect;
    }
//</editor-fold>
    
}
