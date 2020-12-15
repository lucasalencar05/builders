CREATE
DATABASE IF NOT EXISTS builders;
USE
builders;

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente`
(
    id
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    cpf
    VARCHAR
(
    11
) NOT NULL,
    data_nascimento DATE,
    idade INT NOT NULL,
    nome VARCHAR
(
    255
) NOT NULL,
    PRIMARY KEY
(
    id
)
    ) ENGINE=INNODB DEFAULT CHARSET=utf8;


INSERT INTO cliente(nome, cpf, data_nascimento, idade)
VALUES ('Baroadan', '48957335056', '2020-12-14', 0);
INSERT INTO cliente(nome, cpf, data_nascimento, idade)
VALUES ('Amlapen', '47441148065', '2020-12-14', 0);
INSERT INTO cliente(nome, cpf, data_nascimento, idade)
VALUES ('Aegarrond', '61441544003', '2020-12-14', 0);