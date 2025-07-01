# Conexao

Projeto de demonstração utilizando Spring Boot para conectar e gerenciar múltiplos bancos de dados. Inclui integrações com MongoDB, Redis, Neo4j e PostgreSQL, além de suporte a cache.

## Requisitos

- Java 17 ou superior instalado no sistema.
- Acesso às instâncias dos bancos de dados listados no arquivo `application.yaml`.
- Para compilar e executar, utilize o wrapper do Maven (`mvnw` ou `mvnw.cmd` em ambientes Windows).

## Configuração

Edite `src/main/resources/application.yaml` para ajustar as credenciais e as URLs de conexão das bases de dados. Certifique-se de que todos os serviços estejam acessíveis antes de iniciar a aplicação.

## Como compilar

Execute o comando abaixo na raiz do projeto para gerar o artefato:

```bash
./mvnw clean package
```

Se preferir pular os testes (caso existam), utilize `-DskipTests`:

```bash
./mvnw clean package -DskipTests
```

## Execução

Após a compilação, rode a aplicação com o wrapper do Maven ou usando o arquivo JAR gerado:

```bash
./mvnw spring-boot:run
```

ou

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível na porta definida em `application.yaml` (padrão 8080).

