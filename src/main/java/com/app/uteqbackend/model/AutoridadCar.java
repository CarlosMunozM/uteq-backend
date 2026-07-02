package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Data
@Entity
@Table(name = "wp_autoridad_car")
public class AutoridadCar implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Id
    @Column(name = "id_autoridad", nullable = false, updatable = false)
    private UUID auCodigo;
    
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "id_carrera", insertable = false, updatable = false),
        @JoinColumn(name = "id_departamento", insertable = false, updatable = false)
    })
    @JsonIgnoreProperties("crListadoAutoridades")
    private Carrera auObjCarrera;
    
    @ManyToOne
    @JoinColumn(name = "id_cargo")
    @JsonIgnoreProperties("dpListadoAutoridades")
    private DatosMult auObjCargo;
    
    @ElementCollection
    @CollectionTable(name = "wp_titulo_acad", joinColumns = @JoinColumn(name = "id_autoridad"))
    private List<TituloAcad> auListadoTitulosAcad;
    
    @Column(name = "anio_inicio", nullable = false, columnDefinition = "INT CHECK(anio_inicio>1990)")
    private int auAnioInicio;
    
    @Column(name = "anio_fin", nullable = true, columnDefinition = "INT CHECK(anio_fin>1990)")
    private int auAnioFin;
    
    @Column(name = "nombres", nullable = false, length = 200)
    private String auNombres;
    
    @Column(name = "apellidos", nullable = false, length = 200)
    private String auApellidos;
    
    @Column(name = "genero", nullable = false, length = 1)
    private String auGenero;
    
    @Column(name = "direccion", nullable = true, length = 400)
    private String auDireccion;
    
    @Column(name = "telf_ofic", nullable = true, length = 10)
    private String auTelefono;
    
    @Column(name = "extension_telf", nullable = true, length = 15)
    private String auExtensTelf;
    
    @Column(name = "num_celular", nullable = true, length = 10)
    private String auNumCelular;
    
    @Column(name = "correo_elect", nullable = true, length = 150)
    private String auCorreoElect;
    
    @Column(name = "url_foto", nullable = true, length = 100)
    private String auUrlFoto;
    
    @Column(name = "idioma1", nullable = true, length = 100)
    private String auIdioma1;
    
    @Column(name = "idioma2", nullable = true, length = 100)
    private String auIdioma2;
    
    @Column(name = "idioma3", nullable = true, length = 100)
    private String auIdioma3;
    
    @Column(name = "url_pfl_acad", nullable = false, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String auUrlPerfilAcad;
    
    @Column(name = "target", nullable = true, columnDefinition = "CHAR(7) CHECK(target IN ('_blank','_self','_parent','_top'))")
    private String auTarget;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK (estado IN (0,1))")
    private int auEstado;
    
    @Column(name = "url_foto_alt", nullable = true, length = 100)
    private String auUrlFotoAlt;
    
    public AutoridadCar() {
        super();
    }
    
    public AutoridadCar(UUID auCodigo, Carrera auObjCarrera, DatosMult auObjCargo, List<TituloAcad> auListadoTitulosAcad, int auAnioInicio, int auAnioFin, String auNombres, String auApellidos, String auDireccion, String auTelefono, String auExtensTelf, String auNumCelular, String auCorreoElect, String auUrlFoto, String auIdioma1, String auIdioma2, String auIdioma3, String auUrlPerfilAcad, String auTarget, int auEstado, String auUrlFotoAlt) {
        super();
        this.auCodigo = auCodigo;
        this.auObjCarrera = auObjCarrera;
        this.auObjCargo = auObjCargo;
        this.auListadoTitulosAcad = auListadoTitulosAcad;
        this.auAnioInicio = auAnioInicio;
        this.auAnioFin = auAnioFin;
        this.auNombres = auNombres;
        this.auApellidos = auApellidos;
        this.auDireccion = auDireccion;
        this.auTelefono = auTelefono;
        this.auExtensTelf = auExtensTelf;
        this.auNumCelular = auNumCelular;
        this.auCorreoElect = auCorreoElect;
        this.auUrlFoto = auUrlFoto;
        this.auIdioma1 = auIdioma1;
        this.auIdioma2 = auIdioma2;
        this.auIdioma3 = auIdioma3;
        this.auUrlPerfilAcad = auUrlPerfilAcad;
        this.auTarget = auTarget;
        this.auEstado = auEstado;
        this.auUrlFotoAlt = auUrlFotoAlt;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public UUID getAuCodigo() {
        return auCodigo;
    }
    
    public void setAuCodigo(UUID auCodigo) {
        this.auCodigo = auCodigo;
    }
    
    public Carrera getAuObjCarrera() {
        return auObjCarrera;
    }
    
    public void setAuObjCarrera(Carrera auObjCarrera) {
        this.auObjCarrera = auObjCarrera;
    }
    
    public DatosMult getAuObjCargo() {
        return auObjCargo;
    }
    
    public void setAuObjCargo(DatosMult auObjCargo) {
        this.auObjCargo = auObjCargo;
    }
    
    public List<TituloAcad> getAuListadoTitulosAcad() {
        return auListadoTitulosAcad;
    }
    
    public void setAuListadoTitulosAcad(List<TituloAcad> auListadoTitulosAcad) {
        this.auListadoTitulosAcad = auListadoTitulosAcad;
    }
    
    public int getAuAnioInicio() {
        return auAnioInicio;
    }
    
    public void setAuAnioInicio(int auAnioInicio) {
        this.auAnioInicio = auAnioInicio;
    }
    
    public int getAuAnioFin() {
        return auAnioFin;
    }
    
    public void setAuAnioFin(int auAnioFin) {
        this.auAnioFin = auAnioFin;
    }
    
    public String getAuNombres() {
        return auNombres;
    }
    
    public void setAuNombres(String auNombres) {
        this.auNombres = auNombres;
    }
    
    public String getAuApellidos() {
        return auApellidos;
    }
    
    public void setAuApellidos(String auApellidos) {
        this.auApellidos = auApellidos;
    }
    
    public String getAuDireccion() {
        return auDireccion;
    }
    
    public void setAuDireccion(String auDireccion) {
        this.auDireccion = auDireccion;
    }
    
    public String getAuTelefono() {
        return auTelefono;
    }
    
    public void setAuTelefono(String auTelefono) {
        this.auTelefono = auTelefono;
    }
    
    public String getAuExtensTelf() {
        return auExtensTelf;
    }
    
    public void setAuExtensTelf(String auExtensTelf) {
        this.auExtensTelf = auExtensTelf;
    }
    
    public String getAuNumCelular() {
        return auNumCelular;
    }
    
    public void setAuNumCelular(String auNumCelular) {
        this.auNumCelular = auNumCelular;
    }
    
    public String getAuCorreoElect() {
        return auCorreoElect;
    }
    
    public void setAuCorreoElect(String auCorreoElect) {
        this.auCorreoElect = auCorreoElect;
    }
    
    public String getAuUrlFoto() {
        return auUrlFoto;
    }
    
    public void setAuUrlFoto(String auUrlFoto) {
        this.auUrlFoto = auUrlFoto;
    }
    
    public String getAuIdioma1() {
        return auIdioma1;
    }
    
    public void setAuIdioma1(String auIdioma1) {
        this.auIdioma1 = auIdioma1;
    }
    
    public String getAuIdioma2() {
        return auIdioma2;
    }
    
    public void setAuIdioma2(String auIdioma2) {
        this.auIdioma2 = auIdioma2;
    }
    
    public String getAuIdioma3() {
        return auIdioma3;
    }
    
    public void setAuIdioma3(String auIdioma3) {
        this.auIdioma3 = auIdioma3;
    }
    
    public String getAuUrlPerfilAcad() {
        return auUrlPerfilAcad;
    }
    
    public void setAuUrlPerfilAcad(String auUrlPerfilAcad) {
        this.auUrlPerfilAcad = auUrlPerfilAcad;
    }
    
    public String getAuTarget() {
        return auTarget;
    }
    
    public void setAuTarget(String auTarget) {
        this.auTarget = auTarget;
    }
    
    public int getAuEstado() {
        return auEstado;
    }
    
    public void setAuEstado(int auEstado) {
        this.auEstado = auEstado;
    }
    
    public String getAuUrlFotoAlt() {
        return auUrlFotoAlt;
    }
    
    public void setAuUrlFotoAlt(String auUrlFotoAlt) {
        this.auUrlFotoAlt = auUrlFotoAlt;
    }
    
    public String getAuGenero() {
        return auGenero;
    }
    
    public void setAuGenero(String auGenero) {
        this.auGenero = auGenero;
    }
//</editor-fold>

}
