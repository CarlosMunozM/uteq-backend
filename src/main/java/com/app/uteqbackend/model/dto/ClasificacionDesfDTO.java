package com.app.uteqbackend.model.dto;

/**
 *
 * @author R.PP_UTEQ
 */
public class ClasificacionDesfDTO {
    private String nombres;
    private Integer puntos;
    private String tiempo;

    // Constructor
    public ClasificacionDesfDTO(String nombres, Integer puntos) {
        this.nombres = nombres;
        this.puntos = puntos;
    }

    public ClasificacionDesfDTO(String nombres, Integer puntos, String tiempo) {
        this.nombres = nombres;
        this.puntos = puntos;
        this.tiempo = tiempo;
    }

    // Getters y Setters
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    
}
