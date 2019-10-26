CREATE DATABASE FINACAS:
USE FINANCAS:

CREATE TABLE TIPO(
	IdTipo integer,
    NomeTipo varchar(100),
    constraint TIPO_PK primary key (IdTipo)
);
    
CREATE TABLE USUARIO(
	Login varchar(50),
    Senha varchar(50),
    Email varchar(50),
    Nome varchar(50),
    Telefone integer,
    constraint USUARIO_PK primary key (Login)
);

CREATE TABLE CADASTRO_FINANCEIRO(
	NCadastro int,
    DescricaoCompra varchar(100),
    Valor real,
    LoginUsua varchar(50),
    IdT integer,
    constraint CADASTRO_FINANCEIRO primary key (NCadastro),
    foreign key (LoginUsua) references USUARIO (Login),
    foreign key (IdT) references TIPO (IdTipo)
);

CREATE TABLE PESQUISA(
	NCadastro int,
    Login varchar(50),
    constraint PESQUISA_PK primary key (NCadastro, Login),
    foreign key (NCadastro) references CADASTRO_FINANCEIRO (N_Cadastro),
    foreign key (Login) references USUARIO (Login)
);