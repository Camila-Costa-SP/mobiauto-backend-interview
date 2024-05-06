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
    * Atribuição de oportunidades.
    * Consulta de atribuições por usuário.

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
-  Intellij

## Configuração Inicial

Para construir o projeto, execute o seguinte comando na raiz do projeto:

       ./gradlew clean build 
       docker-compose up

Ao construir e executar o projeto, um usuário administrador será automaticamente criado:     

             "email": "admin@example.com",
             "password": "password123"

## Documentação da API

A documentação da API está disponível via Swagger UI, que pode ser acessada navegando para:

http://localhost:8080/swagger-ui.html


## Problemas Conhecidos

 * A distribuição automática de oportunidades ainda não está implementada.

 * Não existem testes unitários para os componentes principais.