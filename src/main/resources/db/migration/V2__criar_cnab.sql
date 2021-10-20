
CREATE TABLE IF NOT EXISTS `cnab` (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `tipo_transacao` int NOT NULL,
  `data` DATE NOT NULL,
  `valor` NUMERIC NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `cartao` varchar(12) NOT NULL,
  `hora` TIME NOT NULL,
  `dono` varchar(14) NOT NULL,
  `loja` varchar(19) NOT NULL,
  FOREIGN KEY (tipo_transacao) REFERENCES tipo_transacao(codigo)
) ;