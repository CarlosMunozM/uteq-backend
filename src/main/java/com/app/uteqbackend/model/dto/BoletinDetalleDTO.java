package com.app.uteqbackend.model.dto;

import lombok.Data;

@Data
public class BoletinDetalleDTO {
    private Integer idDetalle;
    private Integer limiteItems;
    private Integer idSeccion;
    private Integer idReferencia;
    private String urlPortada;
    private String urlNoticia;
    private String titular;
    private Integer orden;

    public BoletinDetalleDTO() {
    }

    public BoletinDetalleDTO(Integer idDetalle, Integer limiteItems, Integer idSeccion,
                             Integer idReferencia, String urlPortada, String urlNoticia,
                             String titular, Integer orden) {
        this.idDetalle = idDetalle;
        this.limiteItems = limiteItems;
        this.idSeccion = idSeccion;
        this.idReferencia = idReferencia;
        this.urlPortada = urlPortada;
        this.urlNoticia = urlNoticia;
        this.titular = titular;
        this.orden = orden;
    }
}
