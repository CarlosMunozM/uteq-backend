package com.app.uteqbackend.service;

import com.app.uteqbackend.model.Usuario;
import java.util.List;

/**
 *
 * @author Carlos Muñoz
 */
public interface UsuarioService {

    // Listar todos los usuarios activos
    public List<Usuario> listarUsuariosActivosUTEQ();

    // Listar usuarios filtrados por rol
    public List<Usuario> listarUsuariosPorRolUTEQ(Integer rolId);

    // Buscar un usuario por su ID (Para cuando vayas a editar en Next.js)
    public Usuario buscarUsuarioPorIdUTEQ(Integer id);

    // Guardar o Crear un nuevo usuario
    public Usuario guardarUsuarioUTEQ(Usuario usuario);

    // Modificar un usuario existente
    public Usuario actualizarUsuarioUTEQ(Usuario usuario);

    // Eliminar de forma lógica (cambiar activo a false)
    public boolean eliminarLogicoUsuarioUTEQ(Integer id);
}
