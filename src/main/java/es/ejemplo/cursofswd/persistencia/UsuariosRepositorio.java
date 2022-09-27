package es.ejemplo.cursofswd.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepositorio extends JpaRepository <Usuario, Long> {
}

