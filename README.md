# Projeto CRUD de Clientes

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/maven-%23C71A36.svg?style=for-the-badge&logo=apachemaven&logoColor=white)
![H2](https://img.shields.io/badge/H2%20Database-%23004E89.svg?style=for-the-badge&logo=databricks&logoColor=white)

### Desafio proposto pela DevSuperior

Desenvolvi uma pequena Api Rest usando Java e Framework Spring.
Desafio era criar um pequeno Crud de Clientes e implementar as funcionalidades CRUD (Criar, Ler, Atualizar, Excluir).

### Detalhes que foram Implementados
Implementei um pequeno Seed(Script) com 10 clientes para testes.
Implementei Exceções personalizadas para entregar uma melhor experiência em possíveis erros na API.
Implementei Validações para os campos de Nome, e Data de Nascimento, não aceitando que os campos fossem nulos e definindo um número de caracteres mínimo e máxima.
Implementei boas praticas e padrão de Projetos em Camadas.

### Funcionalidades
* Criar novo Cliente
* Atualizar Cliente existente
* Deletar Cliente por ID
* Buscar todos os Clientes por paginação
* Buscar Cliente por ID


  ## Tecnologias Utilizadas
  * Java 21
  * POO
  * Spring Boot 3
  * Validation
  * Insomnia
  * IntelliJ IDEA
  * Banco de Dados H2 Console
 
    ## 🧪 Endpoints da API

A API está exposta na porta padrão do Spring Boot (`8080`) e pode ser testada usando ferramentas como Insomnia ou Postman.

**URL Base:** `http://localhost:8080/clients`

| Método HTTP | Rota | Descrição |
| :--- | :--- | :--- |
| **POST** | `/clients` | Cria um **novo cliente**. (Enviar JSON no Body) |
| **GET** | `/clients` | Retorna **todos os clientes** com paginação. (Ex: `/clients?page=0&size=10`) |
| **GET** | `/clients/{id}` | Busca um cliente **pelo ID**. |
| **PUT** | `/clients/{id}` | Atualiza um cliente **existente** pelo ID. (Enviar JSON no Body) |
| **DELETE** | `/clients/{id}` | Deleta um cliente **pelo ID**. |


 ## ⚙️ Configuração e Execução

### 1. Clonar o Repositório

Para obter uma cópia local do projeto, abra seu terminal (ou Git Bash) e execute o comando abaixo, substituindo a URL pelo link do seu repositório:

```bash
git clone https://github.com/lucianosantos-dev/ds-crud-desafio

### 2. Navegar para a Pasta do Projeto

Após a clonagem, entre na pasta recém-criada (o nome é o mesmo do repositório):

```bash
cd ds-crud-desafio

### 3. Execução

O projeto é construído com **Java 21** e **Spring Boot 3**. Você pode iniciá-lo de duas formas:

#### Opção A: Iniciar via IDE (Recomendado)

1.  Abra a pasta clonada (`ds-crud-desafio`) no IntelliJ IDEA ou na IDE de sua preferência.
2.  Localize a classe principal (geralmente a classe que contém `@SpringBootApplication`).
3.  Execute o método principal (`main`).

#### Opção B: Iniciar via Terminal (Usando o Maven Wrapper)

1.  Navegue até a pasta raiz do projeto no seu terminal:
    ```bash
    cd ds-crud-desafio
    ```
2.  Execute o comando do Maven Wrapper:
    ```bash
    ./mvnw spring-boot:run
    ```

A aplicação será iniciada e o serviço da API REST estará disponível em **`http://localhost:8080`**.
    
  
