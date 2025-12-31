# 🧩 DESAFIO DE PROJETO: Design Patterns com Java: Dos Clássicos (GoF) ao Spring Framework

## Bootcamp: CI&T - Backend com Java & AWS 

### Realização: Digital Innovation One

Este projeto demonstra a implementação completa de uma **API REST em Spring Boot** utilizando o **Design Pattern Observer** para notificação automática de mudanças no estado de um pedido.

A aplicação foi construída passo a passo, com foco em organização, boas práticas e clareza arquitetural.

---

## 🚀 Tecnologias utilizadas

- **Java 17+**
- **Spring Boot 3**
- **Spring Web**
- **DevTools**
- **Postman** (para testes)
- Estrutura de dados em memória (`HashMap`) para simular um banco de dados

---

## 🎯 Objetivo do projeto

O objetivo é demonstrar como aplicar o **padrão de projeto Observer** em uma API REST.  
Sempre que um pedido tem seu status alterado, todos os *observers* registrados são automaticamente notificados.

Isso permite:

- Baixo acoplamento entre componentes  
- Extensibilidade (novos observers podem ser adicionados sem alterar o código existente)  
- Separação clara de responsabilidades  

---

## 🧠 O que é o Design Pattern Observer?

O **Observer** é um padrão comportamental onde:

- Um objeto **Subject** mantém uma lista de **Observers**
- Quando ocorre uma mudança de estado, o Subject **notifica todos os observers**
- Cada observer reage de forma independente

No projeto:

- **Subject:** `PedidoSubject`
- **Observers:**  
  - `LogObserver`  
  - `NotificacaoObserver`
- **Evento observado:** mudança de status do pedido

---


---

## 🔧 Funcionamento da API

### 📌 Endpoints disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/pedidos/{id}` | Busca um pedido pelo ID |
| PUT | `/pedidos/{id}/status?status=NOVO` | Atualiza o status do pedido e dispara os observers |

---

## 🧪 Exemplos de testes

### ✔️ Buscar pedido

GET http://localhost:8080/pedidos/1

### ✔️ Atualizar status

PUT http://localhost:8080/pedidos/1/status?status=ENVIADO

### ✔️ Saída esperada no console (Observer funcionando)

[LOG] Pedido 1 mudou para: ENVIADO

[NOTIFICAÇÃO] Cliente Marluce foi avisado sobre o status: ENVIADO



---

## 🧩 Implementação do Observer

### Subject

```java
public class PedidoSubject {
    private final List<PedidoObserver> observers = new ArrayList<>();

    public void adicionarObserver(PedidoObserver observer) {
        observers.add(observer);
    }

    public void notificar(Pedido pedido) {
        observers.forEach(o -> o.atualizar(pedido));
    }
}


public interface PedidoObserver {
    void atualizar(Pedido pedido);
}
```

### Observers concretos

LogObserver: registra no console

NotificacaoObserver: simula envio de notificação ao cliente


## 🗃️ Dados iniciais


Os pedidos são carregados em memória no PedidoService:


banco.put(1L, new Pedido(1L, "Marluce", StatusPedido.NOVO));

banco.put(2L, new Pedido(2L, "Carlos", StatusPedido.PROCESSANDO));

banco.put(3L, new Pedido(3L, "Ana Paula", StatusPedido.ENVIADO));



## 🧭 Como executar

Clone o repositório

Importe no Eclipse ou IntelliJ como projeto Maven

Execute a classe:

ObserverApiApplication.java




