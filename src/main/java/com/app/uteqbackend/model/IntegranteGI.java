package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_grupo_invest_integ")
public class IntegranteGI implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_integrante")
    private int itCodigo;
    
    @ManyToOne
    @JoinColumn(name = "id_grupo")
    @JsonIgnoreProperties("giListadoIntgs")
    private GrupoInv itGrupoInv;
    
    @Column(name = "nombres", nullable = false)
    private String itNombres;
    
    @Column(name = "tipo_intg", nullable = false, columnDefinition = "CHAR(4) CHECK (tipo_intg IN ('DIRT','INTG'))")
    private String itTipoIntg;
    
    @Column(name = "correo_inst", nullable = false)
    private String itCorreoInst;
    
    @Column(name = "perfil_acad", nullable = true)
    private String itPerfilAcad;
    
    @Column(name = "url_foto", nullable = true)
    private String itUrlFoto;
    
    @Column(name = "estado", nullable = false, columnDefinition="INT CHECK(estado IN (0,1))")
    private int itEstado;
    
    public IntegranteGI() {
        super();
    }
    
    public IntegranteGI(int itCodigo, GrupoInv itGrupoInv, String itNombres, String itTipoIntg, String itCorreoInst, String itPerfilAcad, String itUrlFoto, int itEstado) {
        super();
        this.itCodigo = itCodigo;
        this.itGrupoInv = itGrupoInv;
        this.itNombres = itNombres;
        this.itTipoIntg = itTipoIntg;
        this.itCorreoInst = itCorreoInst;
        this.itPerfilAcad = itPerfilAcad;
        this.itUrlFoto = itUrlFoto;
        this.itEstado = itEstado;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getItCodigo() {
        return itCodigo;
    }
    
    public void setItCodigo(int itCodigo) {
        this.itCodigo = itCodigo;
    }
    
    public GrupoInv getItGrupoInv() {
        return itGrupoInv;
    }
    
    public void setItGrupoInv(GrupoInv itGrupoInv) {
        this.itGrupoInv = itGrupoInv;
    }
    
    public String getItNombres() {
        return itNombres;
    }
    
    public void setItNombres(String itNombres) {
        this.itNombres = itNombres;
    }
    
    public String getItTipoIntg() {
        return itTipoIntg;
    }
    
    public void setItTipoIntg(String itTipoIntg) {
        this.itTipoIntg = itTipoIntg;
    }
    
    public String getItCorreoInst() {
        return itCorreoInst;
    }
    
    public void setItCorreoInst(String itCorreoInst) {
        this.itCorreoInst = itCorreoInst;
    }
    
    public String getItPerfilAcad() {
        return itPerfilAcad;
    }
    
    public void setItPerfilAcad(String itPerfilAcad) {
        this.itPerfilAcad = itPerfilAcad;
    }
    
    public String getItUrlFoto() {
        return itUrlFoto;
    }
    
    public void setItUrlFoto(String itUrlFoto) {
        this.itUrlFoto = itUrlFoto;
    }
    
    public int getItEstado() {
        return itEstado;
    }
    
    public void setItEstado(int itEstado) {
        this.itEstado = itEstado;
    }
//</editor-fold>
    
}
