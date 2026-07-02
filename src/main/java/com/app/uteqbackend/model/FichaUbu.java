package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;
import org.hibernate.annotations.Type;

/**
 *
 * @author ANALISTA-TIC 2
 */
@Data
@Entity
@Table(name = "wp_ficha_datos_ubu")
public class FichaUbu implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficha")
    private int fuCodigo;
    
    @Column(name = "num_cedula", nullable = false)
    private String fuCedula;
    
    @Column(name = "nombre_comp", nullable = false)
    private String fuNombreComp;
    
    @Column(name = "telf_movil", nullable = false)
    private String fuTelfMov;
    
    @Column(name = "telf_fijo", nullable = true)
    private String fuTelfFijo;
    
    @Column(name = "nombre_foto", nullable = false)
    private String fuNombreFoto;
    
    @Lob
    @Column(name = "img_perfil", nullable = false)
    private byte[] fuArchivoFoto;
    
    @Column(name = "id_semestre", nullable = false)
    private int fuCodSemestre;
    
    @Column(name = "semestre", nullable = false)
    private String fuSemestre;
    
    @Column(name = "direccion_domc", nullable = false)
    private String fuDireccionDomic;
    
    @Column(name = "correo_elect", nullable = false)
    private String fuCorreoElect;
    
    @Column(name = "id_tipo_sangre", nullable = false)
    private int fuIdTipoSangre;
    
    @Column(name = "tipo_sangre", nullable = false)
    private String fuTipoSangre;
    
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id_facultad", nullable = false, updatable = false)
    private UUID fuIdFacultad;
    
    @Column(name = "facultad", nullable = false)
    private String fuFacultad;
    
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id_carrera", nullable = false, updatable = false)
    private UUID fuIdCarrera;
    
    @Column(name = "carrera", nullable = false)
    private String fuCarrera;
    
    @Column(name = "fecha_reg", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fuFechaReg;
    
    @Column(name = "estado", nullable = false, columnDefinition = "INT CHECK(estado IN (0,1))")
    private int fuEstado;
    
    @OneToMany(mappedBy = "uaFichaUbu", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<FichaUbuActvds> fuListadoActividades = new HashSet<FichaUbuActvds>();
    
    public FichaUbu() {
        super();
    }
    
    public FichaUbu(int fuCodigo, String fuCedula, String fuNombreComp, String fuTelfMov, String fuTelfFijo, String fuNombreFoto, byte[] fuArchivoFoto, int fuCodSemestre, String fuSemestre, String fuDireccionDomic, String fuCorreoElect, int fuIdTipoSangre, String fuTipoSangre, UUID fuIdFacultad, String fuFacultad, UUID fuIdCarrera, String fuCarrera, Date fuFechaReg, int fuEstado) {
        super();
        this.fuCodigo = fuCodigo;
        this.fuCedula = fuCedula;
        this.fuNombreComp = fuNombreComp;
        this.fuTelfMov = fuTelfMov;
        this.fuTelfFijo = fuTelfFijo;
        this.fuNombreFoto = fuNombreFoto;
        this.fuArchivoFoto = fuArchivoFoto;
        this.fuCodSemestre = fuCodSemestre;
        this.fuSemestre = fuSemestre;
        this.fuDireccionDomic = fuDireccionDomic;
        this.fuCorreoElect = fuCorreoElect;
        this.fuIdTipoSangre = fuIdTipoSangre;
        this.fuTipoSangre = fuTipoSangre;
        this.fuIdFacultad = fuIdFacultad;
        this.fuFacultad = fuFacultad;
        this.fuIdCarrera = fuIdCarrera;
        this.fuCarrera = fuCarrera;
        this.fuFechaReg = fuFechaReg;
        this.fuEstado = fuEstado;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getFuCodigo() {
        return fuCodigo;
    }
    
    public void setFuCodigo(int fuCodigo) {
        this.fuCodigo = fuCodigo;
    }
    
    public String getFuCedula() {
        return fuCedula;
    }
    
    public void setFuCedula(String fuCedula) {
        this.fuCedula = fuCedula;
    }
    
    public String getFuNombreComp() {
        return fuNombreComp;
    }
    
    public void setFuNombreComp(String fuNombreComp) {
        this.fuNombreComp = fuNombreComp;
    }
    
    public String getFuTelfMov() {
        return fuTelfMov;
    }
    
    public void setFuTelfMov(String fuTelfMov) {
        this.fuTelfMov = fuTelfMov;
    }
    
    public String getFuTelfFijo() {
        return fuTelfFijo;
    }
    
    public void setFuTelfFijo(String fuTelfFijo) {
        this.fuTelfFijo = fuTelfFijo;
    }
    
    public String getFuNombreFoto() {
        return fuNombreFoto;
    }
    
    public void setFuNombreFoto(String fuNombreFoto) {
        this.fuNombreFoto = fuNombreFoto;
    }
    
    public byte[] getFuArchivoFoto() {
        return fuArchivoFoto;
    }
    
    public void setFuArchivoFoto(byte[] fuArchivoFoto) {
        this.fuArchivoFoto = fuArchivoFoto;
    }
    
    public int getFuCodSemestre() {
        return fuCodSemestre;
    }
    
    public void setFuCodSemestre(int fuCodSemestre) {
        this.fuCodSemestre = fuCodSemestre;
    }
    
    public String getFuSemestre() {
        return fuSemestre;
    }
    
    public void setFuSemestre(String fuSemestre) {
        this.fuSemestre = fuSemestre;
    }
    
    public String getFuDireccionDomic() {
        return fuDireccionDomic;
    }
    
    public void setFuDireccionDomic(String fuDireccionDomic) {
        this.fuDireccionDomic = fuDireccionDomic;
    }
    
    public String getFuCorreoElect() {
        return fuCorreoElect;
    }
    
    public void setFuCorreoElect(String fuCorreoElect) {
        this.fuCorreoElect = fuCorreoElect;
    }
    
    public int getFuIdTipoSangre() {
        return fuIdTipoSangre;
    }
    
    public void setFuIdTipoSangre(int fuIdTipoSangre) {
        this.fuIdTipoSangre = fuIdTipoSangre;
    }
    
    public String getFuTipoSangre() {
        return fuTipoSangre;
    }
    
    public void setFuTipoSangre(String fuTipoSangre) {
        this.fuTipoSangre = fuTipoSangre;
    }
    
    public UUID getFuIdFacultad() {
        return fuIdFacultad;
    }
    
    public void setFuIdFacultad(UUID fuIdFacultad) {
        this.fuIdFacultad = fuIdFacultad;
    }
    
    public String getFuFacultad() {
        return fuFacultad;
    }
    
    public void setFuFacultad(String fuFacultad) {
        this.fuFacultad = fuFacultad;
    }
    
    public UUID getFuIdCarrera() {
        return fuIdCarrera;
    }
    
    public void setFuIdCarrera(UUID fuIdCarrera) {
        this.fuIdCarrera = fuIdCarrera;
    }
    
    public String getFuCarrera() {
        return fuCarrera;
    }
    
    public void setFuCarrera(String fuCarrera) {
        this.fuCarrera = fuCarrera;
    }
    
    public Date getFuFechaReg() {
        return fuFechaReg;
    }
    
    public void setFuFechaReg(Date fuFechaReg) {
        this.fuFechaReg = fuFechaReg;
    }
    
    public int getFuEstado() {
        return fuEstado;
    }
    
    public void setFuEstado(int fuEstado) {
        this.fuEstado = fuEstado;
    }
    
    public Set<FichaUbuActvds> getFuListadoActividades() {
        return fuListadoActividades;
    }
    
    public void setFuListadoActividades(Set<FichaUbuActvds> fuListadoActividades) {
        this.fuListadoActividades = fuListadoActividades;
    }
//</editor-fold>
    
}
