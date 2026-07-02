package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "wp_datos_mult")
public class DatosMult implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_datos_mult")
    private int dmCodgDato;
    
    @Column(name = "descripcion", nullable = false, length = 300)
    private String dmDescripcion;
    
    @Column(name = "tipo_entd", nullable = false, length = 12, columnDefinition = "CHAR(12) CHECK (tipo_entd IN ('CAMPUS','CARGO','ESTRUCTURA','CASOS_EXITO','PREG_FREC','DESTINATARIO','TIPO_SANGRE','CATG_UBU','HORARIO_UBU','REVISTA','RUTA_ARCHV','TIPO_VIDEO','TIPO_CERTF','CORREO_ELC','TIPO_EXPLAB','CMP_PROFS','FORM_PROFS','LAB_UNIV'))")
    private String dmCategoria;
    
    @Column(name = "ubc_lat", nullable = true, length = 20)
    private String dmLatitud;
    
    @Column(name = "ubc_long", nullable = true, length = 20)
    private String dmLongitud;
    
    @Type(type = "uuid-char")
    @Column(name = "id_carrera", nullable = true)
    private String dmIdCarrera;
    
    @Column(name = "nmb_graduado", nullable = true, length = 200)
    private String dmNombreGrad;
    
    @Column(name = "profesion", nullable = true, length = 100)
    private String dmProfesion;
    
    @Column(name = "profesion_en", nullable = true, length = 100)
    private String dmProfesionEn;
    
    @Column(name = "profesion_pt", nullable = true, length = 100)
    private String dmProfesionPt;
    
    @Column(name = "url_foto", nullable = true, length = 100)
    private String dmUrlFoto;
    
    @Column(name = "respuesta", nullable = true, length = 600)
    private String dmRespuesta;
    
    @Column(name = "respuesta_en", nullable = true, length = 600)
    private String dmRespuestaEn;
    
    @Column(name = "respuesta_pt", nullable = true, length = 600)
    private String dmRespuestaPt;
    
    @Column(name = "orden_pregunta", nullable = true)
    private Integer dmOrdenPreg;
    
    @Column(name = "correo_elect", nullable = true, length = 150)
    private String dmCorreoElect;
    
    @Column(name = "id_padre_ubu", nullable = true)
    private Integer dmCodPadreUbu;
    
    @Column(name = "url_pag_web", nullable = false, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String dmUrlPagWeb;
    
    @Column(name = "target", nullable = true, length = 7, columnDefinition = "CHAR(7) CHECK (target IN ('_blank','_self','_parent','_top'))")
    private String dmTarget;
    
    @Column(name = "tipo_archv", nullable = true, length = 3, columnDefinition = "CHAR(3) CHECK(tipo_archv IN ('pdf','img','doc','xls'))")
    private String dmTipoArchv;
    
    @Column(name = "url_directorio", nullable = true, length = 1000)
    private String dmUrlDirect;
    
    @Column(name = "deshab_ubu", nullable = true, columnDefinition = "INT CHECK(deshab_ubu IN (0,1))")
    private Integer dmDeshabUbu;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (0,1))")
    private int dmEstado;
    
    @OneToMany(mappedBy = "auObjCargo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Autoridad> dpListadoAutoridades = new HashSet<Autoridad>();
    
    @OneToMany(mappedBy = "orObjEstructura", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Organigrama> dpListadoOrganigramas = new HashSet<Organigrama>();
    
    @OneToMany(mappedBy = "viTipoVideo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("viTipoVideo")
    private List<VideoInfm> dpListadoVideos = new ArrayList<VideoInfm>();
    
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id_area_ubu", nullable = true, updatable = false)
    private UUID dpCodAreaInt;
    
    @Column(name = "desc_tramite", nullable = true)
    private String dmDescTramite;
    
    @Column(name = "descripcion_en", nullable = false, length = 300)
    private String dmDescripcionEn;
    
    @Column(name = "descripcion_pt", nullable = false, length = 300)
    private String dmDescripcionPt;
    
    @Column(name = "desc_tramite_en", nullable = true)
    private String dmDescTramiteEn;
    
    @Column(name = "desc_tramite_pt", nullable = true)
    private String dmDescTramitePt;
    
    public DatosMult() {
        super();
    }
    
    public DatosMult(int dmCodgDato, String dmDescripcion, String dmCategoria, String dmLatitud, String dmLongitud, Integer dmOrdenPreg, int dmEstado) {
        super();
        this.dmCodgDato = dmCodgDato;
        this.dmDescripcion = dmDescripcion;
        this.dmCategoria = dmCategoria;
        this.dmLatitud = dmLatitud;
        this.dmLongitud = dmLongitud;
        this.dmOrdenPreg = dmOrdenPreg;
        this.dmEstado = dmEstado;
    }
    
    public DatosMult(int dmCodgDato, String dmDescripcion, String dmCategoria, String dmLatitud, String dmLongitud, String dmIdCarrera, String dmNombreGrad, String dmProfesion, String dmUrlFoto, String dmRespuesta, Integer dmOrdenPreg, String dmCorreoElect, Integer dmCodPadreUbu, String dmUrlPagWeb, String dmTarget, String dmTipoArchv, String dmUrlDirect, Integer dmDeshabUbu, int dmEstado) {
        super();
        this.dmCodgDato = dmCodgDato;
        this.dmDescripcion = dmDescripcion;
        this.dmCategoria = dmCategoria;
        this.dmLatitud = dmLatitud;
        this.dmLongitud = dmLongitud;
        this.dmIdCarrera = dmIdCarrera;
        this.dmNombreGrad = dmNombreGrad;
        this.dmProfesion = dmProfesion;
        this.dmUrlFoto = dmUrlFoto;
        this.dmRespuesta = dmRespuesta;
        this.dmOrdenPreg = dmOrdenPreg;
        this.dmCorreoElect = dmCorreoElect;
        this.dmCodPadreUbu = dmCodPadreUbu;
        this.dmUrlPagWeb = dmUrlPagWeb;
        this.dmTarget = dmTarget;
        this.dmTipoArchv = dmTipoArchv;
        this.dmUrlDirect = dmUrlDirect;
        this.dmDeshabUbu = dmDeshabUbu;
        this.dmEstado = dmEstado;
    }

    public DatosMult(int dmCodgDato, String dmDescripcion, String dmCategoria, String dmLatitud, String dmLongitud, String dmIdCarrera, String dmNombreGrad, String dmProfesion, String dmUrlFoto, String dmRespuesta, Integer dmOrdenPreg, String dmCorreoElect, Integer dmCodPadreUbu, String dmUrlPagWeb, String dmTarget, String dmTipoArchv, String dmUrlDirect, Integer dmDeshabUbu, int dmEstado, UUID dpCodAreaInt, String dmDescTramite) {
        super();
        this.dmCodgDato = dmCodgDato;
        this.dmDescripcion = dmDescripcion;
        this.dmCategoria = dmCategoria;
        this.dmLatitud = dmLatitud;
        this.dmLongitud = dmLongitud;
        this.dmIdCarrera = dmIdCarrera;
        this.dmNombreGrad = dmNombreGrad;
        this.dmProfesion = dmProfesion;
        this.dmUrlFoto = dmUrlFoto;
        this.dmRespuesta = dmRespuesta;
        this.dmOrdenPreg = dmOrdenPreg;
        this.dmCorreoElect = dmCorreoElect;
        this.dmCodPadreUbu = dmCodPadreUbu;
        this.dmUrlPagWeb = dmUrlPagWeb;
        this.dmTarget = dmTarget;
        this.dmTipoArchv = dmTipoArchv;
        this.dmUrlDirect = dmUrlDirect;
        this.dmDeshabUbu = dmDeshabUbu;
        this.dmEstado = dmEstado;
        this.dpCodAreaInt = dpCodAreaInt;
        this.dmDescTramite = dmDescTramite;
    }
    
    public DatosMult(String dmNombreGrad, String dmProfesion, String dmUrlFoto, String dmRespuesta, Integer dmOrdenPreg) {
        super();
        this.dmNombreGrad = dmNombreGrad;
        this.dmProfesion = dmProfesion;
        this.dmUrlFoto = dmUrlFoto;
        this.dmRespuesta = dmRespuesta;
        this.dmOrdenPreg = dmOrdenPreg;
    }
    
    public DatosMult(String dmDescripcion, String dmDescTramite) {
        super();
        this.dmDescripcion = dmDescripcion;
        this.dmDescTramite = dmDescTramite;
    }
    
    public DatosMult(int dmCodgDato, String dmDescripcion, String dmDescTramite) {
        super();
        this.dmCodgDato = dmCodgDato;
        this.dmDescripcion = dmDescripcion;
        this.dmDescTramite = dmDescTramite;
    }

    public DatosMult(String dmNombreGrad, String dmProfesion, String dmProfesionEn, String dmProfesionPt, String dmUrlFoto, String dmRespuesta, String dmRespuestaEn, String dmRespuestaPt, Integer dmOrdenPreg) {
        super();
        this.dmNombreGrad = dmNombreGrad;
        this.dmProfesion = dmProfesion;
        this.dmProfesionEn = dmProfesionEn;
        this.dmProfesionPt = dmProfesionPt;
        this.dmUrlFoto = dmUrlFoto;
        this.dmRespuesta = dmRespuesta;
        this.dmRespuestaEn = dmRespuestaEn;
        this.dmRespuestaPt = dmRespuestaPt;
        this.dmOrdenPreg = dmOrdenPreg;
    }
    
    public DatosMult(int dmCodgDato, String dmDescripcion, String dmDescTramite, String dmDescripcionEn, String dmDescripcionPt, String dmDescTramiteEn, String dmDescTramitePt) {
        super();
        this.dmCodgDato = dmCodgDato;
        this.dmDescripcion = dmDescripcion;
        this.dmDescTramite = dmDescTramite;
        this.dmDescripcionEn = dmDescripcionEn;
        this.dmDescripcionPt = dmDescripcionPt;
        this.dmDescTramiteEn = dmDescTramiteEn;
        this.dmDescTramitePt = dmDescTramitePt;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getDmCodgDato() {
        return dmCodgDato;
    }
    
    public void setDmCodgDato(int dmCodgDato) {
        this.dmCodgDato = dmCodgDato;
    }
    
    public String getDmDescripcion() {
        return dmDescripcion != null ? dmDescripcion.trim() : null;
    }
    
    public void setDmDescripcion(String dmDescripcion) {
        this.dmDescripcion = dmDescripcion != null ? dmDescripcion.trim() : null;
    }
    
    public String getDmCategoria() {
        return dmCategoria != null ? dmCategoria.trim() : null;
    }
    
    public void setDmCategoria(String dmCategoria) {
        this.dmCategoria = dmCategoria != null ? dmCategoria.trim() : null;
    }
    
    public String getDmLatitud() {
        return dmLatitud;
    }
    
    public void setDmLatitud(String dmLatitud) {
        this.dmLatitud = dmLatitud;
    }
    
    public String getDmLongitud() {
        return dmLongitud;
    }
    
    public void setDmLongitud(String dmLongitud) {
        this.dmLongitud = dmLongitud;
    }
    
    public String getDmIdCarrera() {
        return dmIdCarrera;
    }
    
    public void setDmIdCarrera(String dmIdCarrera) {
        this.dmIdCarrera = dmIdCarrera;
    }
    
    public String getDmNombreGrad() {
        return dmNombreGrad;
    }
    
    public void setDmNombreGrad(String dmNombreGrad) {
        this.dmNombreGrad = dmNombreGrad;
    }
    
    public String getDmProfesion() {
        return dmProfesion;
    }
    
    public void setDmProfesion(String dmProfesion) {
        this.dmProfesion = dmProfesion;
    }
    
    public String getDmUrlFoto() {
        return dmUrlFoto;
    }
    
    public void setDmUrlFoto(String dmUrlFoto) {
        this.dmUrlFoto = dmUrlFoto;
    }
    
    public String getDmRespuesta() {
        return dmRespuesta;
    }
    
    public void setDmRespuesta(String dmRespuesta) {
        this.dmRespuesta = dmRespuesta;
    }
    
    public Integer getDmOrdenPreg() {
        return dmOrdenPreg;
    }
    
    public void setDmOrdenPreg(Integer dmOrdenPreg) {
        this.dmOrdenPreg = dmOrdenPreg;
    }
    
    public String getDmCorreoElect() {
        return dmCorreoElect;
    }
    
    public void setDmCorreoElect(String dmCorreoElect) {
        this.dmCorreoElect = dmCorreoElect;
    }
    
    public Integer getDmCodPadreUbu() {
        return dmCodPadreUbu;
    }
    
    public void setDmCodPadreUbu(Integer dmCodPadreUbu) {
        this.dmCodPadreUbu = dmCodPadreUbu;
    }
    
    public String getDmUrlPagWeb() {
        return dmUrlPagWeb;
    }
    
    public void setDmUrlPagWeb(String dmUrlPagWeb) {
        this.dmUrlPagWeb = dmUrlPagWeb;
    }
    
    public String getDmTarget() {
        return dmTarget;
    }
    
    public void setDmTarget(String dmTarget) {
        this.dmTarget = dmTarget;
    }
    
    public String getDmTipoArchv() {
        return dmTipoArchv;
    }
    
    public void setDmTipoArchv(String dmTipoArchv) {
        this.dmTipoArchv = dmTipoArchv;
    }
    
    public String getDmUrlDirect() {
        return dmUrlDirect;
    }
    
    public void setDmUrlDirect(String dmUrlDirect) {
        this.dmUrlDirect = dmUrlDirect;
    }
    
    public Integer getDmDeshabUbu() {
        return dmDeshabUbu;
    }
    
    public void setDmDeshabUbu(Integer dmDeshabUbu) {
        this.dmDeshabUbu = dmDeshabUbu;
    }
    
    public int getDmEstado() {
        return dmEstado;
    }
    
    public void setDmEstado(int dmEstado) {
        this.dmEstado = dmEstado;
    }
    
    public Set<Autoridad> getDpListadoAutoridades() {
        return dpListadoAutoridades;
    }
    
    public void setDpListadoAutoridades(Set<Autoridad> dpListadoAutoridades) {
        this.dpListadoAutoridades = dpListadoAutoridades;
    }
    
    public Set<Organigrama> getDpListadoOrganigramas() {
        return dpListadoOrganigramas;
    }
    
    public void setDpListadoOrganigramas(Set<Organigrama> dpListadoOrganigramas) {
        this.dpListadoOrganigramas = dpListadoOrganigramas;
    }
    
    public List<VideoInfm> getDpListadoVideos() {
        return dpListadoVideos;
    }
    
    public void setDpListadoVideos(List<VideoInfm> dpListadoVideos) {
        this.dpListadoVideos = dpListadoVideos;
    }
    
    public UUID getDpCodAreaInt() {
        return dpCodAreaInt;
    }
    
    public void setDpCodAreaInt(UUID dpCodAreaInt) {
        this.dpCodAreaInt = dpCodAreaInt;
    }
    
    public String getDmDescTramite() {
        return dmDescTramite;
    }
    
    public void setDmDescTramite(String dmDescTramite) {
        this.dmDescTramite = dmDescTramite;
    }

    public String getDmDescripcionEn() {
        return dmDescripcionEn != null ? dmDescripcionEn.trim() : null;
    }

    public void setDmDescripcionEn(String dmDescripcionEn) {
        this.dmDescripcionEn = dmDescripcionEn != null ? dmDescripcionEn.trim() : null;
    }

    public String getDmDescripcionPt() {
        return dmDescripcionPt != null ? dmDescripcionPt.trim() : null;
    }

    public void setDmDescripcionPt(String dmDescripcionPt) {
        this.dmDescripcionPt = dmDescripcionPt != null ? dmDescripcionPt.trim() : null;
    }

    public String getDmRespuestaEn() {
        return dmRespuestaEn;
    }

    public void setDmRespuestaEn(String dmRespuestaEn) {
        this.dmRespuestaEn = dmRespuestaEn;
    }

    public String getDmRespuestaPt() {
        return dmRespuestaPt;
    }

    public void setDmRespuestaPt(String dmRespuestaPt) {
        this.dmRespuestaPt = dmRespuestaPt;
    }

    public String getDmDescTramiteEn() {
        return dmDescTramiteEn;
    }

    public void setDmDescTramiteEn(String dmDescTramiteEn) {
        this.dmDescTramiteEn = dmDescTramiteEn;
    }

    public String getDmDescTramitePt() {
        return dmDescTramitePt;
    }

    public void setDmDescTramitePt(String dmDescTramitePt) {
        this.dmDescTramitePt = dmDescTramitePt;
    }

    public String getDmProfesionEn() {
        return dmProfesionEn;
    }

    public void setDmProfesionEn(String dmProfesionEn) {
        this.dmProfesionEn = dmProfesionEn;
    }

    public String getDmProfesionPt() {
        return dmProfesionPt;
    }

    public void setDmProfesionPt(String dmProfesionPt) {
        this.dmProfesionPt = dmProfesionPt;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="METHODS">
    @Override
    public String toString() {
        return "DatosMult{" + "dmCodgDato=" + dmCodgDato + ", dmDescripcion=" + dmDescripcion + ", dmCategoria=" + dmCategoria + ", dmLatitud=" + dmLatitud + ", dmLongitud=" + dmLongitud + ", dmIdCarrera=" + dmIdCarrera + ", dmNombreGrad=" + dmNombreGrad + ", dmProfesion=" + dmProfesion + ", dmUrlFoto=" + dmUrlFoto + ", dmRespuesta=" + dmRespuesta + ", dmOrdenPreg=" + dmOrdenPreg + ", dmCorreoElect=" + dmCorreoElect + ", dmCodPadreUbu=" + dmCodPadreUbu + ", dmUrlPagWeb=" + dmUrlPagWeb + ", dmTarget=" + dmTarget + ", dmTipoArchv=" + dmTipoArchv + ", dmUrlDirect=" + dmUrlDirect + ", dmDeshabUbu=" + dmDeshabUbu + ", dmEstado=" + dmEstado + ", dpListadoAutoridades=" + dpListadoAutoridades + ", dpListadoOrganigramas=" + dpListadoOrganigramas + ", dpListadoVideos=" + dpListadoVideos + '}';
    }
//</editor-fold>
    
}
