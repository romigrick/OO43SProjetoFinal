-- Inserir categorias
INSERT INTO categoria (id, nome)
VALUES
(1, 'Alimentos'),
(2, 'Bebidas'),
(3, 'Limpeza'),
(4, 'Higiene Pessoal'),
(5, 'Eletrodomésticos'),
(6, 'Utensílios Domésticos'),
(7, 'Frutas e Verduras'),
(8, 'Congelados'),
(9, 'Doces e Snacks'),
(10, 'Carnes'),
(11, 'Produtos de Panificação'),
(12, 'Laticínios'),
(13, 'Produtos Naturais e Orgânicos');

-- Inserir produtos
INSERT INTO produto (id, descricao, nome, preco, categoria_id)
VALUES
-- Alimentos
(1, 'Arroz Tipo 1, 5kg', 'Arroz Tipo 1', 19.99, 1),
(2, 'Feijão Carioca, 1kg', 'Feijão Carioca', 6.49, 1),
(3, 'Macarrão Espaguete, 500g', 'Macarrão Espaguete', 4.99, 1),
(4, 'Açúcar Cristal, 1kg', 'Açúcar Cristal', 3.59, 1),
(5, 'Farinha de Trigo, 1kg', 'Farinha de Trigo', 4.99, 1),
(6, 'Sal Refinado, 1kg', 'Sal Refinado', 1.99, 1),
(7, 'Óleo de Soja, 900ml', 'Óleo de Soja', 5.79, 1),
(8, 'Molho de Tomate, 340g', 'Molho de Tomate', 2.99, 1),
(9, 'Ketchup Heinz, 500g', 'Ketchup', 8.49, 1),

-- Bebidas
(10, 'Coca-Cola Lata, 350ml', 'Coca-Cola', 3.99, 2),
(11, 'Água Mineral, 500ml', 'Água Mineral', 1.99, 2),
(12, 'Suco de Laranja, 1L', 'Suco de Laranja', 4.49, 2),
(13, 'Cerveja Skol Lata, 350ml', 'Cerveja Skol', 2.99, 2),
(14, 'Vinho Tinto, 750ml', 'Vinho Tinto', 25.99, 2),

-- Limpeza
(15, 'Detergente Líquido, 500ml', 'Detergente Líquido', 2.79, 3),
(16, 'Sabão em Pó OMO, 1kg', 'Sabão em Pó', 8.99, 3),
(17, 'Água Sanitária, 1L', 'Água Sanitária', 2.49, 3),
(18, 'Desinfetante, 500ml', 'Desinfetante', 4.19, 3),
(19, 'Amaciante, 1L', 'Amaciante', 5.99, 3),

-- Higiene Pessoal
(20, 'Shampoo 300ml', 'Shampoo Head & Shoulders', 14.99, 4),
(21, 'Condicionador 300ml', 'Condicionador Dove', 14.99, 4),
(22, 'Sabonete Líquido, 250ml', 'Sabonete Líquido', 3.49, 4),
(23, 'Desodorante Aerosol, 150ml', 'Desodorante Rexona', 6.99, 4),
(24, 'Papel Higiênico, 12 rolos', 'Papel Higiênico', 16.99, 4),

-- Eletrodomésticos
(25, 'Micro-ondas, 20L', 'Micro-ondas', 299.90, 5),
(26, 'Geladeira Brastemp, 400L', 'Geladeira Brastemp', 1999.90, 5),
(27, 'Liquidificador, 500W', 'Liquidificador', 159.90, 5),
(28, 'Ferro de Passar, 1200W', 'Ferro de Passar', 79.99, 5),

-- Utensílios Domésticos
(29, 'Panela de Pressão, 4L', 'Panela de Pressão', 99.90, 6),
(30, 'Cafeteira Elétrica, 12 xícaras', 'Cafeteira Elétrica', 129.90, 6),
(31, 'Jogo de Facas, 6 peças', 'Jogo de Facas', 49.90, 6),
(32, 'Escorredor de Louças, inox', 'Escorredor de Louças', 29.90, 6),

-- Frutas e Verduras
(33, 'Banana Prata, 1kg', 'Banana Prata', 4.50, 7),
(34, 'Maçã, 1kg', 'Maçã', 6.00, 7),
(35, 'Tomate, 1kg', 'Tomate', 5.99, 7),
(36, 'Alface, 1 unidade', 'Alface', 2.49, 7),
(37, 'Cenoura, 1kg', 'Cenoura', 3.99, 7),

-- Congelados
(38, 'Pizza Congelada, 600g', 'Pizza Congelada', 14.90, 8),
(39, 'Hambúrguer Congelado, 400g', 'Hambúrguer Congelado', 10.99, 8),
(40, 'Frango Congelado, 1kg', 'Frango Congelado', 12.99, 8),

-- Doces e Snacks
(41, 'Chocolate Ao Leite, 200g', 'Chocolate Ao Leite', 6.99, 9),
(42, 'Biscoito Recheado, 400g', 'Biscoito Recheado', 4.49, 9),
(43, 'Amendoim Torrado, 200g', 'Amendoim Torrado', 3.99, 9),
(44, 'Goma de Mascar, 150g', 'Goma de Mascar', 2.49, 9),

-- Carnes
(45, 'Picanha Bovina, 1kg', 'Picanha Bovina', 49.90, 10),
(46, 'Coxinha de Frango, 1kg', 'Coxinha de Frango', 9.99, 10),
(47, 'Costela Suína, 1kg', 'Costela Suína', 15.99, 10),
(48, 'Alcatra Bovina, 1kg', 'Alcatra Bovina', 29.90, 10),

-- Produtos de Panificação
(49, 'Pão Francês, unidade', 'Pão Francês', 0.79, 11),
(50, 'Pão de Forma, 500g', 'Pão de Forma', 3.99, 11),
(51, 'Baguete, unidade', 'Baguete', 2.99, 11),
(52, 'Croissant, unidade', 'Croissant', 1.99, 11),

-- Laticínios
(53, 'Leite Integral, 1L', 'Leite Integral', 3.59, 12),
(54, 'Queijo Mussarela, 500g', 'Queijo Mussarela', 15.99, 12),
(55, 'Iogurte Grego, 150g', 'Iogurte Grego', 6.49, 12),
(56, 'Manteiga, 200g', 'Manteiga', 5.29, 12),

-- Produtos Naturais e Orgânicos
(57, 'Arroz Orgânico, 1kg', 'Arroz Orgânico', 8.99, 13),
(58, 'Feijão Orgânico, 1kg', 'Feijão Orgânico', 10.99, 13),
(59, 'Mel Orgânico, 500g', 'Mel Orgânico', 15.99, 13),
(60, 'Couve Orgânica, maço', 'Couve Orgânica', 5.99, 13);

