package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.Departamento;
import com.app.uteqbackend.model.Noticia;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

    @Query("SELECT n FROM Noticia n JOIN n.objDepartamento d WHERE d.dpEstado=1 AND n.ntEstado=1 ORDER BY n.ntFecha DESC")
    public List<Noticia> getListAllEvents();

    @Query("SELECT n FROM Noticia n JOIN n.objDepartamento d WHERE d.dpEstado=1 AND n.ntEstado=1 AND d.dpCodigo NOT IN('1cf13586-85d1-11ec-befe-244bfe557d55','1cf1aa66-85d1-11ec-beff-244bfe557d55') ORDER BY n.ntFecha DESC")
    public List<Noticia> getListAllEventsNotIncld();

    @Query("SELECT n FROM Noticia n JOIN n.objDepartamento d WHERE d.dpEstado=1 AND n.ntEstado=1 AND d.dpCodigo=?1 ORDER BY n.ntFecha DESC")
    public List<Noticia> getListEventsByDept(UUID codDept);

    @Query("SELECT n FROM Noticia n JOIN n.objDepartamento d JOIN n.objCategoriaNotc c WHERE d.dpEstado=1 AND n.ntEstado=1 ORDER BY n.ntFecha DESC")
    public List<Noticia> getListNewsUniversity();

    @Query("SELECT new com.app.uteqbackend.model.Noticia(n.ntUrlNoticia) FROM Noticia n JOIN n.objDepartamento d JOIN n.objCategoriaNotc c WHERE d.dpEstado=1 AND n.ntEstado=1 AND n.ntUrlNoticia!=NULL ORDER BY n.ntFecha DESC")
    public List<Noticia> getListUrlsNewsUniversity();

    @Query("SELECT new com.app.uteqbackend.model.Noticia(n.ntUrlPortada, n.ntTitular, n.ntTitularEn, n.ntTitularPt, n.ntUrlNoticia, n.ntFecha, n.objDepartamento, n.ntDescripMeta, n.ntDescripMetaEn, n.ntDescripMetaPt) FROM Noticia n JOIN n.objDepartamento d JOIN n.objCategoriaNotc c WHERE d.dpEstado=1 AND n.ntEstado=1 AND n.ntUrlNoticia!=NULL ORDER BY n.ntFecha DESC")
    public List<Noticia> getListInfoPrincNewsUniversity();
    
    @Query("SELECT new com.app.uteqbackend.model.Noticia(n.ntTitular, n.ntUrlNoticia) FROM Noticia n JOIN n.objDepartamento d JOIN n.objCategoriaNotc c WHERE d.dpEstado=1 AND n.ntEstado=1 AND n.ntUrlNoticia!=NULL ORDER BY n.ntFecha ASC")
    public List<Noticia> getListSMPrincNewsUniversity();
    
    @Query("SELECT new com.app.uteqbackend.model.Noticia(n.ntTitular, n.ntTitularEn, n.ntTitularPt, n.ntUrlNoticia) FROM Noticia n JOIN n.objDepartamento d JOIN n.objCategoriaNotc c WHERE d.dpEstado=1 AND n.ntEstado=1 AND n.ntUrlNoticia!=NULL ORDER BY n.ntFecha ASC")
    public List<Noticia> getListSMPrincNewsUniversityLang();

    @Query("SELECT new com.app.uteqbackend.model.Departamento(d.dpNombre, d.dpNombreEn, d.dpNombrePt, d.dpColor) FROM Departamento d WHERE d.dpCodigo=?1 AND d.dpEstado=1")
    Departamento getInfoShortDepartament(@Param("code") UUID code);

    @Query("SELECT n FROM Noticia n JOIN n.objDepartamento d JOIN n.objCategoriaNotc c WHERE n.ntUrlNoticia=?1")
    public Noticia getInformationNewsByUrlParcial(String urlNews);

    @Query(value = "select *FROM nt_listado_noticias_relevantes_por_departamento();", nativeQuery = true)
    public List<Noticia> getListTopSixNewsUniversity();

    @Query(value = "select *FROM nt_listado_seis_noticias_relevantes_por_departamento_lang(:code_news);", nativeQuery = true)
    public List<Noticia> getListTopSixNewsByDepartmUniversity(@Param("code_news") int code_news);

    @Query(value = "select *FROM nt_listado_filtrado_noticias_lang(:lst_depts, :lst_catgs);", nativeQuery = true)
    public List<Noticia> getListNewsFilterByParameters(@Param("lst_depts") String lst_depts, @Param("lst_catgs") String lst_catgs);

    @Query(value = "select *FROM nt_listado_filtrado_noticias_v2_lang(:cod_dep, :lst_catgs, :lst_years);", nativeQuery = true)
    public List<Noticia> getListNewsDepFilterByParameters(@Param("cod_dep") UUID cod_dep, @Param("lst_catgs") String lst_catgs, @Param("lst_years") String lst_years);

}
