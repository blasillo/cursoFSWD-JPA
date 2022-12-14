package es.ejemplo.cursofswd.persistencia;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_usuario", nullable = false,updatable = false)
    private Long idUsuario;

    @Column (name = "nombre_usuario", unique = true, nullable = false, length = 100)
    private String nombreUsuario;

    @Column (name="correo", nullable = false, unique=true, length = 100)
    private String correo;

    @Column (name="clave", nullable = false, length = 255)
    private String clave;

    @Column (name="rol", nullable = false)
    @Enumerated (value = EnumType.STRING)
    private Rol rol;

    @Transient
    private String token;
}
