package com.app.uteqbackend.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_banco_talento")
public class BancoTalento implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_talento")
    private int btCodigo;
    
    @Column(name="num_dni", nullable=false, columnDefinition = "CHAR(10) CHECK(num_dni ~ '^[0-9]*$')")
    private String btNumDni;
    
    @Column(name="nombre_comp", nullable=false, length = 250)
    private String btNombreComp;
    
    @Column(name="id_exper_lab", nullable=false)
    private int btCodExpLab;
    
    @Column(name="exper_lab", nullable=false, length = 300)
    private String btExpLab;
    
    @Column(name="id_campo_prof", nullable=false)
    private int btCodCampoProf;
    
    @Column(name="campo_prof", nullable=false, length = 300)
    private String btCampoProf;
    
    @Column(name="id_form_profs", nullable=false)
    private int btCodFormProf;
    
    @Column(name="form_profs", nullable=false, length = 300)
    private String btFormProf;
    
    @Column(name="publicaciones", nullable=true, length = 2000)
    private String btPublicaciones;
    
    @Lob
    @Column(name = "pdf_hoja_vida", nullable = false)
    private byte[] btArchvHV;
    
    @Column(name="nombre_pdf_hv", nullable=false, length = 300)
    private String btNombrePdfHV;
    
    @Column(name = "fecha_reg", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date btFechaReg;
    
    public BancoTalento() {
        super();
    }
    
    public BancoTalento(int btCodigo, String btNumDni, String btNombreComp, int btCodExpLab, String btExpLab, int btCodCampoProf, String btCampoProf, int btCodFormProf, String btFormProf, String btPublicaciones, byte[] btArchvHV, String btNombrePdfHV, Date btFechaReg) {
        super();
        this.btCodigo = btCodigo;
        this.btNumDni = btNumDni;
        this.btNombreComp = btNombreComp;
        this.btCodExpLab = btCodExpLab;
        this.btExpLab = btExpLab;
        this.btCodCampoProf = btCodCampoProf;
        this.btCampoProf = btCampoProf;
        this.btCodFormProf = btCodFormProf;
        this.btFormProf = btFormProf;
        this.btPublicaciones = btPublicaciones;
        this.btArchvHV = btArchvHV;
        this.btNombrePdfHV = btNombrePdfHV;
        this.btFechaReg = btFechaReg;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getBtCodigo() {
        return btCodigo;
    }
    
    public void setBtCodigo(int btCodigo) {
        this.btCodigo = btCodigo;
    }
    
    public String getBtNumDni() {
        return btNumDni;
    }
    
    public void setBtNumDni(String btNumDni) {
        this.btNumDni = btNumDni;
    }
    
    public String getBtNombreComp() {
        return btNombreComp;
    }
    
    public void setBtNombreComp(String btNombreComp) {
        this.btNombreComp = btNombreComp;
    }
    
    public int getBtCodExpLab() {
        return btCodExpLab;
    }
    
    public void setBtCodExpLab(int btCodExpLab) {
        this.btCodExpLab = btCodExpLab;
    }
    
    public String getBtExpLab() {
        return btExpLab;
    }
    
    public void setBtExpLab(String btExpLab) {
        this.btExpLab = btExpLab;
    }
    
    public int getBtCodCampoProf() {
        return btCodCampoProf;
    }
    
    public void setBtCodCampoProf(int btCodCampoProf) {
        this.btCodCampoProf = btCodCampoProf;
    }
    
    public String getBtCampoProf() {
        return btCampoProf;
    }
    
    public void setBtCampoProf(String btCampoProf) {
        this.btCampoProf = btCampoProf;
    }
    
    public int getBtCodFormProf() {
        return btCodFormProf;
    }
    
    public void setBtCodFormProf(int btCodFormProf) {
        this.btCodFormProf = btCodFormProf;
    }
    
    public String getBtFormProf() {
        return btFormProf;
    }
    
    public void setBtFormProf(String btFormProf) {
        this.btFormProf = btFormProf;
    }
    
    public String getBtPublicaciones() {
        return btPublicaciones;
    }
    
    public void setBtPublicaciones(String btPublicaciones) {
        this.btPublicaciones = btPublicaciones;
    }
    
    public byte[] getBtArchvHV() {
        return btArchvHV;
    }
    
    public void setBtArchvHV(byte[] btArchvHV) {
        this.btArchvHV = btArchvHV;
    }
    
    public String getBtNombrePdfHV() {
        return btNombrePdfHV;
    }
    
    public void setBtNombrePdfHV(String btNombrePdfHV) {
        this.btNombrePdfHV = btNombrePdfHV;
    }
    
    public Date getBtFechaReg() {
        return btFechaReg;
    }
    
    public void setBtFechaReg(Date btFechaReg) {
        this.btFechaReg = btFechaReg;
    }
//</editor-fold>
    
}
