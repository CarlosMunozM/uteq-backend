package com.app.uteqbackend.serviceimpl;

import com.app.uteqbackend.model.Usuario;
import com.app.uteqbackend.repository.UsuarioRepository;
import com.app.uteqbackend.service.UsuarioService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Muñoz
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository objUsuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository objUsuarioRepository) {
        super();
        this.objUsuarioRepository = objUsuarioRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="ENCAPSULAMIENTOS">
    public UsuarioRepository getObjUsuarioRepository() {
        return objUsuarioRepository;
    }

    public void setObjUsuarioRepository(UsuarioRepository objUsuarioRepository) {
        this.objUsuarioRepository = objUsuarioRepository;
    }
    //</editor-fold>

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuariosActivosUTEQ() {
        return objUsuarioRepository.getListAllActiveUsersUTEQ();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuariosPorRolUTEQ(Integer rolId) {
        return objUsuarioRepository.getListUsersByRolUTEQ(rolId);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarUsuarioPorIdUTEQ(Integer id) {
        return objUsuarioRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Usuario guardarUsuarioUTEQ(Usuario usuario) {
        return objUsuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario actualizarUsuarioUTEQ(Usuario usuario) {
        return objUsuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public boolean eliminarLogicoUsuarioUTEQ(Integer id) {
        Usuario user = buscarUsuarioPorIdUTEQ(id);
        if (user != null) {
            user.setActivo(false);
            objUsuarioRepository.save(user);
            return true;
        }
        return false;
    }

}
