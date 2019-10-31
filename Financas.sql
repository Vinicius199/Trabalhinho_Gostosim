CREATE TABLE usuario(

	Login varchar(50),

    Senha varchar(50),

    Email varchar(50),

    Nome varchar(50),

    Telefone integer,

    constraint usuario_PK primary key (Login)

);



CREATE TABLE cadastro_financeiro(

	LoginUsua varchar(50),
	NCadastro int  auto_increment,
    DescCompra varchar(100),
    Valor real,
    NomeTipo varchar(100),
	Tempo varchar(50),
    constraint cadastro_financeiro_PK primary key (NCadastro),

    foreign key (LoginUsua) references usuario (Login) on delete cascade 

);
