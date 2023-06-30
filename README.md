# iwatts - Tech challenger Pós tech FIAP

## Grupo 29
- [@marsleite](https://github.com/marsleite)
- [@CaioLacerda88](https://github.com/CaioLacerda88)
- [@GugaASF](https://github.com/GugaASF)


## Motivação e Objetivo

Atualmente, muitos consumidores de produtos eletroeletrônicos acabam gastando mais do que realmente precisam, o que encarece o orçamento familiar e desperdiça energia desnecessariamente. A solução tecnológica proposta tem como objetivo central fornecer aos usuários uma visão em tempo real de seus consumos, permitindo identificar onde ocorrem os maiores gastos e se há vazamentos de corrente em pontos específicos. Isso possibilitará aos usuários tomar medidas adequadas para economizar energia e reduzir seus custos.

## Requisitos Funcionais

### Cadastro de endereços

- Receber as informações dos endereços, como os campos de rua, número, bairro, cidade e estado.
- Receber as solicitações em formato HTTP POST.
- Validar as informações para garantir que estejam no formato correto e sejam válidas.
- Retornar uma mensagem de erro em caso de problemas.
- Confirmar o sucesso do cadastro retornando uma resposta positiva ao usuário.

### Gestão de pessoas

- Receber as informações das pessoas, incluindo nome, data de nascimento, sexo e parentesco com o usuário.
- Receber as solicitações em formato HTTP POST.
- Validar as informações recebidas.
- Retornar erro e uma mensagem em caso de problemas.

### Gestão de eletrodomésticos

- Receber informações dos eletrodomésticos, como nome, modelo e potência.
- Receber as solicitações em formato HTTP POST.
- Validar as informações recebidas.

## Use Cases

### Gestão de pessoas

`POST /iwatts/v1/user/register`
```json
{
  "nome": "Fulano",
  "email": "iwatts@gmail.com",
  "dataNascimento": "2000-10-03",
  "sexo": "Masculino",
  "parentesco": "Pai"
}
```

`Response:
Status Code: 201 created`
```json
{
  "id": 1,
  "nome": "Fulano",
  "email": "iwatts@gmail.com"
}
```

### Cadastro de endereço

`POST /iwatts/v1/endereco/register`
```json
{
  "rua": "Rua A",
  "numero": "10",
  "cidade": "Sao Paulo",
  "estado": "SP",
  "cep": "12565178",
  "pais": "Brasil",
  "bairro": "Morumbi"
}
```
`Response:
Status Code: 201 created`
```json        
{
  "id": 1
  "rua": "Rua A",
  "numero": "10",
  "cidade": "Sao Paulo",
  "estado": "SP",
  "cep": "12565178",
  "pais": "Brasil",
  "bairro": "Morumbi"
}
```

### Cadastro de Eletrodomésticos

`POST /iwatts/v1/eletro/register`
```json
{
  "name": "Geladeira",
  "modelo": "AB-GELADEIRA",
  "potencia": 1500
}
```
`Response
Status Code: 201 created`
```json
{
  "id": 1,
  "nome": "Geladeira",
  "potencia": 1500
}
```
## Conexão ao banco H2

Para conectar-se ao banco de dados H2, siga as etapas abaixo:

1. Acesse a URL `http://localhost:8080/h2-console` em um navegador web.

2. Na página de login do H2, verifique se os campos estão preenchidos da seguinte forma:
    - **JDBC URL**: jdbc:h2:mem:iwattsdb (ou a URL de conexão configurada em seu projeto)
    - **User Name**: sa
    - **Password**: (deixe em branco)

3. Clique em "Connect" ou pressione Enter para fazer login.

Após a conexão bem-sucedida, você terá acesso à console do H2, onde poderá executar consultas SQL e interagir com o banco de dados.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- H2 Database

## Executando a aplicação

Para executar a aplicação, siga as etapas abaixo:

1. Certifique-se de ter o Java JDK e o Apache Maven instalados em sua máquina.

2. Clone o repositório do projeto iwatts.

3. Navegue até o diretório raiz do projeto no terminal.

4. Execute o seguinte comando para compilar o projeto:
    - `./gradlew clean build`
5. Após a conclusão da compilação, execute o seguinte comando para iniciar a aplicação:
    - `./gradlew bootRun`


A aplicação será iniciada e estará pronta para receber as solicitações nos endpoints especificados.

## Considerações finais

O projeto iwatts visa fornecer aos usuários uma solução tecnológica para monitorar e gerenciar seus consumos de energia de forma eficiente. Esperamos que essa aplicação contribua para a economia de energia, redução de custos e conscientização dos usuários sobre seus hábitos de consumo. Em caso de dúvidas ou problemas, entre em contato com a equipe de suporte.
