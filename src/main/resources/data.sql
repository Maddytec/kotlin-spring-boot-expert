CREATE TABLE IF NOT EXISTS promocao (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL,
    local VARCHAR(100) NOT NULL,
    is_All_Inclusive BOOLEAN,
    quantidade_Dias INTEGER,
    preco DECIMAL(10.2)
);

insert INTO promocao (descricao, local, is_All_Inclusive, quantidade_Dias, preco)
    values ('Visita ao Litoral Norte', 'Bahia', 'true', 3, 3000.22 );
insert INTO promocao (descricao, local, is_All_Inclusive, quantidade_Dias, preco)
    values ('Visita ao Cristo Redentor', 'Rio de Janeiro', 'false', 1, 1000.00 );
insert INTO promocao (descricao, local, is_All_Inclusive, quantidade_Dias, preco)
    values ('Visita ao Parque Ibirapuera', 'São Paulo', 'false', 1, 1550.30 );
insert INTO promocao (descricao, local, is_All_Inclusive, quantidade_Dias, preco)
    values ('Visita ao Beto Carreiro', 'Santa Catarina', 'true', 2, 2000.00 );
insert INTO promocao (descricao, local, is_All_Inclusive, quantidade_Dias, preco)
    values ('Visita a Mangue Seco', 'Sergipe', 'true', 2, 2000.00 );


