# ⭐ Pós Tech (Fase 1) - **Gestão de Comunidade**

<hr/>

### Descrição
O projeto **“Gestão de Comunidade”** é uma ferramenta que oferece soluções para problemas comuns em comunidades, como a falta de vagas de estacionamento, a dificuldade de encontrar objetos perdidos e também, a falta de visibilidade para negócios ou comerciantes locais.

**Saiba mais na wiki** 
[Clique aqui]([https://](https://pos-tech-community-management.notion.site/Gest-o-de-Comunidade-c5a3c66672fd47289b848842d8705cd0?pvs=4))


## 💥 Como executar?

1. Instalar as dependências do do projeto através do maven.
2. A aplicação utiliza banco de dados em memória H2.
3. Context-path: **/community-management**.
4. Executar a aplicação através da classe **CommunityManagementApplication.java**.


## 🚀 Como testar?

   1. /communities
   2. /vacancy
   3. /rent
   4. /user
   5. /approve


### Serviços REST

Veja abaixo o modelo dos payloads ou caso prefira, execute o projeto e acessa o link path abaixo para ver o swagger do projeto:
http://localhost:8080/swagger-ui/index.html

[GET] */communities*

```json
{
    "id": "123",
    "nome": "Comunidade Teste"  
}
```

<hr/>

[POST] */vacancy* - Requisição / Resposta

```json
{
    "id": "",
    "tipoVaga": "",
    "dataInicioLocacao": "",
    "dataFimLocacao": "",
    "agenciaRecebimento": "",
    "contaRecebimento": "",
    "chavePixRecebimento": "",
    "statusAprovacao": "" 
}
```

[GET] */vacancy* - Resposta

```json
{
    "id": "",
    "tipoVaga": "",
    "dataInicioLocacao": "",
    "dataFimLocacao": "",
    "agenciaRecebimento": "",
    "contaRecebimento": "",
    "chavePixRecebimento": "",
    "statusAprovacao": "" 
}
```

[GET] */vacancy/{id}* - Resposta

```json
{
    "id": "",
    "tipoVaga": "",
    "dataInicioLocacao": "",
    "dataFimLocacao": "",
    "agenciaRecebimento": "",
    "contaRecebimento": "",
    "chavePixRecebimento": "",
    "statusAprovacao": "" 
}
```

[PUT] */vacancy/{id}* - Requisição / Resposta

```json
{
    "id": "",
    "tipoVaga": "",
    "dataInicioLocacao": "",
    "dataFimLocacao": "",
    "agenciaRecebimento": "",
    "contaRecebimento": "",
    "chavePixRecebimento": "",
    "statusAprovacao": "" 
}
```

[DELETE] */vacancy/{id}* - Resposta

```json
No content (204)
```
<hr />

[POST] */approve* - Requisição | Resposta

```json
{
    "id": "",
    "vagaId": "",
    "usuarioLocatarioId": "",
    "statusAprovacao": ""
}
```

<hr/>

[POST] */rent* - Requisição | Resposta

```json
{
    "id": "",
    "vagaId": "",
    "usuarioId": "",
    "usuarioLocatarioId": "",
    "status": "",
    "periodoLocacao": ""
}
```

<hr />

[POST] */payments* - Requisição | Resposta

```json
{
    "formaPagamento": {
        "codigo": ""
    },
    "valorCompra": "",
    "numeroCartao": "",
    "dataValidade": "",
    "codigoSeguranca": "",
    "validacaoPix": "",
}
```

<hr />

[POST] */users* - Resposta

```json
{
    "id": "",
    "nome": "",
    "email": "",
    "cpf": "",
    "tipoUsuario": "",
    "comunidadeId": "",
}
```

## 😎 Collection para testes 
[fiap-community-manager.postman_collection.json](https://github.com/brunolimadev/community-management/files/13210986/fiap-community-manager.postman_collection.json)




