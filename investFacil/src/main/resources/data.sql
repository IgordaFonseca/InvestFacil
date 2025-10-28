-- =====================
-- Usuários
-- =====================

DELETE FROM dividendo;
DELETE FROM transacao;
DELETE FROM posicao;
DELETE FROM carteira;
DELETE FROM renda_variavel;
DELETE FROM renda_fixa;
DELETE FROM ativo;
DELETE FROM classe_ativo;
DELETE FROM usuario;


-- Inserindo classes de ativos
INSERT INTO classe_ativo (nome, descricao) VALUES
('Renda Variável', 'Ações negociadas em bolsa de valores'),
('Renda Fixa', 'Títulos de renda fixa do mercado financeiro');

-- Inserindo usuários
INSERT INTO usuario (cpf, nome, email, senha) VALUES
('12345678901', 'Igor Fonseca', 'igor@email.com', '123456'),
('98765432100', 'Maria Oliveira', 'maria@email.com', '123456');

-- Inserindo ativos (pai)
INSERT INTO ativo (ticker, nome, classe_id) VALUES
('PETR4', 'Petrobras PN', 1),
('ITUB4', 'Itaú Unibanco PN', 1),
('TESOUROSELIC', 'Tesouro Selic 2029', 2);

-- Inserindo ativos de renda variável
INSERT INTO renda_variavel (ticker, setor, bolsa, valor_atual) VALUES
('PETR4', 'Petróleo e Gás', 'B3', 36.50),
('ITUB4', 'Bancos', 'B3', 28.30);

-- Inserindo ativos de renda fixa
INSERT INTO renda_fixa (ticker, taxa, vencimento, indexador) VALUES
('TESOUROSELIC', 12.50, '2029-01-01', 'SELIC');

-- Inserindo carteiras
INSERT INTO carteira (nome, data_criacao, usuario_cpf) VALUES
('Carteira Igor', '2025-01-15', '12345678901'),
('Carteira Maria', '2025-01-20', '98765432100');

-- Inserindo posições
INSERT INTO posicao (ativo_ticker, quantidade, data_compra, carteira_id) VALUES
('PETR4', 100, '2025-02-01', 1),
('ITUB4', 50, '2025-02-10', 1),
('TESOUROSELIC', 10, '2025-02-15', 2);

-- Inserindo transações
INSERT INTO transacao (tipo, data, quantidade, preco_unitario, taxa, preco_total, posicao_id) VALUES
('COMPRA', '2025-02-01', 100, 35.00, 5.00, 3505.00, 1),
('COMPRA', '2025-02-10', 50, 27.00, 2.50, 1352.50, 2),
('COMPRA', '2025-02-15', 10, 1000.00, 0.00, 10000.00, 3);

-- Inserindo dividendos
INSERT INTO dividendo (data_com, data_pagamento, valor_pago, posicao_id) VALUES
('2025-03-01', '2025-03-15', 150.00, 1),
('2025-04-01', '2025-04-15', 80.00, 2);

