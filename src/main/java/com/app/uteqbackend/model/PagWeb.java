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
@Table(name = "wp_area_int")
public class PagWeb implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Id
    @Column(name = "id_area_int", nullable = false, updatable = false)
    private UUID pwCodigo;
    
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id_entidad", nullable = true)
    private UUID pwCodEntidad;
    
    @Column(name = "nombre", nullable = false, length = 500)
    private String pwNombre;
    
    @Column(name = "nombre_en", nullable = false, length = 500)
    private String pwNombreEn;
    
    @Column(name = "nombre_pt", nullable = false, length = 500)
    private String pwNombrePt;
    
    @Column(name = "descripcion", nullable = false)
    private String pwDescripcion;
    
    @Column(name = "descripcion_en", nullable = false)
    private String pwDescripcionEn;
    
    @Column(name = "descripcion_pt", nullable = false)
    private String pwDescripcionPt;
    
    @Column(name = "frase_desc", nullable = true, length = 500)
    private String pwFraseDesc;
    
    @Column(name = "frase_desc_en", nullable = true, length = 500)
    private String pwFraseDescEn;
    
    @Column(name = "frase_desc_pt", nullable = true, length = 500)
    private String pwFraseDescPt;
    
    @Column(name = "eventos", nullable = true)
    private String pwEventos;
    
    @Column(name = "eventos_en", nullable = true)
    private String pwEventosEn;
    
    @Column(name = "eventos_pt", nullable = true)
    private String pwEventosPt;
    
    @Column(name = "objetivos", nullable = true)
    private String pwObjetivos;
    
    @Column(name = "objetivos_en", nullable = true)
    private String pwObjetivosEn;
    
    @Column(name = "objetivos_pt", nullable = true)
    private String pwObjetivosPt;
    
    @Column(name = "servicios", nullable = true)
    private String pwServicios;
    
    @Column(name = "servicios_en", nullable = true)
    private String pwServiciosEn;
    
    @Column(name = "servicios_pt", nullable = true)
    private String pwServiciosPt;
    
    @Column(name = "horario", nullable = true, length = 500)
    private String pwHorario;
    
    @Column(name = "horario_en", nullable = true, length = 500)
    private String pwHorarioEn;
    
    @Column(name = "horario_pt", nullable = true, length = 500)
    private String pwHorarioPt;
    
    @Column(name = "correos", nullable = true, length = 500)
    private String pwCorreos;
    
    @Column(name = "responsables", nullable = true, length = 1000)
    private String pwResponsables;
    
    @Column(name = "responsables_en", nullable = true, length = 1000)
    private String pwResponsablesEn;
    
    @Column(name = "responsables_pt", nullable = true, length = 1000)
    private String pwResponsablesPt;
    
    @Column(name = "mision", nullable = true)
    private String pwMision;
    
    @Column(name = "mision_en", nullable = true)
    private String pwMisionEn;
    
    @Column(name = "mision_pt", nullable = true)
    private String pwMisionPt;
    
    @Column(name = "vision", nullable = true)
    private String pwVision;
    
    @Column(name = "vision_en", nullable = true)
    private String pwVisionEn;
    
    @Column(name = "vision_pt", nullable = true)
    private String pwVisionPt;
    
    @Column(name = "tipo_entd", nullable = false, columnDefinition = "CHAR(4) CHECK(tipo_entd IN ('DEPT','CARR','OTRO','UBU','RCT'))")
    private String pwTipoEntd;
    
    @Column(name = "estado", nullable = false, columnDefinition = "CHECK(estado IN (0,1))")
    private int pwEstado;
    
    @Column(name = "cod_menu_asoc", nullable = true)
    private Integer pwCodMenu;
    
    @OneToMany(mappedBy = "smPaginaWeb", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<ServicioMed> pwListadoServMed = new HashSet<ServicioMed>();
    
    @OneToMany(mappedBy = "objAreaRelc", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Evento> pwListadoArea = new HashSet<Evento>();
    
    @Column(name = "img_banner", nullable = true, columnDefinition = "VARCHAR(100) DEFAULT '#'")
    private String pwImgBanner;
    
    @Column(name = "url_pag", nullable = true, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String pwUrlPag;
    
    public PagWeb() {
        super();
    }
    
    public PagWeb(String pwUrlPag) {
        super();
        this.pwUrlPag = pwUrlPag;
    }
    
    public PagWeb(UUID pwCodigo, UUID pwCodEntidad, String pwNombre, String pwDescripcion, String pwFraseDesc, String pwEventos, String pwObjetivos, String pwServicios, String pwHorario, String pwCorreos, String pwResponsables, String pwMision, String pwVision, String pwTipoEntd, int pwEstado, Integer pwCodMenu, String pwImgBanner, String pwUrlPag) {
        super();
        this.pwCodigo = pwCodigo;
        this.pwCodEntidad = pwCodEntidad;
        this.pwNombre = pwNombre;
        this.pwDescripcion = pwDescripcion;
        this.pwFraseDesc = pwFraseDesc;
        this.pwEventos = pwEventos;
        this.pwObjetivos = pwObjetivos;
        this.pwServicios = pwServicios;
        this.pwHorario = pwHorario;
        this.pwCorreos = pwCorreos;
        this.pwResponsables = pwResponsables;
        this.pwMision = pwMision;
        this.pwVision = pwVision;
        this.pwTipoEntd = pwTipoEntd;
        this.pwEstado = pwEstado;
        this.pwCodMenu = pwCodMenu;
        this.pwImgBanner = pwImgBanner;
        this.pwUrlPag = pwUrlPag;
    }

    public PagWeb(String pwNombre, String pwUrlPag) {
        super();
        this.pwNombre = pwNombre;
        this.pwUrlPag = pwUrlPag;
    }

    public PagWeb(String pwNombre, String pwNombreEn, String pwNombrePt, String pwUrlPag) {
        super();
        this.pwNombre = pwNombre;
        this.pwNombreEn = pwNombreEn;
        this.pwNombrePt = pwNombrePt;
        this.pwUrlPag = pwUrlPag;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public UUID getPwCodigo() {
        return pwCodigo;
    }
    
    public void setPwCodigo(UUID pwCodigo) {
        this.pwCodigo = pwCodigo;
    }
    
    public UUID getPwCodEntidad() {
        return pwCodEntidad;
    }
    
    public void setPwCodEntidad(UUID pwCodEntidad) {
        this.pwCodEntidad = pwCodEntidad;
    }
    
    public String getPwNombre() {
        return pwNombre;
    }
    
    public void setPwNombre(String pwNombre) {
        this.pwNombre = pwNombre;
    }
    
    public String getPwDescripcion() {
        return pwDescripcion;
    }
    
    public void setPwDescripcion(String pwDescripcion) {
        this.pwDescripcion = pwDescripcion;
    }
    
    public String getPwFraseDesc() {
        return pwFraseDesc;
    }
    
    public void setPwFraseDesc(String pwFraseDesc) {
        this.pwFraseDesc = pwFraseDesc;
    }
    
    public String getPwEventos() {
        return pwEventos;
    }
    
    public void setPwEventos(String pwEventos) {
        this.pwEventos = pwEventos;
    }
    
    public String getPwObjetivos() {
        return pwObjetivos;
    }
    
    public void setPwObjetivos(String pwObjetivos) {
        this.pwObjetivos = pwObjetivos;
    }
    
    public String getPwServicios() {
        return pwServicios;
    }
    
    public void setPwServicios(String pwServicios) {
        this.pwServicios = pwServicios;
    }
    
    public String getPwHorario() {
        return pwHorario;
    }
    
    public void setPwHorario(String pwHorario) {
        this.pwHorario = pwHorario;
    }
    
    public String getPwCorreos() {
        return pwCorreos;
    }
    
    public void setPwCorreos(String pwCorreos) {
        this.pwCorreos = pwCorreos;
    }
    
    public String getPwResponsables() {
        return pwResponsables;
    }
    
    public void setPwResponsables(String pwResponsables) {
        this.pwResponsables = pwResponsables;
    }
    
    public String getPwMision() {
        return pwMision;
    }
    
    public void setPwMision(String pwMision) {
        this.pwMision = pwMision;
    }
    
    public String getPwVision() {
        return pwVision;
    }
    
    public void setPwVision(String pwVision) {
        this.pwVision = pwVision;
    }
    
    public String getPwTipoEntd() {
        return pwTipoEntd;
    }
    
    public void setPwTipoEntd(String pwTipoEntd) {
        this.pwTipoEntd = pwTipoEntd;
    }
    
    public int getPwEstado() {
        return pwEstado;
    }
    
    public void setPwEstado(int pwEstado) {
        this.pwEstado = pwEstado;
    }
    
    public Integer getPwCodMenu() {
        return pwCodMenu;
    }
    
    public void setPwCodMenu(Integer pwCodMenu) {
        this.pwCodMenu = pwCodMenu;
    }
    
    public Set<ServicioMed> getPwListadoServMed() {
        return pwListadoServMed;
    }
    
    public void setPwListadoServMed(Set<ServicioMed> pwListadoServMed) {
        this.pwListadoServMed = pwListadoServMed;
    }
    
    public Set<Evento> getPwListadoArea() {
        return pwListadoArea;
    }
    
    public void setPwListadoArea(Set<Evento> pwListadoArea) {
        this.pwListadoArea = pwListadoArea;
    }
    
    public String getPwImgBanner() {
        return pwImgBanner;
    }
    
    public void setPwImgBanner(String pwImgBanner) {
        this.pwImgBanner = pwImgBanner;
    }
    
    public String getPwUrlPag() {
        return pwUrlPag;
    }
    
    public void setPwUrlPag(String pwUrlPag) {
        this.pwUrlPag = pwUrlPag;
    }
    
    public String getPwNombreEn() {
        return pwNombreEn;
    }

    public void setPwNombreEn(String pwNombreEn) {
        this.pwNombreEn = pwNombreEn;
    }

    public String getPwNombrePt() {
        return pwNombrePt;
    }

    public void setPwNombrePt(String pwNombrePt) {
        this.pwNombrePt = pwNombrePt;
    }

    public String getPwDescripcionEn() {
        return pwDescripcionEn;
    }

    public void setPwDescripcionEn(String pwDescripcionEn) {
        this.pwDescripcionEn = pwDescripcionEn;
    }

    public String getPwDescripcionPt() {
        return pwDescripcionPt;
    }

    public void setPwDescripcionPt(String pwDescripcionPt) {
        this.pwDescripcionPt = pwDescripcionPt;
    }

    public String getPwFraseDescEn() {
        return pwFraseDescEn;
    }

    public void setPwFraseDescEn(String pwFraseDescEn) {
        this.pwFraseDescEn = pwFraseDescEn;
    }

    public String getPwFraseDescPt() {
        return pwFraseDescPt;
    }

    public void setPwFraseDescPt(String pwFraseDescPt) {
        this.pwFraseDescPt = pwFraseDescPt;
    }

    public String getPwEventosEn() {
        return pwEventosEn;
    }

    public void setPwEventosEn(String pwEventosEn) {
        this.pwEventosEn = pwEventosEn;
    }

    public String getPwEventosPt() {
        return pwEventosPt;
    }

    public void setPwEventosPt(String pwEventosPt) {
        this.pwEventosPt = pwEventosPt;
    }

    public String getPwObjetivosEn() {
        return pwObjetivosEn;
    }

    public void setPwObjetivosEn(String pwObjetivosEn) {
        this.pwObjetivosEn = pwObjetivosEn;
    }

    public String getPwObjetivosPt() {
        return pwObjetivosPt;
    }

    public void setPwObjetivosPt(String pwObjetivosPt) {
        this.pwObjetivosPt = pwObjetivosPt;
    }

    public String getPwServiciosEn() {
        return pwServiciosEn;
    }

    public void setPwServiciosEn(String pwServiciosEn) {
        this.pwServiciosEn = pwServiciosEn;
    }

    public String getPwServiciosPt() {
        return pwServiciosPt;
    }

    public void setPwServiciosPt(String pwServiciosPt) {
        this.pwServiciosPt = pwServiciosPt;
    }

    public String getPwHorarioEn() {
        return pwHorarioEn;
    }

    public void setPwHorarioEn(String pwHorarioEn) {
        this.pwHorarioEn = pwHorarioEn;
    }

    public String getPwHorarioPt() {
        return pwHorarioPt;
    }

    public void setPwHorarioPt(String pwHorarioPt) {
        this.pwHorarioPt = pwHorarioPt;
    }

    public String getPwResponsablesEn() {
        return pwResponsablesEn;
    }

    public void setPwResponsablesEn(String pwResponsablesEn) {
        this.pwResponsablesEn = pwResponsablesEn;
    }

    public String getPwResponsablesPt() {
        return pwResponsablesPt;
    }

    public void setPwResponsablesPt(String pwResponsablesPt) {
        this.pwResponsablesPt = pwResponsablesPt;
    }

    public String getPwMisionEn() {
        return pwMisionEn;
    }

    public void setPwMisionEn(String pwMisionEn) {
        this.pwMisionEn = pwMisionEn;
    }

    public String getPwMisionPt() {
        return pwMisionPt;
    }

    public void setPwMisionPt(String pwMisionPt) {
        this.pwMisionPt = pwMisionPt;
    }

    public String getPwVisionEn() {
        return pwVisionEn;
    }

    public void setPwVisionEn(String pwVisionEn) {
        this.pwVisionEn = pwVisionEn;
    }

    public String getPwVisionPt() {
        return pwVisionPt;
    }

    public void setPwVisionPt(String pwVisionPt) {
        this.pwVisionPt = pwVisionPt;
    }
//</editor-fold>
    
}
