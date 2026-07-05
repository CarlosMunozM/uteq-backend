package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Carlos Muñoz
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // 1. Obtener todos los usuarios activos ordenados por nombre (Estilo Institucional)
    @Query("SELECT u FROM Usuario u WHERE u.activo = true ORDER BY u.nombre ASC")
    public List<Usuario> getListAllActiveUsersUTEQ();

    // 2. Buscar usuarios filtrados por el ID de su Rol
    @Query("SELECT u FROM Usuario u WHERE u.rol.id = :rolId AND u.activo = true ORDER BY u.nombre ASC")
    public List<Usuario> getListUsersByRolUTEQ(@Param("rolId") Integer rolId);

    // 3. Vista optimizada ligera (Trae solo Nombre y Email usando el constructor secundario de Usuario)
    @Query("SELECT new com.app.uteqbackend.model.Usuario(u.nombre, u.email) FROM Usuario u WHERE u.activo = true ORDER BY u.nombre ASC")
    public List<Usuario> getShortListUsersUTEQ();
    
    // 4. Buscar un usuario específico por su Email (Útil para validaciones de duplicados o login)
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    public Usuario getUserByEmailUTEQ(@Param("email") String email);
}
