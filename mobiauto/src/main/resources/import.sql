--Inserindo na tabela de revenda
INSERT INTO tb_revenda (cnpj, nome_social) VALUES('63991635000118','A7L');

--Inserindo na tabela de usuario
INSERT INTO tb_usuario (nome, email, senha,revenda_id) VALUES ('Felipe Lino', 'f.lino1934@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG',1);
INSERT INTO tb_usuario_cargo (usuario_id, cargo) VALUES (1,'GERENTE');

INSERT INTO tb_usuario (nome, email, senha,revenda_id) VALUES ('Michaelly Monique', 'mica@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG',1);
INSERT INTO tb_usuario_cargo (usuario_id, cargo) VALUES (2,'PROPRIETARIO');

INSERT INTO tb_usuario (nome, email, senha,revenda_id) VALUES ('Charlote', 'mi@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG',1);
INSERT INTO tb_usuario_cargo (usuario_id, cargo) VALUES (3,'ASSISTENTE');

--Inserindo na tabela de veiculos

INSERT INTO tb_veiculos (marca,modelo,versao,ano_modelo) VALUES ('Chevrolet','Astra','Hatch',2008);
INSERT INTO tb_veiculos (marca,modelo,versao,ano_modelo) VALUES ('Kawazaki','Z400','Naked',2024);
INSERT INTO tb_veiculos (marca,modelo,versao,ano_modelo) VALUES ('Honda','Lead','Scooter',2014);
INSERT INTO tb_veiculos (marca,modelo,versao,ano_modelo) VALUES ('Yamaha','Crosser','Motocicleta',2016);

--Inserindo na tabela de clientes

INSERT INTO tb_clientes (nome,email,telefone) VALUES ('Felipe Lino','f.lino1934@gmail.com','(13) 98137-5682');
INSERT INTO tb_clientes (nome,email,telefone) VALUES ('Michaelly Lino','midi@gmail.com','(13) 98137-5682');

--Inserindo na tabela de oportunidades

INSERT INTO tb_oportunidades (data_atribuicao, data_conclusao, motivo_conclusao, status, cliente_id, veiculo_id) VALUES(TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z','ABCD','NOVO',1,1);

