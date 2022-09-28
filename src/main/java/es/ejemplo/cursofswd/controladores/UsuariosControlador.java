package es.ejemplo.cursofswd.controladores;

import es.ejemplo.cursofswd.persistencia.Usuario;
import es.ejemplo.cursofswd.servicios.UsuariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuariosControlador {
    //TODO
    private UsuariosServicio servicio;

    @GetMapping("/api/v1/usuarios/")
    public ResponseEntity<?> verUsuarios() {
        return ResponseEntity.ok(servicio.obtenerTodosUsuarios());
    }
    @GetMapping("/api/v1/usuarios/{id}")
    public ResponseEntity<?> verUsuarioPorId  (@PathVariable Long id) {
        return // TODO
    }

    @GetMapping("/api/v1/estudiantes/")
    public ResponseEntity<?> verEstudiantes() {
        return // TODO
    }

    @PostMapping("/api/v1/usuarios/registro")
    public ResponseEntity<?> registroUsuarios (@RequestBody Usuario usuario){
        return //TODO
    }


}
