INSERT INTO perfil (name)
VALUES ('admin');
INSERT INTO usuario (ativo, id, pe_id, nome, senha)
VALUES (true, 1, 1, 'sertao', '$2a$10$0zH50wN9537VSsEGgN.FJeBsP5Ms8Q77MFmWvMj4ifPgf4Jye4cmS');


INSERT INTO produto (preco, quantidade,imagem, descricao, nome)
VALUES (10.00, 10,
        'https://a-static.mlcdn.com.br/450x450/fogao-4-bocas-preto-ou-branco-com-mesa-de-vidro-atlas-monaco-top-glass-bivolt/techshop/fogatl00008/d2245c73e0d609c05de172d4d41aa812.jpeg',
        ' Fogão Atlas 4 Bocas Mônaco Top Glass com Mesa de Vidro e Acendimento Automático Bivolt – Preto', 'fogão');
INSERT INTO produto (preco, quantidade,imagem, descricao, nome)
VALUES (10.00, 10,
        'https://consul.vtexassets.com/arquivos/ids/230866-1200-auto?v=637993883186300000&width=1200&height=auto&aspect=true',
        'Geladeira Consul Frost Free CRM39AB Duplex com Prateleiras Altura Flex Branca - 340L', 'geladeira');

