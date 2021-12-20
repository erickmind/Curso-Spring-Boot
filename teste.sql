-- para criar um banco de dados
create database curso_springboot;

-- para especificar qual banco de dados sera usado
use curso_springboot;

-- criar uma tabela
create table usuario(
	id int,
    nome varchar (255)
);

-- inserir valor na tabela usuario
INSERT INTO usuario (id, nome) values (1, 'Erick');
INSERT INTO usuario (nome, id) values ('Jose', 2);

-- selecionar todos os campos de uma tabela
SELECT * FROM usuario;

-- selecionar apenas 'id' da tabela
SELECT id FROM usuario;

-- selecionar 'id' maior que 1 (condicional)
SELECT id FROM usuario WHERE id > 1;

-- alterar um registro
UPDATE usuario set nome = 'Paulo' WHERE id = 2;

-- deletar uma tabela
drop table usuario;

-- criar uma tabela com chave primaria com auto increment
create table usuario(
	id int primary key auto_increment,
    nome varchar (255)
);

INSERT into usuario (nome) VALUES ('Erick');
SELECT * from usuario;

UPDATE usuario set nome = 'Paulo' where id = 1;

-- deletar todos os registros da tabela
DELETE FROM usuario where id = 1;

INSERT into usuario VALUES (1, 'Jose');

CREATE TABLE curso(
	id int primary key auto_increment,
    nome varchar (255) NOT NULL,
    usuario int references usuario (id) 
);

INSERT INTO curso (nome, usuario) VALUES ('MySQL', 1);
INSERT INTO curso (nome, usuario) VALUES ('Spring', 2);
INSERT INTO curso (nome, usuario) VALUES ('senai', 50);

DELETE FROM curso where id = 5;

-- Join
SELECT * from curso;
SELECT * from usuario;
SELECT * from curso inner join usuario on (usuario.id = curso.usuario);
SELECT * from curso left join usuario on (usuario.id = curso.usuario);




