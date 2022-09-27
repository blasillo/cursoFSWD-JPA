package es.ejemplo.cursofswd;

import es.ejemplo.cursofswd.persistencia.Rol;
import es.ejemplo.cursofswd.persistencia.Usuario;
import es.ejemplo.cursofswd.persistencia.UsuariosRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UsuariosRepoTests {

    @Autowired
    UsuariosRepositorio repositorio;

    @Test
    public void deberia_inyectar_repositorio() {
        assertThat(repositorio).isNotNull();
    }

    @Test
    public void deberia_buscar_por_rol () {
        List<Usuario> estudiantes = repositorio.buscarPorRol( Rol.ESTUDIANTE);
        assertThat( estudiantes ).hasSize(1);
    }

    @Test
    public void deberia_buscar_por_usuario_y_contrasena () {
        Optional<Usuario> usuario = repositorio.buscarPorCorreoClave("prueba2@demo.com","admin");

        assertThat( usuario).isPresent();
    }

    @Test
    public void deberia_guardar_un_usuario() {
        Usuario usuario = new Usuario().builder()
                .nombreUsuario("demo")
                .correo("prueba@demo.com")
                .clave("123456")
                .rol(Rol.ESTUDIANTE)
                .build();

        Usuario usuarioGuardado = repositorio.save(usuario);

        Optional<Usuario> nuevoUsuario = repositorio.findById( usuarioGuardado.getIdUsuario());

        assertThat(nuevoUsuario).isPresent();
    }
}
