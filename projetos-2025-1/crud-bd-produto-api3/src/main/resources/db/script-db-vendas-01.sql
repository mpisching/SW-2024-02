CREATE DATABASE IF NOT EXISTS db_vendas_sw; 
USE db_vendas_sw; 
 
CREATE TABLE categoria( 
   id int NOT NULL auto_increment, 
   descricao  varchar(50) NOT NULL, 
   CONSTRAINT pk_categoria 
      PRIMARY KEY(id) 
) engine=InnoDB; 

CREATE TABLE PRODUTO (
	id int not null auto_increment,
    nome varchar(50) not null,
    descricao varchar(200) not null,
    preco decimal(10,2) not null,
    id_categoria int not null,
    primary key (id)
) engine=InnoDB;

alter table produto add constraint fk_produto_categoria
	foreign key(id_categoria) references categoria(id);
	
INSERT INTO CATEGORIA(DESCRICAO) VALUES ('ELETRÔNICOS');
INSERT INTO CATEGORIA(DESCRICAO) VALUES ('VESTUÁRIO');
    
INSERT INTO PRODUTO(NOME, DESCRICAO, PRECO, ID_CATEGORIA) VALUES ('CAMISETA', 'POLO', 200.0, 2);
INSERT INTO PRODUTO(NOME, DESCRICAO, PRECO, ID_CATEGORIA) VALUES ('COMPUTADOR', 'DESKTOP', 2000.0, 1);
INSERT INTO PRODUTO(NOME, DESCRICAO, PRECO, ID_CATEGORIA) VALUES ('NOTEBOOK', 'ULTRABOOK', 6000.0, 1);	

CREATE TABLE fornecedor (
	id int not null auto_increment,
    nome varchar(50) not null,
    email varchar(100) not null,
    fone varchar(20) not null,
    primary key(id)
);

alter table produto add column id_fornecedor int not null;

set foreign_key_checks=0;

alter table produto add constraint fk_produto_fornecedor
	foreign key(id_fornecedor) references fornecedor(id);

set foreign_key_checks=1;
