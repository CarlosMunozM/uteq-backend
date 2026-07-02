package com.app.uteqbackend.model;

import com.app.uteqbackend.model.keys.CarreraPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "wp_carrera")
@IdClass(value = CarreraPK.class)
public class Carrera implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Id
    @Column(name = "id_carrera", nullable = false, updatable = false)
    private UUID crCodigo;
    
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    @JsonIgnoreProperties("dpListadoCarreras")
    @Id
    private Departamento crDepartamento;
    
    @Column(name = "nombre", nullable = false, length = 300)
    private String crNombre;
    
    @Column(name = "nombre_en", nullable = false, length = 300)
    private String crNombreEn;
    
    @Column(name = "nombre_pt", nullable = false, length = 300)
    private String crNombrePt;
    
    @Column(name = "img_banner", nullable = true, length = 100)
    private String crUrlImgBanner;
    
    @Column(name = "denominacion", nullable = true, length = 300)
    private String crDenom;
    
    @Column(name = "denominacion_en", nullable = true, length = 300)
    private String crDenomEn;
    
    @Column(name = "denominacion_pt", nullable = true, length = 300)
    private String crDenomPt;
    
    @Column(name = "aprobacion_ces", nullable = true, length = 200)
    private String crAprobCES;
    
    @Column(name = "titulo_acad", nullable = false, length = 200)
    private String crTitAcad;
    
    @Column(name = "titulo_acad_en", nullable = false, length = 200)
    private String crTitAcadEn;
    
    @Column(name = "titulo_acad_pt", nullable = false, length = 200)
    private String crTitAcadPt;
    
    @Column(name = "modalidad", nullable = true, length = 50)
    private String crModald;
    
    @Column(name = "modalidad_en", nullable = true, length = 50)
    private String crModaldEn;
    
    @Column(name = "modalidad_pt", nullable = true, length = 50)
    private String crModaldPt;
    
    @Column(name = "duracion", nullable = true, length = 25)
    private String crDurac;
    
    @Column(name = "duracion_en", nullable = true, length = 25)
    private String crDuracEn;
    
    @Column(name = "duracion_pt", nullable = true, length = 25)
    private String crDuracPt;
    
    @Column(name = "perfil_profs", nullable = true)
    private String crPerfilProf;
    
    @Column(name = "perfil_profs_en", nullable = true)
    private String crPerfilProfEn;
    
    @Column(name = "perfil_profs_pt", nullable = true)
    private String crPerfilProfPt;
    
    @Column(name = "campo_ocup", nullable = true)
    private String crCampoOcupc;
    
    @Column(name = "campo_ocup_en", nullable = true)
    private String crCampoOcupcEn;
    
    @Column(name = "campo_ocup_pt", nullable = true)
    private String crCampoOcupcPt;
    
    @Column(name = "mision", nullable = true)
    private String crMision;
    
    @Column(name = "mision_en", nullable = true)
    private String crMisionEn;
    
    @Column(name = "mision_pt", nullable = true)
    private String crMisionPt;
    
    @Column(name = "vision", nullable = true)
    private String crVision;
    
    @Column(name = "vision_en", nullable = true)
    private String crVisionEn;
    
    @Column(name = "vision_pt", nullable = true)
    private String crVisionPt;
    
    @Column(name = "objetivos", nullable = true)
    private String crObjetivos;
    
    @Column(name = "objetivos_en", nullable = true)
    private String crObjetivosEn;
    
    @Column(name = "objetivos_pt", nullable = true)
    private String crObjetivosPt;
    
    @Column(name = "horarios", nullable = true, length = 300)
    private String crHorarios;
    
    @Column(name = "horarios_en", nullable = true, length = 300)
    private String crHorariosEn;
    
    @Column(name = "horarios_pt", nullable = true, length = 300)
    private String crHorariosPt;
    
    @Column(name = "modulos", nullable = true)
    private String crModulos;
    
    @Column(name = "modulos_en", nullable = true)
    private String crModulosEn;
    
    @Column(name = "modulos_pt", nullable = true)
    private String crModulosPt;
    
    @Column(name = "requis_ing", nullable = true)
    private String crReqIng;
    
    @Column(name = "requis_ing_en", nullable = true)
    private String crReqIngEn;
    
    @Column(name = "requis_ing_pt", nullable = true)
    private String crReqIngPt;
    
    @Column(name = "inscripciones", nullable = true, length = 200)
    private String crInscripciones;
    
    @Column(name = "inscripciones_en", nullable = true, length = 200)
    private String crInscripcionesEn;
    
    @Column(name = "inscripciones_pt", nullable = true, length = 200)
    private String crInscripcionesPt;
    
    @Column(name = "matriculas", nullable = true, length = 200)
    private String crMatriculas;
    
    @Column(name = "matriculas_en", nullable = true, length = 200)
    private String crMatriculasEn;
    
    @Column(name = "matriculas_pt", nullable = true, length = 200)
    private String crMatriculasPt;
    
    @Column(name = "inicio_clases", nullable = true, length = 200)
    private String crInicioCls;
    
    @Column(name = "inicio_clases_en", nullable = true, length = 200)
    private String crInicioClsEn;
    
    @Column(name = "inicio_clases_pt", nullable = true, length = 200)
    private String crInicioClsPt;
    
    @Column(name = "formas_pago", nullable = true)
    private String crFormaPago;
    
    @Column(name = "formas_pago_en", nullable = true)
    private String crFormaPagoEn;
    
    @Column(name = "formas_pago_pt", nullable = true)
    private String crFormaPagoPt;
    
    @Column(name = "img_malla", nullable = true, length = 100)
    private String crUrlImgMalla;
    
    @Column(name = "url_video", nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String crUrlVideo;
    
    @Column(name = "url_brochure", nullable = true, length = 100)
    private String crUrlPdfBrochure;
    
    @Column(name = "parcial_url", nullable = false)
    private String crUrlParcial;
    
    @Column(name = "target", nullable = true, length = 7, columnDefinition = "CHAR(7) CHECK(target IN ('_blank','_self','_parent','_top'))")
    private String crTarget;
    
    @Column(name = "tipo_carrera", nullable = false, length = 8, columnDefinition = "CHAR(8) CHECK(tipo_carrera IN ('GRADO','POSGRADO'))")
    private String crTipoCarrera;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK (estado IN (0,1))")
    private int crEstado;
    
    @Column(name = "cod_menu_asoc", nullable = true)
    private Integer crCodMenuAsocd;
    
    @Column(name = "url_portada", nullable = true, length = 100)
    private String crUrlPortada;
    
    @Column(name = "url_portada_en", nullable = true, length = 100)
    private String crUrlPortadaEn;
    
    @Column(name = "url_portada_pt", nullable = true, length = 100)
    private String crUrlPortadaPt;
    
    @Column(name = "url_img_brochure", nullable = true, length = 100)
    private String crUrlImgBrochure;
    
    @OneToMany(mappedBy = "auObjCarrera", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<AutoridadCar> crListadoAutoridades = new HashSet<AutoridadCar>();
    
    @Column(name="perd_matc", nullable=true, columnDefinition="INT CHECK (perd_matc IN (1,0))")
    private Integer crPeriodoMatc;
    
    @OneToMany(mappedBy = "ptCarrera", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ProyectoInvst> crListadoProyectosInv = new HashSet<ProyectoInvst>();
    
    @Column(name="url_img_red_soc", nullable=false)
    private String crUrlImgRS;
    
    @Column(name="url_img_red_soc_en", nullable=false)
    private String crUrlImgRSEn;
    
    @Column(name="url_img_red_soc_pt", nullable=false)
    private String crUrlImgRSPt;
    
    @Column(name="proporcion", nullable=false, columnDefinition="VARCHAR(12) CHECK (proporcion IN ('ratio-1x1','ratio-4x3','ratio-16x9','ratio-21x9'))")
    private String crProporcion;
    
    @Column(name="url_triptc_1", nullable=true)
    private String crUrlTriptc1;
    
    @Column(name="url_triptc_2", nullable=true)
    private String crUrlTriptc2;
    
    @Column(name="doc_triptico", nullable=true)
    private String crDocTriptc;
    
    @Column(name="url_pag_insc", nullable=true)
    private String crUrlPagInsc;
    
    @Column(name = "area_conc", nullable = true)
    private String crAreaConc;
    
    @Column(name = "area_conc_en", nullable = true)
    private String crAreaConcEn;
    
    @Column(name = "area_conc_pt", nullable = true)
    private String crAreaConcPt;
    
    @Column(name="url_slider_princ", nullable=true)
    private String crUrlSldPrinc;
    
    @Column(name="url_page_careers", nullable=true)
    private String crUrlPageCareers;
    
    public Carrera() {
        super();
    }
    
    public Carrera(String crUrlParcial) {
        super();
        this.crUrlParcial = crUrlParcial;
    }

    public Carrera(String crNombre, String crNombreEn, String crNombrePt) {
        super();
        this.crNombre = crNombre;
        this.crNombreEn = crNombreEn;
        this.crNombrePt = crNombrePt;
    }
    
    public Carrera(Departamento crDepartamento, String crNombre, String crUrlParcial) {
        super();
        this.crDepartamento = crDepartamento;
        this.crNombre = crNombre;
        this.crUrlParcial = crUrlParcial;
    }
    
    public Carrera(UUID crCodigo, String crNombre, String crUrlParcial, String crUrlPortada) {
        super();
        this.crCodigo = crCodigo;
        this.crNombre = crNombre;
        this.crUrlParcial = crUrlParcial;
        this.crUrlPortada = crUrlPortada;
    }
    
    public Carrera(UUID crCodigo, Departamento crDepartamento, String crNombre, String crUrlImgBanner, String crDenom, String crAprobCES, String crTitAcad, String crModald, String crDurac, String crPerfilProf, String crCampoOcupc, 
            String crMision, String crVision, String crObjetivos, String crHorarios, String crModulos, String crReqIng, String crInscripciones, String crMatriculas, String crInicioCls, String crFormaPago, String crUrlImgMalla, 
            String crUrlVideo, String crUrlPdfBrochure, String crUrlParcial, String crTarget, String crTipoCarrera, int crEstado, Integer crCodMenuAsocd, String crUrlPortada, String crUrlImgBrochure, Integer crPeriodoMatc) {
        super();
        this.crCodigo = crCodigo;
        this.crDepartamento = crDepartamento;
        this.crNombre = crNombre;
        this.crUrlImgBanner = crUrlImgBanner;
        this.crDenom = crDenom;
        this.crAprobCES = crAprobCES;
        this.crTitAcad = crTitAcad;
        this.crModald = crModald;
        this.crDurac = crDurac;
        this.crPerfilProf = crPerfilProf;
        this.crCampoOcupc = crCampoOcupc;
        this.crMision = crMision;
        this.crVision = crVision;
        this.crObjetivos = crObjetivos;
        this.crHorarios = crHorarios;
        this.crModulos = crModulos;
        this.crReqIng = crReqIng;
        this.crInscripciones = crInscripciones;
        this.crMatriculas = crMatriculas;
        this.crInicioCls = crInicioCls;
        this.crFormaPago = crFormaPago;
        this.crUrlImgMalla = crUrlImgMalla;
        this.crUrlVideo = crUrlVideo;
        this.crUrlPdfBrochure = crUrlPdfBrochure;
        this.crUrlParcial = crUrlParcial;
        this.crTarget = crTarget;
        this.crTipoCarrera = crTipoCarrera;
        this.crEstado = crEstado;
        this.crCodMenuAsocd = crCodMenuAsocd;
        this.crUrlPortada = crUrlPortada;
        this.crUrlImgBrochure = crUrlImgBrochure;
        this.crPeriodoMatc = crPeriodoMatc;
    }
    
    public Carrera(UUID crCodigo, Departamento crDepartamento, String crNombre, String crUrlImgBanner, String crDenom, String crAprobCES, String crTitAcad, String crModald, String crDurac, String crPerfilProf, String crCampoOcupc, 
            String crMision, String crVision, String crObjetivos, String crHorarios, String crModulos, String crReqIng, String crInscripciones, String crMatriculas, String crInicioCls, String crFormaPago, String crUrlImgMalla, 
            String crUrlVideo, String crUrlPdfBrochure, String crUrlParcial, String crTarget, String crTipoCarrera, int crEstado, Integer crCodMenuAsocd, String crUrlPortada, String crUrlImgBrochure, Integer crPeriodoMatc, 
            String crUrlImgRS, String crProporcion, String crUrlTriptc1, String crUrlTriptc2, String crDocTriptc) {
        super();
        this.crCodigo = crCodigo;
        this.crDepartamento = crDepartamento;
        this.crNombre = crNombre;
        this.crUrlImgBanner = crUrlImgBanner;
        this.crDenom = crDenom;
        this.crAprobCES = crAprobCES;
        this.crTitAcad = crTitAcad;
        this.crModald = crModald;
        this.crDurac = crDurac;
        this.crPerfilProf = crPerfilProf;
        this.crCampoOcupc = crCampoOcupc;
        this.crMision = crMision;
        this.crVision = crVision;
        this.crObjetivos = crObjetivos;
        this.crHorarios = crHorarios;
        this.crModulos = crModulos;
        this.crReqIng = crReqIng;
        this.crInscripciones = crInscripciones;
        this.crMatriculas = crMatriculas;
        this.crInicioCls = crInicioCls;
        this.crFormaPago = crFormaPago;
        this.crUrlImgMalla = crUrlImgMalla;
        this.crUrlVideo = crUrlVideo;
        this.crUrlPdfBrochure = crUrlPdfBrochure;
        this.crUrlParcial = crUrlParcial;
        this.crTarget = crTarget;
        this.crTipoCarrera = crTipoCarrera;
        this.crEstado = crEstado;
        this.crCodMenuAsocd = crCodMenuAsocd;
        this.crUrlPortada = crUrlPortada;
        this.crUrlImgBrochure = crUrlImgBrochure;
        this.crPeriodoMatc = crPeriodoMatc;
        this.crUrlImgRS = crUrlImgRS;
        this.crProporcion = crProporcion;
        this.crUrlTriptc1 = crUrlTriptc1;
        this.crUrlTriptc2 = crUrlTriptc2;
        this.crDocTriptc = crDocTriptc;
    }
    
    public Carrera(String crNombre, String crUrlParcial) {
        super();
        this.crNombre = crNombre;
        this.crUrlParcial = crUrlParcial;
    }

    public Carrera(UUID crCodigo, Departamento crDepartamento, String crNombre, String crUrlImgBanner, String crDenom, String crAprobCES, String crTitAcad, String crModald, String crDurac, String crPerfilProf, String crCampoOcupc, 
            String crMision, String crVision, String crObjetivos, String crHorarios, String crModulos, String crReqIng, String crInscripciones, String crMatriculas, String crInicioCls, String crFormaPago, String crUrlImgMalla, 
            String crUrlVideo, String crUrlPdfBrochure, String crUrlParcial, String crTarget, String crTipoCarrera, int crEstado, Integer crCodMenuAsocd, String crUrlPortada, String crUrlImgBrochure, Integer crPeriodoMatc, 
            String crUrlImgRS, String crProporcion, String crUrlTriptc1, String crUrlTriptc2, String crDocTriptc, String crUrlPagInsc) {
        super();
        this.crCodigo = crCodigo;
        this.crDepartamento = crDepartamento;
        this.crNombre = crNombre;
        this.crUrlImgBanner = crUrlImgBanner;
        this.crDenom = crDenom;
        this.crAprobCES = crAprobCES;
        this.crTitAcad = crTitAcad;
        this.crModald = crModald;
        this.crDurac = crDurac;
        this.crPerfilProf = crPerfilProf;
        this.crCampoOcupc = crCampoOcupc;
        this.crMision = crMision;
        this.crVision = crVision;
        this.crObjetivos = crObjetivos;
        this.crHorarios = crHorarios;
        this.crModulos = crModulos;
        this.crReqIng = crReqIng;
        this.crInscripciones = crInscripciones;
        this.crMatriculas = crMatriculas;
        this.crInicioCls = crInicioCls;
        this.crFormaPago = crFormaPago;
        this.crUrlImgMalla = crUrlImgMalla;
        this.crUrlVideo = crUrlVideo;
        this.crUrlPdfBrochure = crUrlPdfBrochure;
        this.crUrlParcial = crUrlParcial;
        this.crTarget = crTarget;
        this.crTipoCarrera = crTipoCarrera;
        this.crEstado = crEstado;
        this.crCodMenuAsocd = crCodMenuAsocd;
        this.crUrlPortada = crUrlPortada;
        this.crUrlImgBrochure = crUrlImgBrochure;
        this.crPeriodoMatc = crPeriodoMatc;
        this.crUrlImgRS = crUrlImgRS;
        this.crProporcion = crProporcion;
        this.crUrlTriptc1 = crUrlTriptc1;
        this.crUrlTriptc2 = crUrlTriptc2;
        this.crDocTriptc = crDocTriptc;
        this.crUrlPagInsc = crUrlPagInsc;
    }

    public Carrera(UUID crCodigo, String crNombre, int crEstado, String crUrlPagInsc, String crAreaConc, String crUrlParcial) {
        super();
        this.crCodigo = crCodigo;
        this.crNombre = crNombre;
        this.crEstado = crEstado;
        this.crUrlPagInsc = crUrlPagInsc;
        this.crAreaConc = crAreaConc;
        this.crUrlParcial = crUrlParcial;
    }
    
    public Carrera(UUID crCodigo, String crNombre, String crNombreEn, String crNombrePt, String crUrlParcial, int crEstado, String crUrlPagInsc, String crAreaConc, String crAreaConcEn, String crAreaConcPt) {
        super();
        this.crCodigo = crCodigo;
        this.crNombre = crNombre;
        this.crNombreEn = crNombreEn;
        this.crNombrePt = crNombrePt;
        this.crUrlParcial = crUrlParcial;
        this.crEstado = crEstado;
        this.crUrlPagInsc = crUrlPagInsc;
        this.crAreaConc = crAreaConc;
        this.crAreaConcEn = crAreaConcEn;
        this.crAreaConcPt = crAreaConcPt;
    }
    
    public Carrera(Departamento crDepartamento, String crNombre, String crNombreEn, String crNombrePt, String crUrlParcial) {
        super();
        this.crDepartamento = crDepartamento;
        this.crNombre = crNombre;
        this.crNombreEn = crNombreEn;
        this.crNombrePt = crNombrePt;
        this.crUrlParcial = crUrlParcial;
    }

    public Carrera(Departamento crDepartamento, String crNombre, String crNombreEn, String crNombrePt, String crUrlParcial, String crUrlSldPrinc, String crUrlPageCareers) {
        this.crDepartamento = crDepartamento;
        this.crNombre = crNombre;
        this.crNombreEn = crNombreEn;
        this.crNombrePt = crNombrePt;
        this.crUrlParcial = crUrlParcial;
        this.crUrlSldPrinc = crUrlSldPrinc;
        this.crUrlPageCareers = crUrlPageCareers;
    }

    public Carrera(UUID crCodigo, String crNombre, String crNombreEn, String crNombrePt, String crUrlParcial, String crUrlPortada) {
        super();
        this.crCodigo = crCodigo;
        this.crNombre = crNombre;
        this.crNombreEn = crNombreEn;
        this.crNombrePt = crNombrePt;
        this.crUrlParcial = crUrlParcial;
        this.crUrlPortada = crUrlPortada;
    }
    
    public Carrera(UUID crCodigo, String crNombre, String crNombreEn, String crNombrePt, String crUrlParcial, String crUrlPortada, String crUrlPortadaEn, String crUrlPortadaPt) {
        super();
        this.crCodigo = crCodigo;
        this.crNombre = crNombre;
        this.crNombreEn = crNombreEn;
        this.crNombrePt = crNombrePt;
        this.crUrlParcial = crUrlParcial;
        this.crUrlPortada = crUrlPortada;
        this.crUrlPortadaEn = crUrlPortadaEn;
        this.crUrlPortadaPt = crUrlPortadaPt;
    }

    public Carrera(String crNombre, String crNombreEn, String crNombrePt, String crUrlParcial) {
        super();
        this.crNombre = crNombre;
        this.crNombreEn = crNombreEn;
        this.crNombrePt = crNombrePt;
        this.crUrlParcial = crUrlParcial;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    
    public UUID getCrCodigo() {
        return crCodigo;
    }
    
    public void setCrCodigo(UUID crCodigo) {
        this.crCodigo = crCodigo;
    }
    
    public Departamento getCrDepartamento() {
        return crDepartamento;
    }
    
    public void setCrDepartamento(Departamento crDepartamento) {
        this.crDepartamento = crDepartamento;
    }
    
    public String getCrNombre() {
        return crNombre;
    }
    
    public void setCrNombre(String crNombre) {
        this.crNombre = crNombre;
    }
    
    public String getCrUrlImgBanner() {
        return crUrlImgBanner;
    }
    
    public void setCrUrlImgBanner(String crUrlImgBanner) {
        this.crUrlImgBanner = crUrlImgBanner;
    }
    
    public String getCrDenom() {
        return crDenom;
    }
    
    public void setCrDenom(String crDenom) {
        this.crDenom = crDenom;
    }
    
    public String getCrAprobCES() {
        return crAprobCES;
    }
    
    public void setCrAprobCES(String crAprobCES) {
        this.crAprobCES = crAprobCES;
    }
    
    public String getCrTitAcad() {
        return crTitAcad;
    }
    
    public void setCrTitAcad(String crTitAcad) {
        this.crTitAcad = crTitAcad;
    }
    
    public String getCrModald() {
        return crModald;
    }
    
    public void setCrModald(String crModald) {
        this.crModald = crModald;
    }
    
    public String getCrDurac() {
        return crDurac;
    }
    
    public void setCrDurac(String crDurac) {
        this.crDurac = crDurac;
    }
    
    public String getCrPerfilProf() {
        return crPerfilProf;
    }
    
    public void setCrPerfilProf(String crPerfilProf) {
        this.crPerfilProf = crPerfilProf;
    }
    
    public String getCrCampoOcupc() {
        return crCampoOcupc;
    }
    
    public void setCrCampoOcupc(String crCampoOcupc) {
        this.crCampoOcupc = crCampoOcupc;
    }
    
    public String getCrMision() {
        return crMision;
    }
    
    public void setCrMision(String crMision) {
        this.crMision = crMision;
    }
    
    public String getCrVision() {
        return crVision;
    }
    
    public void setCrVision(String crVision) {
        this.crVision = crVision;
    }
    
    public String getCrObjetivos() {
        return crObjetivos;
    }
    
    public void setCrObjetivos(String crObjetivos) {
        this.crObjetivos = crObjetivos;
    }
    
    public String getCrHorarios() {
        return crHorarios;
    }
    
    public void setCrHorarios(String crHorarios) {
        this.crHorarios = crHorarios;
    }
    
    public String getCrModulos() {
        return crModulos;
    }
    
    public void setCrModulos(String crModulos) {
        this.crModulos = crModulos;
    }
    
    public String getCrReqIng() {
        return crReqIng;
    }
    
    public void setCrReqIng(String crReqIng) {
        this.crReqIng = crReqIng;
    }
    
    public String getCrInscripciones() {
        return crInscripciones;
    }
    
    public void setCrInscripciones(String crInscripciones) {
        this.crInscripciones = crInscripciones;
    }
    
    public String getCrMatriculas() {
        return crMatriculas;
    }
    
    public void setCrMatriculas(String crMatriculas) {
        this.crMatriculas = crMatriculas;
    }
    
    public String getCrInicioCls() {
        return crInicioCls;
    }
    
    public void setCrInicioCls(String crInicioCls) {
        this.crInicioCls = crInicioCls;
    }
    
    public String getCrFormaPago() {
        return crFormaPago;
    }
    
    public void setCrFormaPago(String crFormaPago) {
        this.crFormaPago = crFormaPago;
    }
    
    public String getCrUrlImgMalla() {
        return crUrlImgMalla;
    }
    
    public void setCrUrlImgMalla(String crUrlImgMalla) {
        this.crUrlImgMalla = crUrlImgMalla;
    }
    
    public String getCrUrlVideo() {
        return crUrlVideo;
    }
    
    public void setCrUrlVideo(String crUrlVideo) {
        this.crUrlVideo = crUrlVideo;
    }
    
    public String getCrUrlPdfBrochure() {
        return crUrlPdfBrochure;
    }
    
    public void setCrUrlPdfBrochure(String crUrlPdfBrochure) {
        this.crUrlPdfBrochure = crUrlPdfBrochure;
    }
    
    public String getCrUrlParcial() {
        return crUrlParcial;
    }
    
    public void setCrUrlParcial(String crUrlParcial) {
        this.crUrlParcial = crUrlParcial;
    }
    
    public String getCrTarget() {
        return crTarget;
    }
    
    public void setCrTarget(String crTarget) {
        this.crTarget = crTarget;
    }
    
    public String getCrTipoCarrera() {
        return crTipoCarrera;
    }
    
    public void setCrTipoCarrera(String crTipoCarrera) {
        this.crTipoCarrera = crTipoCarrera;
    }
    
    public int getCrEstado() {
        return crEstado;
    }
    
    public void setCrEstado(int crEstado) {
        this.crEstado = crEstado;
    }
    
    public Integer getCrCodMenuAsocd() {
        return crCodMenuAsocd;
    }
    
    public void setCrCodMenuAsocd(Integer crCodMenuAsocd) {
        this.crCodMenuAsocd = crCodMenuAsocd;
    }
    
    public String getCrUrlPortada() {
        return crUrlPortada;
    }
    
    public void setCrUrlPortada(String crUrlPortada) {
        this.crUrlPortada = crUrlPortada;
    }
    
    public String getCrUrlImgBrochure() {
        return crUrlImgBrochure;
    }
    
    public void setCrUrlImgBrochure(String crUrlImgBrochure) {
        this.crUrlImgBrochure = crUrlImgBrochure;
    }
    
    public Set<AutoridadCar> getCrListadoAutoridades() {
        return crListadoAutoridades;
    }
    
    public void setCrListadoAutoridades(Set<AutoridadCar> crListadoAutoridades) {
        this.crListadoAutoridades = crListadoAutoridades;
    }
    
    public Integer getCrPeriodoMatc() {
        return crPeriodoMatc;
    }
    
    public void setCrPeriodoMatc(Integer crPeriodoMatc) {
        this.crPeriodoMatc = crPeriodoMatc;
    }
    
    public Set<ProyectoInvst> getCrListadoProyectosInv() {
        return crListadoProyectosInv;
    }
    
    public void setCrListadoProyectosInv(Set<ProyectoInvst> crListadoProyectosInv) {
        this.crListadoProyectosInv = crListadoProyectosInv;
    }
    
    public String getCrUrlImgRS() {
        return crUrlImgRS;
    }
    
    public void setCrUrlImgRS(String crUrlImgRS) {
        this.crUrlImgRS = crUrlImgRS;
    }
    
    public String getCrProporcion() {
        return crProporcion;
    }
    
    public void setCrProporcion(String crProporcion) {
        this.crProporcion = crProporcion;
    }
    
    public String getCrUrlTriptc1() {
        return crUrlTriptc1;
    }
    
    public void setCrUrlTriptc1(String crUrlTriptc1) {
        this.crUrlTriptc1 = crUrlTriptc1;
    }
    
    public String getCrUrlTriptc2() {
        return crUrlTriptc2;
    }
    
    public void setCrUrlTriptc2(String crUrlTriptc2) {
        this.crUrlTriptc2 = crUrlTriptc2;
    }
    
    public String getCrDocTriptc() {
        return crDocTriptc;
    }
    
    public void setCrDocTriptc(String crDocTriptc) {
        this.crDocTriptc = crDocTriptc;
    }
    
    public String getCrUrlPagInsc() {
        return crUrlPagInsc;
    }

    public void setCrUrlPagInsc(String crUrlPagInsc) {
        this.crUrlPagInsc = crUrlPagInsc;
    }
    
    public String getCrAreaConc() {
        return crAreaConc;
    }

    public void setCrAreaConc(String crAreaConc) {
        this.crAreaConc = crAreaConc;
    }
    
    public String getCrNombreEn() {
        return crNombreEn;
    }

    public void setCrNombreEn(String crNombreEn) {
        this.crNombreEn = crNombreEn;
    }

    public String getCrNombrePt() {
        return crNombrePt;
    }

    public void setCrNombrePt(String crNombrePt) {
        this.crNombrePt = crNombrePt;
    }

    public String getCrDenomEn() {
        return crDenomEn;
    }

    public void setCrDenomEn(String crDenomEn) {
        this.crDenomEn = crDenomEn;
    }

    public String getCrDenomPt() {
        return crDenomPt;
    }

    public void setCrDenomPt(String crDenomPt) {
        this.crDenomPt = crDenomPt;
    }

    public String getCrTitAcadEn() {
        return crTitAcadEn;
    }

    public void setCrTitAcadEn(String crTitAcadEn) {
        this.crTitAcadEn = crTitAcadEn;
    }

    public String getCrTitAcadPt() {
        return crTitAcadPt;
    }

    public void setCrTitAcadPt(String crTitAcadPt) {
        this.crTitAcadPt = crTitAcadPt;
    }

    public String getCrModaldEn() {
        return crModaldEn;
    }

    public void setCrModaldEn(String crModaldEn) {
        this.crModaldEn = crModaldEn;
    }

    public String getCrModaldPt() {
        return crModaldPt;
    }

    public void setCrModaldPt(String crModaldPt) {
        this.crModaldPt = crModaldPt;
    }

    public String getCrDuracEn() {
        return crDuracEn;
    }

    public void setCrDuracEn(String crDuracEn) {
        this.crDuracEn = crDuracEn;
    }

    public String getCrDuracPt() {
        return crDuracPt;
    }

    public void setCrDuracPt(String crDuracPt) {
        this.crDuracPt = crDuracPt;
    }

    public String getCrPerfilProfEn() {
        return crPerfilProfEn;
    }

    public void setCrPerfilProfEn(String crPerfilProfEn) {
        this.crPerfilProfEn = crPerfilProfEn;
    }

    public String getCrPerfilProfPt() {
        return crPerfilProfPt;
    }

    public void setCrPerfilProfPt(String crPerfilProfPt) {
        this.crPerfilProfPt = crPerfilProfPt;
    }

    public String getCrCampoOcupcEn() {
        return crCampoOcupcEn;
    }

    public void setCrCampoOcupcEn(String crCampoOcupcEn) {
        this.crCampoOcupcEn = crCampoOcupcEn;
    }

    public String getCrCampoOcupcPt() {
        return crCampoOcupcPt;
    }

    public void setCrCampoOcupcPt(String crCampoOcupcPt) {
        this.crCampoOcupcPt = crCampoOcupcPt;
    }

    public String getCrMisionEn() {
        return crMisionEn;
    }

    public void setCrMisionEn(String crMisionEn) {
        this.crMisionEn = crMisionEn;
    }

    public String getCrMisionPt() {
        return crMisionPt;
    }

    public void setCrMisionPt(String crMisionPt) {
        this.crMisionPt = crMisionPt;
    }

    public String getCrVisionEn() {
        return crVisionEn;
    }

    public void setCrVisionEn(String crVisionEn) {
        this.crVisionEn = crVisionEn;
    }

    public String getCrVisionPt() {
        return crVisionPt;
    }

    public void setCrVisionPt(String crVisionPt) {
        this.crVisionPt = crVisionPt;
    }

    public String getCrObjetivosEn() {
        return crObjetivosEn;
    }

    public void setCrObjetivosEn(String crObjetivosEn) {
        this.crObjetivosEn = crObjetivosEn;
    }

    public String getCrObjetivosPt() {
        return crObjetivosPt;
    }

    public void setCrObjetivosPt(String crObjetivosPt) {
        this.crObjetivosPt = crObjetivosPt;
    }

    public String getCrHorariosEn() {
        return crHorariosEn;
    }

    public void setCrHorariosEn(String crHorariosEn) {
        this.crHorariosEn = crHorariosEn;
    }

    public String getCrHorariosPt() {
        return crHorariosPt;
    }

    public void setCrHorariosPt(String crHorariosPt) {
        this.crHorariosPt = crHorariosPt;
    }

    public String getCrModulosEn() {
        return crModulosEn;
    }

    public void setCrModulosEn(String crModulosEn) {
        this.crModulosEn = crModulosEn;
    }

    public String getCrModulosPt() {
        return crModulosPt;
    }

    public void setCrModulosPt(String crModulosPt) {
        this.crModulosPt = crModulosPt;
    }

    public String getCrReqIngEn() {
        return crReqIngEn;
    }

    public void setCrReqIngEn(String crReqIngEn) {
        this.crReqIngEn = crReqIngEn;
    }

    public String getCrReqIngPt() {
        return crReqIngPt;
    }

    public void setCrReqIngPt(String crReqIngPt) {
        this.crReqIngPt = crReqIngPt;
    }

    public String getCrInscripcionesEn() {
        return crInscripcionesEn;
    }

    public void setCrInscripcionesEn(String crInscripcionesEn) {
        this.crInscripcionesEn = crInscripcionesEn;
    }

    public String getCrInscripcionesPt() {
        return crInscripcionesPt;
    }

    public void setCrInscripcionesPt(String crInscripcionesPt) {
        this.crInscripcionesPt = crInscripcionesPt;
    }

    public String getCrMatriculasEn() {
        return crMatriculasEn;
    }

    public void setCrMatriculasEn(String crMatriculasEn) {
        this.crMatriculasEn = crMatriculasEn;
    }

    public String getCrMatriculasPt() {
        return crMatriculasPt;
    }

    public void setCrMatriculasPt(String crMatriculasPt) {
        this.crMatriculasPt = crMatriculasPt;
    }

    public String getCrInicioClsEn() {
        return crInicioClsEn;
    }

    public void setCrInicioClsEn(String crInicioClsEn) {
        this.crInicioClsEn = crInicioClsEn;
    }

    public String getCrInicioClsPt() {
        return crInicioClsPt;
    }

    public void setCrInicioClsPt(String crInicioClsPt) {
        this.crInicioClsPt = crInicioClsPt;
    }

    public String getCrFormaPagoEn() {
        return crFormaPagoEn;
    }

    public void setCrFormaPagoEn(String crFormaPagoEn) {
        this.crFormaPagoEn = crFormaPagoEn;
    }

    public String getCrFormaPagoPt() {
        return crFormaPagoPt;
    }

    public void setCrFormaPagoPt(String crFormaPagoPt) {
        this.crFormaPagoPt = crFormaPagoPt;
    }

    public String getCrAreaConcEn() {
        return crAreaConcEn;
    }

    public void setCrAreaConcEn(String crAreaConcEn) {
        this.crAreaConcEn = crAreaConcEn;
    }

    public String getCrAreaConcPt() {
        return crAreaConcPt;
    }

    public void setCrAreaConcPt(String crAreaConcPt) {
        this.crAreaConcPt = crAreaConcPt;
    }
    
    public String getCrUrlPortadaEn() {
        return crUrlPortadaEn;
    }

    public void setCrUrlPortadaEn(String crUrlPortadaEn) {
        this.crUrlPortadaEn = crUrlPortadaEn;
    }

    public String getCrUrlPortadaPt() {
        return crUrlPortadaPt;
    }

    public void setCrUrlPortadaPt(String crUrlPortadaPt) {
        this.crUrlPortadaPt = crUrlPortadaPt;
    }

    public String getCrUrlImgRSEn() {
        return crUrlImgRSEn;
    }

    public void setCrUrlImgRSEn(String crUrlImgRSEn) {
        this.crUrlImgRSEn = crUrlImgRSEn;
    }

    public String getCrUrlImgRSPt() {
        return crUrlImgRSPt;
    }

    public void setCrUrlImgRSPt(String crUrlImgRSPt) {
        this.crUrlImgRSPt = crUrlImgRSPt;
    }
    
    public String getCrUrlSldPrinc() {
        return crUrlSldPrinc;
    }

    public void setCrUrlSldPrinc(String crUrlSldPrinc) {
        this.crUrlSldPrinc = crUrlSldPrinc;
    }

    public String getCrUrlPageCareers() {
        return crUrlPageCareers;
    }

    public void setCrUrlPageCareers(String crUrlPageCareers) {
        this.crUrlPageCareers = crUrlPageCareers;
    }
//</editor-fold>

}
