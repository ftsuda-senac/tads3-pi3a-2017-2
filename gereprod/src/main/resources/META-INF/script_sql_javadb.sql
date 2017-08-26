CREATE TABLE produto (
  id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_PRODUTO PRIMARY KEY, 
  nome VARCHAR(100) NOT NULL,
  descricao VARCHAR(500),
  vl_compra DECIMAL(11,2) NOT NULL,
  vl_venda DECIMAL(11,2) NOT NULL,
  categoria VARCHAR(500),
  dt_cadastro TIMESTAMP NOT NULL
);

INSERT INTO produto(nome, descricao, vl_compra, vl_venda, categoria, dt_cadastro) VALUES ('Bolo de chocolate', 'Melhor bolo', 20.0, 50.0, 'bolo, doce', CURRENT_TIMESTAMP);

INSERT INTO produto(nome, descricao, vl_compra, vl_venda, categoria, dt_cadastro) VALUES ('Torta de maça', 'Melhor torta', 15.0, 35.0, 'torta, fruta, maça', CURRENT_TIMESTAMP);