# sertao-desafio-back-end
## Requisitos não funcionais para executar o projeto

- Banco de dados Mysql
- Java 11
- Maven
  
 
Para executar o projeto via maven utilize o comando :

```
mvn clean install spring-boot:run
```

## EndPoint do projeto

o endpoint do produto pode fazer Requisições GET, POST, PUT e DELETE

```
    http://localhost:8080/produto/
```

o endpoint do login pode fazer POST (username: sertão, password: 123456 )

```
    http://localhost:8080/auth/signin
```