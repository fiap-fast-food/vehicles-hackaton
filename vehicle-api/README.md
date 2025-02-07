# Projeto de API de Vendas de Veículos - HACKATON SOAT

Este projeto é uma API para gerenciar a venda de veículos. A API foi desenvolvida usando Spring 3 e MongoDB, e a documentação da API é fornecida pelo Swagger.

## Requisitos

- Java 17 ou superior
- Spring Boot 3
- MongoDB
- Maven

## Endpoints da API

### Cadastrar um veículo para venda

- **URL:** `/api/v1/veiculo`
- **Método:** `POST`
- **Descrição:** responsável por cadastrar um veículo.
- **Request Body:**
    ```json
  {
    "marca": "string",
  "modelo": "string",
  "ano": "2025-02-06T23:39:01.991Z",
  "cor": "string",
  "preco": 0,
  "quilometragem": 1073741824,
  "tipoCombustivel": "string",
  "numeroPortas": 1073741824,
  "potenciaMotor": 1073741824,
  "transmissao": "string",
  "descricao": "string",
  "estadoConservacao": "string",
  "numeroChassi": "string"
    }
    ```

### Editar os dados do veículo

- **URL:** `/api/v1/veiculo/{id}`
- **Método:** `PUT`
- **Descrição:** Edita os dados de um veículo existente.
- **Request Body:**
    ```json
    {
  "marca": "string",
  "modelo": "string",
  "ano": "2025-02-06T23:39:01.991Z",
  "cor": "string",
  "preco": 0,
  "quilometragem": 1073741824,
  "tipoCombustivel": "string",
  "numeroPortas": 1073741824,
  "potenciaMotor": 1073741824,
  "transmissao": "string",
  "descricao": "string",
  "estadoConservacao": "string",
  "numeroChassi": "string"
    }
    ```

### Efetuar a venda de um veículo (Somente para compradores cadastrados)

- **URL:** `/api/v1/venda`
- **Método:** `POST`
- **Descrição:** Efetua a venda de um veículo. Somente disponível para compradores cadastrados.
- **Parameters:**
    - `veiculoId`: ID do veículo a ser vendido.
    - `compradorId`: ID do

### Listagem de veículos à venda

- **URL:** `/api/v1/veiculo/disponiveis`
- **Método:** `GET`
- **Descrição:** Lista veículos à venda, ordenados por preço (do mais barato para o mais caro).

### Listagem de veículos vendidos

- **URL:** `/api/v1/veiculo/vendidos`
- **Método:** `GET`
- **Descrição:** Lista veículos vendidos, ordenados por preço (do mais barato para o mais caro).

### Cadastro de compradores

- **URL:** `/api/v1/usuarios/comprador`
- **Método:** `POST`
- **Descrição:** Cadastra novos compradores.
- **Request Body:**
    ```json
    {
  "nome": "string",
  "email": "string",
  "login": "string",
  "senha": "string",
  "cpf": "string"
    }
    ```

## Regras de Cadastro e Autenticação

### Cadastro de Usuário

Para se cadastrar como usuário, utilize o seguinte endpoint:

- **URL:** `/api/v1/usuarios`
- **Método:** `POST`
- **Descrição:** Cadastra um novo usuário.
- **Request Body:**
    ```json
    {
  "nome": "string",
  "email": "string",
  "login": "string",
  "senha": "string",
  "cpf": "string"
    }
    ```

### Cadastro de Comprador

Para se cadastrar como comprador, utilize o seguinte endpoint:

- **URL:** `/api/v1/usuarios/comprador`
- **Método:** `POST`
- **Descrição:** Cadastra um novo comprador.
- **Request Body:**
    ```json
    {
  "nome": "string",
  "email": "string",
  "login": "string",
  "senha": "string",
  "cpf": "string"
    }
    ```

### Autenticação

Para consumir os endpoints protegidos da API, é necessário se autenticar com as credenciais cadastradas. Utilize o seguinte endpoint para autenticação:

- **URL:** `/api/v1/auth/login`
- **Método:** `POST`
- **Descrição:** Autentica um usuário ou comprador.
- **Request Body:**
    ```json
    {
      "login": "string",
      "senha": "string"
    }
    ```

Após a autenticação, você receberá um token JWT que deve ser incluído no cabeçalho das requisições para acessar os endpoints protegidos.

### Uso do Token JWT

O token JWT recebido na autenticação deve ser incluído no cabeçalho das requisições para acessar os endpoints protegidos. Este token é necessário para garantir a segurança e a autenticação das operações realizadas na API.

### Endpoints Específicos

- **Cadastro de Veículo para Venda:** Utilize o endpoint `POST /api/v1/veiculo` para cadastrar um veículo com informações como marca, modelo, ano, cor e preço.
- **Edição de Veículo:** Utilize o endpoint `PUT /api/v1/veiculo/{id}` para editar os dados de um veículo específico.
- **Venda de Veículo:** Para efetuar a venda de um veículo, primeiro é necessário estar cadastrado como comprador. Utilize o endpoint `POST /api/v1/venda` para realizar a venda.
- **Listagem de Veículos à Venda:** Utilize o endpoint `GET /api/v1/veiculo/disponiveis` para listar veículos disponíveis à venda, ordenados por preço.
- **Listagem de Veículos Vendidos:** Utilize o endpoint `GET /api/v1/veiculo/vendidos` para listar veículos que já foram vendidos, ordenados por preço.

## Configuração do Swagger

O Swagger está disponível em: [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

