package com.app.uteqbackend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "wp_inscripcion_msc")
public class InscripcionMsc  implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private int isCodigo;
    
    @Column(name = "fecha_reg", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date isFechaReg;
    
    @Column(name="dni", nullable=false, length = 20)
    private String isCodgDNI;
    
    @Column(name="nombre_comp", nullable=false, length = 200)
    private String isNombreComp;
    
    @Column(name="correo_elect", nullable=false, length = 200)
    private String isCorreoElect;
    
    @Column(name="telefono", nullable=false, length = 25)
    private String isTelefono;
    
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "id_maestria", nullable = false, updatable = false)
    private UUID isCodMaestria;
    
    @Column(name = "url_brochure_msc", nullable = true, length = 1000)
    private String isUrlBrochure;
    
    public InscripcionMsc() {
        super();
    }
    
    public InscripcionMsc(int isCodigo, Date isFechaReg, String isCodgDNI, String isNombreComp, String isTelefono, UUID isCodMaestria) {
        super();
        this.isCodigo = isCodigo;
        this.isFechaReg = isFechaReg;
        this.isCodgDNI = isCodgDNI;
        this.isNombreComp = isNombreComp;
        this.isTelefono = isTelefono;
        this.isCodMaestria = isCodMaestria;
    }
    
    public InscripcionMsc(int isCodigo, Date isFechaReg, String isCodgDNI, String isNombreComp, String isCorreoElect, String isTelefono, UUID isCodMaestria) {
        super();
        this.isCodigo = isCodigo;
        this.isFechaReg = isFechaReg;
        this.isCodgDNI = isCodgDNI;
        this.isNombreComp = isNombreComp;
        this.isCorreoElect = isCorreoElect;
        this.isTelefono = isTelefono;
        this.isCodMaestria = isCodMaestria;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getIsCodigo() {
        return isCodigo;
    }
    
    public void setIsCodigo(int isCodigo) {
        this.isCodigo = isCodigo;
    }
    
    public Date getIsFechaReg() {
        return isFechaReg;
    }
    
    public void setIsFechaReg(Date isFechaReg) {
        this.isFechaReg = isFechaReg;
    }
    
    public String getIsCodgDNI() {
        return isCodgDNI;
    }
    
    public void setIsCodgDNI(String isCodgDNI) {
        this.isCodgDNI = isCodgDNI;
    }
    
    public String getIsNombreComp() {
        return isNombreComp;
    }
    
    public void setIsNombreComp(String isNombreComp) {
        this.isNombreComp = isNombreComp;
    }
    
    public String getIsTelefono() {
        return isTelefono;
    }
    
    public void setIsTelefono(String isTelefono) {
        this.isTelefono = isTelefono;
    }
    
    public UUID getIsCodMaestria() {
        return isCodMaestria;
    }
    
    public void setIsCodMaestria(UUID isCodMaestria) {
        this.isCodMaestria = isCodMaestria;
    }
    
    public String getIsCorreoElect() {
        return isCorreoElect;
    }
    
    public void setIsCorreoElect(String isCorreoElect) {
        this.isCorreoElect = isCorreoElect;
    }
    
    public String getIsUrlBrochure() {
        return isUrlBrochure;
    }
    
    public void setIsUrlBrochure(String isUrlBrochure) {
        this.isUrlBrochure = isUrlBrochure;
    }
//</editor-fold>
    
}
