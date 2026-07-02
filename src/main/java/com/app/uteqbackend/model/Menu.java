package com.app.uteqbackend.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_menu")
public class Menu implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private int mnCodigo;
    
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id_entidad", nullable = false, updatable = false)
    private UUID mnCodDepart;

    @Column(name = "nombre", nullable = false, length = 200)
    private String mnNombre;

    @Column(name = "tipo_menu", nullable = false, length = 7, columnDefinition = "CHAR(7) CHECK (tipo_menu IN ('MN_PRIM','MN_SEGD','MN_TERC','MN_PIEP','MN_LATL'))")
    private String mnTpMenu;

    @Column(name = "url_asociada", nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) default '#'")
    private String mnUrlAsoc;

    @Column(name = "orden", nullable = false)
    private int mnOrden;

    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK (estado IN (0,1))")
    private int mnEstado;
    
    @Column(name = "icono", nullable = true, length = 100)
    private String mnIcono;

    @ElementCollection
    @CollectionTable(name = "wp_submenu", joinColumns = @JoinColumn(name = "id_menu"))
    private List<Submenu> mnListadoSubmenus;
    
    @Column(name = "nombre_en", nullable = false, length = 200)
    private String mnNombreEn;
    
    @Column(name = "nombre_pt", nullable = false, length = 200)
    private String mnNombrePt;
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructors, gets/sets and method toString">
    public Menu() {
        super();
    }

    public Menu(String mnNombre, String mnUrlAsoc) {
        super();
        this.mnNombre = mnNombre;
        this.mnUrlAsoc = mnUrlAsoc;
    }

    public Menu(int mnCodigo, /*String*/ UUID mnCodDepart, String mnNombre, String mnTpMenu, String mnUrlAsoc, int mnOrden, int mnEstado) {
        super();
        this.mnCodigo = mnCodigo;
        this.mnCodDepart = mnCodDepart;
        this.mnNombre = mnNombre;
        this.mnTpMenu = mnTpMenu;
        this.mnUrlAsoc = mnUrlAsoc;
        this.mnOrden = mnOrden;
        this.mnEstado = mnEstado;
    }

    public Menu(int mnCodigo, /*String*/ UUID mnCodDepart, String mnNombre, String mnTpMenu, String mnUrlAsoc, int mnOrden, int mnEstado, List<Submenu> mnListadoSubmenus) {
        super();
        this.mnCodigo = mnCodigo;
        this.mnCodDepart = mnCodDepart;
        this.mnNombre = mnNombre;
        this.mnTpMenu = mnTpMenu;
        this.mnUrlAsoc = mnUrlAsoc;
        this.mnOrden = mnOrden;
        this.mnEstado = mnEstado;
        this.mnListadoSubmenus = mnListadoSubmenus;
    }

    public Menu(int mnCodigo, /*String*/ UUID mnCodDepart, String mnNombre, String mnTpMenu, String mnUrlAsoc, int mnOrden, int mnEstado, String mnIcono, List<Submenu> mnListadoSubmenus) {
        super();
        this.mnCodigo = mnCodigo;
        this.mnCodDepart = mnCodDepart;
        this.mnNombre = mnNombre;
        this.mnTpMenu = mnTpMenu;
        this.mnUrlAsoc = mnUrlAsoc;
        this.mnOrden = mnOrden;
        this.mnEstado = mnEstado;
        this.mnIcono = mnIcono;
        this.mnListadoSubmenus = mnListadoSubmenus;
    }

    public Menu(int mnCodigo, UUID mnCodDepart, String mnNombre, String mnTpMenu, String mnUrlAsoc, int mnOrden, int mnEstado, String mnIcono) {
        super();
        this.mnCodigo = mnCodigo;
        this.mnCodDepart = mnCodDepart;
        this.mnNombre = mnNombre;
        this.mnTpMenu = mnTpMenu;
        this.mnUrlAsoc = mnUrlAsoc;
        this.mnOrden = mnOrden;
        this.mnEstado = mnEstado;
        this.mnIcono = mnIcono;
    }

    public Menu(String mnNombre, String mnUrlAsoc, String mnNombreEn, String mnNombrePt) {
        super();
        this.mnNombre = mnNombre;
        this.mnUrlAsoc = mnUrlAsoc;
        this.mnNombreEn = mnNombreEn;
        this.mnNombrePt = mnNombrePt;
    }

    public int getMnCodigo() {
        return mnCodigo;
    }

    public void setMnCodigo(int mnCodigo) {
        this.mnCodigo = mnCodigo;
    }

    public /*String*/ UUID getMnCodDepart() {
        return mnCodDepart;
    }

    public void setMnCodDepart(/*String*/ UUID mnCodDepart) {
        this.mnCodDepart = mnCodDepart;
    }

    public String getMnNombre() {
        return mnNombre;
    }

    public void setMnNombre(String mnNombre) {
        this.mnNombre = mnNombre;
    }

    public String getMnTpMenu() {
        return mnTpMenu;
    }

    public void setMnTpMenu(String mnTpMenu) {
        this.mnTpMenu = mnTpMenu;
    }

    public String getMnUrlAsoc() {
        return mnUrlAsoc;
    }

    public void setMnUrlAsoc(String mnUrlAsoc) {
        this.mnUrlAsoc = mnUrlAsoc;
    }

    public int getMnOrden() {
        return mnOrden;
    }

    public void setMnOrden(int mnOrden) {
        this.mnOrden = mnOrden;
    }

    public int getMnEstado() {
        return mnEstado;
    }

    public void setMnEstado(int mnEstado) {
        this.mnEstado = mnEstado;
    }
    
    public String getMnIcono() {
        return mnIcono;
    }

    public void setMnIcono(String mnIcono) {
        this.mnIcono = mnIcono;
    }

    public List<Submenu> getMnListadoSubmenus() {
        return mnListadoSubmenus;
    }

    public void setMnListadoSubmenus(List<Submenu> mnListadoSubmenus) {
        this.mnListadoSubmenus = mnListadoSubmenus;
    }

    @Override
    public String toString() {
        return "MdMenu{" + "mnCodigo=" + mnCodigo + ", mnCodDepart=" + mnCodDepart + ", mnNombre=" + mnNombre + ", mnTpMenu=" + mnTpMenu + ", mnUrlAsoc=" + mnUrlAsoc + ", mnOrden=" + mnOrden + ", mnEstado=" + mnEstado + '}';
    }
    
    public String getMnNombreEn() {
        return mnNombreEn;
    }

    public void setMnNombreEn(String mnNombreEn) {
        this.mnNombreEn = mnNombreEn;
    }

    public String getMnNombrePt() {
        return mnNombrePt;
    }

    public void setMnNombrePt(String mnNombrePt) {
        this.mnNombrePt = mnNombrePt;
    }
    
//</editor-fold>


}
