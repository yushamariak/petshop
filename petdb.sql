INSERT INTO usuarios (login, senha) VALUES
/* 1 */ ('ana', '$shiro1$SHA-256$500000$FQ8vf8bNwTwApLYg+HRHnA==$GMWgnq5phtCN28OPyAb4HU6YkP6v9CjP7/7pETp71zs='), 
/* 2 */('maria', '$shiro1$SHA-256$500000$UuTOjf0QDTjWl/mqsH4HIw==$ZdE8q16NA10yOIskr4bv1PDV/AFKlvFwlzduaJumvMg='),
/* 3 */('jose', '$shiro1$SHA-256$500000$7Pzokvol5ZjY0hDfRFZGxw==$45LNKG0FfMo9G3ND6tmIPqtDUg8kepMuownmlXHw3Js=');

INSERT INTO papel (nome, descricao) VALUES
/* 1 */('admin', 'Administrador do sistema'),
/* 2 */('funcionario', 'Funcionario'),
/* 3 */('veterinario', 'Veterinario');

INSERT INTO permissao (valor, descricao) VALUES
/* 1 */('*', 'admin faz tudo'), 
/* 2 */('pet:listar', 'pode ver todos os pets'),
/* 3 */('pet:cadastrar', 'pode cadastrar pet'),
/* 4 */('pet:buscar', 'pode buscar pet'),
/* 5 */('pet:alterar', 'pode alterar pet'),
/* 6 */('pet:remover', 'pode remover pet'),
/* 7 */('pet:relatorio', 'pode fazer relatorio');

INSERT INTO usuario_tem_papel (usuario_idUsuario, papel_idPapel) VALUES
(1, 1),
(2, 3),
(3, 2);

INSERT INTO papel_tem_permissao (papel_idPapel, permissao_idPermissao) VALUES
(1, 1),
(2, 2),
(2, 4),
(2, 5),
(2, 6),
(2, 7),
(3, 2),
(3, 3),
(3, 4),
(3, 5);

INSERT INTO servicos (descricao, valor) VALUES 
('tosa', 40.00),
('banho', 25.00),
('consulta', 70.00),
('vacina', 30.00),
('exames', 35.00),
('vendas', 0);

INSERT INTO clientes (nome, telefone, cidade, email) VALUES 
('Ana', 	'1111-1111', 'Uberaba', 'ana@example.com'),
('Maria', '2222-2222', 'Uberaba', 'maria@example.com'),
('José', 	'3333-3333', 'Uberaba', 'jose@example.com'),
('Pedro', '4444-4444', 'Uberaba', 'pedro@example.com'),
('João', 	'5555-5555', 'Uberaba', 'joao@example.com'),
('Clara', '6666-6666', 'Uberaba', 'clara@example.com'),
('Paula', '7777-7777', 'Uberaba', 'paula@example.com'),
('Carol', '8888-8888', 'Uberaba', 'carol@example.com');

INSERT INTO funcionarios (cliente_id, usuario_id) VALUES 
(1, 1),
(2, 2),
(3, 3);

INSERT INTO funcionarios_servicos (funcionario_id, servico_id) VALUES
(2,3),
(2,4),
(2,5),
(3,1),
(3,2),
(3,6);
