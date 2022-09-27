package es.ejemplo.cursofswd;

import es.ejemplo.cursofswd.persistencia.Rol;
import es.ejemplo.cursofswd.persistencia.Usuario;
import es.ejemplo.cursofswd.persistencia.UsuariosRepositorio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class CursoFswdApplication {

    @Autowired
    UsuariosRepositorio repositorio;


    public static void main(String[] args) {
        SpringApplication.run(CursoFswdApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return (args) -> {

            log.info("Añadiendo usuarios....\n");
            Usuario admin = new Usuario().builder()
                    .nombreUsuario("admin")
                    .correo("prueba2@demo.com")
                    .clave("admin")
                    .rol(Rol.ADMINISTRADOR)
                    .build();
            repositorio.save( admin );

            Usuario profesor = new Usuario().builder()
                    .nombreUsuario("profesor")
                    .correo("profe@demo.com")
                    .clave("lacasadepapel")
                    .rol(Rol.PROFESOR)
                    .build();

            repositorio.save ( profesor);

            Usuario estudiante = new Usuario().builder()
                    .nombreUsuario("estudiante1")
                    .correo("estudiante@demo.com")
                    .clave("123456")
                    .rol(Rol.ESTUDIANTE)
                    .build();
            repositorio.save(estudiante);


            Optional<Usuario> resultado1 = repositorio.findByCorreoAndClave("profe@demo.com", "lacasadepapel");
            if (resultado1.isPresent()) System.out.println(resultado1.toString());

            //List<Usuario> estu = repositorio.findByRol_Estudiante();
            //System.out.println(estu.stream().collect(Collectors.toList()));

        };
    }

}
