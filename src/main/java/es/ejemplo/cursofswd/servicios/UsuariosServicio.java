package es.ejemplo.cursofswd.servicios;

import es.ejemplo.cursofswd.persistencia.Usuario;

import java.util.List;

public interface UsuariosServicio {

        List<Usuario> obtenerEstudiantes();

        Usuario buscarPorCorreoClave (String correo, String clave);
        List<Usuario> obtenerTodosUsuarios ();
        Usuario obtenerUsuarioPorId(Long id);

        Usuario nuevoUsuario (Usuario usuario);
}

