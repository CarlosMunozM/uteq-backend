package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_categoria_notc")
public class CategoriaNotc implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORS AND VARIABLES">
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private int gtCodigo;
    
    @Column(name = "titulo", nullable = false)
    private String gtTitular;
    
    @Column(name = "titulo_en", nullable = false)
    private String gtTitularEn;
    
    @Column(name = "titulo_pt", nullable = false)
    private String gtTitularPt;
    
    @Column(name = "descripcion", nullable = false)
    private String gtDescripcion;
    
    @Column(name = "descripcion_en", nullable = false)
    private String gtDescripcionEn;
    
    @Column(name = "descripcion_pt", nullable = false)
    private String gtDescripcionPt;
    
    @Column(name = "color", nullable = false)
    private String gtColorIdentf;
    
    @Column(name = "estado", nullable = false)
    private int gtEstado;
    
    @OneToMany(mappedBy = "objCategoriaNotc", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Noticia> gtListadoNoticias = new HashSet<Noticia>();
    
    public CategoriaNotc() {
        super();
    }
    
    public CategoriaNotc(int gtCodigo, String gtTitular, String gtDescripcion, String gtColorIdentf, int gtEstado) {
        super();
        this.gtCodigo = gtCodigo;
        this.gtTitular = gtTitular;
        this.gtDescripcion = gtDescripcion;
        this.gtColorIdentf = gtColorIdentf;
        this.gtEstado = gtEstado;
    }

    public CategoriaNotc(int gtCodigo, String gtTitular, String gtTitularEn, String gtTitularPt, String gtDescripcion, String gtDescripcionEn, String gtDescripcionPt, String gtColorIdentf, int gtEstado) {
        super();
        this.gtCodigo = gtCodigo;
        this.gtTitular = gtTitular;
        this.gtTitularEn = gtTitularEn;
        this.gtTitularPt = gtTitularPt;
        this.gtDescripcion = gtDescripcion;
        this.gtDescripcionEn = gtDescripcionEn;
        this.gtDescripcionPt = gtDescripcionPt;
        this.gtColorIdentf = gtColorIdentf;
        this.gtEstado = gtEstado;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getGtCodigo() {
        return gtCodigo;
    }
    
    public void setGtCodigo(int gtCodigo) {
        this.gtCodigo = gtCodigo;
    }
    
    public String getGtTitular() {
        return gtTitular!=null?gtTitular.trim():null;
    }
    
    public void setGtTitular(String gtTitular) {
        this.gtTitular = gtTitular!=null?gtTitular.trim():null;
    }
    
    public String getGtDescripcion() {
        return gtDescripcion;
    }
    
    public void setGtDescripcion(String gtDescripcion) {
        this.gtDescripcion = gtDescripcion;
    }
    
    public String getGtColorIdentf() {
        return gtColorIdentf;
    }
    
    public void setGtColorIdentf(String gtColorIdentf) {
        this.gtColorIdentf = gtColorIdentf;
    }
    
    public int getGtEstado() {
        return gtEstado;
    }
    
    public void setGtEstado(int gtEstado) {
        this.gtEstado = gtEstado;
    }
    
    public Set<Noticia> getGtListadoNoticias() {
        return gtListadoNoticias;
    }
    
    public void setGtListadoNoticias(Set<Noticia> gtListadoNoticias) {
        this.gtListadoNoticias = gtListadoNoticias;
    }

    public String getGtTitularEn() {
        return gtTitularEn != null ? gtTitularEn.trim() : null;
    }

    public void setGtTitularEn(String gtTitularEn) {
        this.gtTitularEn = gtTitularEn != null ? gtTitularEn.trim() : null;
    }

    public String getGtTitularPt() {
        return gtTitularPt != null ? gtTitularPt.trim() : null;
    }

    public void setGtTitularPt(String gtTitularPt) {
        this.gtTitularPt = gtTitularPt != null ? gtTitularPt.trim() : null;
    }

    public String getGtDescripcionEn() {
        return gtDescripcionEn;
    }

    public void setGtDescripcionEn(String gtDescripcionEn) {
        this.gtDescripcionEn = gtDescripcionEn;
    }

    public String getGtDescripcionPt() {
        return gtDescripcionPt;
    }

    public void setGtDescripcionPt(String gtDescripcionPt) {
        this.gtDescripcionPt = gtDescripcionPt;
    }
    
//</editor-fold>

}
