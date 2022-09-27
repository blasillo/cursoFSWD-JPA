package es.ejemplo.cursofswd.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepositorio extends JpaRepository <Usuario, Long> {

    Optional<Usuario> findByCorreoAndClave(String correo, String clave);

    //List<Usuario> findByRol_Estudiante();

    @Query ("select u from Usuario u where u.rol = :rol")
    List<Usuario> buscarPorRol(@Param("rol")Rol rol);

    @Query("select u from Usuario u where u.correo = :correo and u.clave = :clave")
    Optional<Usuario> buscarPorCorreoClave(@Param("correo")String correo,@Param("clave")String clave);


    //List<Usuario> findAllByClaveLessThan8();
}

