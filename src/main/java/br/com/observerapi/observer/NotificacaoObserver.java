package br.com.observerapi.observer;


import br.com.observerapi.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoObserver implements PedidoObserver {

    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("[NOTIFICAÇÃO] Cliente " + pedido.getCliente() +
                " foi avisado sobre o status: " + pedido.getStatus());
    }
}
