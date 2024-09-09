CREATE TABLE produtos (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          preco DOUBLE NOT NULL,
                          marca VARCHAR(255) NOT NULL,
                          quantidade INT NOT NULL
);