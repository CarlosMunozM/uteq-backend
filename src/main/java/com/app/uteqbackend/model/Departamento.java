package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "wp_departamento")
public class Departamento implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Id
    @Column(name = "id_departamento", nullable = false, updatable = false)
    private UUID dpCodigo;
    
    @Column(name = "nombre", nullable = false, length = 200)
    private String dpNombre;
    
    @Column(name = "nombre_en", nullable = false, length = 200)
    private String dpNombreEn;
    
    @Column(name = "nombre_pt", nullable = false, length = 200)
    private String dpNombrePt;
    
    @Column(name = "mision", nullable = true)
    private String dpMision;
    
    @Column(name = "mision_en", nullable = true)
    private String dpMisionEn;
    
    @Column(name = "mision_pt", nullable = true)
    private String dpMisionPt;
    
    @Column(name = "vision", nullable = true)
    private String dpVision;
    
    @Column(name = "vision_en", nullable = true)
    private String dpVisionEn;
    
    @Column(name = "vision_pt", nullable = true)
    private String dpVisionPt;
    
    @Column(name = "historia", nullable = true)
    private String dpHistoria;
    
    @Column(name = "historia_en", nullable = true)
    private String dpHistoriaEn;
    
    @Column(name = "historia_pt", nullable = true)
    private String dpHistoriaPt;
    
    @Column(name = "objetivos", nullable = true)
    private String dpObjetivos;
    
    @Column(name = "objetivos_en", nullable = true)
    private String dpObjetivosEn;
    
    @Column(name = "objetivos_pt", nullable = true)
    private String dpObjetivosPt;
    
    @Column(name = "responsabilidades", nullable = true)
    private String dpResponsabilidades;
    
    @Column(name = "responsabilidades_en", nullable = true)
    private String dpResponsabilidadesEn;
    
    @Column(name = "responsabilidades_pt", nullable = true)
    private String dpResponsabilidadesPt;
    
    @Column(name = "url_video", nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String dpUrlVideo;
    
    @Column(name = "img_banner", nullable = true, length = 100)
    private String dpImgBanner;
    
    @Column(name = "img_logo", nullable = true, length = 100)
    private String dpImgLogo;
    
    @Column(name = "direccion", nullable = true, length = 300)
    private String dpDireccion;
    
    @Column(name = "direccion_en", nullable = true, length = 300)
    private String dpDireccionEn;
    
    @Column(name = "direccion_pt", nullable = true, length = 300)
    private String dpDireccionPt;
    
    @Column(name = "correo_elect", nullable = true, length = 100)
    private String dpCorreoElect;
    
    @Column(name = "link_cta_facb", nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String dpCtaFacb;
    
    @Column(name = "link_cta_whats", nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String dpCtaWhats;
    
    @Column(name = "link_cta_twt", nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String dpCtaTwt;
    
    @Column(name = "link_cta_youtb", nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String dpCtaYoutb;
    
    @Column(name = "link_cta_instg", nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String dpCtaInstg;
    
    @Column(name = "link_cta_linkedin", nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String dpCtaLinkedIn;
    
    @Column(name = "color_dep", nullable = true, length = 7)
    private String dpColor;
    
    @Column(name = "parcial_url", nullable = false, length = 100)
    private String dpParcialUrl;
    
    @Column(name = "facultad", nullable = false, length = 1, columnDefinition = "CHAR(1) CHECK(facultad IN ('S','N'))")
    private String dpEsFacultad;
    
    @OneToMany(mappedBy = "objDepartamento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Evento> dpListadoEventos = new HashSet<Evento>();
    
    @OneToMany(mappedBy = "objDepartamento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Noticia> dpListadoNoticias = new HashSet<Noticia>();
    
    @OneToMany(mappedBy = "auObjEntDato", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Autoridad> dpListadoAutoridades = new HashSet<Autoridad>();
    
    @OneToMany(mappedBy = "crDepartamento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Carrera> dpListadoCarreras = new HashSet<Carrera>();
    
    @OneToMany(mappedBy = "giFacultad", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<GrupoInv> dpListadoGruposInv = new HashSet<GrupoInv>();
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK (estado IN (0,1))")
    private int dpEstado;
    
    @Column(name = "url_video_insc", nullable = true, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String dpUrlVideoInscripcion;
    
    @Column(name = "url_video_matc", nullable = true, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String dpUrlVideoMatriculacion;
    
    @Column(name = "cod_rec_dep")
    private int dpCodigoUnc;
    
    public Departamento() {
        super();
    }
    
    public Departamento(String dpNombre, String dpEsFacultad, int dpEstado) {
        this.dpNombre = dpNombre;
        this.dpEsFacultad = dpEsFacultad;
        this.dpEstado = dpEstado;
    }
    
    public Departamento(String dpNombre, String dpColor) {
        super();
        this.dpNombre = dpNombre;
        this.dpColor = dpColor;
    }

    public Departamento(String dpParcialUrl) {
        super();
        this.dpParcialUrl = dpParcialUrl;
    }
    
    public Departamento(UUID dpCodigo, String dpNombre, String dpParcialUrl) {
        super();
        this.dpCodigo = dpCodigo;
        this.dpNombre = dpNombre;
        this.dpParcialUrl = dpParcialUrl;
    }
    
    public Departamento(UUID dpCodigo, String dpNombre, String dpImgLogo, String dpParcialUrl) {
        super();
        this.dpCodigo = dpCodigo;
        this.dpNombre = dpNombre;
        this.dpImgLogo = dpImgLogo;
        this.dpParcialUrl = dpParcialUrl;
    }
    
    public Departamento(UUID dpCodigo, String dpNombre, String dpMision, String dpVision, String dpObjetivos, String dpResponsabilidades, String dpUrlVideo, String dpImgBanner, String dpImgLogo, String dpDireccion, String dpCorreoElect, String dpCtaFacb, String dpCtaWhats, String dpCtaTwt, String dpCtaYoutb, String dpCtaInstg, String dpCtaLinkedIn, String dpColor, String dpParcialUrl, String dpEsFacultad, int dpEstado) {
        super();
        this.dpCodigo = dpCodigo;
        this.dpNombre = dpNombre;
        this.dpMision = dpMision;
        this.dpVision = dpVision;
        this.dpObjetivos = dpObjetivos;
        this.dpResponsabilidades = dpResponsabilidades;
        this.dpUrlVideo = dpUrlVideo;
        this.dpImgBanner = dpImgBanner;
        this.dpImgLogo = dpImgLogo;
        this.dpDireccion = dpDireccion;
        this.dpCorreoElect = dpCorreoElect;
        this.dpCtaFacb = dpCtaFacb;
        this.dpCtaWhats = dpCtaWhats;
        this.dpCtaTwt = dpCtaTwt;
        this.dpCtaYoutb = dpCtaYoutb;
        this.dpCtaInstg = dpCtaInstg;
        this.dpCtaLinkedIn = dpCtaLinkedIn;
        this.dpColor = dpColor;
        this.dpParcialUrl = dpParcialUrl;
        this.dpEsFacultad = dpEsFacultad;
        this.dpEstado = dpEstado;
    }
    
    public Departamento(UUID dpCodigo, String dpNombre, String dpMision, String dpVision, String dpHistoria, String dpObjetivos, String dpResponsabilidades, String dpUrlVideo, String dpImgBanner, String dpImgLogo, String dpDireccion, String dpCorreoElect, String dpCtaFacb, String dpCtaWhats, String dpCtaTwt, String dpCtaYoutb, String dpCtaInstg, String dpCtaLinkedIn, String dpColor, String dpParcialUrl, String dpEsFacultad, int dpEstado, String dpUrlVideoInscripcion, String dpUrlVideoMatriculacion) {
        super();
        this.dpCodigo = dpCodigo;
        this.dpNombre = dpNombre;
        this.dpMision = dpMision;
        this.dpVision = dpVision;
        this.dpHistoria = dpHistoria;
        this.dpObjetivos = dpObjetivos;
        this.dpResponsabilidades = dpResponsabilidades;
        this.dpUrlVideo = dpUrlVideo;
        this.dpImgBanner = dpImgBanner;
        this.dpImgLogo = dpImgLogo;
        this.dpDireccion = dpDireccion;
        this.dpCorreoElect = dpCorreoElect;
        this.dpCtaFacb = dpCtaFacb;
        this.dpCtaWhats = dpCtaWhats;
        this.dpCtaTwt = dpCtaTwt;
        this.dpCtaYoutb = dpCtaYoutb;
        this.dpCtaInstg = dpCtaInstg;
        this.dpCtaLinkedIn = dpCtaLinkedIn;
        this.dpColor = dpColor;
        this.dpParcialUrl = dpParcialUrl;
        this.dpEsFacultad = dpEsFacultad;
        this.dpEstado = dpEstado;
        this.dpUrlVideoInscripcion = dpUrlVideoInscripcion;
        this.dpUrlVideoMatriculacion = dpUrlVideoMatriculacion;
    }
    
    public Departamento(UUID dpCodigo, String dpNombre, String dpMision, String dpVision, String dpHistoria, String dpObjetivos, String dpResponsabilidades, String dpUrlVideo, String dpImgBanner, String dpImgLogo, String dpDireccion, String dpCorreoElect, String dpCtaFacb, String dpCtaWhats, String dpCtaTwt, String dpCtaYoutb, String dpCtaInstg, String dpCtaLinkedIn, String dpColor, String dpParcialUrl, String dpEsFacultad, int dpEstado, String dpUrlVideoInscripcion, String dpUrlVideoMatriculacion, int dpCodigoUnc) {
        super();
        this.dpCodigo = dpCodigo;
        this.dpNombre = dpNombre;
        this.dpMision = dpMision;
        this.dpVision = dpVision;
        this.dpHistoria = dpHistoria;
        this.dpObjetivos = dpObjetivos;
        this.dpResponsabilidades = dpResponsabilidades;
        this.dpUrlVideo = dpUrlVideo;
        this.dpImgBanner = dpImgBanner;
        this.dpImgLogo = dpImgLogo;
        this.dpDireccion = dpDireccion;
        this.dpCorreoElect = dpCorreoElect;
        this.dpCtaFacb = dpCtaFacb;
        this.dpCtaWhats = dpCtaWhats;
        this.dpCtaTwt = dpCtaTwt;
        this.dpCtaYoutb = dpCtaYoutb;
        this.dpCtaInstg = dpCtaInstg;
        this.dpCtaLinkedIn = dpCtaLinkedIn;
        this.dpColor = dpColor;
        this.dpParcialUrl = dpParcialUrl;
        this.dpEsFacultad = dpEsFacultad;
        this.dpEstado = dpEstado;
        this.dpUrlVideoInscripcion = dpUrlVideoInscripcion;
        this.dpUrlVideoMatriculacion = dpUrlVideoMatriculacion;
        this.dpCodigoUnc = dpCodigoUnc;
    }
    
    public Departamento(UUID dpCodigo, String dpNombre, String dpNombreEn, String dpNombrePt, String dpParcialUrl) {
        super();
        this.dpCodigo = dpCodigo;
        this.dpNombre = dpNombre;
        this.dpNombreEn = dpNombreEn;
        this.dpNombrePt = dpNombrePt;
        this.dpParcialUrl = dpParcialUrl;
    }
    
    public Departamento(UUID dpCodigo, String dpNombre, String dpNombreEn, String dpNombrePt, String dpImgLogo, String dpParcialUrl) {
        super();
        this.dpCodigo = dpCodigo;
        this.dpNombre = dpNombre;
        this.dpNombreEn = dpNombreEn;
        this.dpNombrePt = dpNombrePt;
        this.dpImgLogo = dpImgLogo;
        this.dpParcialUrl = dpParcialUrl;
    }
    
    public Departamento(String dpNombre, String dpNombreEn, String dpNombrePt, String dpColor) {
        super();
        this.dpNombre = dpNombre;
        this.dpNombreEn = dpNombreEn;
        this.dpNombrePt = dpNombrePt;
        this.dpColor = dpColor;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public UUID getDpCodigo() {
        return dpCodigo;
    }
    
    public void setDpCodigo(UUID dpCodigo) {
        this.dpCodigo = dpCodigo;
    }
    
    public String getDpNombre() {
        return dpNombre != null ? dpNombre.trim() : null;
    }
    
    public void setDpNombre(String dpNombre) {
        this.dpNombre = dpNombre != null ? dpNombre.trim() : null;
    }
    
    public String getDpMision() {
        return dpMision;
    }
    
    public void setDpMision(String dpMision) {
        this.dpMision = dpMision;
    }
    
    public String getDpHistoria() {
        return dpHistoria;
    }
    
    public void setDpHistoria(String dpHistoria) {
        this.dpHistoria = dpHistoria;
    }
    
    public String getDpVision() {
        return dpVision;
    }
    
    public void setDpVision(String dpVision) {
        this.dpVision = dpVision;
    }
    
    public String getDpObjetivos() {
        return dpObjetivos;
    }
    
    public void setDpObjetivos(String dpObjetivos) {
        this.dpObjetivos = dpObjetivos;
    }
    
    public String getDpResponsabilidades() {
        return dpResponsabilidades;
    }
    
    public void setDpResponsabilidades(String dpResponsabilidades) {
        this.dpResponsabilidades = dpResponsabilidades;
    }
    
    public String getDpUrlVideo() {
        return dpUrlVideo;
    }
    
    public void setDpUrlVideo(String dpUrlVideo) {
        this.dpUrlVideo = dpUrlVideo;
    }
    
    public String getDpImgBanner() {
        return dpImgBanner;
    }
    
    public void setDpImgBanner(String dpImgBanner) {
        this.dpImgBanner = dpImgBanner;
    }
    
    public String getDpImgLogo() {
        return dpImgLogo;
    }
    
    public void setDpImgLogo(String dpImgLogo) {
        this.dpImgLogo = dpImgLogo;
    }
    
    public String getDpDireccion() {
        return dpDireccion;
    }
    
    public void setDpDireccion(String dpDireccion) {
        this.dpDireccion = dpDireccion;
    }
    
    public String getDpCorreoElect() {
        return dpCorreoElect;
    }
    
    public void setDpCorreoElect(String dpCorreoElect) {
        this.dpCorreoElect = dpCorreoElect;
    }
    
    public String getDpCtaFacb() {
        return dpCtaFacb;
    }
    
    public void setDpCtaFacb(String dpCtaFacb) {
        this.dpCtaFacb = dpCtaFacb;
    }
    
    public String getDpCtaWhats() {
        return dpCtaWhats;
    }
    
    public void setDpCtaWhats(String dpCtaWhats) {
        this.dpCtaWhats = dpCtaWhats;
    }
    
    public String getDpCtaTwt() {
        return dpCtaTwt;
    }
    
    public void setDpCtaTwt(String dpCtaTwt) {
        this.dpCtaTwt = dpCtaTwt;
    }
    
    public String getDpCtaYoutb() {
        return dpCtaYoutb;
    }
    
    public void setDpCtaYoutb(String dpCtaYoutb) {
        this.dpCtaYoutb = dpCtaYoutb;
    }
    
    public String getDpCtaInstg() {
        return dpCtaInstg;
    }
    
    public void setDpCtaInstg(String dpCtaInstg) {
        this.dpCtaInstg = dpCtaInstg;
    }
    
    public String getDpCtaLinkedIn() {
        return dpCtaLinkedIn;
    }
    
    public void setDpCtaLinkedIn(String dpCtaLinkedIn) {
        this.dpCtaLinkedIn = dpCtaLinkedIn;
    }
    
    public String getDpColor() {
        return dpColor;
    }
    
    public void setDpColor(String dpColor) {
        this.dpColor = dpColor;
    }
    
    public String getDpParcialUrl() {
        return dpParcialUrl;
    }
    
    public void setDpParcialUrl(String dpParcialUrl) {
        this.dpParcialUrl = dpParcialUrl;
    }
    
    public String getDpEsFacultad() {
        return dpEsFacultad;
    }
    
    public void setDpEsFacultad(String dpEsFacultad) {
        this.dpEsFacultad = dpEsFacultad;
    }
    
    public Set<Evento> getDpListadoEventos() {
        return dpListadoEventos;
    }
    
    public void setDpListadoEventos(Set<Evento> dpListadoEventos) {
        this.dpListadoEventos = dpListadoEventos;
    }
    
    public Set<Noticia> getDpListadoNoticias() {
        return dpListadoNoticias;
    }
    
    public void setDpListadoNoticias(Set<Noticia> dpListadoNoticias) {
        this.dpListadoNoticias = dpListadoNoticias;
    }
    
    public Set<Autoridad> getDpListadoAutoridades() {
        return dpListadoAutoridades;
    }
    
    public void setDpListadoAutoridades(Set<Autoridad> dpListadoAutoridades) {
        this.dpListadoAutoridades = dpListadoAutoridades;
    }
    
    public int getDpEstado() {
        return dpEstado;
    }
    
    public void setDpEstado(int dpEstado) {
        this.dpEstado = dpEstado;
    }
    
    public Set<Carrera> getDpListadoCarreras() {
        return dpListadoCarreras;
    }
    
    public void setDpListadoCarreras(Set<Carrera> dpListadoCarreras) {
        this.dpListadoCarreras = dpListadoCarreras;
    }
    
    public String getDpUrlVideoInscripcion() {
        return dpUrlVideoInscripcion;
    }
    
    public void setDpUrlVideoInscripcion(String dpUrlVideoInscripcion) {
        this.dpUrlVideoInscripcion = dpUrlVideoInscripcion;
    }
    
    public String getDpUrlVideoMatriculacion() {
        return dpUrlVideoMatriculacion;
    }
    
    public void setDpUrlVideoMatriculacion(String dpUrlVideoMatriculacion) {
        this.dpUrlVideoMatriculacion = dpUrlVideoMatriculacion;
    }
    
    public int getDpCodigoUnc() {
        return dpCodigoUnc;
    }
    
    public void setDpCodigoUnc(int dpCodigoUnc) {
        this.dpCodigoUnc = dpCodigoUnc;
    }
    
    public Set<GrupoInv> getDpListadoGruposInv() {
        return dpListadoGruposInv;
    }
    
    public void setDpListadoGruposInv(Set<GrupoInv> dpListadoGruposInv) {
        this.dpListadoGruposInv = dpListadoGruposInv;
    }

    public String getDpNombreEn() {
        return dpNombreEn != null ? dpNombreEn.trim() : null;
    }

    public void setDpNombreEn(String dpNombreEn) {
        this.dpNombreEn = dpNombreEn != null ? dpNombreEn.trim() : null;
    }

    public String getDpNombrePt() {
        return dpNombrePt != null ? dpNombrePt.trim() : null;
    }

    public void setDpNombrePt(String dpNombrePt) {
        this.dpNombrePt = dpNombrePt != null ? dpNombrePt.trim() : null;
    }

    public String getDpMisionEn() {
        return dpMisionEn;
    }

    public void setDpMisionEn(String dpMisionEn) {
        this.dpMisionEn = dpMisionEn;
    }

    public String getDpMisionPt() {
        return dpMisionPt;
    }

    public void setDpMisionPt(String dpMisionPt) {
        this.dpMisionPt = dpMisionPt;
    }

    public String getDpVisionEn() {
        return dpVisionEn;
    }

    public void setDpVisionEn(String dpVisionEn) {
        this.dpVisionEn = dpVisionEn;
    }

    public String getDpVisionPt() {
        return dpVisionPt;
    }

    public void setDpVisionPt(String dpVisionPt) {
        this.dpVisionPt = dpVisionPt;
    }

    public String getDpHistoriaEn() {
        return dpHistoriaEn;
    }

    public void setDpHistoriaEn(String dpHistoriaEn) {
        this.dpHistoriaEn = dpHistoriaEn;
    }

    public String getDpHistoriaPt() {
        return dpHistoriaPt;
    }

    public void setDpHistoriaPt(String dpHistoriaPt) {
        this.dpHistoriaPt = dpHistoriaPt;
    }

    public String getDpObjetivosEn() {
        return dpObjetivosEn;
    }

    public void setDpObjetivosEn(String dpObjetivosEn) {
        this.dpObjetivosEn = dpObjetivosEn;
    }

    public String getDpObjetivosPt() {
        return dpObjetivosPt;
    }

    public void setDpObjetivosPt(String dpObjetivosPt) {
        this.dpObjetivosPt = dpObjetivosPt;
    }

    public String getDpResponsabilidadesEn() {
        return dpResponsabilidadesEn;
    }

    public void setDpResponsabilidadesEn(String dpResponsabilidadesEn) {
        this.dpResponsabilidadesEn = dpResponsabilidadesEn;
    }

    public String getDpResponsabilidadesPt() {
        return dpResponsabilidadesPt;
    }

    public void setDpResponsabilidadesPt(String dpResponsabilidadesPt) {
        this.dpResponsabilidadesPt = dpResponsabilidadesPt;
    }

    public String getDpDireccionEn() {
        return dpDireccionEn;
    }

    public void setDpDireccionEn(String dpDireccionEn) {
        this.dpDireccionEn = dpDireccionEn;
    }

    public String getDpDireccionPt() {
        return dpDireccionPt;
    }

    public void setDpDireccionPt(String dpDireccionPt) {
        this.dpDireccionPt = dpDireccionPt;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public String toString() {
        return "Departamento{" + "dpCodigo=" + dpCodigo + ", dpNombre=" + dpNombre + ", dpMision=" + dpMision + ", dpVision=" + dpVision + ", dpHistoria=" + dpHistoria + ", dpObjetivos=" + dpObjetivos + ", dpResponsabilidades=" + dpResponsabilidades + ", dpUrlVideo=" + dpUrlVideo + ", dpImgBanner=" + dpImgBanner + ", dpImgLogo=" + dpImgLogo + ", dpDireccion=" + dpDireccion + ", dpCorreoElect=" + dpCorreoElect + ", dpCtaFacb=" + dpCtaFacb + ", dpCtaWhats=" + dpCtaWhats + ", dpCtaTwt=" + dpCtaTwt + ", dpCtaYoutb=" + dpCtaYoutb + ", dpCtaInstg=" + dpCtaInstg + ", dpCtaLinkedIn=" + dpCtaLinkedIn + ", dpColor=" + dpColor + ", dpParcialUrl=" + dpParcialUrl + ", dpEsFacultad=" + dpEsFacultad + ", dpListadoEventos=" + dpListadoEventos + ", dpListadoNoticias=" + dpListadoNoticias + ", dpListadoAutoridades=" + dpListadoAutoridades + ", dpListadoCarreras=" + dpListadoCarreras + ", dpEstado=" + dpEstado + ", dpUrlVideoInscripcion=" + dpUrlVideoInscripcion + ", dpUrlVideoMatriculacion=" + dpUrlVideoMatriculacion + ", dpCodigoUnc=" + dpCodigoUnc + '}';
    }
//</editor-fold>
   
    
}
