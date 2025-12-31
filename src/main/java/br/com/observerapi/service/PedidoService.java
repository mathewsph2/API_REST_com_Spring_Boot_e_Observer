package br.com.observerapi.service;



import br.com.observerapi.model.Pedido;
import br.com.observerapi.model.StatusPedido;
import br.com.observerapi.observer.PedidoSubject;
import br.com.observerapi.observer.LogObserver;
import br.com.observerapi.observer.NotificacaoObserver;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PedidoService {

    private final Map<Long, Pedido> banco = new HashMap<>();
    private final PedidoSubject subject;

    public PedidoService(PedidoSubject subject,
                         LogObserver logObserver,
                         NotificacaoObserver notificacaoObserver) {

        this.subject = subject;

        // Registra observers automaticamente
        subject.adicionarObserver(logObserver);
        subject.adicionarObserver(notificacaoObserver);

        // Dados iniciais
        banco.put(1L, new Pedido(1L, "Marluce", StatusPedido.NOVO));
        
        banco.put(2L, new Pedido(2L, "Carlos", StatusPedido.PROCESSANDO)); 
        banco.put(3L, new Pedido(3L, "Ana Paula", StatusPedido.ENVIADO)); 
        banco.put(4L, new Pedido(4L, "João Pedro", StatusPedido.ENTREGUE)); 
        banco.put(5L, new Pedido(5L, "Fernanda", StatusPedido.NOVO));
        
    }

    public Pedido buscar(Long id) {
        return banco.get(id);
    }

    public Pedido atualizarStatus(Long id, StatusPedido novoStatus) {
        Pedido pedido = banco.get(id);
        pedido.setStatus(novoStatus);

        subject.notificar(pedido);

        return pedido;
    }
}
