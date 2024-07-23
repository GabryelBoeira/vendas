create table if not exists tb_cidades (
    ID bigint not null AUTO_INCREMENT,
    NOME varchar(120) not null,
    POPULACAO bigint,
    PRIMARY KEY ( ID )
);

insert into tb_cidades (ID, NOME, POPULACAO) values (1, 'Campinas', 200000);
insert into tb_cidades (ID, NOME, POPULACAO) values (2, 'Sao Paulo', 300000);
insert into tb_cidades (ID, NOME, POPULACAO) values (3, 'Rio de Janeiro', 400000);