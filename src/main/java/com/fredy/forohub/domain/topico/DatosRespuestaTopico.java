package com.fredy.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion,
        Long usuario_id,
        Long curso_id,
        Boolean status
) {
    public DatosRespuestaTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha_creacion(),topico.getUsuario_id(),topico.getCurso_id(),topico.getStatus());
    }
}
