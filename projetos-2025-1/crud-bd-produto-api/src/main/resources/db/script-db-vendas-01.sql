CREATE DATABASE IF NOT EXISTS db_vendas_sw; 
USE db_vendas_sw; 
 
CREATE TABLE categoria( 
   id int NOT NULL auto_increment, 
   descricao  varchar(50) NOT NULL, 
   CONSTRAINT pk_categoria 
      PRIMARY KEY(id) 
) engine=InnoDB; 