package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_servicio_med")
public class ServicioMed implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_serv_med")
    private Integer smCodigo;
    
    @ManyToOne
    @JoinColumn(name = "id_area_int")
    @JsonIgnoreProperties("pwListadoServMed")
    private PagWeb smPaginaWeb;
    
    @Column(name = "nombre", nullable = false, length = 300)
    private String smNombre;
    
    @Column(name = "nombre_en", nullable = false, length = 300)
    private String smNombreEn;
    
    @Column(name = "nombre_pt", nullable = false, length = 300)
    private String smNombrePt;
    
    @Column(name = "descripcion", nullable = false)
    private String smDescripcion;
    
    @Column(name = "descripcion_en", nullable = false)
    private String smDescripcionEn;
    
    @Column(name = "descripcion_pt", nullable = false)
    private String smDescripcionPt;
    
    @Column(name = "objetivos", nullable = true)
    private String smObjetivos;
    
    @Column(name = "objetivos_en", nullable = true)
    private String smObjetivosEn;
    
    @Column(name = "objetivos_pt", nullable = true)
    private String smObjetivosPt;
    
    @Column(name = "servicios", nullable = true)
    private String smServicios;
    
    @Column(name = "servicios_en", nullable = true)
    private String smServiciosEn;
    
    @Column(name = "servicios_pt", nullable = true)
    private String smServiciosPt;
    
    @Column(name = "horario", nullable = true, length = 500)
    private String smHorario;
    
    @Column(name = "horario_en", nullable = true, length = 500)
    private String smHorarioEn;
    
    @Column(name = "horario_pt", nullable = true, length = 500)
    private String smHorarioPt;
    
    @Column(name = "correos", nullable = true, length = 500)
    private String smCorreos;
    
    @Column(name = "frase_infm", nullable = true, length = 500)
    private String smFraseInfm;
    
    @Column(name = "frase_infm_en", nullable = true, length = 500)
    private String smFraseInfmEn;
    
    @Column(name = "frase_infm_pt", nullable = true, length = 500)
    private String smFraseInfmPt;
    
    @Column(name = "orden", nullable = false)
    private int smOrden;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (0,1))")
    private int smEstado;
    
    public ServicioMed() {
        super();
    }
    
    public ServicioMed(Integer smCodigo, PagWeb smPaginaWeb, String smNombre, String smDescripcion, String smObjetivos, String smServicios, String smHorario, String smCorreos, String smFraseInfm, int smOrden, int smEstado) {
        super();
        this.smCodigo = smCodigo;
        this.smPaginaWeb = smPaginaWeb;
        this.smNombre = smNombre;
        this.smDescripcion = smDescripcion;
        this.smObjetivos = smObjetivos;
        this.smServicios = smServicios;
        this.smHorario = smHorario;
        this.smCorreos = smCorreos;
        this.smFraseInfm = smFraseInfm;
        this.smOrden = smOrden;
        this.smEstado = smEstado;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public Integer getSmCodigo() {
        return smCodigo;
    }
    
    public void setSmCodigo(Integer smCodigo) {
        this.smCodigo = smCodigo;
    }
    
    public PagWeb getSmPaginaWeb() {
        return smPaginaWeb;
    }
    
    public void setSmPaginaWeb(PagWeb smPaginaWeb) {
        this.smPaginaWeb = smPaginaWeb;
    }
    
    public String getSmNombre() {
        return smNombre;
    }
    
    public void setSmNombre(String smNombre) {
        this.smNombre = smNombre;
    }
    
    public String getSmDescripcion() {
        return smDescripcion;
    }
    
    public void setSmDescripcion(String smDescripcion) {
        this.smDescripcion = smDescripcion;
    }
    
    public String getSmObjetivos() {
        return smObjetivos;
    }
    
    public void setSmObjetivos(String smObjetivos) {
        this.smObjetivos = smObjetivos;
    }
    
    public String getSmServicios() {
        return smServicios;
    }
    
    public void setSmServicios(String smServicios) {
        this.smServicios = smServicios;
    }
    
    public String getSmHorario() {
        return smHorario;
    }
    
    public void setSmHorario(String smHorario) {
        this.smHorario = smHorario;
    }
    
    public String getSmCorreos() {
        return smCorreos;
    }
    
    public void setSmCorreos(String smCorreos) {
        this.smCorreos = smCorreos;
    }
    
    public String getSmFraseInfm() {
        return smFraseInfm;
    }
    
    public void setSmFraseInfm(String smFraseInfm) {
        this.smFraseInfm = smFraseInfm;
    }
    
    public int getSmOrden() {
        return smOrden;
    }
    
    public void setSmOrden(int smOrden) {
        this.smOrden = smOrden;
    }
    
    public int getSmEstado() {
        return smEstado;
    }
    
    public void setSmEstado(int smEstado) {
        this.smEstado = smEstado;
    }
    
    public String getSmNombreEn() {
        return smNombreEn;
    }

    public void setSmNombreEn(String smNombreEn) {
        this.smNombreEn = smNombreEn;
    }

    public String getSmNombrePt() {
        return smNombrePt;
    }

    public void setSmNombrePt(String smNombrePt) {
        this.smNombrePt = smNombrePt;
    }

    public String getSmDescripcionEn() {
        return smDescripcionEn;
    }

    public void setSmDescripcionEn(String smDescripcionEn) {
        this.smDescripcionEn = smDescripcionEn;
    }

    public String getSmDescripcionPt() {
        return smDescripcionPt;
    }

    public void setSmDescripcionPt(String smDescripcionPt) {
        this.smDescripcionPt = smDescripcionPt;
    }

    public String getSmObjetivosEn() {
        return smObjetivosEn;
    }

    public void setSmObjetivosEn(String smObjetivosEn) {
        this.smObjetivosEn = smObjetivosEn;
    }

    public String getSmObjetivosPt() {
        return smObjetivosPt;
    }

    public void setSmObjetivosPt(String smObjetivosPt) {
        this.smObjetivosPt = smObjetivosPt;
    }

    public String getSmServiciosEn() {
        return smServiciosEn;
    }

    public void setSmServiciosEn(String smServiciosEn) {
        this.smServiciosEn = smServiciosEn;
    }

    public String getSmServiciosPt() {
        return smServiciosPt;
    }

    public void setSmServiciosPt(String smServiciosPt) {
        this.smServiciosPt = smServiciosPt;
    }

    public String getSmHorarioEn() {
        return smHorarioEn;
    }

    public void setSmHorarioEn(String smHorarioEn) {
        this.smHorarioEn = smHorarioEn;
    }

    public String getSmHorarioPt() {
        return smHorarioPt;
    }

    public void setSmHorarioPt(String smHorarioPt) {
        this.smHorarioPt = smHorarioPt;
    }

    public String getSmFraseInfmEn() {
        return smFraseInfmEn;
    }

    public void setSmFraseInfmEn(String smFraseInfmEn) {
        this.smFraseInfmEn = smFraseInfmEn;
    }

    public String getSmFraseInfmPt() {
        return smFraseInfmPt;
    }

    public void setSmFraseInfmPt(String smFraseInfmPt) {
        this.smFraseInfmPt = smFraseInfmPt;
    }
    
//</editor-fold>

}
