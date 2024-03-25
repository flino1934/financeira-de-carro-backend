--Inserindo na tabela de revenda
INSERT INTO tb_revenda (cnpj, nome_social) VALUES('63991635000118','A7L');

--Inserindo na tabela de usuario
INSERT INTO tb_usuario (nome, email, senha) VALUES ('Felipe Lino', 'f.lino1934@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario_cargo (usuario_id, cargo) VALUES (1,'GERENTE');

INSERT INTO tb_usuario (nome, email, senha) VALUES ('Michaelly Monique', 'mica@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario_cargo (usuario_id, cargo) VALUES (2,'PROPRIETARIO');

INSERT INTO tb_usuario (nome, email, senha) VALUES ('Charlote', 'mi@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario_cargo (usuario_id, cargo) VALUES (3,'ASSISTENTE');
