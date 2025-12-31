package br.com.observerapi.controller;


import br.com.observerapi.model.Pedido;
import br.com.observerapi.model.StatusPedido;
import br.com.observerapi.service.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}/status")
    public Pedido atualizarStatus(@PathVariable Long id,
                                  @RequestParam StatusPedido status) {
        return service.atualizarStatus(id, status);
    }
}
