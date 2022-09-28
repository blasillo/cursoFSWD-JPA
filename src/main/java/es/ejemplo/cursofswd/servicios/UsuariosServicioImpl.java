package es.ejemplo.cursofswd.servicios;

import es.ejemplo.cursofswd.persistencia.Rol;
import es.ejemplo.cursofswd.persistencia.Usuario;
import es.ejemplo.cursofswd.persistencia.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuariosServicioImpl implements UsuariosServicio {

    @Autowired
    UsuariosRepositorio repositorio;

    @Override
    public List<Usuario> obtenerEstudiantes() {
        //return repositorio.buscarPorRol(Rol.ESTUDIANTE);
        List<Usuario> usuarios = repositorio.findAll()
                                            .stream()
                                              .filter( usu -> usu.getRol().equals(Rol.ESTUDIANTE))
                                              .collect(Collectors.toList());
        return usuarios;
    }


    @Override
    public Usuario buscarPorCorreoClave(String correo, String clave) {
        return repositorio.buscarPorCorreoClave(correo,clave)
                          .orElse(null);
    }

    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        return repositorio.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Usuario nuevoUsuario(Usuario usuario)  {
        usuario.setRol( Rol.ESTUDIANTE); // usuario nuevo por defecto es estudiante
        // la clave hay que guardarla no en claro
        usuario.setClave(  Base64.getEncoder().encodeToString( usuario.getClave().getBytes(StandardCharsets.UTF_8)) );
        return repositorio.save( usuario );
    }


}
