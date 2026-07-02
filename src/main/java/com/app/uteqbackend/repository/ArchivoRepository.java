package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.Archivo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface ArchivoRepository extends JpaRepository<Archivo, Integer> {

    @Query("SELECT a FROM Archivo a WHERE a.arTipoImg=?1 AND a.arEstado=1 ORDER BY a.arDescripcion ASC")
    public List<Archivo> getListLogosUTEQ(String type);

    @Query("SELECT a FROM Archivo a WHERE a.arTipoImg=?1 ORDER BY a.arAnio DESC, a.arMes DESC, a.arInformacion ASC")
    public List<Archivo> getSortListLogosUTEQ(String type);

    @Query("SELECT new com.app.uteqbackend.model.Archivo(a.arDescripcion, a.arUrlDocumento, a.arAnio, a.arFase) FROM Archivo a WHERE a.arTipoImg=?1 AND a.arEstado=1 ORDER BY a.arDescripcion ASC")
    public List<Archivo> getShortListLogosUTEQ(String type);

    @Query("SELECT new com.app.uteqbackend.model.Archivo(a.arUrlDocumento, a.arInformacion, a.arSolicitante) FROM Archivo a WHERE a.arTipoImg=?1 AND a.arEstado=1 ORDER BY a.arDescripcion ASC")
    public List<Archivo> getShortListFormatsUTEQ(String type);

    @Query("SELECT new com.app.uteqbackend.model.Archivo(a.arDescripcion, a.arInformacion, a.arUrlAI, a.arUrlPNG, a.arUrlJPG, a.arEstado, a.arOrdenDocs, a.arUrlDocumento) FROM Archivo a WHERE a.arTipoImg=?1 AND a.arEstado=1 ORDER BY a.arDescripcion ASC")
    public List<Archivo> getShortListImagesUTEQ(String type);

    @Query("SELECT new com.app.uteqbackend.model.Archivo(a.arDescripcion, a.arUrlDocumento, a.arFechaPublc) FROM Archivo a WHERE a.arTipoImg=?1 AND a.arEstado=1 ORDER BY a.arDescripcion ASC")
    public List<Archivo> getShortListDocsUTEQ(String type);

    /*@Query("SELECT new com.app.uteqbackend.model.Archivo(a.arDescripcion, a.arUrlDocumento, a.arAnio, a.arMes, a.arInformacion, a.arDescripcionEn, a.arDescripcionPt, a.arInformacionEn, a.arInformacionPt, a.arOrdenDocs) FROM Archivo a WHERE a.arTipoImg=?1 ORDER BY a.arAnio DESC, a.arMes DESC, a.arInformacion ASC")
    public List<Archivo> getSortListTransprUTEQ(String type);*/
    
    @Query("SELECT new com.app.uteqbackend.model.Archivo(a.arDescripcion, a.arUrlDocumento, a.arAnio, a.arMes, a.arFase, a.arInformacion, a.arSolicitante, a.arOrdenDocs, a.arDescripcionEn, a.arDescripcionPt, a.arInformacionEn, a.arInformacionPt, a.arUrlDocumento2, a.arUrlDocumento3) FROM Archivo a WHERE a.arTipoImg=?1 ORDER BY a.arAnio DESC, a.arMes DESC, a.arInformacion ASC")
    public List<Archivo> getSortListTransprUTEQ(String type);

    @Query("SELECT new com.app.uteqbackend.model.Archivo(a.arDescripcion, a.arUrlDocumento, a.arAnio, a.arFase, a.arUrlPW, a.arTipoRecurso, a.arOrdenDocs, a.arDescripcionEn, a.arDescripcionPt, a.arFaseEn, a.arFasePt) FROM Archivo a WHERE a.arTipoImg=?1 ORDER BY a.arAnio DESC, a.arMes DESC, a.arInformacion ASC")
    public List<Archivo> getSortListRendCtasUTEQ(String type);
    
    //Methods by language
    @Query("SELECT new com.app.uteqbackend.model.Archivo(a.arUrlDocumento, a.arFechaPublc, a.arDescripcionEn) FROM Archivo a WHERE a.arTipoImg=?1 AND a.arEstado=1 ORDER BY a.arDescripcionEn ASC")
    public List<Archivo> getShortListDocsUTEQLangEN(String type);
    
    @Query("SELECT new com.app.uteqbackend.model.Archivo(a.arCodigo, a.arUrlDocumento, a.arFechaPublc, a.arDescripcionPt) FROM Archivo a WHERE a.arTipoImg=?1 AND a.arEstado=1 ORDER BY a.arDescripcionPt ASC")
    public List<Archivo> getShortListDocsUTEQLangPT(String type);
    
    @Query("SELECT new com.app.uteqbackend.model.Archivo(a.arDescripcion, a.arUrlDocumento, a.arFechaPublc, a.arDescripcionEn, a.arDescripcionPt) FROM Archivo a WHERE a.arTipoImg=?1 AND a.arEstado=1")
    public List<Archivo> getShortListDocsUTEQLanguages(String type);
    
    @Query("SELECT new com.app.uteqbackend.model.Archivo(a.arDescripcion, a.arUrlDocumento, a.arAnio, a.arFase, a.arDescripcionEn, a.arDescripcionPt, a.arFaseEn, a.arFasePt) FROM Archivo a WHERE a.arTipoImg=?1 AND a.arEstado=1 ORDER BY a.arDescripcion ASC")
    public List<Archivo> getShortListLogosUTEQLanguages(String type);
    
    @Query("SELECT new com.app.uteqbackend.model.Archivo(a.arUrlDocumento, a.arInformacion, a.arSolicitante, a.arInformacionEn, a.arInformacionPt, a.arSolicitanteEn, a.arSolicitantePt) FROM Archivo a WHERE a.arTipoImg=?1 AND a.arEstado=1 ORDER BY a.arInformacion ASC")
    public List<Archivo> getShortListFormatsUTEQLanguages(String type);
    
    @Query("SELECT new com.app.uteqbackend.model.Archivo(a.arDescripcion, a.arUrlDocumento, a.arInformacion, a.arUrlAI, a.arUrlPNG, a.arUrlJPG, a.arEstado, a.arOrdenDocs, a.arDescripcionEn, a.arDescripcionPt, a.arInformacionEn, a.arInformacionPt) FROM Archivo a WHERE a.arTipoImg=?1 AND a.arEstado=1 ORDER BY a.arDescripcion ASC")
    public List<Archivo> getShortListImagesUTEQLanguages(String type);
    
}
