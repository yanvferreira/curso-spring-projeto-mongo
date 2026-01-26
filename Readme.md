# Workshop Spring Boot com MongoDB

[![Java](https://img.shields.io/badge/Java-25-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0-green.svg)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/MongoDB-Database-forestgreen.svg)](https://www.mongodb.com/)

Este projeto é uma API RESTful desenvolvida durante o curso de **Java Completo** do professor Nélio Alves. O objetivo principal foi explorar a integração do framework Spring Boot com o banco de dados NoSQL MongoDB, abordando conceitos fundamentais de modelagem de dados orientada a documentos.

## 🧠 Conceitos e Aprendizados

Durante o desenvolvimento deste projeto, foram aplicados os seguintes conceitos:

- **Spring Data MongoDB**: Facilita a integração e manipulação de dados no MongoDB.
- **Padrão DTO (Data Transfer Object)**: Utilizado para projetar os dados que trafegam na API, evitando expor as entidades de domínio diretamente.
- **Referência vs Incorporação**:
    - *Referência*: Relacionamento entre documentos (ex: um Post aponta para um User).
    - *Incorporação*: Aninhar objetos dentro do documento (ex: AuthorDTO dentro de Post, CommentDTO dentro de Post) para otimizar consultas.
- **Consultas Personalizadas**:
    - Query Methods do Spring Data.
    - Anotação `@Query` para consultas JSON personalizadas no MongoDB.
- **Tratamento de Exceções**: Manipulação global de erros com `@ControllerAdvice` e `ExceptionHandler`.

## 🏗️ Arquitetura do Projeto

O projeto segue uma arquitetura em camadas bem definida:

1.  **Resource Layer (Controllers)**: Endpoints REST (`@RestController`).
2.  **Service Layer**: Regras de negócio.
3.  **Repository Layer**: Acesso a dados (`MongoRepository`).
4.  **Domain Layer**: Entidades do banco (`@Document`).

### Modelo de Domínio

O sistema simula uma mini rede social com as seguintes entidades:

- **User**: Possui nome, email e uma lista de referências para seus posts.
- **Post**: Possui título, corpo, data, autor (aninhado) e lista de comentários (aninhados).

## 🚀 Como executar

### Pré-requisitos
- Java JDK 17+
- MongoDB instalado e rodando (porta padrão 27017) ou Docker.
- Maven.

### Passos
1. Clone o repositório.
2. Certifique-se de que o MongoDB está em execução.
3. Execute o projeto via Maven ou sua IDE preferida:
   ```bash
   ./mvnw spring-boot:run
   ```
4. A aplicação estará disponível em http://localhost:8080

## 🔗 Endpoints Principais

### Usuários (/users)
- GET /users : Lista todos os usuários.
- GET /users/{id} : Busca usuário por ID.
- POST /users : Cria um novo usuário.
- PUT /users/{id} : Atualiza um usuário.
- DELETE /users/{id} : Deleta um usuário.
- GET /users/{id}/posts : Retorna os posts de um usuário.

### Posts (/posts)
- GET /posts/{id} : Busca post por ID.
- GET /posts/titlesearch?text={texto} : Busca posts contendo texto no título.
- GET /posts/fullsearch?text={texto}&minDate={data}&maxDate={data} : Busca avançada por texto e intervalo de datas.

## 🛠️ Tecnologias Utilizadas
- Java : Linguagem de programação.
- Spring Boot : Framework web.
- MongoDB : Banco de dados NoSQL.
- Maven : Gerenciador de dependências.