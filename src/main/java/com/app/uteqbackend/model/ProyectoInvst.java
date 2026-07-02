package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "wp_proyecto_invest")
public class ProyectoInvst implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Id
    @Column(name = "id_proyecto", nullable = false, updatable = false)
    private UUID ptCodigo;
    
    @ManyToOne
    @JoinColumn(name = "id_grupo")
    @JsonIgnoreProperties("giListadoProyectosInv")
    private GrupoInv ptGrupoInv;
    
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "id_carrera", insertable = false, updatable = false),
        @JoinColumn(name = "id_departamento", insertable = false, updatable = false)
    })
    @JsonIgnoreProperties("crListadoProyectosInv")
    private Carrera ptCarrera;
    
    @Column(name = "nombre", nullable = false)
    private String ptNombre;
    
    @Column(name = "nombre_en", nullable = false)
    private String ptNombreEn;
    
    @Column(name = "nombre_pt", nullable = false)
    private String ptNombrePt;
    
    @Column(name = "url_parcial", nullable = false, columnDefinition = "CHAR(100) UNIQUE")
    private String ptUrlParcial;
    
    @Column(name = "fecha_inicio", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ptFechaInicio;
    
    @Column(name = "fecha_finz", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ptFechaFinlz;
    
    @Column(name = "avance", nullable = false, columnDefinition = "CHAR(12) CHECK(avance IN ('En ejecución','En cierre','Detenido','Finalizado'))")
    private String ptAvance;
    
    @Column(name = "avance_en", nullable = false, columnDefinition = "CHAR(12) CHECK(avance IN ('En ejecución','En cierre','Detenido','Finalizado'))")
    private String ptAvanceEn;
    
    @Column(name = "avance_pt", nullable = false, columnDefinition = "CHAR(12) CHECK(avance IN ('En ejecución','En cierre','Detenido','Finalizado'))")
    private String ptAvancePt;
    
    @Column(name = "monto_aprob", nullable = true)
    private Double ptMonto;
    
    @Column(name = "resumen", nullable = true)
    private String ptResumenSem;
    
    @Column(name = "resumen_en", nullable = true)
    private String ptResumenSemEn;
    
    @Column(name = "resumen_pt", nullable = true)
    private String ptResumenSemPt;
    
    @Column(name = "integrantes", nullable = true)
    private String ptIntegrantes;
    
    @Column(name = "integrantes_en", nullable = true)
    private String ptIntegrantesEn;
    
    @Column(name = "integrantes_pt", nullable = true)
    private String ptIntegrantesPt;
    
    @Column(name = "correo_dirt", nullable = true)
    private String ptCorreoDir;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK (estado IN (0,1))")
    private int ptEstado;
    
    @OneToMany(mappedBy = "psProyectoInvst", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ProduccionCtf> ptListadoProdCtf = new HashSet<ProduccionCtf>();
    
    @OneToMany(mappedBy = "gpiProyectoInvst", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<GaleriaPI> ptListadoEvds = new HashSet<GaleriaPI>();
    
    @Column(name = "convocatoria", nullable = true)
    private String ptConvocatoria;
    
    @Column(name = "convocatoria_en", nullable = true)
    private String ptConvocatoriaEn;
    
    @Column(name = "convocatoria_pt", nullable = true)
    private String ptConvocatoriaPt;
    
    public ProyectoInvst() {
        super();
    }
    
    public ProyectoInvst(String ptUrlParcial) {
        super();
        this.ptUrlParcial = ptUrlParcial;
    }
    
    public ProyectoInvst(UUID ptCodigo, GrupoInv ptGrupoInv, Carrera ptCarrera, String ptNombre, String ptUrlParcial, LocalDateTime ptFechaInicio, LocalDateTime ptFechaFinlz, String ptAvance, Double ptMonto, String ptResumenSem, String ptIntegrantes, String ptCorreoDir, int ptEstado) {
        super();
        this.ptCodigo = ptCodigo;
        this.ptGrupoInv = ptGrupoInv;
        this.ptCarrera = ptCarrera;
        this.ptNombre = ptNombre;
        this.ptUrlParcial = ptUrlParcial;
        this.ptFechaInicio = ptFechaInicio;
        this.ptFechaFinlz = ptFechaFinlz;
        this.ptAvance = ptAvance;
        this.ptMonto = ptMonto;
        this.ptResumenSem = ptResumenSem;
        this.ptIntegrantes = ptIntegrantes;
        this.ptCorreoDir = ptCorreoDir;
        this.ptEstado = ptEstado;
    }

    public ProyectoInvst(GrupoInv ptGrupoInv, Carrera ptCarrera, String ptNombre, String ptNombreEn, String ptNombrePt, LocalDateTime ptFechaInicio, LocalDateTime ptFechaFinlz, String ptAvance, String ptAvanceEn, String ptAvancePt, Double ptMonto, String ptResumenSem, String ptResumenSemEn, String ptResumenSemPt, String ptIntegrantes, String ptIntegrantesEn, String ptIntegrantesPt, String ptCorreoDir) {
        super();
        this.ptGrupoInv = ptGrupoInv;
        this.ptCarrera = ptCarrera;
        this.ptNombre = ptNombre;
        this.ptNombreEn = ptNombreEn;
        this.ptNombrePt = ptNombrePt;
        this.ptFechaInicio = ptFechaInicio;
        this.ptFechaFinlz = ptFechaFinlz;
        this.ptAvance = ptAvance;
        this.ptAvanceEn = ptAvanceEn;
        this.ptAvancePt = ptAvancePt;
        this.ptMonto = ptMonto;
        this.ptResumenSem = ptResumenSem;
        this.ptResumenSemEn = ptResumenSemEn;
        this.ptResumenSemPt = ptResumenSemPt;
        this.ptIntegrantes = ptIntegrantes;
        this.ptIntegrantesEn = ptIntegrantesEn;
        this.ptIntegrantesPt = ptIntegrantesPt;
        this.ptCorreoDir = ptCorreoDir;
    }

    public ProyectoInvst(String ptNombre, String ptUrlParcial) {
        super();
        this.ptNombre = ptNombre;
        this.ptUrlParcial = ptUrlParcial;
    }

    public ProyectoInvst(String ptNombre, String ptNombreEn, String ptNombrePt, String ptUrlParcial) {
        super();
        this.ptNombre = ptNombre;
        this.ptNombreEn = ptNombreEn;
        this.ptNombrePt = ptNombrePt;
        this.ptUrlParcial = ptUrlParcial;
    }

    public ProyectoInvst(String ptNombre, String ptNombreEn, String ptNombrePt, String ptUrlParcial, LocalDateTime ptFechaInicio, String ptConvocatoria, String ptConvocatoriaEn, String ptConvocatoriaPt) {
        super();
        this.ptNombre = ptNombre;
        this.ptNombreEn = ptNombreEn;
        this.ptNombrePt = ptNombrePt;
        this.ptUrlParcial = ptUrlParcial;
        this.ptFechaInicio = ptFechaInicio;
        this.ptConvocatoria = ptConvocatoria;
        this.ptConvocatoriaEn = ptConvocatoriaEn;
        this.ptConvocatoriaPt = ptConvocatoriaPt;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public UUID getPtCodigo() {
        return ptCodigo;
    }
    
    public void setPtCodigo(UUID ptCodigo) {
        this.ptCodigo = ptCodigo;
    }
    
    public GrupoInv getPtGrupoInv() {
        return ptGrupoInv;
    }
    
    public void setPtGrupoInv(GrupoInv ptGrupoInv) {
        this.ptGrupoInv = ptGrupoInv;
    }
    
    public Carrera getPtCarrera() {
        return ptCarrera;
    }
    
    public void setPtCarrera(Carrera ptCarrera) {
        this.ptCarrera = ptCarrera;
    }
    
    public String getPtNombre() {
        return ptNombre;
    }
    
    public void setPtNombre(String ptNombre) {
        this.ptNombre = ptNombre;
    }
    
    public String getPtUrlParcial() {
        return ptUrlParcial;
    }
    
    public void setPtUrlParcial(String ptUrlParcial) {
        this.ptUrlParcial = ptUrlParcial;
    }
    
    public LocalDateTime getPtFechaInicio() {
        return ptFechaInicio;
    }
    
    public void setPtFechaInicio(LocalDateTime ptFechaInicio) {
        this.ptFechaInicio = ptFechaInicio;
    }
    
    public LocalDateTime getPtFechaFinlz() {
        return ptFechaFinlz;
    }
    
    public void setPtFechaFinlz(LocalDateTime ptFechaFinlz) {
        this.ptFechaFinlz = ptFechaFinlz;
    }
    
    public String getPtAvance() {
        return ptAvance;
    }
    
    public void setPtAvance(String ptAvance) {
        this.ptAvance = ptAvance;
    }
    
    public Double getPtMonto() {
        return ptMonto;
    }
    
    public void setPtMonto(Double ptMonto) {
        this.ptMonto = ptMonto;
    }
    
    public String getPtResumenSem() {
        return ptResumenSem;
    }
    
    public void setPtResumenSem(String ptResumenSem) {
        this.ptResumenSem = ptResumenSem;
    }
    
    public String getPtIntegrantes() {
        return ptIntegrantes;
    }
    
    public void setPtIntegrantes(String ptIntegrantes) {
        this.ptIntegrantes = ptIntegrantes;
    }
    
    public String getPtCorreoDir() {
        return ptCorreoDir;
    }
    
    public void setPtCorreoDir(String ptCorreoDir) {
        this.ptCorreoDir = ptCorreoDir;
    }
    
    public int getPtEstado() {
        return ptEstado;
    }
    
    public void setPtEstado(int ptEstado) {
        this.ptEstado = ptEstado;
    }
    
    public Set<ProduccionCtf> getPtListadoProdCtf() {
        return ptListadoProdCtf;
    }
    
    public void setPtListadoProdCtf(Set<ProduccionCtf> ptListadoProdCtf) {
        this.ptListadoProdCtf = ptListadoProdCtf;
    }
    
    public Set<GaleriaPI> getPtListadoEvds() {
        return ptListadoEvds;
    }
    
    public void setPtListadoEvds(Set<GaleriaPI> ptListadoEvds) {
        this.ptListadoEvds = ptListadoEvds;
    }
    
    public String getPtNombreEn() {
        return ptNombreEn;
    }

    public void setPtNombreEn(String ptNombreEn) {
        this.ptNombreEn = ptNombreEn;
    }

    public String getPtNombrePt() {
        return ptNombrePt;
    }

    public void setPtNombrePt(String ptNombrePt) {
        this.ptNombrePt = ptNombrePt;
    }

    public String getPtAvanceEn() {
        return ptAvanceEn;
    }

    public void setPtAvanceEn(String ptAvanceEn) {
        this.ptAvanceEn = ptAvanceEn;
    }

    public String getPtAvancePt() {
        return ptAvancePt;
    }

    public void setPtAvancePt(String ptAvancePt) {
        this.ptAvancePt = ptAvancePt;
    }

    public String getPtResumenSemEn() {
        return ptResumenSemEn;
    }

    public void setPtResumenSemEn(String ptResumenSemEn) {
        this.ptResumenSemEn = ptResumenSemEn;
    }

    public String getPtResumenSemPt() {
        return ptResumenSemPt;
    }

    public void setPtResumenSemPt(String ptResumenSemPt) {
        this.ptResumenSemPt = ptResumenSemPt;
    }

    public String getPtIntegrantesEn() {
        return ptIntegrantesEn;
    }

    public void setPtIntegrantesEn(String ptIntegrantesEn) {
        this.ptIntegrantesEn = ptIntegrantesEn;
    }

    public String getPtIntegrantesPt() {
        return ptIntegrantesPt;
    }

    public void setPtIntegrantesPt(String ptIntegrantesPt) {
        this.ptIntegrantesPt = ptIntegrantesPt;
    }
    
    public String getPtConvocatoria() {
        return ptConvocatoria;
    }

    public void setPtConvocatoria(String ptConvocatoria) {
        this.ptConvocatoria = ptConvocatoria;
    }

    public String getPtConvocatoriaEn() {
        return ptConvocatoriaEn;
    }

    public void setPtConvocatoriaEn(String ptConvocatoriaEn) {
        this.ptConvocatoriaEn = ptConvocatoriaEn;
    }

    public String getPtConvocatoriaPt() {
        return ptConvocatoriaPt;
    }

    public void setPtConvocatoriaPt(String ptConvocatoriaPt) {
        this.ptConvocatoriaPt = ptConvocatoriaPt;
    }
//</editor-fold>

}
