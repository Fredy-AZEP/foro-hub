create table topicos(
    id bigint not null auto_increment,
    titulo varchar(250) not null,
    mensaje TEXT not null,
    fecha_creacion datetime not null,
    usuario_id bigint not null,
    curso_id bigint not null,
    status tinyint,

    primary key(id),

    constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(id),
    constraint fk_topicos_curso_id foreign key(curso_id) references cursos(id)

);