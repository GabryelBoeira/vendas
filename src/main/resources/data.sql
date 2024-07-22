--- ADD CLIENTES, CPFs gerados automaticamente https://www.4devs.com.br/gerador_de_cpf

insert into `CLIENTE` (`ID`, `NOME`, `CPF`) values (DEFAULT, 'João', '37772382014');
insert into `CLIENTE` (`ID`, `NOME`, `CPF`) values (DEFAULT, 'Maria', '00837598087');
insert into `CLIENTE` (`ID`, `NOME`, `CPF`) values (DEFAULT, 'Jose', '06355528091');
insert into `CLIENTE` (`ID`, `NOME`, `CPF`) values (DEFAULT, 'Carlos', '80071319069');
insert into `CLIENTE` (`ID`, `NOME`, `CPF`) values (DEFAULT, 'Pedro', '81454522011');
insert into `CLIENTE` (`ID`, `NOME`, `CPF`) values (DEFAULT, 'Will Smith', '14915748014');

--- ADD PRODUTOS
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (DEFAULT, 'Cerveja', 5.00);
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (DEFAULT, 'Agua', 2.00);
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (DEFAULT, 'Refrigerante', 3.00);
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (DEFAULT, 'Suco', 3.00);
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (DEFAULT, 'Cachorro-Quente', 4.00);


---ADD pedidos
insert into `PEDIDO` (`ID`, `CLIENTE_ID`, `VALOR_TOTAL`, `DATA_PEDIDO`, `STATUS`) values (DEFAULT, 1, 150.00, '2020-01-01 00:00:00.000000', 'DONE');
insert into `PEDIDO` (`ID`, `CLIENTE_ID`, `VALOR_TOTAL`, `DATA_PEDIDO`, `STATUS`) values (DEFAULT, 1, 100.00, '2020-01-01 00:00:00.000000', 'DONE');
insert into `PEDIDO` (`ID`, `CLIENTE_ID`, `VALOR_TOTAL`, `DATA_PEDIDO`, `STATUS`) values (DEFAULT, 1, 100.00, '2020-01-01 00:00:00.000000', 'DONE');

---ADD item pedido
insert into `PEDIDO_ITEM` (`ID`, `PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (DEFAULT, 1, 1, 2);
insert into `PEDIDO_ITEM` (`ID`, `PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (DEFAULT, 1, 5, 1);
insert into `PEDIDO_ITEM` (`ID`, `PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (DEFAULT, 1, 3, 2);

insert into `PEDIDO_ITEM` (`ID`, `PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (DEFAULT, 2, 3, 5);
insert into `PEDIDO_ITEM` (`ID`, `PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (DEFAULT, 2, 4, 2);
insert into `PEDIDO_ITEM` (`ID`, `PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (DEFAULT, 2, 5, 7);

insert into `PEDIDO_ITEM` (`ID`, `PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (DEFAULT, 3, 3, 5);
insert into `PEDIDO_ITEM` (`ID`, `PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (DEFAULT, 3, 4, 2);
insert into `PEDIDO_ITEM` (`ID`, `PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (DEFAULT, 3, 5, 7);

---ADD USER
insert into `USER_SYSTEM` (`ID`, `USERNAME`, `PASSWORD`, `ACTIVE`, `ADMIN`) values (DEFAULT, 'admin', '$2a$10$FuEq5aJhhvuTOW/amhE7VOyA8ktKU77CiFClPhL3XJTDbHDWXvBQO', true, true);
