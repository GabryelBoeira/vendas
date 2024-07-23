create table if not exists tb_cidades (
    ID bigint not null AUTO_INCREMENT,
    NOME varchar(120) not null,
    POPULACAO bigint,
    PRIMARY KEY ( ID )
);

insert into tb_cidades
    (ID, NOME, POPULACAO)
values
    (1, 'Campinas', 200000),
    (2, 'Sao Paulo', 30000000),
    (3, 'Rio de Janeiro', 400000),
    (4, 'Belo Horizonte', 500000),
    (5, 'Porto Alegre', 600000),
    (6, 'Florianopolis', 700000),
    (7, 'Curitiba', 800000),
    (8, 'Recife', 900000),
    (9, 'Fortaleza', 1000000),
    (10, 'Natal', 1100000);
