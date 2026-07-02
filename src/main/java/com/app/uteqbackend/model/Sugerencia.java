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
@Table(name = "wp_sugerencia")
public class Sugerencia implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sugerencia")
    private int sgCodigo;
    
    @Column(name = "fecha_recp", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sgFechaRecp;
    
    @Column(name="nombre_sug", nullable=false, length = 200)
    private String sgNombreComp;
    
    @Column(name="correo_elect", nullable=false, length = 150)
    private String sgCorreoElect;
    
    @Column(name="destinario", nullable=false)
    private int sgDestinatario;
    
    @Column(name="asunto", nullable=false, length = 400)
    private String sgAsunto;
    
    @Column(name="mensaje", nullable=false, columnDefinition = "TEXT")
    private String sgMensaje;
    
    public Sugerencia() {
        super();
    }
    
    public Sugerencia(String sgNombreComp, String sgCorreoElect, int sgDestinatario, String sgAsunto, String sgMensaje) {
        super();
        this.sgNombreComp = sgNombreComp;
        this.sgCorreoElect = sgCorreoElect;
        this.sgDestinatario = sgDestinatario;
        this.sgAsunto = sgAsunto;
        this.sgMensaje = sgMensaje;
    }
    
    public Sugerencia(Date sgFechaRecp, String sgNombreComp, String sgCorreoElect, int sgDestinatario, String sgAsunto, String sgMensaje) {
        super();
        this.sgFechaRecp = sgFechaRecp;
        this.sgNombreComp = sgNombreComp;
        this.sgCorreoElect = sgCorreoElect;
        this.sgDestinatario = sgDestinatario;
        this.sgAsunto = sgAsunto;
        this.sgMensaje = sgMensaje;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public Date getSgFechaRecp() {
        return sgFechaRecp;
    }
    
    public void setSgFechaRecp(Date sgFechaRecp) {
        this.sgFechaRecp = sgFechaRecp;
    }
    
    public String getSgNombreComp() {
        return sgNombreComp;
    }
    
    public void setSgNombreComp(String sgNombreComp) {
        this.sgNombreComp = sgNombreComp;
    }
    
    public String getSgCorreoElect() {
        return sgCorreoElect;
    }
    
    public void setSgCorreoElect(String sgCorreoElect) {
        this.sgCorreoElect = sgCorreoElect;
    }
    
    public int getSgDestinatario() {
        return sgDestinatario;
    }
    
    public void setSgDestinatario(int sgDestinatario) {
        this.sgDestinatario = sgDestinatario;
    }
    
    public String getSgAsunto() {
        return sgAsunto;
    }
    
    public void setSgAsunto(String sgAsunto) {
        this.sgAsunto = sgAsunto;
    }
    
    public String getSgMensaje() {
        return sgMensaje;
    }
    
    public void setSgMensaje(String sgMensaje) {
        this.sgMensaje = sgMensaje;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public String toString() {
        return "Sugerencia{" + "sgFechaRecp=" + sgFechaRecp + ", sgNombreComp=" + sgNombreComp + ", sgCorreoElect=" + sgCorreoElect + ", sgDestinatario=" + sgDestinatario + ", sgAsunto=" + sgAsunto + ", sgMensaje=" + sgMensaje + '}';
    }
//</editor-fold>
    
}
