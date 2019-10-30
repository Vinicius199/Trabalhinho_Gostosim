CREATE TABLE tipo(
	IdTipo integer auto_increment,
    NomeTipo varchar(100),
    constraint tipo_PK primary key (IdTipo)
);
    
CREATE TABLE usuario(
	Login varchar(50),
    Senha varchar(50),
    Email varchar(50),
    Nome varchar(50),
    Telefone integer,
    constraint usuario_PK primary key (Login)
);

CREATE TABLE cadastro_financeiro(
	NCadastro int  auto_increment,
    DescCompra varchar(100),
    Valor real,
    LoginUsua varchar(50),
    constraint cadastro_financeiro_PK primary key (NCadastro),
    foreign key (LoginUsua) references USUARIO (Login)
);

CREATE TABLE cadastro_financa_tem_tipo(
	NCadastro int,
    IdTipo integer,
    constraint cadastro_financa_tem_tipo_PK primary key (NCadastro, IdTipo),
    foreign key (NCadastro) references cadastro_financeiro (NCadastro),
    foreign key (IdTipo) references tipo (IdTipo)
);
