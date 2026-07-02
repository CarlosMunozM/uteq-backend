package com.app.uteqbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "wp_galeria_pi")
public class GaleriaPI implements Serializable{
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES AND CONSTRUCTORS">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evd")
    private int gpiCodigo;
    
    @ManyToOne
    @JoinColumn(name = "id_proyecto_inv")
    @JsonIgnoreProperties("ptListadoEvds")
    private ProyectoInvst gpiProyectoInvst;
    
    @Column(name = "url_img", nullable = false)
    private String gpiUrlImagen;
    
    @Column(name = "descripcion", nullable = true)
    private String gpiDescripcion;
    
    @Column(name = "fecha_reg", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gpiFechaRegistro;
    
    @Column(name = "orden", nullable = false)
    private int gpiOrden;
    
    @Column(name = "estado", nullable = false, columnDefinition="INT CHECK(estado IN (0,1))")
    private int gpiEstado;
    
    public GaleriaPI() {
        super();
    }
    
    public GaleriaPI(int gpiCodigo, ProyectoInvst gpiProyectoInvst, String gpiUrlImagen, String gpiDescripcion, LocalDateTime gpiFechaRegistro, int gpiOrden, int gpiEstado) {
        super();
        this.gpiCodigo = gpiCodigo;
        this.gpiProyectoInvst = gpiProyectoInvst;
        this.gpiUrlImagen = gpiUrlImagen;
        this.gpiDescripcion = gpiDescripcion;
        this.gpiFechaRegistro = gpiFechaRegistro;
        this.gpiOrden = gpiOrden;
        this.gpiEstado = gpiEstado;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET AND SET">
    public int getGpiCodigo() {
        return gpiCodigo;
    }
    
    public void setGpiCodigo(int gpiCodigo) {
        this.gpiCodigo = gpiCodigo;
    }
    
    public ProyectoInvst getGpiProyectoInvst() {
        return gpiProyectoInvst;
    }
    
    public void setGpiProyectoInvst(ProyectoInvst gpiProyectoInvst) {
        this.gpiProyectoInvst = gpiProyectoInvst;
    }
    
    public String getGpiUrlImagen() {
        return gpiUrlImagen;
    }
    
    public void setGpiUrlImagen(String gpiUrlImagen) {
        this.gpiUrlImagen = gpiUrlImagen;
    }
    
    public String getGpiDescripcion() {
        return gpiDescripcion;
    }
    
    public void setGpiDescripcion(String gpiDescripcion) {
        this.gpiDescripcion = gpiDescripcion;
    }
    
    public LocalDateTime getGpiFechaRegistro() {
        return gpiFechaRegistro;
    }
    
    public void setGpiFechaRegistro(LocalDateTime gpiFechaRegistro) {
        this.gpiFechaRegistro = gpiFechaRegistro;
    }
    
    public int getGpiOrden() {
        return gpiOrden;
    }
    
    public void setGpiOrden(int gpiOrden) {
        this.gpiOrden = gpiOrden;
    }
    
    public int getGpiEstado() {
        return gpiEstado;
    }
    
    public void setGpiEstado(int gpiEstado) {
        this.gpiEstado = gpiEstado;
    }
//</editor-fold>
    
}
