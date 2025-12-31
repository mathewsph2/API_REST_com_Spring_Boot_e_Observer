package br.com.observerapi.observer;



import br.com.observerapi.model.Pedido;


public interface PedidoObserver {
    void atualizar(Pedido pedido);
}
