create table clientes (
    id bigint not null auto_increment,
    cpf varchar(11) not null,
    nome varchar(255) not null,
    genero varchar(255) not null,
    data_de_nascimento date not null,
    profissao varchar(255) not null,
    renda_mensal decimal(19,2) not null,
    cep varchar(8) not null,
    cidade varchar(255) not null,
    estado varchar(255) not null,
    logradouro varchar(255) not null,
    numero varchar(255) not null,
    telefone varchar(11) not null,
    data datetime not null,
    primary key (id)
) engine=MyISAM DEFAULT CHARSET=utf8;

create table propostas_de_credito(
    id bigint not null auto_increment,
    cliente_id bigint not null,
    usuario_captador_id bigint not null,
    status varchar(255) not null,
    data datetime not null,
    resultado_id bigint, primary key (id)
) engine=MyISAM DEFAULT CHARSET=utf8;

create table resultados (
    id bigint not null auto_increment,
    valor decimal(19,2),
    motivo varchar(255),
    usuario_analisador_id bigint not null,
    data datetime not null,
    primary key (id)
) engine=MyISAM DEFAULT CHARSET=utf8;

create table usuarios (
    id bigint not null auto_increment,
    email varchar(255) not null,
    nome varchar(255) not null,
    papel varchar(255) not null,
    senha varchar(64) not null,
    primary key (id)
) engine=MyISAM DEFAULT CHARSET=utf8;