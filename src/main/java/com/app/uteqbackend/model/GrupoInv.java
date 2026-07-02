package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_grupo_invest")
public class GrupoInv implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Id
    @Column(name = "id_grupo", nullable = false, updatable = false)
    private UUID giCodigo;
    
    @ManyToOne
    @JoinColumn(name = "id_facultad")
    @JsonIgnoreProperties("dpListadoGruposInv")
    private Departamento giFacultad;
    
    @Column(name = "nombre", nullable = false)
    private String giNombre;
    
    @Column(name = "nombre_en", nullable = false)
    private String giNombreEn;
    
    @Column(name = "nombre_pt", nullable = false)
    private String giNombrePt;
    
    @Column(name = "mision", nullable = true)
    private String giMision;
    
    @Column(name = "mision_en", nullable = true)
    private String giMisionEn;
    
    @Column(name = "mision_pt", nullable = true)
    private String giMisionPt;
    
    @Column(name = "vision", nullable = true)
    private String giVision;
    
    @Column(name = "objetivos", nullable = true)
    private String giObjetivos;
    
    @Column(name = "objetivos_en", nullable = true)
    private String giObjetivosEn;
    
    @Column(name = "objetivos_pt", nullable = true)
    private String giObjetivosPt;
    
    @Column(name = "descripcion", nullable = true)
    private String giDescripcion;
    
    @Column(name = "img_banner", nullable = true)
    private String giUrlBanner;
    
    @Column(name = "url_parcial", nullable = false)
    private String giUrlParcial;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK (estado IN (0,1))")
    private int giEstado;
    
    @OneToMany(mappedBy = "itGrupoInv", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<IntegranteGI> giListadoIntgs = new HashSet<IntegranteGI>();
    
    public GrupoInv() {
        super();
    }

    public GrupoInv(String giNombre, String giNombreEn, String giNombrePt) {
        super();
        this.giNombre = giNombre;
        this.giNombreEn = giNombreEn;
        this.giNombrePt = giNombrePt;
    }
    
    public GrupoInv(String giUrlParcial) {
        super();
        this.giUrlParcial = giUrlParcial;
    }
    
    public GrupoInv(UUID giCodigo, Departamento giFacultad, String giNombre, String giMision, String giVision, String giObjetivos, String giDescripcion, String giUrlBanner, String giUrlParcial, int giEstado) {
        super();
        this.giCodigo = giCodigo;
        this.giFacultad = giFacultad;
        this.giNombre = giNombre;
        this.giMision = giMision;
        this.giVision = giVision;
        this.giObjetivos = giObjetivos;
        this.giDescripcion = giDescripcion;
        this.giUrlBanner = giUrlBanner;
        this.giUrlParcial = giUrlParcial;
        this.giEstado = giEstado;
    }

    public GrupoInv(String giNombre, String giUrlParcial) {
        super();
        this.giNombre = giNombre;
        this.giUrlParcial = giUrlParcial;
    }

    public GrupoInv(String giNombre, String giNombreEn, String giNombrePt, String giUrlParcial) {
        super();
        this.giNombre = giNombre;
        this.giNombreEn = giNombreEn;
        this.giNombrePt = giNombrePt;
        this.giUrlParcial = giUrlParcial;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public UUID getGiCodigo() {
        return giCodigo;
    }
    
    public void setGiCodigo(UUID giCodigo) {
        this.giCodigo = giCodigo;
    }
    
    public Departamento getGiFacultad() {
        return giFacultad;
    }
    
    public void setGiFacultad(Departamento giFacultad) {
        this.giFacultad = giFacultad;
    }
    
    public String getGiNombre() {
        return giNombre;
    }
    
    public void setGiNombre(String giNombre) {
        this.giNombre = giNombre;
    }
    
    public String getGiMision() {
        return giMision;
    }
    
    public void setGiMision(String giMision) {
        this.giMision = giMision;
    }
    
    public String getGiVision() {
        return giVision;
    }
    
    public void setGiVision(String giVision) {
        this.giVision = giVision;
    }
    
    public String getGiObjetivos() {
        return giObjetivos;
    }
    
    public void setGiObjetivos(String giObjetivos) {
        this.giObjetivos = giObjetivos;
    }
    
    public String getGiDescripcion() {
        return giDescripcion;
    }
    
    public void setGiDescripcion(String giDescripcion) {
        this.giDescripcion = giDescripcion;
    }
    
    public String getGiUrlBanner() {
        return giUrlBanner;
    }
    
    public void setGiUrlBanner(String giUrlBanner) {
        this.giUrlBanner = giUrlBanner;
    }
    
    public String getGiUrlParcial() {
        return giUrlParcial;
    }
    
    public void setGiUrlParcial(String giUrlParcial) {
        this.giUrlParcial = giUrlParcial;
    }
    
    public int getGiEstado() {
        return giEstado;
    }
    
    public void setGiEstado(int giEstado) {
        this.giEstado = giEstado;
    }
    
    public Set<IntegranteGI> getGiListadoIntgs() {
        return giListadoIntgs;
    }
    
    public void setGiListadoIntgs(Set<IntegranteGI> giListadoIntgs) {
        this.giListadoIntgs = giListadoIntgs;
    }
    
    public String getGiNombreEn() {
        return giNombreEn;
    }

    public void setGiNombreEn(String giNombreEn) {
        this.giNombreEn = giNombreEn;
    }

    public String getGiNombrePt() {
        return giNombrePt;
    }

    public void setGiNombrePt(String giNombrePt) {
        this.giNombrePt = giNombrePt;
    }

    public String getGiMisionEn() {
        return giMisionEn;
    }

    public void setGiMisionEn(String giMisionEn) {
        this.giMisionEn = giMisionEn;
    }

    public String getGiMisionPt() {
        return giMisionPt;
    }

    public void setGiMisionPt(String giMisionPt) {
        this.giMisionPt = giMisionPt;
    }

    public String getGiObjetivosEn() {
        return giObjetivosEn;
    }

    public void setGiObjetivosEn(String giObjetivosEn) {
        this.giObjetivosEn = giObjetivosEn;
    }

    public String getGiObjetivosPt() {
        return giObjetivosPt;
    }

    public void setGiObjetivosPt(String giObjetivosPt) {
        this.giObjetivosPt = giObjetivosPt;
    }
    
//</editor-fold>

}
