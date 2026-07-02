package com.app.uteqbackend.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author ANALISTA-TIC 2
 */

@Data
@Entity
@Table(name = "wp_archivo")
public class Archivo implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_archivo")
    private int arCodigo;
    
    @Column(name = "descripcion", nullable = true)
    private String arDescripcion;
    
    @Column(name = "url_documento", nullable = true)
    private String arUrlDocumento;
    
    @Column(name = "fecha_public", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date arFechaPublc;
    
    @Column(name = "anio", nullable = true, columnDefinition = "INT CHECK(anio>1990 AND anio<=CAST(date_part('year', CURRENT_DATE) AS INT))")
    private Integer arAnio;
    
    @Column(name = "mes", nullable = true, columnDefinition = "INT ck_mes CHECK(mes>=1 AND mes<=12)")
    private Integer arMes;
    
    @Column(name = "fase", nullable = true)
    private String arFase;
    
    @Column(name = "informacion", nullable = true)
    private String arInformacion;
    
    @Column(name = "url_ai", nullable = true)
    private String arUrlAI;
    
    @Column(name = "url_png", nullable = true)
    private String arUrlPNG;
    
    @Column(name = "url_jpg", nullable = true)
    private String arUrlJPG;
    
    @Column(name = "target", nullable = true, columnDefinition = "CHAR(7) ck_target CHECK(target IN ('_blank','_self','_parent','_top'))")
    private String arTarget;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT ck_estado CHECK(estado IN (0,1))")
    private int arEstado;
    
    @Column(name = "solicitante", nullable = true)
    private String arSolicitante;
    
    @Column(name = "imagen", nullable = true)
    private String arImagen;
    
    @Column(name = "tipo_res", nullable = true)
    private String arTipoRes;
    
    @Column(name = "sesion_res", nullable = true)
    private String arSesionRes;
    
    @Column(name = "tipo_img", nullable = true, columnDefinition = "CHAR(5) ck_tipo_img CHECK(tipo_img IN ('LOGOT','ARCHV','FORSL','RENCT','TRSPR','COOPI','PLNUN','REGNM','LOGST','TRBSC','PSICG','RESLS','NRMIV','DOCSG'))")
    private String arTipoImg;
    
    @Column(name="url_pag_web_asocd", nullable=true, length = 1000, columnDefinition = "VARCHAR(1000) DEFAULT '#'")
    private String arUrlPW;
    
    @Column(name = "tipo_recurso", nullable = true, columnDefinition = "CHAR(5) ck_tipo_recurso CHECK(tipo_recurso IN ('DOCXS','PGWEB'))")
    private String arTipoRecurso;
    
    @Column(name = "orden_docx", nullable = true)
    private Integer arOrdenDocs;
    
    @Column(name = "descripcion_en", nullable = true)
    private String arDescripcionEn;
    
    @Column(name = "descripcion_pr", nullable = true)
    private String arDescripcionPt;
    
    @Column(name = "fase_en", nullable = true)
    private String arFaseEn;
    
    @Column(name = "fase_pt", nullable = true)
    private String arFasePt;
    
    @Column(name = "informacion_en", nullable = true)
    private String arInformacionEn;
    
    @Column(name = "informacion_pt", nullable = true)
    private String arInformacionPt;
    
    @Column(name = "solicitante_en", nullable = true)
    private String arSolicitanteEn;
    
    @Column(name = "solicitante_pt", nullable = true)
    private String arSolicitantePt;
    
    @Column(name = "tipo_res_en", nullable = true)
    private String arTipoResEn;
    
    @Column(name = "tipo_res_pt", nullable = true)
    private String arTipoResPt;
    
    @Column(name = "sesion_res_en", nullable = true)
    private String arSesionResEn;
    
    @Column(name = "sesion_res_pt", nullable = true)
    private String arSesionResPt;
    
    @Column(name = "url_documento_2", nullable = true)
    private String arUrlDocumento2;
    
    @Column(name = "url_documento_3", nullable = true)
    private String arUrlDocumento3;
    
    
    public Archivo() {
        super();
    }
    
    public Archivo(String arDescripcion, String arUrlDocumento, Integer arAnio, String arFase) {
        super();
        this.arDescripcion = arDescripcion;
        this.arUrlDocumento = arUrlDocumento;
        this.arAnio = arAnio;
        this.arFase = arFase;
    }
    
    public Archivo(String arUrlDocumento, String arInformacion, String arSolicitante) {
        super();
        this.arUrlDocumento = arUrlDocumento;
        this.arInformacion = arInformacion;
        this.arSolicitante = arSolicitante;
    }
    
    public Archivo(String arDescripcion, String arInformacion, String arUrlAI, String arUrlPNG, String arUrlJPG, int arEstado, int arOrdenDocs, String arUrlDocumento) {
        super();
        this.arDescripcion = arDescripcion;
        this.arInformacion = arInformacion;
        this.arUrlAI = arUrlAI;
        this.arUrlPNG = arUrlPNG;
        this.arUrlJPG = arUrlJPG;
        this.arEstado = arEstado;
        this.arOrdenDocs = arOrdenDocs;
        this.arUrlDocumento = arUrlDocumento;
    }
    
    public Archivo(String arDescripcion, String arUrlDocumento, Date arFechaPublc) {
        super();
        this.arDescripcion = arDescripcion;
        this.arUrlDocumento = arUrlDocumento;
        this.arFechaPublc = arFechaPublc;
    }

    public Archivo(String arUrlDocumento, Date arFechaPublc, String arDescripcionEn) {
        super();
        this.arUrlDocumento = arUrlDocumento;
        this.arFechaPublc = arFechaPublc;
        this.arDescripcionEn = arDescripcionEn;
    }

    public Archivo(int arCodigo, String arUrlDocumento, Date arFechaPublc, String arDescripcionPt) {
        super();
        this.arCodigo = arCodigo;
        this.arUrlDocumento = arUrlDocumento;
        this.arFechaPublc = arFechaPublc;
        this.arDescripcionPt = arDescripcionPt;
    }
    
    public Archivo(String arDescripcion, String arUrlDocumento, Integer arAnio, Integer arMes, String arInformacion) {
        super();
        this.arDescripcion = arDescripcion;
        this.arUrlDocumento = arUrlDocumento;
        this.arAnio = arAnio;
        this.arMes = arMes;
        this.arInformacion = arInformacion;
    }
    
    public Archivo(String arDescripcion, String arUrlDocumento, Integer arAnio, String arFase, String arUrlPW, String arTipoRecurso) {
        super();
        this.arDescripcion = arDescripcion;
        this.arUrlDocumento = arUrlDocumento;
        this.arAnio = arAnio;
        this.arFase = arFase;
        this.arUrlPW = arUrlPW;
        this.arTipoRecurso = arTipoRecurso;
    }
    
    public Archivo(int arCodigo, String arDescripcion, String arUrlDocumento, Date arFechaPublc, Integer arAnio, Integer arMes, String arFase, String arInformacion, String arUrlAI, String arUrlPNG, String arUrlJPG, String arTarget, int arEstado, String arSolicitante, String arImagen, String arTipoRes, String arSesionRes, String arTipoImg, String arUrlPW, String arTipoRecurso, Integer arOrdenDocs) {
        super();
        this.arCodigo = arCodigo;
        this.arDescripcion = arDescripcion;
        this.arUrlDocumento = arUrlDocumento;
        this.arFechaPublc = arFechaPublc;
        this.arAnio = arAnio;
        this.arMes = arMes;
        this.arFase = arFase;
        this.arInformacion = arInformacion;
        this.arUrlAI = arUrlAI;
        this.arUrlPNG = arUrlPNG;
        this.arUrlJPG = arUrlJPG;
        this.arTarget = arTarget;
        this.arEstado = arEstado;
        this.arSolicitante = arSolicitante;
        this.arImagen = arImagen;
        this.arTipoRes = arTipoRes;
        this.arSesionRes = arSesionRes;
        this.arTipoImg = arTipoImg;
        this.arUrlPW = arUrlPW;
        this.arTipoRecurso = arTipoRecurso;
        this.arOrdenDocs = arOrdenDocs;
    }

    public Archivo(String arDescripcion, String arUrlDocumento, Date arFechaPublc, String arDescripcionEn, String arDescripcionPt) {
        super();
        this.arDescripcion = arDescripcion;
        this.arUrlDocumento = arUrlDocumento;
        this.arFechaPublc = arFechaPublc;
        this.arDescripcionEn = arDescripcionEn;
        this.arDescripcionPt = arDescripcionPt;
    }
    
    public Archivo(String arDescripcion, String arUrlDocumento, Integer arAnio, String arFase, String arDescripcionEn, String arDescripcionPt, String arFaseEn, String arFasePt) {
        super();
        this.arDescripcion = arDescripcion;
        this.arUrlDocumento = arUrlDocumento;
        this.arAnio = arAnio;
        this.arFase = arFase;
        this.arDescripcionEn = arDescripcionEn;
        this.arDescripcionPt = arDescripcionPt;
        this.arFaseEn = arFaseEn;
        this.arFasePt = arFasePt;
    }

    public Archivo(String arUrlDocumento, String arInformacion, String arSolicitante, String arInformacionEn, String arInformacionPt, String arSolicitanteEn, String arSolicitantePt) {
        super();
        this.arUrlDocumento = arUrlDocumento;
        this.arInformacion = arInformacion;
        this.arSolicitante = arSolicitante;
        this.arInformacionEn = arInformacionEn;
        this.arInformacionPt = arInformacionPt;
        this.arSolicitanteEn = arSolicitanteEn;
        this.arSolicitantePt = arSolicitantePt;
    }
    
    public Archivo(String arDescripcion, String arUrlDocumento, String arInformacion, String arUrlAI, String arUrlPNG, String arUrlJPG, int arEstado, Integer arOrdenDocs, String arDescripcionEn, String arDescripcionPt, String arInformacionEn, String arInformacionPt) {
        super();
        this.arDescripcion = arDescripcion;
        this.arUrlDocumento = arUrlDocumento;
        this.arInformacion = arInformacion;
        this.arUrlAI = arUrlAI;
        this.arUrlPNG = arUrlPNG;
        this.arUrlJPG = arUrlJPG;
        this.arEstado = arEstado;
        this.arOrdenDocs = arOrdenDocs;
        this.arDescripcionEn = arDescripcionEn;
        this.arDescripcionPt = arDescripcionPt;
        this.arInformacionEn = arInformacionEn;
        this.arInformacionPt = arInformacionPt;
    }

    /*public Archivo(String arDescripcion, String arUrlDocumento, Integer arAnio, Integer arMes, String arInformacion, String arInformacionEn, String arInformacionPt) {
        super();
        this.arDescripcion = arDescripcion;
        this.arUrlDocumento = arUrlDocumento;
        this.arAnio = arAnio;
        this.arMes = arMes;
        this.arInformacion = arInformacion;
        this.arInformacionEn = arInformacionEn;
        this.arInformacionPt = arInformacionPt;
    }*/

    public Archivo(String arDescripcion, String arUrlDocumento, Integer arAnio, Integer arMes, String arInformacion, String arDescripcionEn, String arDescripcionPt, String arInformacionEn, String arInformacionPt, Integer arOrdenDocs) {
        super();
        this.arDescripcion = arDescripcion;
        this.arUrlDocumento = arUrlDocumento;
        this.arAnio = arAnio;
        this.arMes = arMes;
        this.arInformacion = arInformacion;
        this.arDescripcionEn = arDescripcionEn;
        this.arDescripcionPt = arDescripcionPt;
        this.arInformacionEn = arInformacionEn;
        this.arInformacionPt = arInformacionPt;
        this.arOrdenDocs = arOrdenDocs;
    }

    public Archivo(String arDescripcion, String arUrlDocumento, Integer arAnio, String arFase, String arUrlPW, String arTipoRecurso, String arDescripcionEn, String arDescripcionPt, String arFaseEn, String arFasePt) {
        super();
        this.arDescripcion = arDescripcion;
        this.arUrlDocumento = arUrlDocumento;
        this.arAnio = arAnio;
        this.arFase = arFase;
        this.arUrlPW = arUrlPW;
        this.arTipoRecurso = arTipoRecurso;
        this.arDescripcionEn = arDescripcionEn;
        this.arDescripcionPt = arDescripcionPt;
        this.arFaseEn = arFaseEn;
        this.arFasePt = arFasePt;
    }
    
    public Archivo(String arDescripcion, String arUrlDocumento, Integer arAnio, String arFase, String arUrlPW, String arTipoRecurso, Integer arOrdenDocs, String arDescripcionEn, String arDescripcionPt, String arFaseEn, String arFasePt) {
        super();
        this.arDescripcion = arDescripcion;
        this.arUrlDocumento = arUrlDocumento;
        this.arAnio = arAnio;
        this.arFase = arFase;
        this.arUrlPW = arUrlPW;
        this.arTipoRecurso = arTipoRecurso;
        this.arOrdenDocs = arOrdenDocs;
        this.arDescripcionEn = arDescripcionEn;
        this.arDescripcionPt = arDescripcionPt;
        this.arFaseEn = arFaseEn;
        this.arFasePt = arFasePt;
    }
    
    public Archivo(String arDescripcion, String arUrlDocumento, Integer arAnio, Integer arMes, String arFase, String arInformacion, String arSolicitante, Integer arOrdenDocs, String arDescripcionEn, String arDescripcionPt, String arInformacionEn, String arInformacionPt, String arUrlDocumento2, String arUrlDocumento3) {
        super();
        this.arDescripcion = arDescripcion;
        this.arUrlDocumento = arUrlDocumento;
        this.arAnio = arAnio;
        this.arMes = arMes;
        this.arFase = arFase;
        this.arInformacion = arInformacion;
        this.arSolicitante = arSolicitante;
        this.arOrdenDocs = arOrdenDocs;
        this.arDescripcionEn = arDescripcionEn;
        this.arDescripcionPt = arDescripcionPt;
        this.arInformacionEn = arInformacionEn;
        this.arInformacionPt = arInformacionPt;
        this.arUrlDocumento2 = arUrlDocumento2;
        this.arUrlDocumento3 = arUrlDocumento3;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getArCodigo() {
        return arCodigo;
    }
    
    public void setArCodigo(int arCodigo) {
        this.arCodigo = arCodigo;
    }
    
    public String getArDescripcion() {
        return arDescripcion;
    }
    
    public void setArDescripcion(String arDescripcion) {
        this.arDescripcion = arDescripcion;
    }
    
    public String getArUrlDocumento() {
        return arUrlDocumento;
    }
    
    public void setArUrlDocumento(String arUrlDocumento) {
        this.arUrlDocumento = arUrlDocumento;
    }
    
    public Date getArFechaPublc() {
        return arFechaPublc;
    }
    
    public void setArFechaPublc(Date arFechaPublc) {
        this.arFechaPublc = arFechaPublc;
    }
    
    public Integer getArAnio() {
        return arAnio;
    }
    
    public void setArAnio(Integer arAnio) {
        this.arAnio = arAnio;
    }
    
    public Integer getArMes() {
        return arMes;
    }
    
    public void setArMes(Integer arMes) {
        this.arMes = arMes;
    }
    
    public String getArFase() {
        return arFase;
    }
    
    public void setArFase(String arFase) {
        this.arFase = arFase;
    }
    
    public String getArInformacion() {
        return arInformacion;
    }
    
    public void setArInformacion(String arInformacion) {
        this.arInformacion = arInformacion;
    }
    
    public String getArUrlAI() {
        return arUrlAI;
    }
    
    public void setArUrlAI(String arUrlAI) {
        this.arUrlAI = arUrlAI;
    }
    
    public String getArUrlPNG() {
        return arUrlPNG;
    }
    
    public void setArUrlPNG(String arUrlPNG) {
        this.arUrlPNG = arUrlPNG;
    }
    
    public String getArUrlJPG() {
        return arUrlJPG;
    }
    
    public void setArUrlJPG(String arUrlJPG) {
        this.arUrlJPG = arUrlJPG;
    }
    
    public String getArTarget() {
        return arTarget;
    }
    
    public void setArTarget(String arTarget) {
        this.arTarget = arTarget;
    }
    
    public int getArEstado() {
        return arEstado;
    }
    
    public void setArEstado(int arEstado) {
        this.arEstado = arEstado;
    }
    
    public String getArSolicitante() {
        return arSolicitante;
    }
    
    public void setArSolicitante(String arSolicitante) {
        this.arSolicitante = arSolicitante;
    }
    
    public String getArImagen() {
        return arImagen;
    }
    
    public void setArImagen(String arImagen) {
        this.arImagen = arImagen;
    }
    
    public String getArTipoRes() {
        return arTipoRes;
    }
    
    public void setArTipoRes(String arTipoRes) {
        this.arTipoRes = arTipoRes;
    }
    
    public String getArSesionRes() {
        return arSesionRes;
    }
    
    public void setArSesionRes(String arSesionRes) {
        this.arSesionRes = arSesionRes;
    }
    
    public String getArTipoImg() {
        return arTipoImg;
    }
    
    public void setArTipoImg(String arTipoImg) {
        this.arTipoImg = arTipoImg;
    }
    
    public String getArUrlPW() {
        return arUrlPW;
    }
    
    public void setArUrlPW(String arUrlPW) {
        this.arUrlPW = arUrlPW;
    }
    
    public String getArTipoRecurso() {
        return arTipoRecurso;
    }
    
    public void setArTipoRecurso(String arTipoRecurso) {
        this.arTipoRecurso = arTipoRecurso;
    }
    
    public Integer getArOrdenDocs() {
        return arOrdenDocs;
    }
    
    public void setArOrdenDocs(Integer arOrdenDocs) {
        this.arOrdenDocs = arOrdenDocs;
    }
    
    public String getArDescripcionEn() {
        return arDescripcionEn;
    }

    public void setArDescripcionEn(String arDescripcionEn) {
        this.arDescripcionEn = arDescripcionEn;
    }

    public String getArDescripcionPt() {
        return arDescripcionPt;
    }

    public void setArDescripcionPt(String arDescripcionPt) {
        this.arDescripcionPt = arDescripcionPt;
    }
    
    public String getArFaseEn() {
        return arFaseEn;
    }

    public void setArFaseEn(String arFaseEn) {
        this.arFaseEn = arFaseEn;
    }

    public String getArFasePt() {
        return arFasePt;
    }

    public void setArFasePt(String arFasePt) {
        this.arFasePt = arFasePt;
    }
    
    public String getArInformacionEn() {
        return arInformacionEn;
    }

    public void setArInformacionEn(String arInformacionEn) {
        this.arInformacionEn = arInformacionEn;
    }

    public String getArInformacionPt() {
        return arInformacionPt;
    }

    public void setArInformacionPt(String arInformacionPt) {
        this.arInformacionPt = arInformacionPt;
    }

    public String getArSolicitanteEn() {
        return arSolicitanteEn;
    }

    public void setArSolicitanteEn(String arSolicitanteEn) {
        this.arSolicitanteEn = arSolicitanteEn;
    }

    public String getArSolicitantePt() {
        return arSolicitantePt;
    }

    public void setArSolicitantePt(String arSolicitantePt) {
        this.arSolicitantePt = arSolicitantePt;
    }

    public String getArTipoResEn() {
        return arTipoResEn;
    }

    public void setArTipoResEn(String arTipoResEn) {
        this.arTipoResEn = arTipoResEn;
    }

    public String getArTipoResPt() {
        return arTipoResPt;
    }

    public void setArTipoResPt(String arTipoResPt) {
        this.arTipoResPt = arTipoResPt;
    }

    public String getArSesionResEn() {
        return arSesionResEn;
    }

    public void setArSesionResEn(String arSesionResEn) {
        this.arSesionResEn = arSesionResEn;
    }

    public String getArSesionResPt() {
        return arSesionResPt;
    }

    public void setArSesionResPt(String arSesionResPt) {
        this.arSesionResPt = arSesionResPt;
    }
    
    public String getArUrlDocumento2() {
        return arUrlDocumento2;
    }

    public void setArUrlDocumento2(String arUrlDocumento2) {
        this.arUrlDocumento2 = arUrlDocumento2;
    }

    public String getArUrlDocumento3() {
        return arUrlDocumento3;
    }

    public void setArUrlDocumento3(String arUrlDocumento3) {
        this.arUrlDocumento3 = arUrlDocumento3;
    }
//</editor-fold>

}
