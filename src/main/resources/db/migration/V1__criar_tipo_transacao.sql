
CREATE TABLE IF NOT EXISTS `tipo_transacao` (
  `codigo` int NOT NULL PRIMARY KEY,
  `descricao` varchar(50) NOT NULL,
  `natureza` varchar(50) NOT NULL,
  `sinal` varchar(1) NOT NULL 
) ;