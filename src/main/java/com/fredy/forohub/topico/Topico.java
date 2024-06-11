package com.fredy.forohub.topico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @Column(unique = true)
    private String mensaje;

    private LocalDateTime fecha_creacion;

    private Long usuario_id;

    private Long curso_id;

    private Boolean status;

    public Topico(DatosRegistroTopico datosRegistroTopico){
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fecha_creacion = LocalDateTime.now();
        this.usuario_id = datosRegistroTopico.usuario_id();
        this.curso_id = datosRegistroTopico.curso_id();
        this.status = true;
    }

    public void actualizarTopico(DatosActualizarTopico datosActualizarTopico){
        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
    }

    public void desactivarTopico(){
        this.status = false;
    }
}
