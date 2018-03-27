## Desafio: Analise de Crédito

## Arquitetura
A aplicação está dividida em dois projetos distintos, front e back.
-  **Client**: desenvolvido com [Angular](https://angular.io), onde o usuário tem acesso e interage com as funcionalidades.
-  **Api**: utilizando [Spring Boot](https://spring.io/), que fornece a autenticação e regras de negócio.

O banco de dados utilizado foi o [MariaDB](https://mariadb.org/),  onde já se encontra publicado (via [Amazon RDS](https://aws.amazon.com/pt/rds/)) e configurado no projeto.

### Client
O front da aplicação foi desenvolvido com o framework **Angular 5**, utilizando validações de rotas por perfil de usuário, separação por módulos e componentes, e lazy loading para os módulos.

### Api
O back foi desenvolvido com **Spring Boot**, utilizando o conceito teórico e prático do **DDD** (Domain Driven Design), onde está estruturado com uma [
](http://dddsample.sourceforge.net/architecture.html).
Foi dado preferência à uma linguagem ubiqua no desenvolvimento do domínio, com base nas informações obtidas do negócio. Técnologias utilizadas:

- Spring Boot.
 - **JWT** para autenticação stateless.
 - **Swagger** para documentação da api.
 - Controle de migrações do banco com **Flyway**.
 - Geração de imagens docker juntamente com package da aplicação com [Dockerfile Maven](https://github.com/spotify/dockerfile-maven).

## Testando
#### Dependências
 - JDK 1.8+
 - Docker
 - Docker Compose v1.16+
 - NPM

#### Como levantar a aplicação
Primeiramente faremos as builds das aplicações:

    $ cd client && npm i && npm run build:prod && cd ..
    $ cd api && ./mvnw clean package && cd ..

Em seguida, levantamos os containers:

    $ docker-compose up -d

O app estará acessivel através da porta **80** e a api na **3000**.
Para acessar o app: http://localhost/
Para acessar o swagger: http://localhost:3000/api/swagger-ui.html#/

A aplicação também esta disponível (via [Amazon EC2](https://aws.amazon.com/pt/ec2/))  na web: http://34.217.58.191/

#### Usuários pré-cadastrados

| Email| Senha|Papel|
|--|--|--|
|analista@gmail.com|12345678|Analista de crédito|
|captador@gmail.com|12345678|Captador de propostas|