CREATE DATABASE IF NOT EXISTS db_produtos;
USE db_produtos;
CREATE TABLE categoria(
   id int NOT NULL auto_increment,
   descricao  varchar(50) NOT NULL,
   CONSTRAINT pk_categoria
      PRIMARY KEY(id)
) engine=InnoDB;

CREATE TABLE produto(
   id int NOT NULL auto_increment,
   nome varchar(50) not null,
   descricao varchar(200),
   preco decimal(10,2) not null,
   id_categoria int not null ,
   primary key(id)
);

alter table produto add constraint fk_produto_categoria
foreign key(id_categoria) references categoria(id);