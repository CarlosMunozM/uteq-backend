package com.app.uteqbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author R.PP_UTEQ
 */

@Data
@Entity
@Table(name = "wp_pistas_dbq")
public class PistaDbq {
   
    //<editor-fold defaultstate="collapsed" desc="VARIABLES">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_pst")
    private int codigo_id;
    
    @Column(name = "codigo", nullable = false, length = 8)
    private String identf;
    
    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;
    
    @Column(name = "validez", nullable = false)
    private int validez;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    public PistaDbq() {
        super();
    }
    
    public PistaDbq(int codigo_id, String identf, int puntuacion) {
        this.codigo_id = codigo_id;
        this.identf = identf;
        this.puntuacion = puntuacion;
    }

    public PistaDbq(int codigo_id, String identf, int puntuacion, int validez) {
        this.codigo_id = codigo_id;
        this.identf = identf;
        this.puntuacion = puntuacion;
        this.validez = validez;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getCodigo_id() {
        return codigo_id;
    }
    
    public void setCodigo_id(int codigo_id) {
        this.codigo_id = codigo_id;
    }
    
    public String getIdentf() {
        return identf;
    }
    
    public void setIdentf(String identf) {
        this.identf = identf;
    }
    
    public int getPuntuacion() {
        return puntuacion;
    }
    
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    public int getValidez() {
        return validez;
    }

    public void setValidez(int validez) {
        this.validez = validez;
    }
//</editor-fold>

}
