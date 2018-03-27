## Desafio: Analise de Crédito

## Arquitetura
A aplicação esta dividida em dois subprojetos:
-  **Client**: desenvolvido com [Angular](https://angular.io), onde o usuário tem acesso e interage com as funcionalidades.
-  **Api**: utilizando [Spring Boot](https://spring.io/), que fornece a autenticação e regras de negócio.

O banco de dados utilizado foi o [MariaDB](https://mariadb.org/),  onde já se encontra publicado (via [Amazon RDS](https://aws.amazon.com/pt/rds/)) e configurado no projeto.

### Client
O front da aplicação foi implementado utilizando o **Angular 5**, e a geração do projeto, tanto como os módulos, componentes, serviços e geração de build foi utilizado o **Angular CLI**.

### Api
A api foi desenvolvida utilizando princípios do DDD e estruturada com uma [arquitetura em camadas](http://dddsample.sourceforge.net/architecture.html). Foi dado preferência à uma linguagem ubiqua no desenvolvimento do domínio, com base nas informações obtidas do negócio. Técnologias utilizadas:

- Spring Boot.
 - **JWT** para autenticação stateless.
 - **Swagger** para documentação da api.
 - Controle de migrações do banco com **Flyway**.
 - Geração de imagens docker juntamento com package da aplicação com [Dockerfile Maven](https://github.com/spotify/dockerfile-maven).

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

O app estará acessivel através da porta **80** e a api na **3000**. Para acessar o app acesse [http://localhost](http://localhost).

A aplicação também esta disponível (via [Amazon EC2](https://aws.amazon.com/pt/ec2/))  na web: http://34.217.58.191/

#### Usuários pré-cadastrados

| Email| Senha|Papél|
|--|--|--|
|analista@gmail.com|12345678|Analista de crédito|
|captador@gmail.com|12345678|Captador de propostas|
