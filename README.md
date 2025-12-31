# 🧩 API REST com Spring Boot — Design Pattern Observer

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


