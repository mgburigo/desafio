<p align="center">

<h3 align="center">Importação de Arquivo e Higienização de Dados</h3>

  <p align="center">
    Desafio Manipulação de dados e Persistência em base de dados relacional.
    <br />

  </p>
</p>


<!-- SOBRE O PROJETO -->
## Sobre o Projeto

Desafio proposto para criar um serviço em uma das linguagens GO, Python, Java, C#, Javascript/Typescript (NodeJS), PHP, Dart, Rust que receba um arquivo csv/txt de entrada.
* Este serviço deve persistir no banco de dados relacional (postgresql) todos os dados contidos no arquivo
   - OBS: O arquivo não possui um separador muito convencional
* Deve-se fazer o split dos dados em colunas no banco de dados
* Realizar higienização dos dados após persistência (sem acento, maiúsculo, etc)
* Validar os CPFs/CNPJs contidos (válidos e não válidos numericamente)
* Todo o código deve estar disponível em repositório público do GIT

Arquivo 

* pasta do projeto resources/file/base_teste.txt

Desejável

* Utilização do DB Postgres.
* Docker Compose , com orientações para executar (arquivo readme)

### Desenvolvido com

* [JAVA](https://www.java.com/pt-BR/)
* [Postgresql](https://www.postgresql.org/)
* [Docker](https://www.docker.com/)






<!-- GETTING STARTED -->
### Iniciando

1. Na pasta raiz do projeto executar os camandos:
   ```sh
   gradlew clean
   ```

   ```sh
   gradlew build -x test
   ```

    ```sh
    docker-compose up
    ```

2. Na ferramenta Postman, importar via link a collection referente ao serviço para executar o desafio
   [https://www.getpostman.com/collections/424023562b5df587e341Get](https://www.getpostman.com/collections/424023562b5df587e341Get)


3. Após containers executando, os endpoints para execução:

method: POST
http://localhost:8181/api/desafio/importa

method: POST
http://localhost:8181/api/desafio/higieniza

method: DELETE
http://localhost:8181/api/desafio/limpa

<!-- VALIDAÇÕES REALIZADAS -->
## Validações realizadas

###/importa
_Com o arquivo já incorporado ao projeto, o endpoint fará a persistência de TODOS os dados no banco Postgres na tabela TB_CLIENTE que será criada
ao inicializar a API;_

###/higieniza
_Em todos os registros adicionados ao banco, será feita a higienização conforme solicitado, LETRAS MAÍUSCULAS, sem acentos, será validado somente CPF com o padrão
000.000.000-00 e CNPJs com o padrão 00.000.000/0000-00, irá remover espaços no inicio e fim do dado e irá salvar uma coluna com a informa de CPF válido
e CNPJ válido

###/limpa
_Remove todos os dados da tabela TB_CLIENTE_


###Consultas

* http://localhost:5050

* senha: postgres

* Add New Server

* Connection: 
  * HostName/address: desafio_postgresqldb_1 
  * Password: postgres
![img.png](img.png)

pgAdmin4 para acessar o Postgres com os dados importados

Executar a Higienização.

SELECT * from TB_CLIENTE;

SELECT * FROM TB_CLIENTE WHERE cpf_valido = false




<!-- CONTATO -->
## Contato

Michel Búrigo - [@michel_burigo](https://instagram/michel_burigo) - mg_burigo@hotmail.com

Project Link: [https://github.com/mgburigo/desafio](https://github.com/mgburigo/desafio)








