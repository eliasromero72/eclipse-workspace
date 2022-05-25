
insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao,
ano_modelo, valor) values ('AAA', '1111', 'Fiat',
'Toro', 2020, 2020, 107000);
insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao,
ano_modelo, valor) values ('BBB', '2222', 'Ford',
'Fiesta', 2019, 2019, 42000);
insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao,
ano_modelo, valor) values ('CCC', '3333', 'VW',
'Gol', 2019, 2020, 35000);
commit;

insert into tab_veiculo (codigo, fabricante, modelo,
ano_fabricacao, ano_modelo, valor, tipo_combustivel)
values (2, 'Fiat', 'Toro', 2020, 2020, 107000, 'DIESEL');
insert into tab_veiculo (codigo, fabricante, modelo,
ano_fabricacao, ano_modelo, valor, tipo_combustivel)
values (3, 'Ford', 'Fiesta', 2019, 2019, 42000, 'GASOLINA');
insert into tab_veiculo (codigo, fabricante, modelo,
ano_fabricacao, ano_modelo, valor, tipo_combustivel)
values (4, 'VW', 'Gol', 2019, 2020, 35000, 'BICOMBUSTIVEL');
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

sysdate() MySQL
sysdate Oracle

insert into tab_veiculo (fabricante, modelo,
ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro,
nome_proprietario, telefone_proprietario) values ('Fiat', 'Toro',
2020, 2020, 107000, 'DIESEL', sysdate(), 'Fernando Martins',
'34 9 1111 1111');
insert into tab_veiculo (fabricante, modelo,
ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro,
nome_proprietario, telefone_proprietario) values ('Ford', 'Fiesta',
2019, 2019, 42000, 'GASOLINA', sysdate(), 'Isabela Santos',
'34 9 2222 2222');
insert into tab_veiculo (fabricante, modelo,
ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro,
nome_proprietario, telefone_proprietario) values ('VW', 'Gol',
2019, 2020, 35000, 'BICOMBUSTIVEL', sysdate(), 'Ulisses Silva',
'34 9 3333 3333');
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

insert into tab_veiculo (codigo, fabricante, modelo,
ano_fabricacao, ano_modelo, valor, tipo_combustivel,
data_cadastro, proprietario_codigo) values (3, 'Ford', 'Ka',
2018, 2019, 27000, 'BICOMBUSTIVEL', sysdate(), 1);
commit;

insert into acessorio (codigo, descricao) values (1, 'Direção hidráulica');
insert into acessorio (codigo, descricao) values (2, 'Alarme');
insert into acessorio (codigo, descricao) values (3, 'Ar condicionado');
insert into acessorio (codigo, descricao) values (4, 'Bancos de couro');
commit;

insert into veiculo_acessorio (veiculo_codigo, acessorio_codigo)
values (1, 1);
insert into veiculo_acessorio (veiculo_codigo, acessorio_codigo)
values (1, 2);
insert into veiculo_acessorio (veiculo_codigo, acessorio_codigo)
values (1, 3);
insert into veiculo_acessorio (veiculo_codigo, acessorio_codigo)
values (1, 4);
commit;
