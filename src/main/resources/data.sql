--- ADD CLIENTES, CPFs gerados automaticamente https://www.4devs.com.br/gerador_de_cpf

insert into `CLIENTE` (`ID`, `NOME`, `CPF`) values (100,'João', '37772382014');
insert into `CLIENTE` (`NOME`, `CPF`) values ('Maria', '00837598087');
insert into `CLIENTE` (`NOME`, `CPF`) values ('Jose', '06355528091');
insert into `CLIENTE` (`NOME`, `CPF`) values ('Carlos', '80071319069');
insert into `CLIENTE` (`NOME`, `CPF`) values ('Pedro', '81454522011');
insert into `CLIENTE` (`NOME`, `CPF`) values ('Will Smith', '14915748014');

--- ADD PRODUTOS
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (1, 'Cerveja', 5.00);
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (2, 'Agua', 2.00);
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (3, 'Refrigerante', 3.00);
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (4, 'Suco', 3.00);
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (5, 'Cachorro Quente', 4.00);


---ADD pedidos
insert into `PEDIDO` (`ID`, `CLIENTE_ID`, `VALOR_TOTAL`, `DATA_PEDIDO`) values (1, 100, 150.00, '2020-01-01 00:00:00.000000');
insert into `PEDIDO` (`ID`, `CLIENTE_ID`, `VALOR_TOTAL`, `DATA_PEDIDO`) values (2, 100, 100.00, '2020-01-01 00:00:00.000000');
insert into `PEDIDO` (`ID`, `CLIENTE_ID`, `VALOR_TOTAL`, `DATA_PEDIDO`) values (3, 100, 100.00, '2020-01-01 00:00:00.000000');

---ADD item pedido
insert into `PEDIDO_ITEM` (`PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (1, 1, 2);
insert into `PEDIDO_ITEM` (`PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (1, 5, 1);
insert into `PEDIDO_ITEM` (`PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (1, 3, 2);

insert into `PEDIDO_ITEM` (`PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (2, 3, 5);
insert into `PEDIDO_ITEM` (`PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (2, 4, 2);
insert into `PEDIDO_ITEM` (`PEDIDO_ID`, `PRODUTO_ID`, `QUANTIDADE`) values (2, 5, 7);