package com.app.uteqbackend.service;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface RequerimientoCertfService {

    String registerRequestCertification(String cedula, String nombreComp, String correoElect, int tipoCertf, String mensaje);

}
