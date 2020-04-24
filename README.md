# Programa Estagio ZG Soluções - Fase 1
AppClienteRocambole

Banco de Dados Criado com o Workbench MySql.

create database rocambole;
use rocambole;

CREATE TABLE cliente (
	codigo INT AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    telefone VARCHAR(20),
    endereco VARCHAR(50),
    PRIMARY KEY (codigo)
);

CREATE TABLE distribuidora (
	codigo INT AUTO_INCREMENT,
    nome varchar (50) NOT NULDL,
    telefone varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    PRIMARY KEY (codigo)
);

CREATE TABLE estoque (
	codigo_produto INT AUTO_INCREMENT,
    nome_produto VARCHAR(50) NOT NULL,
    valor_custo DOUBLE NOT NULL,
    valor_venda DOUBLE NOT NULL,
    quantidade INT NOT NULL,
    id_distribuidora INT NOT NULL,
    PRIMARY KEY (codigo_produto),
	FOREIGN KEY (id_distribuidora) REFERENCES distribuidora (codigo)
);

CREATE TABLE caixa (
	codigo INT AUTO_INCREMENT,
    codigo_produto INT NOT NULL,
	nome_produto VARCHAR(50) NOT NULL,
    valor_unitario DOUBLE NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (codigo),
	FOREIGN KEY (codigo_produto) REFERENCES estoque (codigo_produto)
);

CREATE TABLE promocao_levou_ganhou (
	codigo INT AUTO_INCREMENT,
	nome_promocao VARCHAR(50) NOT NULL,
    produto_relacionado INT NOT NULL,
    quantidade_leva VARCHAR(50) NOT NULL,
    quantidade_paga VARCHAR(50) NOT NULL,
    PRIMARY KEY (codigo),
    FOREIGN KEY (produto_relacionado) REFERENCES estoque (codigo_produto)
);

CREATE TABLE promocao_leva_paga(
	codigo INT AUTO_INCREMENT,
    nome_promocao VARCHAR(50) NOT NULL,
    produto_relacionado INT NOT NULL,
    quantidade_leva INT  NOT NULL,
    valor_que_paga DOUBLE NOT NULL,
    PRIMARY KEY (codigo),
    FOREIGN KEY (produto_relacionado) REFERENCES estoque (codigo_produto)
);


O Intelij não quiz funcionar a conexão com o banco de dados então tive que usar o netbens e nele o Junit não funcionou, na hora de baixar o drive dava erro no servidor, por isso não usei o Junit para testede unidade.

Eu tentei simular um sistema real.
Então a tabela Estoque deve ser  Preenchida antes da adição no caixa.
E o produto só é adicioanado se estiver uma distribuidora previamente.

Infelismente os testes não funcionaram.

Eu agradeço a oportunidade, gostaria de mais um ou dois dias para terminar o projeto final e fazer a refatoração do outro codigo.


