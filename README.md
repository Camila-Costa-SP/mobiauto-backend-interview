# Sistema de Gestão de Oportunidades e Revendas
Este projeto é composto por um conjunto de microsserviços destinados à gestão de oportunidades e revendas de produtos.
Cada microsserviço é responsável por uma parte específica do sistema, garantindo alta coesão e baixo acoplamento entre os componentes.

### Microsserviços
O sistema é dividido nos seguintes microsserviços:

* ### Auth Manager
Responsável pela autenticação e autorização dos usuários do sistema e por Gerenciar as informações dos usuários.

#### Principais Funcionalidades:
    * Autenticação de usuários.
    * Emissão de tokens JWT.
    * Criação, atualização e remoção de usuários.
    * Consulta de usuários por e-mail ou ID.

* ### Opportunity Manager
Gerencia as oportunidades de vendas de produtos.

#### Principais Funcionalidades:
    * Criação, atualização e consulta de oportunidades.
    * Gestão do status das oportunidades.

* ### Resale Manager
Gerencia as informações de revendas.

#### Principais Funcionalidades:
    * Registro e atualização de informações de revendas.
    * Exclusão de revendas.

* ### Opportunity Handler
Responsável por atribuir oportunidades a usuários específicos dentro do sistema.

#### Principais Funcionalidades:
    * Atribuição automática de oportunidades aos assistentes de vendas com base na carga de trabalho e tempo desde a última atribuição.
    * Uso de fila SQS para gerenciamento assíncrono de atribuições.

  ### Tecnologias Utilizadas:
  * Spring Boot: Framework principal para criação de microsserviços.
  * Spring Security & JWT: Para autenticação e autorização.
  * Hibernate & Spring Data JPA: Para persistência de dados.
  * MapStruct: Para mapeamento entre entidades e DTOs.
  * PostgreSQL: Banco de dados utilizado.


## Pré-Requisitos

- Java 17
- Docker e Docker Compose
- Client REST para testes de API (ex: Postman)
- Intellij

## Configuração Inicial

Para construir o projeto, execute o seguinte comando na raiz do projeto:

       ./gradlew clean build 
       docker-compose up

## Testando a API

A  API pode ser testada via Postman WEB, que pode ser acessada navegando para:

https://www.postman.com/mobiauto-backend-interview/workspace/mobiauto-backend-interview/collection/34652197-2bcafe23-7447-44c5-bac9-29a8efbb05d7


## Problemas Conhecidos

 * Não existem testes unitários para os componentes principais.