create table usuarios(
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    email varchar(100) not null unique,
    password varchar(300) not null unique,
    perfil_id bigint not null,

    primary key(id),

    constraint fk_usuarios_perfil_id foreign key(perfil_id) references perfiles(id)

);