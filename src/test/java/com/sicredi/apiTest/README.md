# Testes da API

Este repositório contém testes automatizados para uma API de reserva de hotéis. Os testes foram implementados em Java utilizando o framework JUnit e a biblioteca RestAssured para realizar as chamadas HTTP.

## Requisitos
* JDK 8 ou superior
* Apache Maven

## Ferramentas e bibliotecas
* <a href="https://github.com/DiUS/java-faker" target="_blank">Faker</a> <br>
* <a href="https://mvnrepository.com/artifact/com.google.code.gson/gson" target="_blank">Gson</a><br>
* <a href="https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api" target="_blank">JUnit</a><br>
* <a href="https://mvnrepository.com/artifact/io.rest-assured/rest-assured" target="_blank">RestAssured</a><br>


## Testes Implementados

### POST

1. **Criar Booking - *200***
    - Verifica se é possível criar uma reserva de hotel com sucesso.

2. **Criar Booking - *400***
    - Verifica o comportamento da API quando uma solicitação POST é enviada sem um corpo de requisição.

3. **Criar Booking e buscar por ID - *200***
    - Verifica se é possível criar uma reserva de hotel e em seguida buscar por seu ID.

### GET

1. **Buscar booking por ID - *200***
    - Verifica se é possível buscar uma reserva de hotel existente pelo seu ID.

2. **Buscar booking por ID inexistente - *404***
    - Verifica o comportamento da API ao tentar buscar uma reserva de hotel com um ID inexistente.

3. **Buscar todas as bookings - *200***
    - Verifica se é possível recuperar todas as reservas de hotel cadastradas na API.

### PING

1. **Ping - *201***
    - Verifica se a API está acessível através de um ping.

## Executando os Testes

Para executar os testes, 
importe este projeto em uma IDE Java, 
como o IntelliJ IDEA, e execute cada classe 
de teste individualmente. Certifique-se de 
que as dependências do projeto, como o JUnit 
e o RestAssured, estejam configuradas 
corretamente.

