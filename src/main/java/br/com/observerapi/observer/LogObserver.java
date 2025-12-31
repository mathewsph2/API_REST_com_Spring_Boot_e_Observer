package br.com.observerapi.observer;



import br.com.observerapi.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class LogObserver implements PedidoObserver {

    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("[LOG] Pedido " + pedido.getId() +
                " mudou para: " + pedido.getStatus());
    }
}
