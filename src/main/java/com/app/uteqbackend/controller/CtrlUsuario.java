package com.app.uteqbackend.controller;

import com.app.uteqbackend.model.Usuario;
import com.app.uteqbackend.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Muñoz 2
 */
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Permite que React/Next.js se conecte sin problemas de CORS
public class CtrlUsuario {

    private final UsuarioService objUsuarioService;

    @Autowired
    public CtrlUsuario(UsuarioService objUsuarioService) {
        super();
        this.objUsuarioService = objUsuarioService;
    }

    // 1. GET: Listar todos los activos
    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        try {
            List<Usuario> lista = objUsuarioService.listarUsuariosActivosUTEQ();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Error in function listarUsuarios(): " + ex.getMessage());
            return new ResponseEntity<>("Error al obtener la lista de usuarios.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 2. GET: Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id) {
        try {
            Usuario user = objUsuarioService.buscarUsuarioPorIdUTEQ(id);
            if (user == null) {
                return new ResponseEntity<>("Usuario no encontrado.", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Error in function buscarPorId(): " + ex.getMessage());
            return new ResponseEntity<>("Error interno al buscar el usuario.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 3. GET: Filtrar por Rol
    @GetMapping("/rol/{rolId}")
    public ResponseEntity<?> listarPorRol(@PathVariable("rolId") Integer rolId) {
        try {
            List<Usuario> lista = objUsuarioService.listarUsuariosPorRolUTEQ(rolId);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Error in function listarPorRol(): " + ex.getMessage());
            return new ResponseEntity<>("Error al filtrar usuarios por rol.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 4. POST: Crear nuevo usuario
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = objUsuarioService.guardarUsuarioUTEQ(usuario);
            return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println("Error in function crearUsuario(): " + ex.getMessage());
            return new ResponseEntity<>("Error al registrar el nuevo usuario.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 5. PUT: Actualizar usuario
    @PutMapping
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario) {
        try {
            if (usuario.getId() == null) {
                return new ResponseEntity<>("El ID del usuario es obligatorio para actualizar.", HttpStatus.BAD_REQUEST);
            }
            Usuario usuarioEditado = objUsuarioService.actualizarUsuarioUTEQ(usuario);
            return new ResponseEntity<>(usuarioEditado, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Error in function actualizarUsuario(): " + ex.getMessage());
            return new ResponseEntity<>("Error al actualizar los datos del usuario.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 6. DELETE: Eliminación lógica
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarLogico(@PathVariable("id") Integer id) {
        try {
            boolean eliminado = objUsuarioService.eliminarLogicoUsuarioUTEQ(id);
            if (!eliminado) {
                return new ResponseEntity<>("No se encontró el usuario para eliminar.", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Usuario deshabilitado correctamente.", HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Error in function eliminarLogico(): " + ex.getMessage());
            return new ResponseEntity<>("Error al intentar eliminar el usuario.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //</editor-fold>
}
