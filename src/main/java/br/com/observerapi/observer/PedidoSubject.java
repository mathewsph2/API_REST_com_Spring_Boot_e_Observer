package br.com.observerapi.observer;



import br.com.observerapi.model.Pedido;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoSubject {

    private final List<PedidoObserver> observers = new ArrayList<>();

    public void adicionarObserver(PedidoObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(PedidoObserver observer) {
        observers.remove(observer);
    }

    public void notificar(Pedido pedido) {
        observers.forEach(o -> o.atualizar(pedido));
    }
}
