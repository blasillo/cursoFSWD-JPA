package es.ejemplo.cursofswd.servicios;

import es.ejemplo.cursofswd.persistencia.Rol;
import es.ejemplo.cursofswd.persistencia.Usuario;
import es.ejemplo.cursofswd.persistencia.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;


@Service
public class UsuariosServicioImpl implements UsuariosServicio {

    // TODO
    UsuariosRepositorio repositorio;

    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        return repositorio.findAll();
    }

    @Override
    public List<Usuario> obtenerEstudiantes() {

        return // TODO
    }


    @Override
    public Usuario buscarPorCorreoClave(String correo, String clave) {
        return //TODO
    }



    @Override
    public Usuario obtenerUsuarioPorId(Long id) {

        return // TODO
    }

    @Override
    @Transactional
    public Usuario nuevoUsuario(Usuario usuario)  {
        usuario.setRol( Rol.ESTUDIANTE); // usuario nuevo por defecto es estudiante
        // la clave no hay que guardarla en claro
        usuario.setClave(  Base64.getEncoder().encodeToString( usuario.getClave().getBytes(StandardCharsets.UTF_8)) );


        return // TODO
    }


}
