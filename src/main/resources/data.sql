--- ADD CLIENTES, CPFs gerados automaticamente https://www.4devs.com.br/gerador_de_cpf

insert into `CLIENTE` (`ID`, `NOME`, `CPF`) values (1, 'João', '37772382014');
insert into `CLIENTE` (`ID`, `NOME`, `CPF`) values (2, 'Maria', '00837598087');
insert into `CLIENTE` (`ID`, `NOME`, `CPF`) values (3, 'Jose', '06355528091');
insert into `CLIENTE` (`ID`, `NOME`, `CPF`) values (4, 'Carlos', '80071319069');
insert into `CLIENTE` (`ID`, `NOME`, `CPF`) values (5, 'Pedro', '81454522011');
insert into `CLIENTE` (`ID`, `NOME`, `CPF`) values (6, 'Will Smith', '14915748014');

--- ADD PRODUTOS
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (1, 'Cerveja', 5.00);
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (2, 'Agua', 2.00);
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (3, 'Refrigerante', 3.00);
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (4, 'Suco', 3.00);
insert into `PRODUTO` (`ID`, `DESCRICAO`, `VALOR`) values (5, 'Cachorro-Quente', 4.00);


---ADD pedidos
insert into `PEDIDO` (`ID`, `CLIENTE_ID`, `VALOR_TOTAL`) values (DEFAULT, 1, 150.00);
insert into `PEDIDO` (`ID`, `CLIENTE_ID`, `VALOR_TOTAL`) values (DEFAULT, 1, 100.00);
insert into `PEDIDO` (`ID`, `CLIENTE_ID`, `VALOR_TOTAL`) values (DEFAULT, 1, 100.00);

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