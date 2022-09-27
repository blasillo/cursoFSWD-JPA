package es.ejemplo.cursofswd;

import es.ejemplo.cursofswd.persistencia.UsuariosRepositorio;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CursoFswdApplicationTests {

    @Autowired
    UsuariosRepositorio repositorio;
    @Test
    void contextLoads() {
        assertThat(repositorio).isNotNull();
    }


}
