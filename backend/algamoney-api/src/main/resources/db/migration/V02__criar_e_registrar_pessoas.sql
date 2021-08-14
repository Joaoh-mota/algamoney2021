CREATE TABLE pessoa (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    logradouro VARCHAR(50),
    numero VARCHAR(10),
    complemento VARCHAR(100),
    bairro VARCHAR(50),
    cep VARCHAR(10),
    cidade VARCHAR(50),
    estado VARCHAR(30),
    ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) values ('Alvaro',true,'Rua das flores','304','Portão marrom','Centro','77000-000','Palmas','Tocantins');
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) values ('João Henrique',true,'Alameda 9','','16','Quadra 210 sul','77020-584','Palmas','Tocantins');
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) values ('Anna',false,'Rua Pedreira','22','Arvore na frente','Luzeira','','Aparecida do Rio Negro','Tocantins');
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) values ('Pedro',true,'Rua das flores','022','Portão marrom','Centro','77111-000','Palmas','Tocantins');
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) values ('José',false,'Rua das flores','102','Portão verde','Centro','77222-000','Palmas','Tocantins');