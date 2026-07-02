package com.app.uteqbackend.service;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface SugerenciaService {

    String registerDataSuggestion(String nombre, String correoElect, int destinatario, String asunto, String mensaje);
    
    String registerDataSupportAdmission(String nombre, String correoElect, String destinatario, String asunto, String mensaje);
            
}
