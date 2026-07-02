package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.Archivo;
import com.app.uteqbackend.model.CapacitacionUTH;
import com.app.uteqbackend.model.Carrera;
import com.app.uteqbackend.model.CategoriaNotc;
import com.app.uteqbackend.model.ConcursoMer;
import com.app.uteqbackend.model.DatosMult;
import com.app.uteqbackend.model.Departamento;
import com.app.uteqbackend.model.DtpModal;
import com.app.uteqbackend.model.DtsModal;
import com.app.uteqbackend.model.Empleo;
import com.app.uteqbackend.model.EventoOrgz;
import com.app.uteqbackend.model.GaleriaLb;
import com.app.uteqbackend.model.GaleriaPI;
import com.app.uteqbackend.model.GaleriaPV;
import com.app.uteqbackend.model.GrupoInv;
import com.app.uteqbackend.model.IntegranteGI;
import com.app.uteqbackend.model.LineaInv;
import com.app.uteqbackend.model.Menu;
import com.app.uteqbackend.model.Metrica;
import com.app.uteqbackend.model.Noticia;
import com.app.uteqbackend.model.PagWeb;
import com.app.uteqbackend.model.PeriodicoMens;
import com.app.uteqbackend.model.PlantillaEmail;
import com.app.uteqbackend.model.ProyectoInvst;
import com.app.uteqbackend.model.ProyectoVinc;
import com.app.uteqbackend.model.PublicacionRs;
import com.app.uteqbackend.model.ServicioMed;
import com.app.uteqbackend.model.Submenu;
import com.app.uteqbackend.model.VideoInfm;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface DatosMultRepository extends JpaRepository<DatosMult, Integer> {

    @Query(value = "select *FROM dm_listado_datos_multiples_por_tipo(:type);", nativeQuery = true)
    List<DatosMult> getDataMultiplesOfUniversity(@Param("type") String typeMenu);
    
    @Query(value = "select *FROM dm_obtener_informacion_por_codigo(:id);", nativeQuery = true)
    DatosMult getInfoDataMultById(@Param("id") int id);

    @Query("SELECT d FROM Departamento d WHERE d.dpCodigo=?1")
    public Departamento getInformationDepartamentByID(UUID code);

    @Query("SELECT d FROM Departamento d WHERE d.dpParcialUrl=?1")
    public Departamento getInformationDepartamentByUrlParcial(String urlParcial);

    @Query(value = "select *FROM dm_listado_ordenado_datos_multiples_por_tipo(:type);", nativeQuery = true)
    List<DatosMult> getDataMultiplesOfUniversitySort(@Param("type") String typeMenu);

    @Query(value = "select *FROM dm_listado_completo_ordenado_datos_multiples_por_tipo(:type);", nativeQuery = true)
    List<DatosMult> getDataTypesVideos(@Param("type") String typeMenu);

    @Query("SELECT p FROM PagWeb p WHERE p.pwCodigo=?1")
    PagWeb getInformationPageWebByCode(UUID code);

    @Query("SELECT p FROM PagWeb p WHERE p.pwFraseDesc=?1")
    PagWeb getInformationPageWebByUrlParcial(String urlParcial);

    @Query(value = "select *FROM cm_listado_concursos_meritos_oposc();", nativeQuery = true)
    List<ConcursoMer> getListDataMeritContests();

    @Query("SELECT c FROM ConcursoMer c WHERE c.cmEstado=1 AND c.cmFechaFin>=?1 ORDER BY c.cmFechaInc DESC")
    List<ConcursoMer> getListDataMeritContests(Date currentDate);

    @Query("SELECT c FROM Carrera c JOIN c.crDepartamento d WHERE d.dpCodigo=?1 AND c.crEstado=1 ORDER BY c.crNombre ASC")
    List<Carrera> getListDataCareersUnivsByType(UUID codeDepartm);

    @Query("SELECT new com.app.uteqbackend.model.Carrera(c.crUrlParcial) FROM Carrera c JOIN c.crDepartamento d WHERE d.dpCodigo=?1 AND c.crEstado=1 ORDER BY c.crNombre ASC")
    List<Carrera> getListDataUrlsCareersUnivsByType(UUID codeDepartm);
    
    @Query("SELECT new com.app.uteqbackend.model.Carrera(c.crNombre, c.crNombreEn, c.crNombrePt, c.crUrlParcial) FROM Carrera c JOIN c.crDepartamento d WHERE d.dpCodigo=?1 AND c.crEstado=1 ORDER BY c.crNombre ASC")
    List<Carrera> getListDataSMUrlsCareersUnivsByType(UUID codeDepartm);

    @Query("SELECT new com.app.uteqbackend.model.Carrera(c.crCodigo, c.crNombre, c.crNombreEn, c.crNombrePt, c.crUrlParcial, c.crUrlPortada, c.crUrlPortadaEn, c.crUrlPortadaPt) FROM Carrera c JOIN c.crDepartamento d WHERE d.dpCodigo=?1 AND c.crEstado=1 ORDER BY c.crNombre ASC")
    List<Carrera> getListShortDataUrlsCareersUnivsByType(UUID codeDepartm);

    @Query("SELECT c FROM Carrera c WHERE c.crUrlParcial=?1")
    Carrera getInformationCareerByUrlParcial(String urlParcial);

    @Query(value = "select *FROM is_registrar_datos_inscripcion(:cedula, :nombre_comp, :correo_elect, :telefono, :cod_maestria, :url_brochure);", nativeQuery = true)
    String registerDataInscription(@Param("cedula") String cedula, @Param("nombre_comp") String nombre_comp, @Param("correo_elect") String correo_elect, @Param("telefono") String telefono, @Param("cod_maestria") UUID cod_maestria, @Param("url_brochure") String url_brochure);

    @Query("SELECT c FROM Carrera c WHERE c.crCodigo=?1")
    Carrera getInformationCareerByCode(UUID codCarrera);

    @Query("SELECT e FROM EventoOrgz e WHERE e.eoUrlParcial=?1")
    EventoOrgz getInformationEventOrgz(String urlParcial);

    @Query("SELECT e FROM EventoOrgz e WHERE e.eoEstado= 1 ORDER BY e.eoFecha DESC")
    List<EventoOrgz> getListEventsOrgzUniversity();

    @Query("SELECT c FROM Carrera c JOIN c.crDepartamento d WHERE d.dpCodigo=?1 AND c.crEstado=1 AND c.crPeriodoMatc=1 ORDER BY c.crNombre ASC")
    List<Carrera> getListDataCareersMatcUnivsByType(UUID codeDepartm);

    @Query("SELECT c FROM Carrera c JOIN c.crDepartamento d WHERE d.dpCodigo=?1 AND c.crEstado=1 ORDER BY c.crNombre ASC")
    List<Carrera> getListDataCareersGradeMatcUnivsByType(UUID codeDepartm);

    @Query("SELECT p FROM PlantillaEmail p WHERE p.peUbicacion=?1 AND p.peEstado=1")
    PlantillaEmail getInformationTemplateEmail(String location);

    @Query(value = "select *FROM mt_registrar_datos_matricula(:cedula, :nombre_comp, :correo_elect, :telefono, :cod_maestria, :url_brochure, :pdf1, :nombrePdf1, :pdf2, :nombrePdf2, :pdf3, :nombrePdf3, :pdf4, :nombrePdf4, :pdf5, :nombrePdf5, :pdf6, :nombrePdf6, :pdf7, :nombrePdf7, :pdf8, :nombrePdf8);", nativeQuery = true)
    String registerDataEnrollment(@Param("cedula") String cedula, @Param("nombre_comp") String nombre_comp, @Param("correo_elect") String correo_elect, @Param("telefono") String telefono, @Param("cod_maestria") UUID cod_maestria,
            @Param("url_brochure") String url_brochure, @Param("pdf1") byte[] pdf1, @Param("nombrePdf1") String nombrePdf1, @Param("pdf2") byte[] pdf2, @Param("nombrePdf2") String nombrePdf2, @Param("pdf3") byte[] pdf3, @Param("nombrePdf3") String nombrePdf3,
            @Param("pdf4") byte[] pdf4, @Param("nombrePdf4") String nombrePdf4, @Param("pdf5") byte[] pdf5, @Param("nombrePdf5") String nombrePdf5, @Param("pdf6") byte[] pdf6, @Param("nombrePdf6") String nombrePdf6,
            @Param("pdf7") byte[] pdf7, @Param("nombrePdf7") String nombrePdf7, @Param("pdf8") byte[] pdf8, @Param("nombrePdf8") String nombrePdf8);

    @Query("SELECT c FROM Carrera c JOIN c.crDepartamento d WHERE d.dpEsFacultad='S' AND c.crEstado=1 ORDER BY c.crNombre ASC")
    List<Carrera> getListDataCareersUnivsByFaculty();

    @Query("SELECT new com.app.uteqbackend.model.Carrera(c.crUrlParcial) FROM Carrera c JOIN c.crDepartamento d WHERE d.dpEsFacultad='S' AND c.crEstado=1 ORDER BY c.crNombre ASC")
    List<Carrera> getListDataUrlsCareersUnivsByFaculty();

    /*@Query("SELECT new com.app.uteqbackend.model.Carrera(c.crDepartamento, c.crNombre, c.crUrlParcial) FROM Carrera c JOIN c.crDepartamento d WHERE d.dpEsFacultad='S' AND c.crEstado=1 ORDER BY c.crNombre ASC")
    List<Carrera> getListDataUrlsInfoCareersUnivsByFaculty();*/
    
    @Query("SELECT new com.app.uteqbackend.model.Carrera(c.crDepartamento, c.crNombre, c.crNombreEn, c.crNombrePt, c.crUrlParcial, c.crUrlSldPrinc, c.crUrlPageCareers) FROM Carrera c JOIN c.crDepartamento d WHERE d.dpEsFacultad='S' AND c.crEstado=1 ORDER BY c.crNombre ASC")
    List<Carrera> getListDataUrlsInfoCareersUnivsByFaculty();
    
    @Query("SELECT new com.app.uteqbackend.model.Carrera(c.crDepartamento, c.crNombre, c.crNombreEn, c.crNombrePt, c.crUrlParcial) FROM Carrera c JOIN c.crDepartamento d WHERE d.dpEstado=1 AND (LOWER(UNACCENT(c.crNombre)) LIKE LOWER(UNACCENT(CONCAT('%',?1,'%'))) OR LOWER(UNACCENT(c.crUrlParcial)) LIKE LOWER(UNACCENT(CONCAT('%',?1,'%')))) AND c.crEstado=1 ORDER BY c.crNombre ASC")
    List<Carrera> getListDataUrlsInfoCareersUnivsByWords(@Param("textin") String textin);
    
    /*@Query("SELECT new com.app.uteqbackend.model.Carrera(c.crCodigo, c.crNombre, c.crEstado, c.crUrlPagInsc, c.crAreaConc, c.crUrlParcial) FROM Carrera c JOIN c.crDepartamento d WHERE d.dpEsFacultad='S' AND c.crEstado=1 ORDER BY c.crNombre ASC")
    List<Carrera> getListCareersUAN();*/
    
    //UUID crCodigo, String crNombre, String crNombreEn, String crNombrePt, String crUrlParcial, int crEstado, String crUrlPagInsc, String crAreaConc, String crAreaConcEn, String crAreaConcPt
    @Query("SELECT new com.app.uteqbackend.model.Carrera(c.crCodigo, c.crNombre, c.crNombreEn, c.crNombrePt, c.crUrlParcial, c.crEstado, c.crUrlPagInsc, c.crAreaConc, c.crAreaConcEn, c.crAreaConcPt) FROM Carrera c JOIN c.crDepartamento d WHERE d.dpEsFacultad='S' AND c.crEstado=1 ORDER BY c.crNombre ASC")
    List<Carrera> getListCareersUAN();

    /*@Query("SELECT new com.app.uteqbackend.model.Departamento(d.dpCodigo, d.dpNombre, d.dpImgLogo, d.dpParcialUrl) FROM Departamento d WHERE d.dpCodigo=?1")
    public Departamento getInfoShortFaculty(@Param("code_faculty") UUID code_faculty);*/
    
    @Query("SELECT new com.app.uteqbackend.model.Departamento(d.dpCodigo, d.dpNombre, d.dpNombreEn, d.dpNombrePt, d.dpImgLogo, d.dpParcialUrl) FROM Departamento d WHERE d.dpCodigo=?1")
    public Departamento getInfoShortFaculty(@Param("code_faculty") UUID code_faculty);

    @Query("SELECT new com.app.uteqbackend.model.Departamento(d.dpNombre, d.dpEsFacultad, d.dpEstado) FROM Departamento d WHERE d.dpCodigo=?1")
    public Departamento getInfoFacultySrc(@Param("code_faculty") UUID code_faculty);

    @Query("SELECT s FROM ServicioMed s WHERE s.smEstado=1")
    List<ServicioMed> getListMedicalServices();

    @Query("SELECT c FROM CapacitacionUTH c WHERE c.cuEstado=1 AND c.cuFechaFin>=?1 ORDER BY c.cuFechaInicio DESC")
    List<CapacitacionUTH> getListCoursesUTH(Date currentDate);

    @Query(value = "select *FROM bt_registrar_datos_persona_uth(:cedula, :nombre_comp, :codigo_exp_lab, :codigo_cmp_prof, :cod_form_prof, :publicaciones, :archivo_hv, :nombre_pdf_hv);", nativeQuery = true)
    String registerDataCurriculumVitaeUTH(@Param("cedula") String cedula, @Param("nombre_comp") String nombre_comp, @Param("codigo_exp_lab") int codigo_exp_lab, @Param("codigo_cmp_prof") /*int*/ String codigo_cmp_prof,
            @Param("cod_form_prof") int cod_form_prof, @Param("publicaciones") String publicaciones, @Param("archivo_hv") byte[] archivo_hv, @Param("nombre_pdf_hv") String nombre_pdf_hv);

    @Query("SELECT d FROM Departamento d WHERE d.dpEsFacultad='S' AND d.dpEstado=1")
    public List<Departamento> getListDepartamentsAsFaculty();

    @Query("SELECT new com.app.uteqbackend.model.Departamento(d.dpParcialUrl) FROM Departamento d WHERE d.dpEsFacultad='S' AND d.dpEstado=1")
    public List<Departamento> getListUrlsDepartamentsAsFaculty();

    /*@Query("SELECT new com.app.uteqbackend.model.Departamento(d.dpCodigo, d.dpNombre, d.dpParcialUrl) FROM Departamento d WHERE d.dpEsFacultad='S' AND d.dpEstado=1")
    public List<Departamento> getListUrlsDepartamentsAsFacultyV3();*/
    
    @Query("SELECT new com.app.uteqbackend.model.Departamento(d.dpCodigo, d.dpNombre, d.dpNombreEn, d.dpNombrePt, d.dpParcialUrl) FROM Departamento d WHERE d.dpEsFacultad='S' AND d.dpEstado=1")
    public List<Departamento> getListUrlsDepartamentsAsFacultyV3();

    @Query(value = "select *FROM dm_listado_horarios_por_area(:cod_area);", nativeQuery = true)
    List<DatosMult> getListSchedulesUBU(@Param("cod_area") int cod_area);

    @Query("SELECT c FROM Carrera c JOIN c.crDepartamento d WHERE c.crEstado=1 AND d.dpCodigo=?1 ORDER BY c.crNombre ASC")
    List<Carrera> getListDataCareersUnivsByCodeFaculty(@Param("code_faculty") UUID code_faculty);

    @Query(value = "select *FROM fu_registrar_datos_ficha_ubu(:cedula, :nombre_comp, :telf_movil, :telf_fijo, :nmb_foto, :imagen_prf, :cod_semestre, :nmb_semestre, :dir_domic, :correo_elct, :cod_tp_sgr, :tp_sgr, :cod_facultad, :nmb_facultad, :cod_carrera, :nmb_carrera, :lista_actvds);", nativeQuery = true)
    String registerDataStudentActivitiesUBU(@Param("cedula") String cedula, @Param("nombre_comp") String nombre_comp, @Param("telf_movil") String telf_movil, @Param("telf_fijo") String telf_fijo, @Param("nmb_foto") String nmb_foto,
            @Param("imagen_prf") byte[] imagen_prf, @Param("cod_semestre") int cod_semestre, @Param("nmb_semestre") String nmb_semestre, @Param("dir_domic") String dir_domic, @Param("correo_elct") String correo_elct,
            @Param("cod_tp_sgr") int cod_tp_sgr, @Param("tp_sgr") String tp_sgr, @Param("cod_facultad") UUID cod_facultad, @Param("nmb_facultad") String nmb_facultad, @Param("cod_carrera") UUID cod_carrera,
            @Param("nmb_carrera") String nmb_carrera, @Param("lista_actvds") String lista_actvds);

    @Query("SELECT p FROM PublicacionRs p WHERE p.prRedSocial=?1 AND p.prEstado=1 ORDER BY p.prFecha DESC")
    List<PublicacionRs> getListPublicationsUniversity(@Param("type_sn") String type_sn, Pageable pageable);

    @Query("SELECT d FROM Departamento d WHERE d.dpEstado=1 ORDER BY d.dpNombre ASC")
    public List<Departamento> getListDepartamentsActive();

    @Query("SELECT c FROM CategoriaNotc c WHERE c.gtEstado=1 ORDER BY c.gtTitular ASC")
    public List<CategoriaNotc> getListCategoriesActive();

    @Query("SELECT w FROM PagWeb w WHERE w.pwTipoEntd=?1 AND w.pwEstado=1")
    public List<PagWeb> getListOthersWebPagesByEntity(@Param("tipo_entd") String tipo_entd);

    @Query("SELECT new com.app.uteqbackend.model.PagWeb(w.pwUrlPag) FROM PagWeb w WHERE w.pwTipoEntd=?1 AND w.pwEstado=1")
    public List<PagWeb> getListUrlsOthersWebPagesByEntity(@Param("tipo_entd") String tipo_entd);
    
    @Query("SELECT new com.app.uteqbackend.model.PagWeb(w.pwNombre, w.pwNombreEn, w.pwNombrePt, w.pwUrlPag) FROM PagWeb w WHERE w.pwTipoEntd=?1 AND w.pwEstado=1")
    public List<PagWeb> getListUrlsOthersWebSMPagesByEntity(@Param("tipo_entd") String tipo_entd);

    @Query("SELECT m FROM DtsModal d JOIN d.mdsModal m WHERE m.mdpCodEntidad=?1")
    public DtpModal getInformationModalUniv(@Param("cod_entd") UUID cod_entd);

    @Query("SELECT d FROM DtsModal d JOIN d.mdsModal m WHERE m.mdpCodigo=?1")
    public Set<DtsModal> getListDetailsModal(@Param("cod_modal") int cod_modal);

    @Query("SELECT d FROM DtsModal d JOIN d.mdsModal m WHERE m.mdpCodEntidad=?1")
    public List<DtsModal> getListElementsModal(@Param("cod_entd") UUID cod_entd);

    @Query(value = "SELECT new com.app.uteqbackend.model.Menu(m.mnNombre, m.mnUrlAsoc, m.mnNombreEn, m.mnNombrePt) FROM Menu m WHERE LOWER(UNACCENT(m.mnNombre)) LIKE LOWER(UNACCENT(CONCAT('%',?1,'%'))) OR LOWER(UNACCENT(m.mnUrlAsoc)) LIKE LOWER(UNACCENT(CONCAT('%',?1,'%'))) AND m.mnEstado=1 AND m.mnUrlAsoc<>'#'")
    List<Menu> getListFilterInformationMenu(String val_frase, Sort sort);

    @Query(value = "SELECT new com.app.uteqbackend.model.Submenu(s.smNombre, s.smUrlAsoc, s.smNombreEn, s.smNombrePt) FROM Submenu s INNER JOIN Menu m ON s.smCodMenu=m.mnCodigo WHERE (LOWER(UNACCENT(s.smNombre)) LIKE LOWER(UNACCENT(CONCAT('%',?1,'%'))) OR LOWER(UNACCENT(s.smUrlAsoc)) LIKE LOWER(UNACCENT(CONCAT('%',?1,'%')))) AND s.smEstado=1 AND s.smUrlAsoc<>'#' AND m.mnTpMenu<>'MN_LATL'")
    List<Submenu> getListFilterInformationSubMenu(String val_frase, Sort sort);

    @Query(value = "SELECT n FROM Noticia n WHERE LOWER(UNACCENT(n.ntTitular)) LIKE LOWER(UNACCENT(CONCAT('%',?1,'%'))) OR LOWER(UNACCENT(n.ntDescripMeta)) LIKE LOWER(UNACCENT(CONCAT('%',?1,'%'))) OR LOWER(UNACCENT(n.ntCuerpo)) LIKE LOWER(UNACCENT(CONCAT('%',?1,'%'))) AND n.ntEstado=1 AND n.ntUrlNoticia NOT IN ('#','')")
    List<Noticia> getListFilterInformationNoticia(String val_frase, Sort sort);

    @Query(value = "SELECT v FROM VideoInfm v WHERE LOWER(UNACCENT(v.titulo)) LIKE LOWER(UNACCENT(CONCAT('%',?1,'%')))")
    List<VideoInfm> getListFilterInformationVideos(String val_frase, Sort sort);

    @Query("SELECT p FROM PeriodicoMens p")
    List<PeriodicoMens> getListFilterInformationPeriodicos(Sort sort);

    @Query("SELECT r FROM DatosMult r WHERE r.dmCategoria='REVISTA' AND r.dmUrlPagWeb<>'#' AND r.dmEstado=1")
    List<DatosMult> getListFilterInformationRevistas();

    @Query("SELECT a FROM Archivo a WHERE LOWER(UNACCENT(a.arDescripcion)) LIKE LOWER(UNACCENT(CONCAT('%',?1,'%'))) AND a.arEstado=1 AND a.arDescripcion<>'' AND a.arDescripcion IS NOT NULL")
    List<Archivo> getListFilterInformationArchivos(String val_frase, Sort sort);

    //@Query("SELECT e FROM Empleo e WHERE e.epEstado=1 AND (e.epFechaInc <= NOW() AND e.epFechaFin >= NOW()) ORDER BY e.epFechaInc DESC")
    @Query("SELECT e FROM Empleo e WHERE e.epEstado=1 ORDER BY e.epFechaInc DESC")
    List<Empleo> getListJobsEmployments();

    @Query("SELECT m FROM Metrica m WHERE m.mcCodigoEntd=?1")
    List<Metrica> getListMetricsUnivs(@Param("cod_entd") UUID cod_entd);

    @Query("SELECT p FROM ProyectoVinc p WHERE p.pvUrlParcial=?1")
    ProyectoVinc getInformationOfProjectLinkageByUrl(String code_url);

    @Query("SELECT p FROM ProyectoVinc p WHERE p.pvEstadoVis=1 ORDER BY p.pvPeriodo DESC, p.pvFechaInc DESC")
    List<ProyectoVinc> getListProjectsLinkage();
    
    @Query("SELECT new com.app.uteqbackend.model.ProyectoVinc(p.pvTitulo, p.pvTituloEn, p.pvTituloPt, p.pvUrlParcial) FROM ProyectoVinc p WHERE p.pvEstadoVis=1 ORDER BY p.pvPeriodo DESC, p.pvFechaInc DESC")
    List<ProyectoVinc> getListSMProjectsLinkage();

    @Query("SELECT new com.app.uteqbackend.model.ProyectoVinc(p.pvUrlParcial) FROM ProyectoVinc p WHERE p.pvEstadoVis=1 ORDER BY p.pvPeriodo DESC, p.pvFechaInc DESC")
    List<ProyectoVinc> getListUrlsProjectsLinkage();

    @Query("SELECT g FROM GaleriaPV g INNER JOIN g.gpCodPV p WHERE p.pvUrlParcial=?1 AND g.gpEstado=1 ORDER BY g.gpOrden ASC")
    List<GaleriaPV> getListImgProjectsPV(String urlParcial);

    @Query("SELECT l FROM LineaInv l WHERE l.liEstado=1 ORDER BY l.liNombre ASC")
    List<LineaInv> getListResearchLines();

    @Query("SELECT g FROM GrupoInv g INNER JOIN g.giFacultad f WHERE f.dpEsFacultad='S' AND f.dpEstado=1 AND g.giEstado=1 ORDER BY f.dpNombre ASC")
    List<GrupoInv> getListInformationResearchGroups();

    @Query("SELECT new com.app.uteqbackend.model.GrupoInv(g.giNombre, g.giNombreEn, g.giNombrePt, g.giUrlParcial) FROM GrupoInv g INNER JOIN g.giFacultad f WHERE f.dpEsFacultad='S' AND f.dpEstado=1 AND g.giEstado=1 ORDER BY f.dpNombre ASC")
    List<GrupoInv> getListSMUrlsInformationResearchGroups();
    
    @Query("SELECT new com.app.uteqbackend.model.GrupoInv(g.giUrlParcial) FROM GrupoInv g INNER JOIN g.giFacultad f WHERE f.dpEsFacultad='S' AND f.dpEstado=1 AND g.giEstado=1 ORDER BY f.dpNombre ASC")
    List<GrupoInv> getListUrlsInformationResearchGroups();

    @Query("SELECT g FROM GrupoInv g WHERE g.giCodigo=?1")
    GrupoInv getInformationResearchGroup(UUID codeGroup);

    @Query("SELECT i FROM IntegranteGI i INNER JOIN i.itGrupoInv g WHERE g.giUrlParcial=?1 AND i.itEstado=1 ORDER BY i.itNombres ASC")
    List<IntegranteGI> getListGroupsMembers(String urlParcial);

    @Query("SELECT p FROM ProyectoInvst p WHERE p.ptEstado=1 ORDER BY p.ptFechaInicio DESC")
    List<ProyectoInvst> getListResProjects();
    
    @Query("SELECT new com.app.uteqbackend.model.ProyectoInvst(p.ptNombre, p.ptNombreEn, p.ptNombrePt, p.ptUrlParcial, p.ptFechaInicio, p.ptConvocatoria, p.ptConvocatoriaEn, p.ptConvocatoriaPt) FROM ProyectoInvst p WHERE p.ptEstado=1 ORDER BY p.ptFechaInicio DESC")
    List<ProyectoInvst> getListResProjectsV1();
    
    @Query("SELECT new com.app.uteqbackend.model.ProyectoInvst(p.ptNombre, p.ptNombreEn, p.ptNombrePt, p.ptUrlParcial) FROM ProyectoInvst p WHERE p.ptEstado=1 ORDER BY p.ptFechaInicio DESC")
    List<ProyectoInvst> getListSMResProjects();

    @Query("SELECT new com.app.uteqbackend.model.ProyectoInvst(p.ptUrlParcial) FROM ProyectoInvst p WHERE p.ptEstado=1 ORDER BY p.ptFechaInicio DESC")
    List<ProyectoInvst> getListUrlsResProjects();
    
    //
    /*@Query("SELECT p FROM ProyectoInvst p WHERE p.ptUrlParcial=?1")
    ProyectoInvst getInformationProjectByCode(String urlParcial);*/
    
    /*@Query("SELECT new com.app.uteqbackend.model.ProyectoInvst(" +
       "new com.app.uteqbackend.model.GrupoInv(g.giNombre, g.giNombreEn, g.giNombrePt), " +
       "new com.app.uteqbackend.model.Carrera(c.crNombre, c.crNombreEn, c.crNombrePt), " +
       "p.ptNombre, p.ptNombreEn, p.ptNombrePt, p.ptFechaInicio, p.ptFechaFinlz, " +
       "p.ptAvance, p.ptAvanceEn, p.ptAvancePt, p.ptMonto, " +
       "p.ptResumenSem, p.ptResumenSemEn, p.ptResumenSemPt, " +
       "p.ptIntegrantes, p.ptIntegrantesEn, p.ptIntegrantesPt, p.ptCorreoDir) " +
       "FROM ProyectoInvst p " +
       "JOIN p.ptGrupoInv g " +
       "JOIN p.ptCarrera c " +
       "WHERE p.ptUrlParcial = ?1")*/
    /*@Query("SELECT new com.app.uteqbackend.model.ProyectoInvst(" +
       "p.ptGrupoInv, p.ptCarrera," +
       "p.ptNombre, p.ptNombreEn, p.ptNombrePt, p.ptFechaInicio, p.ptFechaFinlz, " +
       "p.ptAvance, p.ptAvanceEn, p.ptAvancePt, p.ptMonto, " +
       "p.ptResumenSem, p.ptResumenSemEn, p.ptResumenSemPt, " +
       "p.ptIntegrantes, p.ptIntegrantesEn, p.ptIntegrantesPt, p.ptCorreoDir) " +
       "FROM ProyectoInvst p " +
       "WHERE p.ptUrlParcial = ?1")*/
    @Query("SELECT p FROM ProyectoInvst p WHERE p.ptUrlParcial=?1")
    ProyectoInvst getInformationProjectByCode(String urlParcial);

    @Query("SELECT p FROM PagWeb p WHERE TRIM(p.pwUrlPag)=?1")
    PagWeb getInformationPageWebByUrl(String urlParcial);

    @Query("SELECT w FROM PagWeb w WHERE w.pwCodEntidad=?1 AND w.pwEstado=1")
    public List<PagWeb> getListPagesByCode(@Param("code") UUID code);

    @Query("SELECT new com.app.uteqbackend.model.PagWeb(w.pwUrlPag) FROM PagWeb w WHERE w.pwCodEntidad=?1 AND w.pwEstado=1")
    public List<PagWeb> getListUrlsPagesByCode(@Param("code") UUID code);

    @Query("SELECT g FROM GaleriaPI g INNER JOIN g.gpiProyectoInvst p WHERE p.ptUrlParcial=?1 AND g.gpiEstado=1 ORDER BY g.gpiOrden ASC")
    List<GaleriaPI> getListImgProjectsPI(String urlParcial);

    //@Query("SELECT new com.app.uteqbackend.model.DatosMult(d.dmNombreGrad, d.dmProfesion, d.dmUrlFoto, d.dmRespuesta, d.dmOrdenPreg) FROM DatosMult d WHERE d.dmCategoria='CASOS_EXITO' AND d.dmEstado=1 ORDER BY d.dmOrdenPreg ASC")    
    @Query("SELECT new com.app.uteqbackend.model.DatosMult(d.dmNombreGrad, d.dmProfesion, d.dmProfesionEn, d.dmProfesionPt, d.dmUrlFoto, d.dmRespuesta, d.dmRespuestaEn, d.dmRespuestaPt, d.dmOrdenPreg) FROM DatosMult d WHERE d.dmCategoria='CASOS_EXITO' AND d.dmEstado=1 ORDER BY d.dmOrdenPreg ASC")
    public List<DatosMult> getListTestimonialUniversity();

    @Query("SELECT new com.app.uteqbackend.model.GaleriaLb(g.glbCodigoLab, g.glbUrlImg, g.glbDescripc, g.glbOrden) FROM GaleriaLb g WHERE g.glbEstado=1 ORDER BY g.glbOrden ASC")
    public List<GaleriaLb> getListImagesLaboratory();

    //@Query("SELECT new com.app.uteqbackend.model.DatosMult(d.dmCodgDato, d.dmDescripcion, d.dmDescTramite) FROM DatosMult d WHERE d.dmCategoria='LAB_UNIV' AND d.dmEstado=1 ORDER BY d.dmOrdenPreg ASC")
    @Query("SELECT new com.app.uteqbackend.model.DatosMult(d.dmCodgDato, d.dmDescripcion, d.dmDescTramite, d.dmDescripcionEn, d.dmDescripcionPt, d.dmDescTramiteEn, d.dmDescTramitePt) FROM DatosMult d WHERE d.dmCategoria='LAB_UNIV' AND d.dmEstado=1 ORDER BY d.dmOrdenPreg ASC")
    public List<DatosMult> getInformationLaboratories();
    
    //Methods by language
    @Query(value = "select *FROM dm_listado_datos_multiples_por_tipo_lang(:type);", nativeQuery = true)
    List<DatosMult> getDataMultiplesOfUniversityLang(@Param("type") String typeMenu);
    

}
