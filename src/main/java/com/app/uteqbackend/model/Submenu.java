package com.app.uteqbackend.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Data
@Entity
@Table(name="wp_submenu")
public class Submenu implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_submenu", nullable=false)
    private int smCodigo;
    
    @Column(name="id_menu", nullable=false)
    private int smCodMenu;
    
    @Column(name="tipo_nodo", nullable=true)
    private Integer smTipoNodo;
    
    @Column(name="id_padre", nullable=true, columnDefinition = "INT CHECK(id_padre<>id_submenu)")
    private Integer smCodPadre;
    
    @Column(name="nombre", nullable=false, length = 200)
    private String smNombre;
    
    @Column(name="url_asociada", nullable=false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String smUrlAsoc;
    
    @Column(name="orden", nullable=false)
    private int smOrden;
    
    @Column(name="estado", nullable=false, columnDefinition = "INT CHECK(estado IN (0,1))")
    private int smEstado;
    
    @Column(name="icono", nullable=true, length = 100)
    private String smIcono;
    
    @Column(name="nombre_en", nullable=false, length = 200)
    private String smNombreEn;
    
    @Column(name="nombre_pt", nullable=false, length = 200)
    private String smNombrePt;
    
    @Column(name="url_asociada_en", nullable=false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String smUrlAsocEn;
    
    @Column(name="url_asociada_pt", nullable=false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String smUrlAsocPt;
    
    public Submenu() {
        super();
    }
    
    public Submenu(String smNombre, String smUrlAsoc) {
        super();
        this.smNombre = smNombre;
        this.smUrlAsoc = smUrlAsoc;
    }
    
    public Submenu(int smCodigo, int smCodMenu, Integer smTipoNodo, Integer smCodPadre, String smNombre, String smUrlAsoc, int smOrden, int smEstado) {
        super();
        this.smCodigo = smCodigo;
        this.smCodMenu = smCodMenu;
        this.smTipoNodo = smTipoNodo;
        this.smCodPadre = smCodPadre;
        this.smNombre = smNombre;
        this.smUrlAsoc = smUrlAsoc;
        this.smOrden = smOrden;
        this.smEstado = smEstado;
    }
    
    public Submenu(int smCodigo, int smCodMenu, Integer smTipoNodo, Integer smCodPadre, String smNombre, String smUrlAsoc, int smOrden, int smEstado, String smIcono) {
        super();
        this.smCodigo = smCodigo;
        this.smCodMenu = smCodMenu;
        this.smTipoNodo = smTipoNodo;
        this.smCodPadre = smCodPadre;
        this.smNombre = smNombre;
        this.smUrlAsoc = smUrlAsoc;
        this.smOrden = smOrden;
        this.smEstado = smEstado;
        this.smIcono = smIcono;
    }

    public Submenu(String smNombre, String smUrlAsoc, String smNombreEn, String smNombrePt) {
        super();
        this.smNombre = smNombre;
        this.smUrlAsoc = smUrlAsoc;
        this.smNombreEn = smNombreEn;
        this.smNombrePt = smNombrePt;
    }

    public Submenu(String smNombre, String smUrlAsoc, String smNombreEn, String smNombrePt, String smUrlAsocEn, String smUrlAsocPt) {
        super();
        this.smNombre = smNombre;
        this.smUrlAsoc = smUrlAsoc;
        this.smNombreEn = smNombreEn;
        this.smNombrePt = smNombrePt;
        this.smUrlAsocEn = smUrlAsocEn;
        this.smUrlAsocPt = smUrlAsocPt;
    }

    public Submenu(int smCodigo, int smCodMenu, Integer smTipoNodo, Integer smCodPadre, String smNombre, String smUrlAsoc, int smOrden, int smEstado, String smIcono, String smNombreEn, String smNombrePt, String smUrlAsocEn, String smUrlAsocPt) {
        super();
        this.smCodigo = smCodigo;
        this.smCodMenu = smCodMenu;
        this.smTipoNodo = smTipoNodo;
        this.smCodPadre = smCodPadre;
        this.smNombre = smNombre;
        this.smUrlAsoc = smUrlAsoc;
        this.smOrden = smOrden;
        this.smEstado = smEstado;
        this.smIcono = smIcono;
        this.smNombreEn = smNombreEn;
        this.smNombrePt = smNombrePt;
        this.smUrlAsocEn = smUrlAsocEn;
        this.smUrlAsocPt = smUrlAsocPt;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getSmCodigo() {
        return smCodigo;
    }
    
    public void setSmCodigo(int smCodigo) {
        this.smCodigo = smCodigo;
    }
    
    public int getSmCodMenu() {
        return smCodMenu;
    }
    
    public void setSmCodMenu(int smCodMenu) {
        this.smCodMenu = smCodMenu;
    }
    
    public Integer getSmTipoNodo() {
        return smTipoNodo;
    }
    
    public void setSmTipoNodo(Integer smTipoNodo) {
        this.smTipoNodo = smTipoNodo;
    }
    
    public Integer getSmCodPadre() {
        return smCodPadre;
    }
    
    public void setSmCodPadre(Integer smCodPadre) {
        this.smCodPadre = smCodPadre;
    }
    
    public String getSmNombre() {
        return smNombre;
    }
    
    public void setSmNombre(String smNombre) {
        this.smNombre = smNombre;
    }
    
    public String getSmUrlAsoc() {
        return smUrlAsoc;
    }
    
    public void setSmUrlAsoc(String smUrlAsoc) {
        this.smUrlAsoc = smUrlAsoc;
    }
    
    public int getSmOrden() {
        return smOrden;
    }
    
    public void setSmOrden(int smOrden) {
        this.smOrden = smOrden;
    }
    
    public int getSmEstado() {
        return smEstado;
    }
    
    public void setSmEstado(int smEstado) {
        this.smEstado = smEstado;
    }
    
    public String getSmIcono() {
        return smIcono;
    }
    
    public void setSmIcono(String smIcono) {
        this.smIcono = smIcono;
    }

    public String getSmNombreEn() {
        return smNombreEn;
    }

    public void setSmNombreEn(String smNombreEn) {
        this.smNombreEn = smNombreEn;
    }

    public String getSmNombrePt() {
        return smNombrePt;
    }

    public void setSmNombrePt(String smNombrePt) {
        this.smNombrePt = smNombrePt;
    }

    public String getSmUrlAsocEn() {
        return smUrlAsocEn;
    }

    public void setSmUrlAsocEn(String smUrlAsocEn) {
        this.smUrlAsocEn = smUrlAsocEn;
    }

    public String getSmUrlAsocPt() {
        return smUrlAsocPt;
    }

    public void setSmUrlAsocPt(String smUrlAsocPt) {
        this.smUrlAsocPt = smUrlAsocPt;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public String toString() {
        return "Submenu{" + "smCodigo=" + smCodigo + ", smCodMenu=" + smCodMenu + ", smTipoNodo=" + smTipoNodo + ", smCodPadre=" + smCodPadre + ", smNombre=" + smNombre + ", smUrlAsoc=" + smUrlAsoc + ", smOrden=" + smOrden + ", smEstado=" + smEstado + ", smIcono=" + smIcono + '}';
    }
//</editor-fold>
    
}
