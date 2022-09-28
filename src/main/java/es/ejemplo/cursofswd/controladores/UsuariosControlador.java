package es.ejemplo.cursofswd.controladores;

import es.ejemplo.cursofswd.persistencia.Usuario;
import es.ejemplo.cursofswd.servicios.UsuariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuariosControlador {
    @Autowired
    private UsuariosServicio servicio;

    @GetMapping("/api/v1/usuarios/")
    public ResponseEntity<?> verUsuarios() {
        return ResponseEntity.ok(servicio.obtenerTodosUsuarios());
    }
    @GetMapping("/api/v1/usuarios/{id}")
    public ResponseEntity<?> verUsuarioPorId  (@PathVariable Long id) {
        return ResponseEntity.ok (servicio.obtenerUsuarioPorId(id));
    }

    @GetMapping("/api/v1/estudiantes/")
    public ResponseEntity<?> verEstudiantes() {
        return ResponseEntity.ok(servicio.obtenerEstudiantes());
    }

    @PostMapping("/api/v1/usuarios/registro")
    public ResponseEntity<?> registroUsuarios (@RequestBody Usuario usuario){
        return new ResponseEntity<>( servicio.nuevoUsuario(usuario ), HttpStatus.CREATED);
    }


}
