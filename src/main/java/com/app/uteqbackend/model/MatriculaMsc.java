package com.app.uteqbackend.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;
import org.hibernate.annotations.Type;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Data
@Entity
@Table(name = "wp_matricula_msc")
public class MatriculaMsc {
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private int mtCodigo;
    
    @Column(name = "fecha_reg", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mtFechaReg;
    
    @Column(name="dni", nullable=false, length = 20)
    private String mtCodgDNI;
    
    @Column(name="nombre_comp", nullable=false, length = 200)
    private String mtNombreComp;
    
    @Column(name="correo_elect", nullable=false, length = 200)
    private String mtCorreoElect;
    
    @Column(name="telefono", nullable=false, length = 25)
    private String mtTelefono;
    
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id_maestria", nullable = false, updatable = false)
    private UUID mtCodMaestria;
    
    @Column(name = "url_brochure_msc", nullable = true, length = 1000)
    private String mtUrlBrochure;
    
    @Lob
    @Column(name = "pdf_dni", nullable = false)
    private byte[] mtPdfDni;
    
    @Column(name = "nombre_dni", nullable = false)
    private String mtNombreDni;
    
    @Lob
    @Column(name = "pdf_rgt", nullable = false)
    private byte[] mtPdfRgt;
    
    @Column(name = "nombre_rgt", nullable = false)
    private String mtNombreRgt;
    
    @Lob
    @Column(name = "pdf_ttn", nullable = true)
    private byte[] mtPdfTtn;
    
    @Column(name = "nombre_ttn", nullable = true)
    private String mtNombreTtn;
    
    @Lob
    @Column(name = "pdf_agd", nullable = true)
    private byte[] mtPdfAgd;
    
    @Column(name = "nombre_agd", nullable = true)
    private String mtNombreAgd;
    
    @Lob
    @Column(name = "pdf_rac", nullable = true)
    private byte[] mtPdfRac;
    
    @Column(name = "nombre_rac", nullable = true)
    private String mtNombreRac;
    
    @Lob
    @Column(name = "pdf_rlb", nullable = true)
    private byte[] mtPdfRlb;
    
    @Column(name = "nombre_rlb", nullable = true)
    private String mtNombreRlb;
    
    @Lob
    @Column(name = "pdf_cmt", nullable = true)
    private byte[] mtPdfCmt;
    
    @Column(name = "nombre_cmt", nullable = true)
    private String mtNombreCmt;
    
    @Lob
    @Column(name = "pdf_atc", nullable = false)
    private byte[] mtPdfAtc;
    
    @Column(name = "nombre_atc", nullable = false)
    private String mtNombreAtc;
    
    public MatriculaMsc() {
        super();
    }
    
    public MatriculaMsc(int mtCodigo, Date mtFechaReg, String mtCodgDNI, String mtNombreComp, String mtCorreoElect, String mtTelefono, UUID mtCodMaestria, String mtUrlBrochure) {
        super();
        this.mtCodigo = mtCodigo;
        this.mtFechaReg = mtFechaReg;
        this.mtCodgDNI = mtCodgDNI;
        this.mtNombreComp = mtNombreComp;
        this.mtCorreoElect = mtCorreoElect;
        this.mtTelefono = mtTelefono;
        this.mtCodMaestria = mtCodMaestria;
        this.mtUrlBrochure = mtUrlBrochure;
    }
    
    public MatriculaMsc(int mtCodigo, Date mtFechaReg, String mtCodgDNI, String mtNombreComp, String mtCorreoElect, String mtTelefono, UUID mtCodMaestria, String mtUrlBrochure, byte[] mtPdfDni, String mtNombreDni, byte[] mtPdfRgt, String mtNombreRgt, byte[] mtPdfTtn, String mtNombreTtn, byte[] mtPdfAgd, String mtNombreAgd, byte[] mtPdfRac, String mtNombreRac, byte[] mtPdfRlb, String mtNombreRlb, byte[] mtPdfCmt, String mtNombreCmt, byte[] mtPdfAtc, String mtNombreAtc) {
        super();
        this.mtCodigo = mtCodigo;
        this.mtFechaReg = mtFechaReg;
        this.mtCodgDNI = mtCodgDNI;
        this.mtNombreComp = mtNombreComp;
        this.mtCorreoElect = mtCorreoElect;
        this.mtTelefono = mtTelefono;
        this.mtCodMaestria = mtCodMaestria;
        this.mtUrlBrochure = mtUrlBrochure;
        this.mtPdfDni = mtPdfDni;
        this.mtNombreDni = mtNombreDni;
        this.mtPdfRgt = mtPdfRgt;
        this.mtNombreRgt = mtNombreRgt;
        this.mtPdfTtn = mtPdfTtn;
        this.mtNombreTtn = mtNombreTtn;
        this.mtPdfAgd = mtPdfAgd;
        this.mtNombreAgd = mtNombreAgd;
        this.mtPdfRac = mtPdfRac;
        this.mtNombreRac = mtNombreRac;
        this.mtPdfRlb = mtPdfRlb;
        this.mtNombreRlb = mtNombreRlb;
        this.mtPdfCmt = mtPdfCmt;
        this.mtNombreCmt = mtNombreCmt;
        this.mtPdfAtc = mtPdfAtc;
        this.mtNombreAtc = mtNombreAtc;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getMtCodigo() {
        return mtCodigo;
    }
    
    public void setMtCodigo(int mtCodigo) {
        this.mtCodigo = mtCodigo;
    }
    
    public Date getMtFechaReg() {
        return mtFechaReg;
    }
    
    public void setMtFechaReg(Date mtFechaReg) {
        this.mtFechaReg = mtFechaReg;
    }
    
    public String getMtCodgDNI() {
        return mtCodgDNI;
    }
    
    public void setMtCodgDNI(String mtCodgDNI) {
        this.mtCodgDNI = mtCodgDNI;
    }
    
    public String getMtNombreComp() {
        return mtNombreComp;
    }
    
    public void setMtNombreComp(String mtNombreComp) {
        this.mtNombreComp = mtNombreComp;
    }
    
    public String getMtCorreoElect() {
        return mtCorreoElect;
    }
    
    public void setMtCorreoElect(String mtCorreoElect) {
        this.mtCorreoElect = mtCorreoElect;
    }
    
    public String getMtTelefono() {
        return mtTelefono;
    }
    
    public void setMtTelefono(String mtTelefono) {
        this.mtTelefono = mtTelefono;
    }
    
    public UUID getMtCodMaestria() {
        return mtCodMaestria;
    }
    
    public void setMtCodMaestria(UUID mtCodMaestria) {
        this.mtCodMaestria = mtCodMaestria;
    }
    
    public String getMtUrlBrochure() {
        return mtUrlBrochure;
    }
    
    public void setMtUrlBrochure(String mtUrlBrochure) {
        this.mtUrlBrochure = mtUrlBrochure;
    }
    
    public byte[] getMtPdfDni() {
        return mtPdfDni;
    }
    
    public void setMtPdfDni(byte[] mtPdfDni) {
        this.mtPdfDni = mtPdfDni;
    }
    
    public String getMtNombreDni() {
        return mtNombreDni;
    }
    
    public void setMtNombreDni(String mtNombreDni) {
        this.mtNombreDni = mtNombreDni;
    }
    
    public byte[] getMtPdfRgt() {
        return mtPdfRgt;
    }
    
    public void setMtPdfRgt(byte[] mtPdfRgt) {
        this.mtPdfRgt = mtPdfRgt;
    }
    
    public String getMtNombreRgt() {
        return mtNombreRgt;
    }
    
    public void setMtNombreRgt(String mtNombreRgt) {
        this.mtNombreRgt = mtNombreRgt;
    }
    
    public byte[] getMtPdfTtn() {
        return mtPdfTtn;
    }
    
    public void setMtPdfTtn(byte[] mtPdfTtn) {
        this.mtPdfTtn = mtPdfTtn;
    }
    
    public String getMtNombreTtn() {
        return mtNombreTtn;
    }
    
    public void setMtNombreTtn(String mtNombreTtn) {
        this.mtNombreTtn = mtNombreTtn;
    }
    
    public byte[] getMtPdfAgd() {
        return mtPdfAgd;
    }
    
    public void setMtPdfAgd(byte[] mtPdfAgd) {
        this.mtPdfAgd = mtPdfAgd;
    }
    
    public String getMtNombreAgd() {
        return mtNombreAgd;
    }
    
    public void setMtNombreAgd(String mtNombreAgd) {
        this.mtNombreAgd = mtNombreAgd;
    }
    
    public byte[] getMtPdfRac() {
        return mtPdfRac;
    }
    
    public void setMtPdfRac(byte[] mtPdfRac) {
        this.mtPdfRac = mtPdfRac;
    }
    
    public String getMtNombreRac() {
        return mtNombreRac;
    }
    
    public void setMtNombreRac(String mtNombreRac) {
        this.mtNombreRac = mtNombreRac;
    }
    
    public byte[] getMtPdfRlb() {
        return mtPdfRlb;
    }
    
    public void setMtPdfRlb(byte[] mtPdfRlb) {
        this.mtPdfRlb = mtPdfRlb;
    }
    
    public String getMtNombreRlb() {
        return mtNombreRlb;
    }
    
    public void setMtNombreRlb(String mtNombreRlb) {
        this.mtNombreRlb = mtNombreRlb;
    }
    
    public byte[] getMtPdfCmt() {
        return mtPdfCmt;
    }
    
    public void setMtPdfCmt(byte[] mtPdfCmt) {
        this.mtPdfCmt = mtPdfCmt;
    }
    
    public String getMtNombreCmt() {
        return mtNombreCmt;
    }
    
    public void setMtNombreCmt(String mtNombreCmt) {
        this.mtNombreCmt = mtNombreCmt;
    }
    
    public byte[] getMtPdfAtc() {
        return mtPdfAtc;
    }
    
    public void setMtPdfAtc(byte[] mtPdfAtc) {
        this.mtPdfAtc = mtPdfAtc;
    }
    
    public String getMtNombreAtc() {
        return mtNombreAtc;
    }
    
    public void setMtNombreAtc(String mtNombreAtc) {
        this.mtNombreAtc = mtNombreAtc;
    }
//</editor-fold>
    
}
