create table respuestas(
    id bigint not null auto_increment,
    mensaje TEXT not null,
    fecha_creacion datetime not null,
    usuario_id bigint not null,
    topico_id bigint not null,
    solucion tinyint DEFAULT 0,

    primary key(id),

    constraint fk_respuestas_usuario_id foreign key(usuario_id) references usuarios(id),
    constraint fk_respuestas_topico_id foreign key(topico_id) references topicos(id)

);