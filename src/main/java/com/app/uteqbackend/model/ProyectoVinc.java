package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "wp_proyecto_vinc")
public class ProyectoVinc implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Id
    @Column(name = "id_proyecto_vinc", nullable = false, updatable = false)
    private UUID pvCodigo;
    
    @Column(name = "titulo", nullable = false)
    private String pvTitulo;
    
    @Column(name = "titulo_en", nullable = false)
    private String pvTituloEn;
    
    @Column(name = "titulo_pt", nullable = false)
    private String pvTituloPt;
    
    @Column(name = "url_parcial", nullable = false, columnDefinition = "CHAR(100) UNIQUE")
    private String pvUrlParcial;
    
    @Column(name = "codigo", nullable = false)
    private String pvCodigoUniv;
    
    @Column(name = "identf_pv", nullable = false)
    private int pvIdentf;
    
    @Column(name = "estado_proy", nullable = false, columnDefinition = "CHAR(12) CHECK(estado_proy IN ('En ejecución','En cierre','Detenido','Finalizado'))")
    private String pvEstadoProy;
    
    @Column(name = "estado_proy_en", nullable = false)
    private String pvEstadoProyEn;
    
    @Column(name = "estado_proy_pt", nullable = false)
    private String pvEstadoProyPt;
    
    @Column(name = "facultad", nullable = true)
    private String pvFacultad;
    
    @Column(name = "facultad_en", nullable = true)
    private String pvFacultadEn;
    
    @Column(name = "facultad_pt", nullable = true)
    private String pvFacultadPt;
    
    @Column(name = "carrera", nullable = true)
    private String pvCarrera;
    
    @Column(name = "carrera_en", nullable = true)
    private String pvCarreraEn;
    
    @Column(name = "carrera_pt", nullable = true)
    private String pvCarreraPt;
    
    @Column(name = "director", nullable = true)
    private String pvDirector;
    
    @Column(name = "correo_dir", nullable = true)
    private String pvCorreoDir;
    
    @Column(name = "linea_invst", nullable = true)
    private String pvLineaInv;
    
    @Column(name = "linea_invst_en", nullable = true)
    private String pvLineaInvEn;
    
    @Column(name = "linea_invst_pt", nullable = true)
    private String pvLineaInvPt;
    
    @Column(name = "campo_amplio", nullable = true)
    private String pvCampoAmplio;
    
    @Column(name = "campo_amplio_en", nullable = true)
    private String pvCampoAmplioEn;
    
    @Column(name = "campo_amplio_pt", nullable = true)
    private String pvCampoAmplioPt;
    
    @Column(name = "campo_especifico", nullable = true)
    private String pvCampoEspecf;
    
    @Column(name = "campo_especifico_en", nullable = true)
    private String pvCampoEspecfEn;
    
    @Column(name = "campo_especifico_pt", nullable = true)
    private String pvCampoEspecfPt;
    
    @Column(name = "periodo", nullable = true)
    private String pvPeriodo;
    
    @Column(name = "fecha_inicio", nullable = true)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime pvFechaInc;
    
    @Column(name = "fecha_fin", nullable = true)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime pvFechaFin;
    
    @Column(name = "programa", nullable = true)
    private String pvPrograma;
    
    @Column(name = "programa_en", nullable = true)
    private String pvProgramaEn;
    
    @Column(name = "programa_pt", nullable = true)
    private String pvProgramaPt;
    
    @Column(name = "convenios", nullable = true)
    private String pvConvenios;
    
    @Column(name = "num_beneficiarios", nullable = true)
    private Integer pvNumBenefc;
    
    @Column(name = "objetivos", nullable = true)
    private String pvObjetivos;
    
    @Column(name = "objetivos_en", nullable = true)
    private String pvObjetivosEn;
    
    @Column(name = "objetivos_pt", nullable = true)
    private String pvObjetivosPt;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (1,0))")
    private int pvEstadoVis;
    
    @OneToMany(mappedBy = "pcInformPV", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<PublicacionPV> pvListadoPublcs = new HashSet<PublicacionPV>();
    
    @OneToMany(mappedBy = "gpCodPV", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<GaleriaPV> pvListadoEvd = new HashSet<GaleriaPV>();
    
    public ProyectoVinc() {
        super();
    }
    
    public ProyectoVinc(String pvUrlParcial) {
        super();
        this.pvUrlParcial = pvUrlParcial;
    }
    
    public ProyectoVinc(UUID pvCodigo, String pvTitulo, String pvUrlParcial, String pvCodigoUniv, int pvIdentf, String pvEstadoProy, String pvFacultad, String pvCarrera, String pvDirector, String pvCorreoDir, String pvLineaInv, String pvCampoAmplio, String pvCampoEspecf, String pvPeriodo, LocalDateTime pvFechaInc, LocalDateTime pvFechaFin, String pvPrograma, String pvConvenios, Integer pvNumBenefc, String pvObjetivos, int pvEstadoVis, Set<PublicacionPV> pvListadoPublcs) {
        super();
        this.pvCodigo = pvCodigo;
        this.pvTitulo = pvTitulo;
        this.pvUrlParcial = pvUrlParcial;
        this.pvCodigoUniv = pvCodigoUniv;
        this.pvIdentf = pvIdentf;
        this.pvEstadoProy = pvEstadoProy;
        this.pvFacultad = pvFacultad;
        this.pvCarrera = pvCarrera;
        this.pvDirector = pvDirector;
        this.pvCorreoDir = pvCorreoDir;
        this.pvLineaInv = pvLineaInv;
        this.pvCampoAmplio = pvCampoAmplio;
        this.pvCampoEspecf = pvCampoEspecf;
        this.pvPeriodo = pvPeriodo;
        this.pvFechaInc = pvFechaInc;
        this.pvFechaFin = pvFechaFin;
        this.pvPrograma = pvPrograma;
        this.pvConvenios = pvConvenios;
        this.pvNumBenefc = pvNumBenefc;
        this.pvObjetivos = pvObjetivos;
        this.pvEstadoVis = pvEstadoVis;
        this.pvListadoPublcs = pvListadoPublcs;
    }

    public ProyectoVinc(String pvTitulo, String pvUrlParcial) {
        super();
        this.pvTitulo = pvTitulo;
        this.pvUrlParcial = pvUrlParcial;
    }

    public ProyectoVinc(String pvTitulo, String pvTituloEn, String pvTituloPt, String pvUrlParcial) {
        super();
        this.pvTitulo = pvTitulo;
        this.pvTituloEn = pvTituloEn;
        this.pvTituloPt = pvTituloPt;
        this.pvUrlParcial = pvUrlParcial;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public UUID getPvCodigo() {
        return pvCodigo;
    }
    
    public void setPvCodigo(UUID pvCodigo) {
        this.pvCodigo = pvCodigo;
    }
    
    public String getPvTitulo() {
        return pvTitulo;
    }
    
    public void setPvTitulo(String pvTitulo) {
        this.pvTitulo = pvTitulo;
    }
    
    public String getPvUrlParcial() {
        return pvUrlParcial;
    }
    
    public void setPvUrlParcial(String pvUrlParcial) {
        this.pvUrlParcial = pvUrlParcial;
    }
    
    public String getPvCodigoUniv() {
        return pvCodigoUniv;
    }
    
    public void setPvCodigoUniv(String pvCodigoUniv) {
        this.pvCodigoUniv = pvCodigoUniv;
    }
    
    public int getPvIdentf() {
        return pvIdentf;
    }
    
    public void setPvIdentf(int pvIdentf) {
        this.pvIdentf = pvIdentf;
    }
    
    public String getPvEstadoProy() {
        return pvEstadoProy;
    }
    
    public void setPvEstadoProy(String pvEstadoProy) {
        this.pvEstadoProy = pvEstadoProy;
    }
    
    public String getPvFacultad() {
        return pvFacultad;
    }
    
    public void setPvFacultad(String pvFacultad) {
        this.pvFacultad = pvFacultad;
    }
    
    public String getPvCarrera() {
        return pvCarrera;
    }
    
    public void setPvCarrera(String pvCarrera) {
        this.pvCarrera = pvCarrera;
    }
    
    public String getPvDirector() {
        return pvDirector;
    }
    
    public void setPvDirector(String pvDirector) {
        this.pvDirector = pvDirector;
    }
    
    public String getPvCorreoDir() {
        return pvCorreoDir;
    }
    
    public void setPvCorreoDir(String pvCorreoDir) {
        this.pvCorreoDir = pvCorreoDir;
    }
    
    public String getPvLineaInv() {
        return pvLineaInv;
    }
    
    public void setPvLineaInv(String pvLineaInv) {
        this.pvLineaInv = pvLineaInv;
    }
    
    public String getPvCampoAmplio() {
        return pvCampoAmplio;
    }
    
    public void setPvCampoAmplio(String pvCampoAmplio) {
        this.pvCampoAmplio = pvCampoAmplio;
    }
    
    public String getPvCampoEspecf() {
        return pvCampoEspecf;
    }
    
    public void setPvCampoEspecf(String pvCampoEspecf) {
        this.pvCampoEspecf = pvCampoEspecf;
    }
    
    public String getPvPeriodo() {
        return pvPeriodo;
    }
    
    public void setPvPeriodo(String pvPeriodo) {
        this.pvPeriodo = pvPeriodo;
    }
    
    public LocalDateTime getPvFechaInc() {
        return pvFechaInc;
    }
    
    public void setPvFechaInc(LocalDateTime pvFechaInc) {
        this.pvFechaInc = pvFechaInc;
    }
    
    public LocalDateTime getPvFechaFin() {
        return pvFechaFin;
    }
    
    public void setPvFechaFin(LocalDateTime pvFechaFin) {
        this.pvFechaFin = pvFechaFin;
    }
    
    public String getPvPrograma() {
        return pvPrograma;
    }
    
    public void setPvPrograma(String pvPrograma) {
        this.pvPrograma = pvPrograma;
    }
    
    public String getPvConvenios() {
        return pvConvenios;
    }
    
    public void setPvConvenios(String pvConvenios) {
        this.pvConvenios = pvConvenios;
    }
    
    public Integer getPvNumBenefc() {
        return pvNumBenefc;
    }
    
    public void setPvNumBenefc(Integer pvNumBenefc) {
        this.pvNumBenefc = pvNumBenefc;
    }
    
    public String getPvObjetivos() {
        return pvObjetivos;
    }
    
    public void setPvObjetivos(String pvObjetivos) {
        this.pvObjetivos = pvObjetivos;
    }
    
    public int getPvEstadoVis() {
        return pvEstadoVis;
    }
    
    public void setPvEstadoVis(int pvEstadoVis) {
        this.pvEstadoVis = pvEstadoVis;
    }
    
    public Set<PublicacionPV> getPvListadoPublcs() {
        return pvListadoPublcs;
    }
    
    public void setPvListadoPublcs(Set<PublicacionPV> pvListadoPublcs) {
        this.pvListadoPublcs = pvListadoPublcs;
    }
    
    public Set<GaleriaPV> getPvListadoEvd() {
        return pvListadoEvd;
    }
    
    public void setPvListadoEvd(Set<GaleriaPV> pvListadoEvd) {
        this.pvListadoEvd = pvListadoEvd;
    }
    
    public String getPvTituloEn() {
        return pvTituloEn;
    }

    public void setPvTituloEn(String pvTituloEn) {
        this.pvTituloEn = pvTituloEn;
    }

    public String getPvTituloPt() {
        return pvTituloPt;
    }

    public void setPvTituloPt(String pvTituloPt) {
        this.pvTituloPt = pvTituloPt;
    }

    public String getPvEstadoProyEn() {
        return pvEstadoProyEn;
    }

    public void setPvEstadoProyEn(String pvEstadoProyEn) {
        this.pvEstadoProyEn = pvEstadoProyEn;
    }

    public String getPvEstadoProyPt() {
        return pvEstadoProyPt;
    }

    public void setPvEstadoProyPt(String pvEstadoProyPt) {
        this.pvEstadoProyPt = pvEstadoProyPt;
    }

    public String getPvFacultadEn() {
        return pvFacultadEn;
    }

    public void setPvFacultadEn(String pvFacultadEn) {
        this.pvFacultadEn = pvFacultadEn;
    }

    public String getPvFacultadPt() {
        return pvFacultadPt;
    }

    public void setPvFacultadPt(String pvFacultadPt) {
        this.pvFacultadPt = pvFacultadPt;
    }

    public String getPvCarreraEn() {
        return pvCarreraEn;
    }

    public void setPvCarreraEn(String pvCarreraEn) {
        this.pvCarreraEn = pvCarreraEn;
    }

    public String getPvCarreraPt() {
        return pvCarreraPt;
    }

    public void setPvCarreraPt(String pvCarreraPt) {
        this.pvCarreraPt = pvCarreraPt;
    }

    public String getPvLineaInvEn() {
        return pvLineaInvEn;
    }

    public void setPvLineaInvEn(String pvLineaInvEn) {
        this.pvLineaInvEn = pvLineaInvEn;
    }

    public String getPvLineaInvPt() {
        return pvLineaInvPt;
    }

    public void setPvLineaInvPt(String pvLineaInvPt) {
        this.pvLineaInvPt = pvLineaInvPt;
    }

    public String getPvCampoAmplioEn() {
        return pvCampoAmplioEn;
    }

    public void setPvCampoAmplioEn(String pvCampoAmplioEn) {
        this.pvCampoAmplioEn = pvCampoAmplioEn;
    }

    public String getPvCampoAmplioPt() {
        return pvCampoAmplioPt;
    }

    public void setPvCampoAmplioPt(String pvCampoAmplioPt) {
        this.pvCampoAmplioPt = pvCampoAmplioPt;
    }

    public String getPvCampoEspecfEn() {
        return pvCampoEspecfEn;
    }

    public void setPvCampoEspecfEn(String pvCampoEspecfEn) {
        this.pvCampoEspecfEn = pvCampoEspecfEn;
    }

    public String getPvCampoEspecfPt() {
        return pvCampoEspecfPt;
    }

    public void setPvCampoEspecfPt(String pvCampoEspecfPt) {
        this.pvCampoEspecfPt = pvCampoEspecfPt;
    }

    public String getPvProgramaEn() {
        return pvProgramaEn;
    }

    public void setPvProgramaEn(String pvProgramaEn) {
        this.pvProgramaEn = pvProgramaEn;
    }

    public String getPvProgramaPt() {
        return pvProgramaPt;
    }

    public void setPvProgramaPt(String pvProgramaPt) {
        this.pvProgramaPt = pvProgramaPt;
    }

    public String getPvObjetivosEn() {
        return pvObjetivosEn;
    }

    public void setPvObjetivosEn(String pvObjetivosEn) {
        this.pvObjetivosEn = pvObjetivosEn;
    }

    public String getPvObjetivosPt() {
        return pvObjetivosPt;
    }

    public void setPvObjetivosPt(String pvObjetivosPt) {
        this.pvObjetivosPt = pvObjetivosPt;
    }
    
//</editor-fold>
    
}
