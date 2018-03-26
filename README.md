## Desafio: Analise de Crédito

### Arquitetura
A aplicação esta dividida em dois subprojetos, o **client** desenvolvido com [Angular](https://angular.io), onde o usuário tem acesso e interage com as funcionalidades, e a **api** utilizando [Spring Boot](https://spring.io/), que fornece a autenticação e regras de negócio.
O banco de dados utilizado foi o [MariaDB](https://mariadb.org/),  onde já se encontra publicado (via [Amazon RDS](https://aws.amazon.com/pt/rds/)) e configurado no projeto.

Os detalhes de cada subprojeto, estão descritos em suas respectivas pastas.

#### Dependências
 - JDK 1.8+
 - Docker
 - Docker Compose v1.16+
 - Angular CLI 1.6+

#### Como levantar a aplicação
Primeiramente faremos as builds das aplicações:

    $ cd client && ng build && cd ..
    $ cd api && ./mvnw clean package && cd ..

Em seguida, levantamos os containers:

    $ docker-compose up -d

O app estará acessivel através da porta **80** e a api na **3000**. Para acessar o app acesse [http://localhost](http://localhost).

#### Usuários pré-cadastrados

| Email| Senha|Papél|
|--|--|--|
|analista@gmail.com|12345678|Analista de crédito|
|captador@gmail.com|12345678|Captador de propostas|


