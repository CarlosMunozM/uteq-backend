package com.app.uteqbackend.model.dto;

import com.app.uteqbackend.model.SliderDet;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author R.PP_UTEQ
 */
public class SliderCabzDTO implements Serializable{
    
    private int slcCodigo;
    private String slcCodigoEntd;
    private String slcUbicacion;
    private String slcTipo;
    private int slcEstado;
    private List<SliderDet> slcListadoImagenes;

    public SliderCabzDTO() {
    }

    public SliderCabzDTO(int slcCodigo, String slcCodigoEntd, String slcUbicacion, String slcTipo, int slcEstado, List<SliderDet> slcListadoImagenes) {
        this.slcCodigo = slcCodigo;
        this.slcCodigoEntd = slcCodigoEntd;
        this.slcUbicacion = slcUbicacion;
        this.slcTipo = slcTipo;
        this.slcEstado = slcEstado;
        this.slcListadoImagenes = slcListadoImagenes;
    }

    public int getSlcCodigo() {
        return slcCodigo;
    }

    public void setSlcCodigo(int slcCodigo) {
        this.slcCodigo = slcCodigo;
    }

    public String getSlcCodigoEntd() {
        return slcCodigoEntd;
    }

    public void setSlcCodigoEntd(String slcCodigoEntd) {
        this.slcCodigoEntd = slcCodigoEntd;
    }

    public String getSlcUbicacion() {
        return slcUbicacion;
    }

    public void setSlcUbicacion(String slcUbicacion) {
        this.slcUbicacion = slcUbicacion;
    }

    public String getSlcTipo() {
        return slcTipo;
    }

    public void setSlcTipo(String slcTipo) {
        this.slcTipo = slcTipo;
    }

    public int getSlcEstado() {
        return slcEstado;
    }

    public void setSlcEstado(int slcEstado) {
        this.slcEstado = slcEstado;
    }

    public List<SliderDet> getSlcListadoImagenes() {
        return slcListadoImagenes;
    }

    public void setSlcListadoImagenes(List<SliderDet> slcListadoImagenes) {
        this.slcListadoImagenes = slcListadoImagenes;
    }
    
}
