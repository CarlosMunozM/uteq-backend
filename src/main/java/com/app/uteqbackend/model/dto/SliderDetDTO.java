package com.app.uteqbackend.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author R.PP_UTEQ
 */
public class SliderDetDTO implements Serializable{
    
    private int sldCodigo;
    private String sldUrlImgVid;
    private String sldTipo;
    private String sldEnlace;
    private String sldTitulo;
    private String sldDescripcion;
    private int sldOrden;
    private String sldTituloEn;
    private String sldTituloPt;
    private String sldDescripcionEn;
    private String sldDescripcionPt;
    private String sldUrlImgVidEn;
    private String sldUrlImgVidPt;

    public SliderDetDTO() {
    }

    public SliderDetDTO(int sldCodigo, String sldUrlImgVid, String sldTipo, String sldEnlace, String sldTitulo, String sldDescripcion, int sldOrden, String sldTituloEn, String sldTituloPt, String sldDescripcionEn, String sldDescripcionPt, String sldUrlImgVidEn, String sldUrlImgVidPt) {
        this.sldCodigo = sldCodigo;
        this.sldUrlImgVid = sldUrlImgVid;
        this.sldTipo = sldTipo;
        this.sldEnlace = sldEnlace;
        this.sldTitulo = sldTitulo;
        this.sldDescripcion = sldDescripcion;
        this.sldOrden = sldOrden;
        this.sldTituloEn = sldTituloEn;
        this.sldTituloPt = sldTituloPt;
        this.sldDescripcionEn = sldDescripcionEn;
        this.sldDescripcionPt = sldDescripcionPt;
        this.sldUrlImgVidEn = sldUrlImgVidEn;
        this.sldUrlImgVidPt = sldUrlImgVidPt;
    }

    public int getSldCodigo() {
        return sldCodigo;
    }

    public void setSldCodigo(int sldCodigo) {
        this.sldCodigo = sldCodigo;
    }

    public String getSldUrlImgVid() {
        return sldUrlImgVid;
    }

    public void setSldUrlImgVid(String sldUrlImgVid) {
        this.sldUrlImgVid = sldUrlImgVid;
    }

    public String getSldTipo() {
        return sldTipo;
    }

    public void setSldTipo(String sldTipo) {
        this.sldTipo = sldTipo;
    }

    public String getSldEnlace() {
        return sldEnlace;
    }

    public void setSldEnlace(String sldEnlace) {
        this.sldEnlace = sldEnlace;
    }

    public String getSldTitulo() {
        return sldTitulo;
    }

    public void setSldTitulo(String sldTitulo) {
        this.sldTitulo = sldTitulo;
    }

    public String getSldDescripcion() {
        return sldDescripcion;
    }

    public void setSldDescripcion(String sldDescripcion) {
        this.sldDescripcion = sldDescripcion;
    }

    public int getSldOrden() {
        return sldOrden;
    }

    public void setSldOrden(int sldOrden) {
        this.sldOrden = sldOrden;
    }

    public String getSldTituloEn() {
        return sldTituloEn;
    }

    public void setSldTituloEn(String sldTituloEn) {
        this.sldTituloEn = sldTituloEn;
    }

    public String getSldTituloPt() {
        return sldTituloPt;
    }

    public void setSldTituloPt(String sldTituloPt) {
        this.sldTituloPt = sldTituloPt;
    }

    public String getSldDescripcionEn() {
        return sldDescripcionEn;
    }

    public void setSldDescripcionEn(String sldDescripcionEn) {
        this.sldDescripcionEn = sldDescripcionEn;
    }

    public String getSldDescripcionPt() {
        return sldDescripcionPt;
    }

    public void setSldDescripcionPt(String sldDescripcionPt) {
        this.sldDescripcionPt = sldDescripcionPt;
    }

    public String getSldUrlImgVidEn() {
        return sldUrlImgVidEn;
    }

    public void setSldUrlImgVidEn(String sldUrlImgVidEn) {
        this.sldUrlImgVidEn = sldUrlImgVidEn;
    }

    public String getSldUrlImgVidPt() {
        return sldUrlImgVidPt;
    }

    public void setSldUrlImgVidPt(String sldUrlImgVidPt) {
        this.sldUrlImgVidPt = sldUrlImgVidPt;
    }
    
}
