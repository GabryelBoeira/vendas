--- ADD CLIENTES
insert into `CLIENTE` (`ID`,`NOME`) values (100,'João');
insert into `CLIENTE` (`NOME`) values ('Maria');
insert into `CLIENTE` (`NOME`) values ('Jose');
insert into `CLIENTE` (`NOME`) values ('Carlos');
insert into `CLIENTE` (`NOME`) values ('Pedro');
insert into `CLIENTE` (`NOME`) values ('Will Smith');

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