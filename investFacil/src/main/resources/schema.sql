-- Criar banco de dados
CREATE DATABASE IF NOT EXISTS investfacil;
USE investfacil;

-- =====================
-- Tabela USUARIO
-- =====================
CREATE TABLE usuario (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

-- =====================
-- Tabela CLASSE_ATIVO
-- =====================
CREATE TABLE classe_ativo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(255)
);

-- =====================
-- Tabela ATIVO (herança JOINED)
-- =====================
CREATE TABLE ativo (
    ticker VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    classe_id INT,
    CONSTRAINT fk_ativo_classe FOREIGN KEY (classe_id) REFERENCES classe_ativo(id)
);

-- =====================
-- Subtabelas de herança
-- =====================
CREATE TABLE renda_fixa (
    ticker VARCHAR(20) PRIMARY KEY,
    taxa DECIMAL(6,2),
    vencimento DATE,
    indexador VARCHAR(50),
    CONSTRAINT fk_rf_ativo FOREIGN KEY (ticker) REFERENCES ativo(ticker)
);

CREATE TABLE renda_variavel (
    ticker VARCHAR(20) PRIMARY KEY,
    setor VARCHAR(100),
    bolsa VARCHAR(50),
    valor_atual DECIMAL(10,2),
    CONSTRAINT fk_rv_ativo FOREIGN KEY (ticker) REFERENCES ativo(ticker)
);

-- =====================
-- Tabela CARTEIRA
-- =====================
CREATE TABLE carteira (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_criacao DATE NOT NULL,
    usuario_cpf VARCHAR(11),
    FOREIGN KEY (usuario_cpf) REFERENCES usuario(cpf)
);

-- =====================
-- Tabela POSICAO
-- =====================
CREATE TABLE posicao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ativo_ticker VARCHAR(20) NOT NULL,
    quantidade INT NOT NULL DEFAULT 0,
    data_compra DATE,
    carteira_id INT NOT NULL,
    FOREIGN KEY (ativo_ticker) REFERENCES ativo(ticker),
    FOREIGN KEY (carteira_id) REFERENCES carteira(id)
);

-- =====================
-- Tabela TRANSACAO
-- =====================
CREATE TABLE transacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(20) NOT NULL, -- COMPRA ou VENDA
    data DATE NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    taxa DECIMAL(10,2),
    preco_total DECIMAL(12,2),
    posicao_id INT NOT NULL,
    FOREIGN KEY (posicao_id) REFERENCES posicao(id)
);

-- =====================
-- Tabela DIVIDENDO
-- =====================
CREATE TABLE dividendo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_com DATE NOT NULL,
    data_pagamento DATE,
    valor_pago DECIMAL(10,2) NOT NULL,
    posicao_id INT NOT NULL,
    FOREIGN KEY (posicao_id) REFERENCES posicao(id)
);
