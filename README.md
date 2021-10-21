
# Projeto referente ao desafio bycoders

Esse projeto tem como objetivo atender aos requisitos informados no desafio para leitura e extração de um arquivo CNAB.
Esse repositório representa o back-end do projeto. As tecnologias usadas foram Spring boot, Java 11, MySQL e Docker.

# Estrutura do Projeto

O projeto foi pensado para expor apis REST. A estrutura foi divida em pacotes, sendo cada pacote responsável por armazenar as classes com suas devidas responsabilidades

# Como rodar o projeto

O primeiro passo é clonar o repositório da branch master: git clone -b master https://github.com/jerrymagal/poc-bycoders-api.git

Para trabalhar com banco, foi utilizado o flyway, que é uma ferramenta de migration. Quando o projeto é iniciado, o flyway executada os scripts de banco.

Para execução do projeto foi utilizado o docker para subir tanto a aplicação como o banco, para tal foram criados os arquivos Dockefile e docker-compose.yml.

Acessar a raiz do projeto e executar o comando: docker-compose up --build -d

Esse comando vai criar as imagens e subir ambos containers.

# Testar a aplicação

Para testar a aplicação foi utilizado o Swegger afim de gerar a documentação das apis. O Endereço é http://localhost:6868/bycoders-api/swagger-ui.html#/

# Importante

Foi observado que ao clocar o projeto para uma máquina Windows, o arquivo mvnw que é necessário para execução do Dockerfile, veio com a formatação quebrada. Para correção bastou mudar a formatação para LF.
