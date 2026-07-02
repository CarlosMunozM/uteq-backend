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
@Table(name = "wp_titulo_acad")
public class TituloAcad implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_titulo")
    private int taCodigo;
    
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id_autoridad", nullable = false, updatable = false)
    private UUID taCodAutord;
    
    @Column(name = "descripcion", nullable = false, length = 400)
    private String taDescripcion;
    
    @Column(name = "titulo_rec", nullable = false, length = 300)
    private String taTituloRec;
    
    @Column(name = "inst_supr", nullable = false, length = 400)
    private String taInstitucionSup;
    
    @Column(name = "tipo_inst", nullable = false, length = 3, columnDefinition = "CHAR(3) CHECK(tipo_inst IN ('NAC','INT'))")
    private String taTipoInst;
    
    @Column(name = "anio_grad", nullable = true, columnDefinition = "INT CHECK(anio_grad>1940 AND anio_grad<=CAST(date_part('year', CURRENT_DATE) AS INT))")
    private int taAnioGrad;
    
    @Column(name = "abreviatura", nullable = false, length = 10)
    private String taAbreviatura;
    
    @Column(name = "nivel", nullable = false)
    private int taNivel;
    
    @Column(name = "titulo_rec_en", nullable = false, length = 300)
    private String taTituloRecEn;
    
    @Column(name = "titulo_rec_pt", nullable = false, length = 300)
    private String taTituloRecPt;
    
    
    public TituloAcad() {
        super();
    }
    
    public TituloAcad(int taCodigo, UUID taCodAutord, String taDescripcion, String taTituloRec, String taInstitucionSup, String taTipoInst, int taAnioGrad, String taAbreviatura, int taNivel) {
        super();
        this.taCodigo = taCodigo;
        this.taCodAutord=taCodAutord;
        this.taDescripcion = taDescripcion;
        this.taTituloRec = taTituloRec;
        this.taInstitucionSup = taInstitucionSup;
        this.taTipoInst = taTipoInst;
        this.taAnioGrad = taAnioGrad;
        this.taAbreviatura = taAbreviatura;
        this.taNivel = taNivel;
    }
    
    public TituloAcad(UUID taCodAutord, String taDescripcion, String taTituloRec, String taInstitucionSup, String taTipoInst, int taAnioGrad, String taAbreviatura, int taNivel) {
        super();
        this.taCodAutord = taCodAutord;
        this.taDescripcion = taDescripcion;
        this.taTituloRec = taTituloRec;
        this.taInstitucionSup = taInstitucionSup;
        this.taTipoInst = taTipoInst;
        this.taAnioGrad = taAnioGrad;
        this.taAbreviatura = taAbreviatura;
        this.taNivel = taNivel;
    }
    
    public TituloAcad(String taDescripcion, String taTituloRec, String taInstitucionSup, String taTipoInst, int taAnioGrad, String taAbreviatura, int taNivel) {
        super();
        this.taDescripcion = taDescripcion;
        this.taTituloRec = taTituloRec;
        this.taInstitucionSup = taInstitucionSup;
        this.taTipoInst = taTipoInst;
        this.taAnioGrad = taAnioGrad;
        this.taAbreviatura = taAbreviatura;
        this.taNivel = taNivel;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getTaCodigo() {
        return taCodigo;
    }
    
    public void setTaCodigo(int taCodigo) {
        this.taCodigo = taCodigo;
    }
    
    public UUID getTaCodAutord() {
        return taCodAutord;
    }
    
    public void setTaCodAutord(UUID taCodAutord) {
        this.taCodAutord = taCodAutord;
    }
    
    public String getTaDescripcion() {
        return taDescripcion;
    }
    
    public void setTaDescripcion(String taDescripcion) {
        this.taDescripcion = taDescripcion;
    }
    
    public String getTaTituloRec() {
        return taTituloRec;
    }
    
    public void setTaTituloRec(String taTituloRec) {
        this.taTituloRec = taTituloRec;
    }
    
    public String getTaInstitucionSup() {
        return taInstitucionSup;
    }
    
    public void setTaInstitucionSup(String taInstitucionSup) {
        this.taInstitucionSup = taInstitucionSup;
    }
    
    public String getTaTipoInst() {
        return taTipoInst;
    }
    
    public void setTaTipoInst(String taTipoInst) {
        this.taTipoInst = taTipoInst;
    }
    
    public int getTaAnioGrad() {
        return taAnioGrad;
    }
    
    public void setTaAnioGrad(int taAnioGrad) {
        this.taAnioGrad = taAnioGrad;
    }
    
    public String getTaAbreviatura() {
        return taAbreviatura;
    }
    
    public void setTaAbreviatura(String taAbreviatura) {
        this.taAbreviatura = taAbreviatura;
    }
    
    public int getTaNivel() {
        return taNivel;
    }
    
    public void setTaNivel(int taNivel) {
        this.taNivel = taNivel;
    }
    
    public String getTaTituloRecEn() {
        return taTituloRecEn;
    }

    public void setTaTituloRecEn(String taTituloRecEn) {
        this.taTituloRecEn = taTituloRecEn;
    }

    public String getTaTituloRecPt() {
        return taTituloRecPt;
    }

    public void setTaTituloRecPt(String taTituloRecPt) {
        this.taTituloRecPt = taTituloRecPt;
    }
    
//</editor-fold>

}
