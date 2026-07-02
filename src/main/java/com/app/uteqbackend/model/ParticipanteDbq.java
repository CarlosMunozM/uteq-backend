package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "wp_participantes_dbq")
public class ParticipanteDbq implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_partc")
    private int pdbqCodigo;
    
    @Column(name = "dni", nullable = false, length = 10)
    private String pdbqDni;
    
    @Column(name = "nombres", nullable = false, length = 200)
    private String pdbqNombres;
    
    @Column(name = "telefono", nullable = false, length = 10)
    private String pdbqTelefono;
    
    @Column(name = "edad", nullable = false)
    private int pdbqEdad;
    
    @Column(name = "email", nullable = false, length = 50)
    private String pdbqEmail;
    
    @Column(name = "codigo_reg", nullable = false, length = 8)
    private String pdbqCodigoReq;
    
    @Column(name = "fecha_reg", nullable = true)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime pdbqFechaReg;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getPdbqCodigo() {
        return pdbqCodigo;
    }
    
    public void setPdbqCodigo(int pdbqCodigo) {
        this.pdbqCodigo = pdbqCodigo;
    }
    
    public String getPdbqDni() {
        return pdbqDni;
    }
    
    public void setPdbqDni(String pdbqDni) {
        this.pdbqDni = pdbqDni;
    }
    
    public String getPdbqNombres() {
        return pdbqNombres;
    }
    
    public void setPdbqNombres(String pdbqNombres) {
        this.pdbqNombres = pdbqNombres;
    }
    
    public String getPdbqTelefono() {
        return pdbqTelefono;
    }
    
    public void setPdbqTelefono(String pdbqTelefono) {
        this.pdbqTelefono = pdbqTelefono;
    }
    
    public int getPdbqEdad() {
        return pdbqEdad;
    }
    
    public void setPdbqEdad(int pdbqEdad) {
        this.pdbqEdad = pdbqEdad;
    }
    
    public String getPdbqEmail() {
        return pdbqEmail;
    }
    
    public void setPdbqEmail(String pdbqEmail) {
        this.pdbqEmail = pdbqEmail;
    }
    
    public String getPdbqCodigoReq() {
        return pdbqCodigoReq;
    }
    
    public void setPdbqCodigoReq(String pdbqCodigoReq) {
        this.pdbqCodigoReq = pdbqCodigoReq;
    }
    
    public LocalDateTime getPdbqFechaReg() {
        return pdbqFechaReg;
    }
    
    public void setPdbqFechaReg(LocalDateTime pdbqFechaReg) {
        this.pdbqFechaReg = pdbqFechaReg;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    public ParticipanteDbq() {
        super();
    }
    
    public ParticipanteDbq(int pdbqCodigo, String pdbqDni, String pdbqNombres, String pdbqTelefono, int pdbqEdad, String pdbqEmail, String pdbqCodigoReq, LocalDateTime pdbqFechaReg) {
        super();
        this.pdbqCodigo = pdbqCodigo;
        this.pdbqDni = pdbqDni;
        this.pdbqNombres = pdbqNombres;
        this.pdbqTelefono = pdbqTelefono;
        this.pdbqEdad = pdbqEdad;
        this.pdbqEmail = pdbqEmail;
        this.pdbqCodigoReq = pdbqCodigoReq;
        this.pdbqFechaReg = pdbqFechaReg;
    }
//</editor-fold>
    
}
