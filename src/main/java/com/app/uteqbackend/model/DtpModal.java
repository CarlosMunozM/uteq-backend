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
@Table(name = "wp_dp_modal")
public class DtpModal implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dp_modal")
    private int mdpCodigo;
    
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id_entidad", nullable = false, updatable = false, unique = true)
    private UUID mdpCodEntidad;
    
    @Column(name = "tipo_entidad", nullable = false, columnDefinition = "CHAR(3) CHECK (tipo_entidad IN ('PAG','DEP'))")
    private String mdpTipoEntidad;
    
    @Column(name = "es_slider", nullable = false, columnDefinition = "INT CHECK (es_slider IN (1,0))")
    private int mdpSlider;
    
    @Column(name = "proporcion", nullable = false, columnDefinition = "CHAR(12) CHECK (proporcion IN ('ratio-1x1','ratio-4x3','ratio-16x9','ratio-21x9'))")
    private String mdpProporcion;
    
    @Column(name = "titulo", nullable = true)
    private String mdpTitulo;
    
    @Column(name = "titulo_en", nullable = true)
    private String mdpTituloEn;
    
    @Column(name = "titulo_pt", nullable = true)
    private String mdpTituloPt;
    
    @Column(name = "descripcion", nullable = false)
    private String mdpDescripcion;
    
    @Column(name = "fecha_inicio", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime mdpFechaInicio;
    
    @Column(name = "fecha_fin", nullable = true)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime mdpFechaFin;
    
    @Column(name = "estado", nullable = false, columnDefinition="INT CHECK(estado IN (0,1))")
    private int mdpEstado;
    
    @Column(name = "fecha_reg", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime mdpFechaReg;
    
    @OneToMany(mappedBy = "mdsModal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<DtsModal> mdpDetallesModal = new HashSet<DtsModal>();
    
    public DtpModal() {
        super();
    }
    
    public DtpModal(int mdpCodigo, UUID mdpCodEntidad, String mdpTipoEntidad, int mdpSlider, String mdpProporcion, String mdpTitulo, String mdpDescripcion, /*Date*/LocalDateTime mdpFechaInicio, /*Date*/LocalDateTime mdpFechaFin, int mdpEstado, /*Date*/LocalDateTime mdpFechaReg) {
        super();
        this.mdpCodigo = mdpCodigo;
        this.mdpCodEntidad = mdpCodEntidad;
        this.mdpTipoEntidad = mdpTipoEntidad;
        this.mdpSlider = mdpSlider;
        this.mdpProporcion = mdpProporcion;
        this.mdpTitulo = mdpTitulo;
        this.mdpDescripcion = mdpDescripcion;
        this.mdpFechaInicio = mdpFechaInicio;
        this.mdpFechaFin = mdpFechaFin;
        this.mdpEstado = mdpEstado;
        this.mdpFechaReg = mdpFechaReg;
    }

    public DtpModal(int mdpCodigo, UUID mdpCodEntidad, String mdpTipoEntidad, int mdpSlider, String mdpProporcion, String mdpTitulo, String mdpTituloEn, String mdpTituloPt, String mdpDescripcion, LocalDateTime mdpFechaInicio, LocalDateTime mdpFechaFin, int mdpEstado, LocalDateTime mdpFechaReg) {
        super();
        this.mdpCodigo = mdpCodigo;
        this.mdpCodEntidad = mdpCodEntidad;
        this.mdpTipoEntidad = mdpTipoEntidad;
        this.mdpSlider = mdpSlider;
        this.mdpProporcion = mdpProporcion;
        this.mdpTitulo = mdpTitulo;
        this.mdpTituloEn = mdpTituloEn;
        this.mdpTituloPt = mdpTituloPt;
        this.mdpDescripcion = mdpDescripcion;
        this.mdpFechaInicio = mdpFechaInicio;
        this.mdpFechaFin = mdpFechaFin;
        this.mdpEstado = mdpEstado;
        this.mdpFechaReg = mdpFechaReg;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getMdpCodigo() {
        return mdpCodigo;
    }
    
    public void setMdpCodigo(int mdpCodigo) {
        this.mdpCodigo = mdpCodigo;
    }
    
    public UUID getMdpCodEntidad() {
        return mdpCodEntidad;
    }
    
    public void setMdpCodEntidad(UUID mdpCodEntidad) {
        this.mdpCodEntidad = mdpCodEntidad;
    }
    
    public String getMdpTipoEntidad() {
        return mdpTipoEntidad;
    }
    
    public void setMdpTipoEntidad(String mdpTipoEntidad) {
        this.mdpTipoEntidad = mdpTipoEntidad;
    }
    
    public int getMdpSlider() {
        return mdpSlider;
    }
    
    public void setMdpSlider(int mdpSlider) {
        this.mdpSlider = mdpSlider;
    }
    
    public String getMdpProporcion() {
        return mdpProporcion;
    }
    
    public void setMdpProporcion(String mdpProporcion) {
        this.mdpProporcion = mdpProporcion;
    }
    
    public String getMdpTitulo() {
        return mdpTitulo;
    }
    
    public void setMdpTitulo(String mdpTitulo) {
        this.mdpTitulo = mdpTitulo;
    }
    
    public String getMdpDescripcion() {
        return mdpDescripcion;
    }
    
    public void setMdpDescripcion(String mdpDescripcion) {
        this.mdpDescripcion = mdpDescripcion;
    }
    
    public LocalDateTime getMdpFechaInicio() {
        return mdpFechaInicio;
    }
    
    public void setMdpFechaInicio(LocalDateTime mdpFechaInicio) {
        this.mdpFechaInicio = mdpFechaInicio;
    }
    
    public LocalDateTime getMdpFechaFin() {
        return mdpFechaFin;
    }
    
    public void setMdpFechaFin(LocalDateTime mdpFechaFin) {
        this.mdpFechaFin = mdpFechaFin;
    }
    
    public int getMdpEstado() {
        return mdpEstado;
    }
    
    public void setMdpEstado(int mdpEstado) {
        this.mdpEstado = mdpEstado;
    }
    
    public LocalDateTime getMdpFechaReg() {
        return mdpFechaReg;
    }
    
    public void setMdpFechaReg(LocalDateTime mdpFechaReg) {
        this.mdpFechaReg = mdpFechaReg;
    }
    
    public Set<DtsModal> getMdpDetallesModal() {
        return mdpDetallesModal;
    }
    
    public void setMdpDetallesModal(Set<DtsModal> mdpDetallesModal) {
        this.mdpDetallesModal = mdpDetallesModal;
    }
    
    public String getMdpTituloEn() {
        return mdpTituloEn;
    }

    public void setMdpTituloEn(String mdpTituloEn) {
        this.mdpTituloEn = mdpTituloEn;
    }

    public String getMdpTituloPt() {
        return mdpTituloPt;
    }

    public void setMdpTituloPt(String mdpTituloPt) {
        this.mdpTituloPt = mdpTituloPt;
    }
//</editor-fold>

}
