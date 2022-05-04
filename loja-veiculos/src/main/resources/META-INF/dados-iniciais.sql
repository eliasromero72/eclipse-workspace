insert into tab_veiculo (codigo, fabricante, modelo,
ano_fabricacao, ano_modelo, valor, tipo_combustivel)
values (1, 'Fiat', 'Toro', 2020, 2020, 107000, 'DIESEL');
insert into tab_veiculo (codigo, fabricante, modelo,
ano_fabricacao, ano_modelo, valor, tipo_combustivel)
values (2, 'Ford', 'Fiesta', 2019, 2019, 42000, 'GASOLINA');
insert into tab_veiculo (codigo, fabricante, modelo,
ano_fabricacao, ano_modelo, valor, tipo_combustivel)
values (3, 'VW', 'Gol', 2019, 2020, 35000, 'BICOMBUSTIVEL');
commit;

insert into tab_veiculo (codigo, fabricante, modelo,
ano_fabricacao, ano_modelo, valor, tipo_combustivel,
data_cadastro) values (1, 'Fiat', 'Toro', 2020, 2020,
107000, 'DIESEL', sysdate());
insert into tab_veiculo (codigo, fabricante, modelo,
ano_fabricacao, ano_modelo, valor, tipo_combustivel,
data_cadastro) values (2, 'Ford', 'Fiesta', 2019, 2019,
42000, 'GASOLINA', sysdate());
insert into tab_veiculo (codigo, fabricante, modelo,
ano_fabricacao, ano_modelo, valor, tipo_combustivel,
data_cadastro) values (3, 'VW', 'Gol', 2019, 2020,
35000, 'BICOMBUSTIVEL', sysdate());
commit;

insert into proprietario (codigo, nome, telefone)
values (1, 'Fernando Martins', '34 9 1111 1111');
insert into proprietario (codigo, nome, telefone)
values (2, 'Isabela Santos', '34 9 2222 2222');
insert into proprietario (codigo, nome, telefone)
values (3, 'Ulisses Silva', '34 9 3333 3333');
commit;

insert into tab_veiculo (codigo, fabricante, modelo, ano_fabricacao,
ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario)
values (1, 'Fiat', 'Toro', 2020, 2020, 107000, 'DIESEL', sysdate(), 1);
insert into tab_veiculo (codigo, fabricante, modelo, ano_fabricacao,
ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario)
values (2, 'Ford', 'Fiesta', 2019, 2019, 42000, 'GASOLINA', sysdate(), 2);
insert into tab_veiculo (codigo, fabricante, modelo, ano_fabricacao,
ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario)
values (3, 'VW', 'Gol', 2019, 2020, 35000, 'BICOMBUSTIVEL', sysdate(), 3);
commit;