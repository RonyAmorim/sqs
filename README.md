# Spring Boot SQS Example

Este projeto é um exemplo de aplicação Spring Boot que utiliza Amazon SQS (Simple Queue Service) para enviar e receber mensagens.

## Requisitos

- Java 21
- Maven
- Docker (para executar o LocalStack)

## Configuração

### 1. Clonar o Repositório

```sh
git clone https://github.com/seu-usuario/spring-boot-sqs-example.git
cd spring-boot-sqs-example
```

### 2. Executar o LocalStack

```sh
docker run --rm -it -p 4566:4566 -p 4571:4571 localstack/localstack
```

## Como Executar

### 1. Construir o Projeto

```sh
mvn clean install
```

### 2. Executar a Aplicação

```sh
mvn spring-boot:run
```

### 3. Enviar Mensagens para a Fila
Use uma ferramenta como Postman para enviar uma solicitação POST para http://localhost:8080/api/sqs/send com um corpo de mensagem JSON:
```json
{
  "content": "Hello, SQS!"
}
```

### 4. Verificar Mensagens Recebidas
Confira os logs da aplicação para ver as mensagens recebidas pelo consumidor.

## Estrutura do Código

- consumer/SqsConsumerService.java: Consumidor que lê mensagens da fila SQS.
- producer/SqsProducerService.java: Produtor que envia mensagens para a fila SQS.
- config/SqsConfig.java: Configuração do cliente SQS.
- controller/SqsController.java: Controlador REST para enviar mensagens.
